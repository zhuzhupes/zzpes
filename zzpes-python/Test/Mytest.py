# coding:utf-8
import os
import pathlib

import matplotlib.pyplot as plt
import numpy as np
import string


def getLogDataV1(method, endLoss="][570/571]"):
    """
        获取日志的信息，F信息有，但是内容不正确为0
    @param method:
    @param endLoss: 最后一条loss的判断标志
    @return: ((trainStep,trainLoss),(valStep,valNloss,valFloss,valNacc,valFAcc,valNTolAcc,valFTolAcc))
    """
    path = '/ImageReconization/Project/Attention_ocr/methods/'+method+'/expr/logs/'
    losss= []
    train_loss = []
    train_step = []
    test_loss = []
    test_step = []
    all_currency = []
    test_currency = []
    all_distance = []
    current_step = 0
    for fpath in os.listdir(path):
        xpath = path + str(fpath)+'/log.log'

        if(not  pathlib.Path(xpath).exists()):
            continue
        with open(xpath, 'r', encoding='gbk') as f:
            line = f.readline().replace('\n', '')
            while(line):
                if(endLoss in line):
                    current_step += 1
                    train_step.append(int(current_step))
                    current_loss = float(line.split('Loss: ')[-1])
                    train_loss.append(float(format(current_loss, '.1f')))
                if('INFO - loss:' in line):
                    l = float(line.split('INFO - loss: ')[-1].split(', accuray:')[0])
                    test_loss.append(l)
                    test_currency.append(float(line.split(', accuray:')[-1].split(', total_accuray')[0]))
                    all_currency.append(float(line.split(', accuray:')[-1].split(', total_accuray: ')[1]))
                    all_distance.append(float(line.split('编辑距离: ')[-1].split(', 1-编辑距离')[1]))
                    test_step.append(int(current_step))
                line = f.readline().replace('\n', '')
    return ((train_step, train_loss), (test_step, test_loss, test_currency, all_distance))


if __name__ == "__main__":
    trainInfo, testInfo = getLogDataV1('cpu_train', endLoss='[900/910]')
    pass