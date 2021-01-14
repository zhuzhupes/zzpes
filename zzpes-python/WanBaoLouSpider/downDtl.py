#!/usr/bin/python
# -*- coding: utf-8 -*-
import pathlib

from Common.DataUtils import getQiyuName
from Common.logger import spiderLog as logger
from multiprocessing import Process,Queue
from Common.Constant import Constant
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *
from Test.TestUtils import TestUtils
from src.spider import parse_page_data


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
                    logger.info("查询角色{}的类型为{}的信息链接失败...".format(consignment_id, qry_type))
                    continue
                jsonData = loads_jsonp(r.text)
                if ('SUCCESS' not in jsonData['msg']):
                    logger.info("查询角色{}的类型为{}的信息，需要验证码了...".format(consignment_id, qry_type))
                    continue
            else:
                qry_type = 'role_pet_info'
                r = TestUtils.getTestData(Constant.TEST_DTLPET_INFO_JSONP_PATH)
                jsonData = loads_jsonp(r)
            res_key = DtlDict.trans(qry_type)
            additional_items = jsonData['data']['additional_data'][res_key]
            datas = additional_items
            dtlType = qry_type
            if(type(datas) == list):
                # 已经到最后一层
                dtlTypeDtl = dtlType
                for itemData in datas:
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

def procDtlItem(dtlType, dtlTypeDtl, data):
    """
        解析万宝楼明细详情
    :param dtlType: 详情类别：外观、宠物、奇遇、家园等等
    :param dtlTypeDtl: 二类，比如外观的肩挂、腰挂等
    :param data: 数据
    :return:
    """
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
        for k, v in data.items():
            if (type(v) == dict):
                if('height' in v.keys() and 'url' in v.keys()):
                    posx = int(v['x'])
                    posy = int(v['y'])
                    logger.info('奇遇type: {},x: {}, y: {}'.format(type, abs(posx), abs(posy)))
                    qiyuUrl = v['url']
                    url = qiyuUrl.split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                    if(qiyuUrl == Constant.URL_QIYU_TYPE_OLD):
                        qiyuType = 0
                    elif(qiyuUrl == Constant.URL_QIYU_TYPE_NEW):
                        qiyuType = 1
                    else:
                        logger.info("奇遇URL不存在!!!!!!!!!!!")
                        logger.info(qiyuUrl)
                    qiyuItem = getQiyuName(qiyuType, abs(int(posx)), abs(int(posy)))
                    logger.info("拥有奇遇:{}".format(qiyuItem['key']))
                    dtlItem = dbSession.getDtlInfo(None, None, None, None, None, qiyuItem['key'])
                    if(name != qiyuItem['key']):
                        logger.info("奇遇:{}信息和记录不匹配".format(qiyuItem['key'], v))
                    if (dtlItem == None):
                        logger.info("奇遇:{}不存在".format(qiyuItem['key']))
        dbSession.procDtlInfo(dtlType, dtlTypeDtl, id, url, None, name)
    except OSError:
        logger.info("hahahhahahah")
        pass

def setDetailQryInfo(detailTaskQueue):
    """
        详情查询数据准备
    :param detailTaskQueue:
    :return:
    """
    sessionId = getRandomStr(40)
    log_path = Constant.LOG_FILE_PATH
    dtl_need_qry = {}
    for path_name in os.listdir(log_path):
        logFile = os.path.join(log_path, path_name, 'spider.log')
        if (not pathlib.Path(logFile).exists()):
            continue
        else:
            with open(logFile, 'rb') as f:
                line = f.readline()
                while(line):
                    try:
                        line = line.decode(encoding='utf-8')
                    except:
                        line = f.readline().decode(encoding='utf8')
                    if('数据库没有  ' in line and ', URL是' in line):
                        id = line.split('数据库没有  ')[1].split(', URL是')[0]
                        if(id not in dtl_need_qry.keys()):
                            dtl_need_qry[id] = 'val'
                    line = f.readline()
    logger.info("需要查询的id录入如下：")
    logger.info(dtl_need_qry)
    for role in dtl_need_qry.keys():
        for key in Constant.QRY_DTL_TYPES.keys():
            detailTaskQueue.put((sessionId, role, key))
    logger.info("id详情查询初始化完成========================================================================")


if __name__ == '__main__':
    # 创建任务队列
    detailTaskQueue = Queue()
    # 创建数据队列
    dataQueue = Queue()
    setDetailQryInfo(detailTaskQueue)
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_crawl = Process(target=downDetail, args=(detailTaskQueue, dataQueue))
        process_crawl.start()
    # 创建解析进程
    for i in range(Constant.SPIDER_THREAD_NUMS):
        process_parse = Process(target=parse_page_data, args=(dataQueue,))
        process_parse.start()
