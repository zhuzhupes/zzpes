#!/usr/bin/python
# encoding: utf-8

import random
import torch
from torch.utils.data import Dataset
from torch.utils.data import sampler
import torchvision.transforms as transforms
from PIL import Image
import numpy as np
import os
import json

from Common.Constant import Constant


class listDataset(Dataset):
    def __init__(self, data_file=None):
        prices = []
        files = []
        with open(data_file, 'r') as fp:
            line = fp.readline()
            while (line):
                fileName, price = line.split(' ')
                files.append(fileName)
                prices.append(float(price.replace('\n', '')))
                line = fp.readline()
        self.trainDatas = files
        self.trainVals = torch.from_numpy(np.array(prices)).type(torch.FloatTensor)
        self.nSamples = len(self.trainDatas)

    def __len__(self):
        return self.nSamples

    def __getitem__(self, index):
        fileName = self.trainDatas[index]
        with open(fileName, 'r') as f:
            itemData = json.load(f)
            items = []
            items.append(itemData['followNum'])
            items.append(itemData['expPoint'])
            items.append(itemData['equipPoint'])
            items.append(int(itemData['state']))
            items.append(itemData['remainingTime'])

            items = torch.from_numpy(np.array(items)).type(torch.FloatTensor)
            contents = []
            for c in itemData['content']:
                contents.append(int(c))
            contents = torch.from_numpy(np.array(contents)).type(torch.FloatTensor)
            val = self.trainVals[index]
            if(Constant.USE_GPU):
                contents = contents.cuda()
                items = items.cuda()
                val = val.cuda()
        return ((contents, items),val)
