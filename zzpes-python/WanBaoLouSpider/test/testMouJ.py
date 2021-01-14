#!/usr/bin/python
# -*- coding: utf-8 -*-
from multiprocessing import Process,Queue
from WanBaoLouSpider.downDtl import setDetailQryInfo
from WanBaoLouSpider.downDtl import downDetail
from WanBaoLouSpider.downMouJ import setMJQryInfo
from WanBaoLouSpider.downMouJ import downLoadMouJianDtl

if __name__ == '__main__':
    mouJTaskQueue = Queue()
    dataQueue = Queue()
    setMJQryInfo(mouJTaskQueue,'')
    downLoadMouJianDtl(mouJTaskQueue, dataQueue)

