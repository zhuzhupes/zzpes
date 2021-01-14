#!/usr/bin/python
# -*- coding: utf-8 -*-
from multiprocessing import Process,Queue
from WanBaoLouSpider.downDtl import setDetailQryInfo
from WanBaoLouSpider.downDtl import downDetail

if __name__ == '__main__':
    detailTaskQueue = Queue()
    dataQueue = Queue()
    setDetailQryInfo(detailTaskQueue)
    downDetail(detailTaskQueue, dataQueue)

