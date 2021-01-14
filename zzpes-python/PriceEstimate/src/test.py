# !/usr/bin/env python
# -*- coding: utf-8 -*-
"""
__title__ = ''
"""
import torch
from torch import nn
import torch.nn.functional as F
import torch.utils.data as Data
import numpy as np
from torchvision import datasets, transforms
from torch.nn import init
from zcltools.utils import createFile

from Common.Constant import Constant
from Common.logger import peLog as logger
from Common.utils import getCurrentDateStr
from PriceEstimate.src.constant import MODULE_SAVE_PATH
from PriceEstimate.src.utils import getNewModel
from models import FCNet
from models import weights_init
import dataset
import os

current_dir = os.path.dirname(__file__)
np.random.seed(666)
# plt.scatter(X, y)
# plt.show()


BATCH_SIZE = 2
LR = 0.01
EPOCH = 5000

train_dataset = dataset.listDataset(data_file='../datas/20210112/labels/zytx0101七秀成女.label')
train_loader = Data.DataLoader(
    train_dataset, batch_size=BATCH_SIZE,
    shuffle=True,
    drop_last=True)
test_dataset = dataset.listDataset(data_file='../datas/20210112/labels/zytx0101七秀成女.label')
test_loader = Data.DataLoader(
    test_dataset, batch_size=BATCH_SIZE,
    shuffle=True,
    drop_last=False)
adam_net = FCNet(40000,1)
if(Constant.USE_GPU):
    adam_net = adam_net.cuda()
model = getNewModel(MODULE_SAVE_PATH)
adam_net.apply(weights_init) # 对整个网络层进行参数初始化
# 有初始化损失 xavier_normal  ：
# {1: tensor(0.0972, grad_fn=<MseLossBackward>), 2: tensor(0.0731, grad_fn=<MseLossBackward>),
# 3: tensor(0.0881, grad_fn=<MseLossBackward>), 4: tensor(0.1120, grad_fn=<MseLossBackward>),
# 5: tensor(0.1012, grad_fn=<MseLossBackward>)}
# 有初始化损失 kaiming_normal  ： 表现相对较好---
# {1: tensor(0.1476, grad_fn=<MseLossBackward>), 2: tensor(0.0234, grad_fn=<MseLossBackward>),
# 3: tensor(0.0162, grad_fn=<MseLossBackward>), 4: tensor(0.0170, grad_fn=<MseLossBackward>),
# 5: tensor(0.0218, grad_fn=<MseLossBackward>)}

# 没有初始化损失
# {1: tensor(0.0265, grad_fn=<MseLossBackward>), 2: tensor(0.0121, grad_fn=<MseLossBackward>),
# 3: tensor(0.0096, grad_fn=<MseLossBackward>), 4: tensor(0.0109, grad_fn=<MseLossBackward>),
# 5: tensor(0.0104, grad_fn=<MseLossBackward>)}
# 设置优化器和损失函数
opt_adam = torch.optim.Adam(adam_net.parameters(), lr=LR)
loss_func = nn.MSELoss()
if(Constant.USE_GPU):
    loss_func = loss_func.cuda()
if model:
    logger.info('loading pretrained model from %s' % model)
    adam_net = torch.load(model)
    if(Constant.USE_GPU):
        adam_net = adam_net.cuda()
# 对数据进行分批训练
# 在神经网络中传递完整的数据集一次是不够的，
# 而且我们需要将完整的数据集在同样的神经网络中传递多次。
# 但是请记住，我们使用的是有限的数据集，
# 并且我们使用一个迭代过程即梯度下降。因此仅仅更新权重一次或者说使用一个 epoch 是不够的。
# 比如对于一个有 2000 个训练样本的数据集。将 2000 个样本分成大小为 500 的 batch，那么完成一个 epoch 需要 4 个 iteration。

for epoch in range(EPOCH):
    tloss = 0
    for step, (b_x, b_y) in enumerate(train_loader):
        pre = adam_net(b_x)
        loss = loss_func(pre, b_y)
        opt_adam.zero_grad()
        loss.backward()
        opt_adam.step()
        tloss += loss
    if(epoch % 1 == 0):
        logger.info('train: epoch:{}, loss:{}'.format(epoch, tloss))
        if(not os.path.isfile('/Project/JRPES/PriceEstimate/export/pths/')):
            createFile('/Project/JRPES/PriceEstimate/export/pths/', False)
        torch.save(adam_net, '/Project/JRPES/PriceEstimate/export/pths/{}module_{}.pth'.format(getCurrentDateStr(), epoch))
    if(epoch % 50 == 0):
        test_loss = 0
        for step, (b_x, b_y) in enumerate(test_loader):
            adam_net.eval()
            pre = adam_net(b_x)
            loss = loss_func(pre, b_y)
            test_loss += loss
        logger.info(' test: epoch:{}, loss:{}'.format(epoch, test_loss))

