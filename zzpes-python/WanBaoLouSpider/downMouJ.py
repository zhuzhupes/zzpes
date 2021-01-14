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
from src.spider import parse_page_data

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
            oldSessId ,consignment_id = taskQueue.get()
            # consignment_id = '661496686136250368'
            url = 'http://www.jx3yj.com/wanbaolouxx.aspx?bid={}'.format(consignment_id)
            newSessId = oldSessId
            if(oldSessId == None):
                # 如果以前sessionId不存在就直接创建一个40位sessionID
                newSessId = getRandomStr(40)
            if (Constant.DATA_GET_BY_NET):
                r = getUrl(url, newSessId)
                if (r == None):
                    dataQueue.put((Constant.QUEUE_DTYPE_DETAIL_QRY_ERROR, consignment_id, 'MJ'))
                    logger.info("链接报错啦...")
                    continue
                content = r.content.decode("utf-8")
                content = content.replace('\n','').replace('\r','').replace('\t','')
            else:
                with open(Constant.TEST_DTL_JSONP_PATH) as f:
                    content = f.read()
                    content = content.replace('\n','').replace('\r','').replace('\t','')
            html = etree.HTML(content)
            qiyus = html.xpath('//div[contains(@style,"background:url")]')
            dtlDatas = [0 for i in range(Constant.DTL_ITEM_NUMS)]
            isAllIn = True
            for qiyu in qiyus:
                posx = re.findall(r'background-position-x:(.*)px;', qiyu.get('style'))[0]
                posy = re.findall(r'background-position-y:(.*)px', qiyu.get('style'))[0]
                qiyuUrl = re.findall(r'url\((.*)\);', qiyu.get('style'))[0]
                if(qiyuUrl == Constant.URL_QIYU_TYPE_OLD):
                    type = 0
                elif(qiyuUrl == Constant.URL_QIYU_TYPE_NEW):
                    type = 1
                qiyuItem = getQiyuName(type, abs(int(posx)), abs(int(posy)))
                dtlItem = dbSession.getDtlInfo(None,None,None,None,None,qiyuItem['key'])
                if(dtlItem == None):
                    logger.info("奇遇:{}不存在".format(qiyuItem['key']))
                    isAllIn = False
                    break
                dtlDatas[dtlItem.dtlId] = 1
            # 所有外观节点
            infoDatas = html.xpath('//div[@class="s1"]')
            for infoData in infoDatas:
                name = ""
                alias = ""
                itemUrl = ""
                if(len(infoData) == 2):
                    if(infoData[0].get('src') != None):
                        itemUrl = infoData[0].get('src').split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                        name = infoData[1].text
                elif(len(infoData) == 3):
                    if(infoData[0].get('src') != None):
                        itemUrl = infoData[0].get('src').split('https://dl.pvp.xoyo.com/prod/icons/')[-1]
                        name = infoData[1].text
                        alias = infoData[2].text
                # logger.info("名字是:{}----url是：{}-----别称是:{}".format(name,itemUrl,qukuohao(alias)))
                if(itemUrl != "" and itemUrl[0] =='/'):
                    itemUrl = itemUrl[1:]
                dtlItem = dbSession.getDtlInfo(None,None,None,itemUrl,None,name)
                if(dtlItem != None):
                    dtlDatas[dtlItem.dtlId] = 1
                else:
                    logger.info("数据库没有  {}, URL是{},名字叫{},别名叫{}的详情数据".format(consignment_id, itemUrl,name,qukuohao(alias)))
                    isAllIn = False
                    break
            if(isAllIn):
                dataQueue.put((Constant.QUEUE_DTYPE_DTL_INFO, consignment_id, dtlDatas))

        else:
            #数据队列中没有任务了
            time.sleep(0.01)
            sumTime = sumTime + 1
            if sumTime > 5000:
                logger.info("等待25秒还是没有数据，结束下载进程...")
                isContinue = False
                break

def setMJQryInfo(mouJTaskQueue):
    """
        详情某间查询数据准备
    :param mouJTaskQueue:
    :return:
    """
    sessionId = getRandomStr(40)
    roles = dbSession.getUnFinishedData()
    for role in roles:
        mouJTaskQueue.put((sessionId, role.jx3rId))
    logger.info("某间id详情查询初始化完成========================================================================")


if __name__ == '__main__':
    # 创建任务队列
    # 创建数据队列
    dataQueue = Queue()
    mouJTaskQueue = Queue()
    setMJQryInfo(mouJTaskQueue)
    for i in range(3):
        process_crawl = Process(target=downLoadMouJianDtl, args=(mouJTaskQueue, dataQueue))
        process_crawl.start()
    # 创建解析进程
    for i in range(1):
        process_parse = Process(target=parse_page_data, args=(dataQueue,))
        process_parse.start()
