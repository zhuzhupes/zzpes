import time
import logging
import os
from Common.utils import check_create_paths
from Common.Constant import Constant

class Jx3Logger(object):
    def __init__(self):
        self.spiderLogger = self.get_log('spider.log')
        self.dbLogger = self.get_log('dblog.log')
        self.peLogger = self.get_log('peLog.log')
    def getSpiderLog(self):
        return self.spiderLogger

    def getDbLogger(self):
        return self.dbLogger
    def getPeLogger(self):
        return self.peLogger

    def get_log(self, file_name):
        times = str(time.strftime("%Y-%m-%d", time.localtime()))
        logger = logging.getLogger(file_name)  # 设定logger的名字
        logger.setLevel(logging.INFO)  # 设定logger得等级
        ch = logging.StreamHandler()  # 输出流的hander，用与设定logger的各种信息
        ch.setLevel(logging.INFO)  # 设定输出hander的level
        current_dir = os.path.dirname(__file__)
        log_path = Constant.LOG_FILE_PATH + times + '/'
        check_create_paths(log_path)
        try:
            with open(log_path + file_name, 'a') as f:
                pass
        except:
            with open(log_path + file_name, 'w') as f:
                pass
        fh = logging.FileHandler(log_path + file_name, mode='a',encoding='utf8')  # 文件流的hander，输出得文件名称，以及mode设置为覆盖模式
        fh.setLevel(logging.INFO)  # 设定文件hander得lever

        formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')
        ch.setFormatter(formatter)  # 两个hander设置个是，输出得信息包括，时间，信息得等级，以及message
        fh.setFormatter(formatter)
        logger.addHandler(fh)  # 将两个hander添加到我们声明的logger中去
        logger.addHandler(ch)
        return logger
# 日志类
logger = Jx3Logger()
# 蜘蛛日志
spiderLog = logger.getSpiderLog()
dbLog = logger.getDbLogger()
peLog = logger.getPeLogger()

