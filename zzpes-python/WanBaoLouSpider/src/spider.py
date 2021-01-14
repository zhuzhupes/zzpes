#!/usr/bin/python
# -*- coding: utf-8 -*-
from Common.logger import spiderLog as logger
from Common.Constant import Constant
from Common.DBSession import DbSession as dbSession
from Common.DbEntity.TransDict import *
from Common.utils import *

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
                consignment_id, datas = infos[1:]
                content = b''
                for data in datas:
                    if(data == 1):
                        content += b'1'
                    else:
                        content += b'0'
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