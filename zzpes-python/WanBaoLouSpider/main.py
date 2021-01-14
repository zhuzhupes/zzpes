#!/usr/bin/python
# -*- coding: utf-8 -*-
from requests import Response
import re

from Common.DataUtils import getQiyuName
from Common.LocalFileAdapter import LocalFileAdapter
from Common.logger import spiderLog as logger
from Common.utils import getUrl
from lxml import etree
import xml.dom.minidom
import multiprocessing
from multiprocessing import Pool
import requests
from multiprocessing import Process,Pipe
from Common.logger import spiderLog as logger

from multiprocessing import Process,Queue
from Common.utils import getUrl
from Common.utils import getRandomStr
from Common.Constant import Constant
import multiprocessing
import threading
import requests
from concurrent.futures import ThreadPoolExecutor, as_completed
from Common.DbHelper import getOrignPeriods
import json
import  random
import  os
import time
from concurrent.futures import ThreadPoolExecutor
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *
from Test.TestUtils import TestUtils



def parse_page_data(dataQueue):
    """
    解析进程解析数据
    :param dataQueue:
    :return:
    """
    logger.info("处理数据队列启动...")
    sumTime = 0
    isContinue = True
    while isContinue:
        if not dataQueue.empty():
            sumTime = 0
            infos = dataQueue.get()
            type = infos[0]
            if(type == Constant.QUEUE_DTYPE_PRICE_PERIOD_ERROR):
                dbSession.handleErrorPrice(infos[2], infos[1], infos[3], infos[4], infos[5], infos[6])
                # 记录查询错误
                dataQueue.put((Constant.QUEUE_DTYPE_PRICE_QRY_INFO, infos[1], infos[3], infos[4], infos[5],0,0, Constant.QRY_STATE_FAILED))
            elif(type == Constant.QUEUE_DTYPE_OVERALL_INFO):
                data = infos[1]
                jx3rId = data['consignment_id']
                ocptName = data['attrs']['role_sect']
                ocptId = OcptDict.trans(ocptName)
                campName = data['attrs']['role_camp']
                campId = CampDict.trans(campName)
                bodyName = data['attrs']['role_shape']
                bodyTypeId = BodyDict.trans(bodyName)
                price = data['single_unit_price']
                price = float(price)/100
                followNum = data['followed_num']
                expScore = data['attrs']['role_experience_point']
                equipScore = data['attrs']['role_equipment_point']
                serverId = data['zone_id'] + data['server_id']
                state = data['state']
                remainingTime = data['remaining_time']
                dbSession.saveOverAllInfo(jx3rId, ocptId, campId, bodyTypeId, price, followNum, expScore, equipScore,serverId,state,remainingTime)
                if(serverId not in ServiceDict.jsonData.keys()):
                    dbSession.saveServerInfo(serverId, data['info'])
            elif(type == Constant.QUEUE_DTYPE_PRICE_QRY_INFO):
                dbSession.savePriceQryInfo(infos[1], infos[2], infos[3], infos[4],infos[5],infos[6],infos[7])
            elif(type == Constant.QUEUE_DTYPE_DTL_INFO):
                # 类型是详情
                consignment_id, content = infos[1:]
                dbSession.saveDtlInfo(consignment_id,content)
            else:
                logger.info("没有对应的类")
        else:
            # 数据队列中没有任务了
            time.sleep(0.01)
            sumTime = sumTime + 1
            if sumTime > 5000:
                isContinue = False
                logger.info("等待25秒还是没有数据，数据处理队列关闭")
                break

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



def downDetail(taskQueue, dataQueue):
    """
    下载详情信息
    :param taskQueue:
    :param dataQueue:
    :return:
    """
    sumTime = 0
    isContinue = True
    while isContinue:
        if not taskQueue.empty():
            sumTime = 0
            time.sleep(0.5)
            oldSessId ,consignment_id, qry_type = taskQueue.get()
            req_id = getRandomStr(32)
            timestamp = getTimeStampStr()
            _jsonp = '__xfe10'
            url = 'https://api-wanbaolou.xoyo.com/api/buyer/goods/additional_data?req_id={req_id}&consignment_id={consignment_id}' \
                  '&goods_type=2&additional_key={qry_type}&__ts__={timestamp}&callback={jsonp}'\
                .format(req_id=req_id,
                        consignment_id=consignment_id,
                        qry_type=qry_type,
                        timestamp=timestamp,
                        jsonp=_jsonp)
            newSessId = oldSessId
            if(oldSessId == None):
                # 如果以前sessionId不存在就直接创建一个40位sessionID
                newSessId = getRandomStr(40)
            if (Constant.DATA_GET_BY_NET):
                r = getWblDtl(url)
                if (r == None):
                    dataQueue.put((Constant.QUEUE_DTYPE_DETAIL_QRY_ERROR, consignment_id, qry_type))
                    continue
                jsonData = r.json()
                if ('SUCCESS' not in jsonData.keys()):
                    logger.info("需要验证码了****************************")
                    dataQueue.put((Constant.QUEUE_DTYPE_DETAIL_QRY_ERROR, consignment_id, qry_type))
                    continue
            else:
                qry_type = 'role_appearance_info'
                r = TestUtils.getTestData(Constant.TEST_DTLADVNT_INFO_JSONP_PATH)
                jsonData = loads_jsonp(r)
            res_key = DtlDict.trans(qry_type)
            additional_items = jsonData['data']['additional_data'][res_key]
            # dataQueue.put((Constant.QUEUE_DTYPE_DTL_INFO, res_key, consignment_id, additional_items))
            datas = additional_items
            dtlType = qry_type
            consignment_id = consignment_id
            if(type(datas) == list):
                # 已经到最后一层
                dtlTypeDtl = dtlType
                for itemData in list:
                    procDtlItem(dtlType, dtlTypeDtl, itemData)
            else:
                for k,v in datas.items():
                    if(type(v) == list):
                        dtlTypeDtl = k
                        for data in v:
                            procDtlItem(dtlType, dtlTypeDtl, data)
            logger.info("弄完了想不到吧")

        else:
            #数据队列中没有任务了
            time.sleep(0.01)
            sumTime = sumTime + 1
            if sumTime > 5000:
                logger.info("等待25秒还是没有数据，结束下载进程...")
                isContinue = False
                break


