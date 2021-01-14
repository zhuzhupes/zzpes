from Common.Constant import Constant
from sqlalchemy import Column, String, create_engine,Integer
from sqlalchemy.orm import sessionmaker
from Common.DbEntity.DataBaseClass import *
from Common.logger import dbLog as logger
from Common.utils import *
from sqlalchemy import or_,and_
class DbSession():
    engine = create_engine('mysql+pymysql://{user}:{passwd}@{host}:{port}/{dbName}'
                           .format(user=Constant.DB_USER,
                                   passwd=Constant.DB_PASSWD,
                                   host=Constant.DB_HOST,
                                   port=Constant.DB_PORT,
                                   dbName=Constant.DB_NAME),
                           pool_size=Constant.DB_POOL_SIZE)
    Db_Session =  sessionmaker(bind=engine)
    session = Db_Session()

    @staticmethod
    def qryData(id):
        return DbSession.session.query(Jx3OcptInfo).all()

    @staticmethod
    def saveAprceInfo(data):
        logger.info('接收到处理外观信息表数据...')
        id, name, alias = data
        oldInfo = DbSession.session.query(Jx3AprceInfo)\
            .filter(Jx3AprceInfo.aprceTypeId == id).all()
        if(oldInfo == None or len(oldInfo) == 0):
            logger.info("该id不存在插入数据库id={id}...".format(id=id))
            insertInfo = Jx3AprceInfo(aprceTypeId=id,aprceTypeName=name,
                                      aprceTypeNameAlias=alias)
            DbSession.session.add(insertInfo)
            DbSession.session.commit()
        else:
            logger.info("该id存在,更新数据库id={}...".format(id))
            DbSession.session.query(Jx3AprceInfo).filter(Jx3AprceInfo.aprceTypeId == id).\
                update({Jx3AprceInfo.aprceTypeName :name,
                        Jx3AprceInfo.aprceTypeNameAlias:alias})
            DbSession.session.commit()
        res = DbSession.session.query(Jx3AprceInfo).\
            filter(Jx3AprceInfo.aprceTypeId == id).first()
        return res

    @staticmethod
    def handleErrorPrice(errorId, batchId, startPrice, endPrice, errorPageNo, errorState):
        """
            保存错误价格区间信息
        :param data:
        :return:
        """
        logger.info('接受到错误信息：{}, {}, {}, {}, {}...'.format(errorId,startPrice,endPrice,errorPageNo,errorState))
        if(errorState == None or errorState<0):
            errorState = 1 #初始状态
        if (errorId == None or errorId<0):
            insertInfo = Jx3PricePeriodErrorInfo(
                                            batchId=batchId,
                                            startPrice=startPrice,
                                            endPrice=endPrice,
                                            errorPageNo=errorPageNo,
                                            errorState=errorState,
                                            updateTime=getCurrentTimeStampStr())
            DbSession.session.add(insertInfo)
            DbSession.session.commit()
            DbSession.session.flush()
            return insertInfo
        else:
            DbSession.session.query(Jx3PricePeriodErrorInfo)\
                .filter(Jx3PricePeriodErrorInfo.errorId == errorId) \
                .update({Jx3PricePeriodErrorInfo.startPrice: startPrice,
                         Jx3PricePeriodErrorInfo.endPrice: endPrice,
                         Jx3PricePeriodErrorInfo.errorPageNo: errorPageNo,
                         Jx3PricePeriodErrorInfo.errorState: errorState,
                         Jx3PricePeriodErrorInfo.updateTime: getCurrentTimeStampStr()})
            DbSession.session.commit()
            return DbSession.session.query(Jx3PricePeriodErrorInfo).filter(Jx3PricePeriodErrorInfo.batchId == batchId,
                                                                 Jx3PricePeriodErrorInfo.startPrice == startPrice).all()


    @staticmethod
    def saveOverAllInfo(jx3rId, ocptId, campTypeId, bodyShapeId, price, followNum, expPoint, equipPoint, serverId,
                                  state, remainingTime):
        """
            保存角色总览信息
        :param data:
        :return:
        """
        logger.info('接受到角色总览信息...')
        oldInfo = DbSession.session.query(Jx3RoleInfoOverall).filter(Jx3RoleInfoOverall.jx3rId == jx3rId).all()
        if(oldInfo == None or len(oldInfo) == 0):
            logger.info("该{jx3rId}的角色不存在...".format(jx3rId=jx3rId))
            insertInfo = Jx3RoleInfoOverall(jx3rId=jx3rId,
                                            ocptId=ocptId,
                                            campTypeId=campTypeId,
                                            bodyShapeId=bodyShapeId,
                                            price=price,
                                            followNum=followNum,
                                            expPoint=expPoint,
                                            equipPoint=equipPoint,
                                            serverId=serverId,
                                            state=state,
                                            remainingTime=remainingTime,
                                            endTime=getStampToEndTime(remainingTime),
                                            createTime=getCurrentTimeStampStr(),
                                            updateTime=getCurrentTimeStampStr())
            DbSession.session.add(insertInfo)
            DbSession.session.commit()
            DbSession.session.flush()
            return insertInfo
        else:
            logger.info("总览{id}的id存在，不做操作...".format(id=id))
        return DbSession.session.query(Jx3RoleInfoOverall).filter(Jx3RoleInfoOverall.jx3rId == jx3rId).all()


    @staticmethod
    def getUnFinishedData():
        """
            查询详情不全的数据
        :return:
        """
        return DbSession.session.query(Jx3RoleInfoOverall)\
            .filter(Jx3RoleInfoOverall.dtlInfoContent == None).all()

    @staticmethod
    def getPriceDsc():
        """
            查询详情不全的数据
        :return:
        """
        return DbSession.session.query(Jx3RoleInfoOverall) \
            .filter(Jx3RoleInfoOverall.dtlInfoContent == None,
                    Jx3RoleInfoOverall.expPoint>100000).all()
    @staticmethod
    def saveServerInfo(serverId, info):
        """
            服务器信息
        :param data:
        :return:
        """
        oldInfo = DbSession.session.query(Jx3ServerInfo).filter(Jx3ServerInfo.serverId == serverId).all()
        if(oldInfo == None or len(oldInfo) == 0):
            try:
                serverName = info.split('-')[0] + '-' + info.split('-')[1]
            except:
                serverName = info
            logger.info("该{serverId}的服务器信息不存在...".format(serverId=serverId))
            insertInfo = Jx3ServerInfo(serverId=serverId,
                                            serverName=serverName)
            try:
                DbSession.session.add(insertInfo)
                DbSession.session.commit()
                DbSession.session.flush()
            except:
                logger.info("插入服务器信息报错...{}".format(insertInfo))
            return insertInfo

    @staticmethod
    def getOverAllInfoById(jx3rId):
        """
            根据id查询剑三总览信息
        :param jx3rId:id
        :return:
        """
        return DbSession.session.query(Jx3RoleInfoOverall).filter(Jx3PriceQryInfo.jx3rId == jx3rId).all()


    @staticmethod
    def savePriceQryInfo(batchId, startPrice, endPrice, pageNo, nowPageDataNum, rangeTotalNums,  state):
        """
            价格查询信息
        :param data:
        :return:
        """
        # logger.info('接受到价格查询信息...')
        if(batchId == None):
            batchId = getBatchId()
        oldInfo = DbSession.session.query(Jx3PriceQryInfo).filter(Jx3PriceQryInfo.batchId == batchId,
                                                                  Jx3PriceQryInfo.startPrice==startPrice,
                                                                  Jx3PriceQryInfo.pageNo==pageNo).all()
        if(state == None):
            state = 0
            # 0初始化；1 - 已执行；2 - 执行错误
        if(oldInfo == None or len(oldInfo) == 0):
            # logger.info("批次号为{batchId}的开始价格为{startPrice}的查询信息不存在...".format(batchId=batchId, startPrice=startPrice))
            insertInfo = Jx3PriceQryInfo(batchId=batchId,
                                         startPrice=startPrice,
                                         endPrice=endPrice,
                                         pageNo=pageNo,
                                         nowPageDataNum=nowPageDataNum,
                                         rangeTotalNums=rangeTotalNums,
                                         state=state,
                                         createTime=getCurrentTimeStampStr(),
                                         updateTime=getCurrentTimeStampStr())
            DbSession.session.add(insertInfo)
            DbSession.session.commit()
            DbSession.session.flush()
            return insertInfo
        else:
            logger.info(f"批次号为:{batchId}的开始价格为{startPrice}，第{pageNo}页的查询信息存在，更新操作...".format(batchId=batchId, startPrice=startPrice,pageNo=pageNo))
            if(oldInfo[0].state == Constant.QRY_STATE_FINISHED):
                logger.info("上次查询已经完成，本次状态不更新...")
                return
            DbSession.session.query(Jx3PriceQryInfo) \
                .filter(Jx3PriceQryInfo.batchId == batchId,Jx3PriceQryInfo.startPrice == startPrice) \
                .update({Jx3PriceQryInfo.startPrice: startPrice,
                         Jx3PriceQryInfo.endPrice: endPrice,
                         Jx3PriceQryInfo.pageNo: pageNo,
                         Jx3PriceQryInfo.nowPageDataNum: nowPageDataNum,
                         Jx3PriceQryInfo.rangeTotalNums: rangeTotalNums,
                         Jx3PriceQryInfo.state: state,
                         Jx3PriceQryInfo.updateTime:getCurrentTimeStampStr()})
            DbSession.session.commit()

    @staticmethod
    def updateOverAllLogInf(jx3rId,dtlId):
        """
            更新总览信息日志
        :param jx3rId: 剑三角色id
        :param dtlId: 详情id
        :return:
        """
        oldInfo = DbSession.session.query(Jx3RoleInfoOverall).filter(Jx3RoleInfoOverall.jx3rId==jx3rId).all()
        if(oldInfo == None or len(oldInfo) == 0):
            logger.info("角色id为{}的角色信息不存在...".format(jx3rId))
        else:
            if(dtlId != None):
                DbSession.session.query(Jx3RoleInfoOverall) \
                    .filter(Jx3RoleInfoOverall.jx3rId == jx3rId) \
                    .update({Jx3RoleInfoOverall.dtlInfoId: dtlId,
                             Jx3RoleInfoOverall.dtlInfoUpdateTime: getCurrentTimeStampStr()})
            DbSession.session.commit()

    @staticmethod
    def saveDtlInfo(jx3rId, dtlContent):
        """
            保存详情信息
        :param jx3rId:
        :param dtlContent:
        :return:
        """
        oldInfo = DbSession.session.query(Jx3RoleInfoOverall)\
            .filter(Jx3RoleInfoOverall.jx3rId == jx3rId).first()
        if (oldInfo != None and oldInfo.dtlInfoContent != None):
            logger.info("{}的详情信息已存在".format(jx3rId))
        else:
            logger.info("更新{}的详情".format(jx3rId))
            DbSession.session.query(Jx3RoleInfoOverall) \
                .filter(Jx3RoleInfoOverall.jx3rId==jx3rId) \
                .update({Jx3RoleInfoOverall.dtlInfoContent: dtlContent,
                         Jx3RoleInfoOverall.dtlInfoUpdateTime:getCurrentTimeStampStr(),
                         Jx3RoleInfoOverall.updateTime:getCurrentTimeStampStr()})
            DbSession.session.commit()

    @staticmethod
    def procDtlInfo(dtlType, dtlTypeDtl, dtlTypeId, dtlUrl, dtlAliace, dtlZhcnName):
        """
            处理详情信息
        :param dtlType: 详情大类
        :param dtlTypeDtl: 详情小类
        :param dtlTypeId: 详情id
        :param dtlUrl: 详情url
        :param dtlAliace: 详情别称
        :param dtlZhcnName: 详情中文名
        :return:
        """
        oldInfos = DbSession.session.query(Jx3DtlInfo)\
            .filter(Jx3DtlInfo.dtlType == dtlType,
                    Jx3DtlInfo.dtlTypeDtl==dtlTypeDtl,
                    Jx3DtlInfo.dtlTypeId==dtlTypeId).all()
        if (oldInfos != None and len(oldInfos) != 0):
            names = {}
            for oldInfo in oldInfos:
                if(oldInfo.dtlZhcnName == dtlZhcnName):
                    return
                if(oldInfo.dtlZhcnName not in names.keys()):
                    names[oldInfo.dtlZhcnName] = '1'
            if(dtlZhcnName not in names):
                logger.info("{}-{}-{}--{}的详情信息已存在，插入".format(dtlType, dtlTypeDtl, dtlTypeId,oldInfo.dtlZhcnName))
                insertInfo = Jx3DtlInfo(dtlType=dtlType,
                                          dtlTypeDtl=dtlTypeDtl,
                                          dtlTypeId=dtlTypeId,
                                          dtlUrl=dtlUrl,
                                          dtlAliace=dtlAliace,
                                          dtlZhcnName=dtlZhcnName)
                DbSession.session.add(insertInfo)
                DbSession.session.commit()
                DbSession.session.flush()
        else:
            logger.info("插入{}-{}-{}的详情信息".format(dtlType,dtlTypeDtl,dtlTypeId))
            insertInfo = Jx3DtlInfo(dtlType=dtlType,
                                          dtlTypeDtl=dtlTypeDtl,
                                          dtlTypeId=dtlTypeId,
                                          dtlUrl=dtlUrl,
                                          dtlAliace=dtlAliace,
                                          dtlZhcnName=dtlZhcnName)
            DbSession.session.add(insertInfo)
            DbSession.session.commit()
            DbSession.session.flush()

    @staticmethod
    def getQryInfo(batchId):
        """
            价格查询信息
        :param data:
        :return:
        """
        return DbSession.session.query(Jx3PriceQryInfo).filter(Jx3PriceQryInfo.batchId == batchId,
                                                               Jx3PriceQryInfo.state !=Constant.QRY_STATE_FINISHED).all()

    @staticmethod
    def getDtlInfo(dtlType, dtlTypeDtl, dtlTypeId, dtlUrl, dtlAliace, dtlZhcnName):
        """
            处理详情信息
        :param dtlType: 详情大类
        :param dtlTypeDtl: 详情小类
        :param dtlTypeId: 详情id
        :param dtlUrl: 详情url
        :param dtlAliace: 详情别称
        :param dtlZhcnName: 详情中文名
        :return:
        """
        qryExp = DbSession.session.query(Jx3DtlInfo)
        if(dtlType != None):
            qryExp = qryExp.filter(Jx3DtlInfo.dtlType == dtlType)
        if(dtlTypeDtl != None):
            qryExp = qryExp.filter(Jx3DtlInfo.dtlTypeDtl == dtlTypeDtl)
        if(dtlTypeId != None):
            qryExp = qryExp.filter(Jx3DtlInfo.dtlTypeId == dtlTypeId)
        if(dtlAliace != None):
            qryExp = qryExp.filter(Jx3DtlInfo.dtlAliace == dtlAliace)
        if(dtlZhcnName != None and dtlUrl != None):
            qryExp = qryExp.filter(or_(Jx3DtlInfo.dtlUrl == dtlUrl, Jx3DtlInfo.dtlZhcnName == dtlZhcnName))
        elif(dtlZhcnName != None):
            qryExp = qryExp.filter(Jx3DtlInfo.dtlZhcnName == dtlZhcnName)
        return qryExp.first()

    @staticmethod
    def getFinishedOverall():
        """
            查询详情不全的数据
        :return:
        """
        return DbSession.session.query(Jx3RoleInfoOverall)\
            .filter(Jx3RoleInfoOverall.dtlInfoContent != None).all()

    @staticmethod
    def getAllBodys():
        return DbSession.session.query(Jx3BodyShapeInfo).all()
    @staticmethod
    def getAllOcpts():
        return DbSession.session.query(Jx3OcptInfo).all()
