#!/usr/bin/python
# -*- coding: utf-8 -*-
from multiprocessing.pool import Pool

from Common.DataUtils import getQiyuName
from Common.logger import spiderLog as logger
from multiprocessing import Process,Queue
from Common.Constant import Constant
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *
from Test.TestUtils import TestUtils
from WanBaoLouSpider.src.spider import parse_page_data
from Common.CodeCracker import CodeCracker

def downDetail(inputData):
    oldSessId, consignment_id, qry_type, codeCracker1 = inputData
    req_id = getRandomStr(32)
    timestamp = getTimeStampStr()
    _jsonp = '__xfe10'
    url = 'https://api-wanbaolou.xoyo.com/api/buyer/goods/additional_data?req_id={req_id}&consignment_id={consignment_id}' \
          '&goods_type=2&additional_key={qry_type}&__ts__={timestamp}&callback={jsonp}' \
        .format(req_id=req_id,
                consignment_id=consignment_id,
                qry_type=qry_type,
                timestamp=timestamp,
                jsonp=_jsonp)
    newSessId = oldSessId
    if (oldSessId == None):
        # 如果以前sessionId不存在就直接创建一个40位sessionID
        newSessId = getRandomStr(40)
    logger.info("id0是: " + str(id(codeCracker)))
    if (Constant.DATA_GET_BY_NET):
        r = getWblDtl(url)
        if (r == None):
            logger.info("查询角色{}的类型为{}的信息链接失败...".format(consignment_id, qry_type))
            return
        jsonData = loads_jsonp(r.text)
        logger.info("id0是: " + str(id(codeCracker)))
        if ('SUCCESS' not in jsonData['msg']):
            crackStatus = codeCracker.getData()
            if (crackStatus == 0):
                logger.info("还未进行过破解，即将破解...")
                if(codeCracker.updateStatus(1) != None):
                    codeCracker.startCodeCrack()
                logger.info("本线程沉睡20秒后重新下载")
                time.sleep(20)
                downDetail(inputData)
            elif (crackStatus == 1):
                logger.info("正在破解...")
                logger.info("本线程沉睡20秒后重新下载")
                time.sleep(20)
                downDetail(inputData)
            else:
                logger.info("已经破解过但是还是没有...")
                return
    else:
        qry_type = 'role_pet_info'
        r = TestUtils.getTestData(Constant.TEST_DTLPET_INFO_JSONP_PATH)
        jsonData = loads_jsonp(r)
    res_key = DtlDict.trans(qry_type)
    additional_items = jsonData['data']['additional_data'][res_key]
    datas = additional_items
    dtlType = qry_type
    if (type(datas) == list):
        # 已经到最后一层
        dtlTypeDtl = dtlType
        for itemData in datas:
            procDtlItem(dtlType, dtlTypeDtl, itemData)
    else:
        for k, v in datas.items():
            if (type(v) == list):
                dtlTypeDtl = k
                for data in v:
                    procDtlItem(dtlType, dtlTypeDtl, data)
    logger.info("弄完了想不到吧")


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
            elif (type(v) == dict):
                if('height' in v.keys()):
                    posx = int(v['x'])
                    posy = int(v['y'])
                    qiyuItem = getQiyuName(type, abs(int(posx)), abs(int(posy)))
                    logger.info("拥有奇遇:{}".format(qiyuItem['key']))
                    dtlItem = dbSession.getDtlInfo(None, None, None, None, None, qiyuItem['key'])
                    if(name != qiyuItem['key']):
                        logger.info("奇遇:{}信息和记录不匹配".format(qiyuItem['key'], v))
                    if (dtlItem == None):
                        logger.info("奇遇:{}不存在".format(qiyuItem['key']))
                        dbSession.procDtlInfo(dtlType, dtlTypeDtl, )
                        if(id != dtlItem.dtlTypeId):
                            logger.info("奇遇:{}的id信息和记录不匹配".format(qiyuItem['key'], v))
        dbSession.procDtlInfo(dtlType, dtlTypeDtl, id, url, None, name)
    except:
        logger.info("hahahhahahah")
        pass

def getDtlQryList(codeCracker):
    """
        详情查询数据准备
    :return:
    """
    dtlList = []
    sessionId = getRandomStr(40)
    roles = dbSession.getUnFinishedData()
    for role in roles[:5]:
        for key in Constant.QRY_DTL_TYPES.keys():
            dtlList.append((sessionId, role.jx3rId, key, codeCracker))
    logger.info("id详情查询初始化完成========================================================================")
    logger.info(dtlList)
    return  dtlList

codeCracker = CodeCracker()
if __name__ == '__main__':
    # 创建任务队列
    detailTaskQueue = Queue()
    # 创建数据队列
    dataQueue = Queue()
    dtlList = getDtlQryList(codeCracker)
    with Pool(5) as p:
        p.map(downDetail, dtlList)
    process_parse = Process(target=parse_page_data, args=(dataQueue,))
    process_parse.start()
    process_parse.join()

