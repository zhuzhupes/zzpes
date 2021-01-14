import time
import logging
import os
from Common.utils import check_create_paths

def get_append_file(fullName, file_name):
    """
        专用于追加文件内容的日志
    :param file_name:
    :return:
    """
    times = str(time.strftime("%Y-%m-%d", time.localtime()))
    logger = logging.getLogger('mylog')  # 设定logger的名字
    logger.setLevel(logging.INFO)  # 设定logger得等级
    ch = logging.StreamHandler()  # 输出流的hander，用与设定logger的各种信息
    ch.setLevel(logging.INFO)  # 设定输出hander的level
    fh = logging.FileHandler(file_name, mode='a', encoding='utf8')  # 文件流的hander，输出得文件名称，以及mode设置为覆盖模式
    fh.setLevel(logging.INFO)  # 设定文件hander得lever

    formatter = logging.Formatter('%(message)s')
    ch.setFormatter(formatter)  # 两个hander设置个是，输出得信息包括，时间，信息得等级，以及message
    fh.setFormatter(formatter)
    logger.addHandler(fh)  # 将两个hander添加到我们声明的logger中去
    logger.addHandler(ch)
    return logger