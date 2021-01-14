#!/usr/bin/python
# -*- coding: utf-8 -*-
from Common.DataUtils import getQiyuName
from lxml import etree
from Common.logger import spiderLog as logger
from multiprocessing import Process,Queue
from Common.Constant import Constant
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *
from Test.TestUtils import TestUtils
from src.spider import parse_page_data

def downLoadOverAllInfo(taskQueue, dataQueue):
    """
    下载价格查询数据
    :param taskQueue:
    :param dataQueue:
    :return:
    """
    sumTime = 0
    isContinue = True
    while isContinue:
        if not taskQueue.empty():
            sumTime = 0
            time.sleep(1)
            batchId, startPrice, endPrice, nowPage, oldSessId = taskQueue.get()
            logger.info(f"现在查询价格between: %s and %s 元, page=%s" % (startPrice, endPrice,nowPage))
            url = 'https://api-wanbaolou.xoyo.com/api/buyer/goods/list?zone_id=&server_id=&filter[price]=' + str(
                startPrice) + ',' + str(
                endPrice) + '&filter[state]=0&filter[tags]=0&filter[role_shape]=0&filter[role_camp]=0&filter[role_equipment_point]=0&filter[role_experience_point]=0&game=jx3&page=' + str(
                nowPage) + '&size=10&goods_type=2&sort[undefined]'
            newSessId = oldSessId
            if(oldSessId == None):
                # 如果以前sessionId不存在就直接创建一个40位sessionID
                newSessId = getRandomStr(40)
            if(Constant.DATA_GET_BY_NET):
                r = getUrlWbl(url, newSessId)
                if (r == None):
                    dataQueue.put((Constant.QUEUE_DTYPE_PRICE_PERIOD_ERROR, batchId, -1, startPrice, endPrice, nowPage, -1))
                    continue
                jsonData = r.text
                if ('SUCCESS' not in jsonData):
                    logger.info(jsonData)
                    logger.info("需要验证码了****************************")
                    dataQueue.put(
                        (Constant.QUEUE_DTYPE_PRICE_PERIOD_ERROR, batchId, -1, startPrice, endPrice, nowPage, -1))
                    continue
                jsonData = r.json()
            else:
                # 测试获取本地静态数据
                r = TestUtils.getTestData(Constant.TEST_OVERALL_INFO_JSONP_PATH)
                jsonData = loads_jsonp(r)
            response_infos = jsonData['data']['list']
            res_length = len(response_infos)
            totalRecord = 0
            if (res_length > 0):
                totalRecord = r.json()['data']['total_record']
                taskQueue.put((batchId, startPrice, endPrice, nowPage+1, newSessId))
            # 更新查询状态
            dataQueue.put((Constant.QUEUE_DTYPE_PRICE_QRY_INFO,batchId, startPrice, endPrice, nowPage,res_length,totalRecord, Constant.QRY_STATE_FINISHED))
            for infoItem in response_infos:
                dataQueue.put((Constant.QUEUE_DTYPE_OVERALL_INFO, infoItem))
        else:
            #数据队列中没有任务了
            time.sleep(0.01)
            sumTime = sumTime + 1
            if sumTime > 5000:
                logger.info("等待25秒还是没有数据，结束下载进程...")
                isContinue = False
                break

def setOverQryInfo(overAllTaskQueue, batchId):
    """
        准备总览信息查询数据
    :param overAllTaskQueue:
    :param batchId: 批次号
    :return:
    """
    sessionId = getRandomStr(40)
    if (batchId == None or batchId == "" or len(batchId) != 14):
        batchId = getBatchId()
        for start in range(1, 40):
            dbSession.savePriceQryInfo(batchId, start * 100, start * 100 + 99, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start * 100, start*100+99))
            overAllTaskQueue.put((batchId, start * 100, start * 100 + 99, 1, sessionId))
        for start in range(10, 100):
            dbSession.savePriceQryInfo(batchId, start * 400, start * 400 + 399, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*400, start * 400 + 399))
            overAllTaskQueue.put((batchId, start * 400, start * 400 + 399, 1, sessionId))
        for start in range(40, 100):
            dbSession.savePriceQryInfo(batchId, start * 1000, start * 1000 + 999, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*1000, start * 1000 + 999))
            overAllTaskQueue.put((batchId, start * 1000, start * 1000 + 999, 1, sessionId))
        for start in range(10, 40):
            dbSession.savePriceQryInfo(batchId, start * 10000, start * 10000 + 9999, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*10000, start * 10000 + 9999))
            overAllTaskQueue.put((batchId, start * 10000, start * 10000 + 9999, 1, sessionId))
    else:
        ls = dbSession.getQryInfo(batchId)
        for item in ls:
            overAllTaskQueue.put((batchId, item.startPrice, item.endPrice, item.pageNo, sessionId))
    logger.info("========================================================================")

if __name__ == '__main__':
    # 创建任务队列
    overAllTaskQueue = Queue()
    detailTaskQueue = Queue()
    # 创建数据队列
    dataQueue = Queue()
    setOverQryInfo(overAllTaskQueue, None)
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_crawl = Process(target=downLoadOverAllInfo, args=(overAllTaskQueue, dataQueue))
        process_crawl.start()
    # 创建解析进程
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_parse = Process(target=parse_page_data, args=(dataQueue,))
        process_parse.start()
