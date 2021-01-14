
from Common.Constant import Constant

def getQiyuName(type, x, y):
    """
        根据信息获取奇遇名字
    :param type:
    :param x:
    :param y:
    :return:
    """
    dt = type
    dx = x
    dy = y
    if(dt == 0):
        if(x != 764):
            dy = int((dy-41)/51)*51 + 41
        else:
            dy = int(dy/51)*51
    else:
        dy = int(dy/51)*51
    return Constant.QIYU_NAME_POS_DICT[(dt,dx,dy)]

    pass