#!/usr/bin/python
# -*- coding: utf-8 -*-
from multiprocessing import Process,Queue
from WanBaoLouSpider.downDtl import setDetailQryInfo
from WanBaoLouSpider.downDtl import downDetail
from WanBaoLouSpider.downOverAll import setOverQryInfo
from WanBaoLouSpider.downOverAll import downLoadOverAllInfo

if __name__ == '__main__':
    overAllTaskQueue = Queue()
    dataQueue = Queue()
    setOverQryInfo(overAllTaskQueue,'20210104155946')
    downLoadOverAllInfo(overAllTaskQueue, dataQueue)