if __name__ == "__main__":
    # DbSession.saveOverAllInfo('20201229000100',0,0,0,3600,3,36000,34000,'kjk',3,604694)
    # DbSession.saveOverAllInfo('20201229000101',0,0,0,3600,3,36000,34000,'kjk',3,604694)
    # DbSession.saveOverAllInfo('20201229000102',0,0,0,3600,3,36000,34000,'kjk',3,604694)
    # DbSession.handleErrorPrice(-1, 90, 100, 3, 3)
    # DbSession.saveServerInfo('gate2411', '双线四区-奉天证道-梵***')
    # DbSession.savePriceQryInfo('20201227225220', 1, 99, 1, 0, 0, Constant.QRY_STATE_INIT)
    # r = DbSession.getUnFinishedData()
    # DbSession.savePetInfo('20201229000101','pet', 'type1')
    # DbSession.saveAdvntInfo('20201229000101','advnt', 'type1')
    # DbSession.saveAprceInfo('20201229000101','aprce', 'type1')
    # DbSession.savePriceQryInfo('20201229194626', 3900, start * 100 + 99, 1, 0, 0, Constant.QRY_STATE_INIT)
    # for start in range(10, 100):
    #     DbSession.savePriceQryInfo('20201229194626', start * 400, start * 400 + 399, 1, 0, 0, Constant.QRY_STATE_INIT)
    # for start in range(10, 100):
    #     DbSession.savePriceQryInfo('20201229194626', start * 4000, start * 4000 + 3999, 1, 0, 0, Constant.QRY_STATE_INIT)
    # a = DbSession.getDtlInfo(None,None,None,None,None,'倾城令·玄霰·右')
    pass