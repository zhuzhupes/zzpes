#!/usr/bin/python
# encoding: utf-8
#  -*- encoding: utf-8 -*-
import string
import logging
import time
import os
import bisect


class ZclList(list):
    def __init__(self, max_deep):
        self.max_deep = max_deep
        self.max_deep_nums = 60
        self.data_list = [[] for k in range(self.max_deep_nums)]
        self.now_deep = 0
        self.min_deep = -1
        self.probability_list = [[] for k in range(self.max_deep_nums)]

    def append(self, tuple_data):
        '''

        @param tuple_data: 概率，层数
        @return:
        '''
        index = self.__get_index(tuple_data[0], tuple_data[1])
        self.data_list[tuple_data[1]].insert(index, tuple_data)
        if (self.min_deep == -1):
            self.min_deep = tuple_data[1]
        self.probability_list[tuple_data[1]].insert(index, tuple_data[0])
        self.now_deep += 1
        if (self.now_deep > self.max_deep):
            # 超过最大深度，需要弹出概率最小的
            self.now_deep += -1
            old_min_deep = self.min_deep
            if (len(self.probability_list[self.min_deep]) == 1):
                self.min_deep += 1
                while (self.min_deep < self.max_deep_nums and len(self.probability_list[self.min_deep]) == 0):
                    self.min_deep += 1
            if (self.now_deep <= 0):
                self.min_deep = -1
            return self.probability_list[old_min_deep].pop(0), self.data_list[old_min_deep].pop(0)

    def __get_index(self, probability, deep):
        return bisect.bisect(self.probability_list[deep], probability)

    def pop(self, index=-1):
        self.now_deep -= 1
        old_min_deep = self.min_deep
        if (len(self.probability_list[self.min_deep]) == 1):
            self.min_deep += 1
            while (self.min_deep < self.max_deep_nums and len(self.probability_list[self.min_deep]) == 0):
                self.min_deep += 1
        if (self.now_deep <= 0):
            self.min_deep = -1
        return self.probability_list[old_min_deep].pop(index), self.data_list[old_min_deep].pop(index)

    def listsize(self):
        return self.now_deep


def converLower(words):
    """
        字符串转小写
    @param words:
    @return:
    """
    # 临时str
    tempstr = ""
    for c in words:
        if c in string.ascii_letters:
            tempstr += c.lower()
        else:
            tempstr += c
    return tempstr


def check_create_paths(file_path):
    if (file_path[0] == '/' or ':' in file_path):
        if (not os.path.exists(file_path)):
            os.makedirs(file_path)
    else:
        abs_path = os.getcwd() + '/' + file_path
        if (not os.path.exists(abs_path)):
            os.makedirs(abs_path)


def get_log(file_name):
    times = str(time.strftime("%Y-%m-%d", time.localtime()))
    logger = logging.getLogger('test')  # 设定logger的名字
    logger.setLevel(logging.INFO)  # 设定logger得等级
    ch = logging.StreamHandler()  # 输出流的hander，用与设定logger的各种信息
    ch.setLevel(logging.INFO)  # 设定输出hander的level
    current_dir = os.path.dirname(__file__)
    parent_path = os.path.dirname(current_dir)
    file_name = times + file_name
    log_path = parent_path + '/facedata/testlogs/'
    check_create_paths(log_path)
    try:
        with open(log_path + file_name, 'a') as f:
            pass
    except:
        with open(log_path + file_name, 'w') as f:
            pass
    fh = logging.FileHandler(log_path + file_name, mode='a')  # 文件流的hander，输出得文件名称，以及mode设置为覆盖模式
    fh.setLevel(logging.INFO)  # 设定文件hander得lever

    formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')
    ch.setFormatter(formatter)  # 两个hander设置个是，输出得信息包括，时间，信息得等级，以及message
    fh.setFormatter(formatter)
    logger.addHandler(fh)  # 将两个hander添加到我们声明的logger中去
    logger.addHandler(ch)
    return logger


def createFile(file_path, isFile=True):
    """
    创建文件
    :param file_path: 文件路径
    :param isFile: 文件名
    :return:
    """
    if (not isFile):
        if (file_path[0] == '/' or ':' in file_path):
            if (not os.path.exists(file_path)):
                os.makedirs(file_path)
        else:
            abs_path = os.getcwd() + '/' + file_path
            if (not os.path.exists(abs_path)):
                os.makedirs(abs_path)
    else:
        # 不是文件
        path_name = os.path.dirname(file_path)
        if (path_name[0] == '/' or ':' in path_name):
            if (not os.path.exists(path_name)):
                os.makedirs(path_name)
        else:
            abs_path = os.getcwd() + '/' + path_name
            if (not os.path.exists(abs_path)):
                os.makedirs(abs_path)
        with open(file_path, 'w') as f:
            pass