def downLoadMouJianDtl(taskQueue, dataQueue):
    """
    下载某间详情信息
    :param taskQueue:
    :param dataQueue:
    :return:
    """
    sumTime = 0
    isContinue = True
    while isContinue:
        if not taskQueue.empty():
            sumTime = 0
            time.sleep(0.5)
            oldSessId ,consignment_id, qry_type = taskQueue.get()
            # consignment_id = '661496686136250368'
            url = 'http://www.jx3yj.com/wanbaolouxx.aspx?bid={}'.format(consignment_id)
            newSessId = oldSessId
            if(oldSessId == None):
                # 如果以前sessionId不存在就直接创建一个40位sessionID
                newSessId = getRandomStr(40)
            if (Constant.DATA_GET_BY_NET):
                r = getUrl(url, newSessId)
                if (r == None):
                    dataQueue.put((Constant.QUEUE_DTYPE_DETAIL_QRY_ERROR, consignment_id, qry_type))
                    continue
                content = r.content.decode("utf-8")
                content = content.replace('\n','').replace('\r','').replace('\t','')
            else:
                # requests_session = requests.session()
                # requests_session.mount('file://', LocalFileAdapter())
                # r = requests_session.get('file:///Projects/JPRES/Demo/Data/某间查号.html')
                with open(Constant.TEST_DTL_JSONP_PATH) as f:
                    content = f.read()
                    content = content.replace('\n','').replace('\r','').replace('\t','')
            # items = re.findall( r'<img src="([a-zA-Z:/._0-9?=]*)" />[\n\t ]*<span>([\u4e00-\u9fa5·]*)</span>[\n\t ]*<span class=\"suchen\">\(([\u4e00-\u9fa5·]*)\)</span>', content, re.M|re.I)
            # for item in items:
            #
            #     pass
            logger.info(content)
            html = etree.HTML(content)
            qiyus = html.xpath('//div[contains(@style,"background:url")]')
            itemData = []
            qiyuData = [0 for i in range(Constant.QIYU_MAX_ID)]
            for qiyu in qiyus:
                posx = re.findall(r'background-position-x:(.*)px;', qiyu.get('style'))[0]
                posy = re.findall(r'background-position-y:(.*)px', qiyu.get('style'))[0]
                qiyuUrl = re.findall(r'url\((.*)\);', qiyu.get('style'))[0]
                if(qiyuUrl == Constant.URL_QIYU_TYPE_OLD):
                    type = 0
                elif(qiyuUrl == Constant.URL_QIYU_TYPE_NEW):
                    type = 1
                qiyuItem = getQiyuName(type, abs(int(posx)), abs(int(posy)))

                logger.info("拥有奇遇:{}".format(qiyuItem['key']))
                qiyuData[qiyuItem['val']] = 1
            # 所有外观节点
            infoDatas = html.xpath('//div[@class="s1"]')
            dtlData = [0 for i in range(10000)]
            for infoData in infoDatas:
                name = ""
                alias = ""
                itemUrl = ""
                if(len(infoData) == 2):
                    itemUrl = infoData[0].get('src').split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                    name = infoData[1].text
                elif(len(infoData) == 3):
                    itemUrl = infoData[0].get('src').split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                    name = infoData[1].text
                    alias = infoData[2].text
                # logger.info("名字是:{}----url是：{}-----别称是:{}".format(name,itemUrl,qukuohao(alias)))
                dtlItem = dbSession.getDtlInfo(None,None,None,itemUrl,None,name)
                if(dtlItem != None):
                    dtlData[dtlItem.dtlId] = 1
                else:
                    logger.info("数据库没有URL是{},名字叫{},别名叫{}的详情数据".format(itemUrl,name,qukuohao(alias)))
            dataQueue.put((Constant.QUEUE_DTYPE_DTL_INFO, consignment_id, str(qiyuData)+str(dtlData)))
            logger.info("弄完了想不到吧")

        else:
            #数据队列中没有任务了
            time.sleep(0.01)
            sumTime = sumTime + 1
            if sumTime > 1000:
                logger.info("等待5秒还是没有数据，结束下载进程...")
                isContinue = False
                break

