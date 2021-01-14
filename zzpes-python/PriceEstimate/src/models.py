import torch
from torch import nn
import torch.nn.functional as F
from torch.nn import init

#构建网络结构
class FCNet(nn.Module):
    def __init__(self, inputSize, outSize):
        super(FCNet, self).__init__()
        # self.hidden = nn.Linear(inputSize, 40000)
        # self.hidden = nn.Linear(40000, 10000)
        # self.hidden = nn.Linear(2500, 1000)
        # self.hidden = nn.Linear(1000, 200)
        # self.predict = nn.Linear(200, outSize)

        self.module = nn.Sequential(
            nn.Linear(inputSize, 2000),
            nn.ReLU(),
            nn.Linear(2000, 400),
            nn.ReLU()
        )
        self.out = nn.Sequential(
            nn.Linear(405, 50),
            nn.ReLU(),
            nn.Linear(50, outSize),
        )
    def forward(self, x):
        content, other = x
        temp_out = self.module(content)
        out = self.out(torch.cat((temp_out, other), 1))
        return out.squeeze(1)


def weights_init(m):
    if isinstance(m, nn.Linear):
        init.kaiming_normal(m.weight.data)
        # init.xavier_normal(m.bias.data)
