import random
from multiprocessing import Pool

from Common.Constant import Constant
from Common.utils import getCurrentDateStr
from PriceEstimate.common.TestConstant import *
import numpy as np
import matplotlib.pyplot as plt
import json
from Common.fileappend import get_append_file

def TestTrainDataFileGenerate(input):
    """
        创建数据文件方法：test.txt里面是文件名
        txt/*：是文件内容
    :return:
    """
    # 具有的属性的个数
    currentNum, logger, dateStr = input
    nums = random.randint(Constant.TEST_DATA_VALS_MIN_LENGTH, Constant.TEST_DATA_VALS_MAX_LENGTH)
    valueDatas = np.random.randint(0, Constant.TEST_DATA_MAX_LENGTH - 1, nums)
    fileName = 'data%s%08d.dat' % (dateStr, currentNum)
    logger.info('这个东西真好啊')
    fullFileName = TEST_DATA_FILE_PATH + fileName
    with open(fullFileName, 'wb') as f:
        for x in range(40000):
            if (x in valueDatas):
                f.write(b'1')
            else:
                f.write(b'0')
    logger.info(fullFileName)
def TestValGenerate():
    vals = {}
    valueDatas = np.random.randint(0, Constant.TEST_DATA_MAX_LENGTH - 1, 2000)
    for d in valueDatas[:-300]:
        vals[d] = random.randint(0,500)
    for d in valueDatas[-300:-100]:
        vals[d] = random.randint(500,1000)
    for d in valueDatas[-100:]:
        vals[d] = random.randint(1000,10000)
    for i in range(40000):
        if(i not in vals.keys()):
            vals[i] = 0
    with open(TEST_DATA_ALGORITHM_FILE_PATH, 'w') as f:
        f.write(str(vals))

def getError(data):
    return (1-random.uniform(-1, 1)*0.01)*data

def getValTestData():
    with open(TEST_DATA_ALGORITHM_FILE_PATH, 'r') as f:
        algorithm = f.readlines()
        algorithm = eval(algorithm[0])
    values = []
    with open(TEST_DATA_INPUT_FILE, 'rb') as f:
        line = f.readline()
        while(line):
            value = 0
            index = 0
            for c in line.decode()[:-1]:
                value += getError(int(c)*algorithm[index])
                index += 1
            # print(value)
            line = f.readline()
            values.append(value)
    with open(TEST_DATA_INPUT_VAL_FILE, 'w') as f:
        for v in values:
            f.write(str(int(v)))
            f.write('\n')
    pass

def testCreateTrainFile(nums=200000):
    with open(TEST_DATA_TEST_FILE, 'w') as fb:
        pass
    logger = get_append_file(TEST_DATA_TEST_FILE, 'test.txt')
    input = []
    process_nums = 11
    dateStr = getCurrentDateStr().replace('-', '')
    for i in range(nums):
        for k in range(process_nums):
            input.append((i*process_nums+k, logger, dateStr))
    print("初始化数据完成...")
    with Pool(12) as p:
        p.map(TestTrainDataFileGenerate, input)

if __name__ == "__main__":
    # getError(None)
    testCreateTrainFile()
    x = b'1'
    print(int(x)*3)
    pass