def procDtlItem(dtlType, dtlTypeDtl, data):
    try:
        name = None
        id = None
        url = None
        for k, v in data.items():
            if (type(v) in [str, int]):
                if (k == 'name'):
                    name = v
                if (k == 'url' or k == 'icon'):
                    if ('https://dl.pvp.xoyo.com/prod/icons/' in v):
                        url = v.split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                    else:
                        url = v
                if (k == 'id'):
                    id = v
            elif (type(v) == dict):
                logger.info("详情类型不是str")
                logger.info(v)
        dbSession.procDtlInfo(dtlType, dtlTypeDtl, id, url, None, name)
    except:
        logger.info("hahahhahahah")
        pass

def setOverQryInfo(overAllTaskQueue):
    """
        准备总览信息查询数据
    :param overAllTaskQueue:
    :return:
    """
    useNewBatch = False
    sessionId = getRandomStr(40)
    if (useNewBatch):
        batchId = getBatchId()
        for start in range(1, 40):
            if (useNewBatch):
                dbSession.savePriceQryInfo(batchId, start * 100, start * 100 + 99, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start * 100, start*100+99))
            overAllTaskQueue.put((batchId, start * 100, start * 100 + 99, 1, sessionId))

        for start in range(10, 100):
            if (useNewBatch):
                dbSession.savePriceQryInfo(batchId, start * 400, start * 400 + 399, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*400, start * 400 + 399))
            overAllTaskQueue.put((batchId, start * 400, start * 400 + 399, 1, sessionId))
        for start in range(40, 100):
            if (useNewBatch):
                dbSession.savePriceQryInfo(batchId, start * 1000, start * 1000 + 999, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*1000, start * 1000 + 999))
            overAllTaskQueue.put((batchId, start * 1000, start * 1000 + 999, 1, sessionId))
        for start in range(10, 40):
            if (useNewBatch):
                dbSession.savePriceQryInfo(batchId, start * 10000, start * 10000 + 9999, 1, 0, 0, Constant.QRY_STATE_INIT)
            if (start % 1 == 0):
                logger.info("{}初始化到了{}".format(start*10000, start * 10000 + 9999))
            overAllTaskQueue.put((batchId, start * 10000, start * 10000 + 9999, 1, sessionId))
    else:
        batchId = '20210104155946'
        ls = dbSession.getQryInfo(batchId)
        for item in ls:
            overAllTaskQueue.put((batchId, item.startPrice, item.endPrice, item.pageNo, sessionId))
    logger.info("{}批次价格查询记录初始化完成...".format(batchId))
    logger.info("========================================================================")

def setDetailQryInfo(detailTaskQueue):
    """
        详情查询数据准备
    :param detailTaskQueue:
    :return:
    """
    sessionId = getRandomStr(40)
    roles = dbSession.getUnFinishedData()
    for role in roles:
        for key in Constant.DTL_TYPES_DBCODE.keys():
            if(eval("role.{}".format(key)) == None):
                # logger.info("设置id{}".format(role.jx3rId))
                detailTaskQueue.put((sessionId, role.jx3rId, Constant.DTL_TYPES_DBCODE[key]))
                break
            else:
                logger.info("{}的类型为{}的值是不是空...".format(role.jx3rId, key))
    logger.info("id详情查询初始化完成========================================================================")



if __name__ == '__main__':
    # 创建任务队列
    overAllTaskQueue = Queue()
    detailTaskQueue = Queue()
    # 创建数据队列
    dataQueue = Queue()
    setOverQryInfo(overAllTaskQueue)
    # setDetailQryInfo(detailTaskQueue)
    # # 创建进程爬取价格查询任务
    # for i in range(Constant.SPIDER_THREAD_NUMS):
    #     process_crawl = Process(target=downLoadOverAllInfo, args=(overAllTaskQueue, dataQueue))
    #     process_crawl.start()
    # for i in range(Constant.SPIDER_THREAD_NUMS):
    #     process_crawl = Process(target=downBaseInfo, args=(baseTaskQueue, dataQueue))
    #     process_crawl.start()
    # detailTaskQueue.put(('ksjdkfjskdfjksd' ,'ksdjfksdjkfs', 'ks'))
    # downDetail(detailTaskQueue, dataQueue)
    # detailTaskQueue.put((getRandomStr(40), '642348241029820416', 'kjkdfsdf'))
    # downLoadMouJianDtl(detailTaskQueue, dataQueue)
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_crawl = Process(target=downLoadOverAllInfo, args=(overAllTaskQueue, dataQueue))
        process_crawl.start()
    # 创建解析进程
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_parse = Process(target=parse_page_data, args=(dataQueue,))
        process_parse.start()
