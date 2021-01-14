import json

from Common.DBSession import DbSession as dbSession
from Common.Constant import Constant as Constant
import Common.utils as utils
import os
from zcltools.utils import createFile
from Common.DbEntity.TransDict import OcptDict,BodyDict
def createInidDtlFile():
    bodys = dbSession.getAllBodys()
    ocpts = dbSession.getAllOcpts()
    createFile(Constant.TRAIN_DATA_LABEL_FILE_PATH,False)
    createFile(Constant.TRAIN_DATA_DTLS_FILE_PATH,False)
    for ocpt in ocpts:
        for body in bodys:
            zhiye_tixing = "zytx%02d%02d%s%s" % (ocpt.ocptId, body.bodyShapeId,ocpt.ocptName,body.bodyShapeName)
            labelFileName = Constant.TRAIN_DATA_LABEL_FILE_PATH+zhiye_tixing+".label"
            with open(labelFileName, 'w') as f:
                pass

def createDtlFile():
    createInidDtlFile()
    for item in dbSession.getFinishedOverall():
        zhiye_tixing = "zytx%02d%02d%s%s" % (item.ocptId, item.bodyShapeId,OcptDict.trans(item.ocptId), BodyDict.trans(item.bodyShapeId))
        labelFileName = Constant.TRAIN_DATA_LABEL_FILE_PATH+zhiye_tixing+".label"
        dtlFileName = Constant.TRAIN_DATA_DTLS_FILE_PATH+"{}.dat".format(item.jx3rId)
        with open(labelFileName, 'a') as f:
            f.write(dtlFileName+' '+str(item.price)+'\n')
        with open(dtlFileName, 'w') as f:
            dtl = {}
            dtl['followNum'] = item.followNum
            dtl['expPoint'] = item.expPoint
            dtl['equipPoint'] = item.equipPoint
            dtl['state'] = item.state
            dtl['remainingTime'] = item.remainingTime
            dtl['content'] = item.dtlInfoContent.decode()
            f.write(json.dumps(dtl))

if __name__ == "__main__":
    createDtlFile()
    pass