#!/usr/bin/python
# -*- coding: utf-8 -*-
from Common.logger import spiderLog as logger
from Common.Constant import Constant
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *
from multiprocessing import Process,Queue
from WanBaoLouSpider.src.spider import parse_page_data

if __name__ == '__main__':
    dataQueue = Queue()
    dataQueue.put((Constant.QUEUE_DTYPE_PRICE_PERIOD_ERROR, '20210105101010', -1, 100, 200, 1, -1))
    dataQueue.put((Constant.QUEUE_DTYPE_PRICE_QRY_INFO, '20210105101010', 100, 200, 3, 10, 100,
                   Constant.QRY_STATE_FINISHED))
    parse_page_data(dataQueue)