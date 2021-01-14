import os
import requests
import json
import re
import datetime
import time
import random
import string
from PIL import Image
def check_create_paths(file_path):
    if(file_path[0] == '/' or ':' in file_path):
        if(not os.path.exists(file_path)):
            os.makedirs(file_path)
    else:
        abs_path = os.getcwd() + '/' + file_path
        if(not os.path.exists(abs_path)):
            os.makedirs(abs_path)
def getBatchId():
    """
        获取批次号
    :return:
    """
    return datetime.datetime.now().strftime('%Y%m%d%H%M%S')

def getUrl(url, ts_session_id):
    """
        request 链接，报错则return None
    """
    try:
        cookie = "_wsi1=aef187e01755d765142714e8c850ae873d0f93d8; " \
                 "UM_distinctid=1756f879e2f436-04538ce0b163f2-7d677f6e-1fa400-1756f879e3067e; " \
                 "OZ_1U_751=vid=vea59d121ad6ae.0&ctime={time1}&ltime={time2}; " \
                 "ts_session_id={ts_session_id};" \
                 " ts_session_id_={ts_session_id2}".format(
            time1=int(time.time()),time2=int(time.time())+40,ts_session_id=ts_session_id,ts_session_id2=ts_session_id
        )
        req_header = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.66',
            'Cookie': cookie,
            'Referer': 'https://jx3.seasunwbl.com/buyer?t=role',
        }
        return requests.get(url, headers=req_header)
    except:
        # print('Error : '+url)
        return None


def getUrlWbl(url, ts_session_id):
    """
        request 链接，报错则return None
    """
    try:
        cookie = "_wsi1=aef187e01755d765142714e8c850ae873d0f93d8; " \
                 "OZ_1U_751=vid=vea59d121ad6ae.0&ctime={time1}&ltime={time2}; " \
                 "ts_session_id={ts_session_id};" \
                 " ts_session_id_={ts_session_id2}".format(
            time1=int(time.time()),time2=int(time.time())+40,ts_session_id=ts_session_id,ts_session_id2=ts_session_id
        )
        req_header = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.66',
            'Cookie': cookie,
            'Referer': 'api-wanbaolou.xoyo.com',
        }
        return requests.get(url, headers=req_header)
    except:
        # print('Error : '+url)
        return None

def getWblDtl(url):
    """
        request 链接，报错则return None
    """
    try:
        cookie = "ts_session_id_=oCKpzvA7B5ca3ufsClVJWMyhvRob7CYmnq4tvq4k; xoyokey_=ZNwZLy7Wko%3D%26%26rk_U%3Dkoxha7Wrmuk5%26%26oWcBk7a%3DzwZl3LzomkWakxh7ruk5%26okzg.l.nr_ZZzz%26LwxwWzzB%3D.%3Dz%26%26zWeyza%26cZLolzzjZ%26%3Dr7wrmZacB"

        req_header = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.66',
            'Cookie': cookie,
            'Referer': 'api-wanbaolou.xoyo.com',
        }
        return requests.get(url, headers=req_header)
    except:
        # print('Error : '+url)
        return None

def toUpHumer(data, splitChar=' ', firstUpper = False):
    """
        转驼峰命名
    :param data:需要转换的文件
    :param splitChar:分隔符，默认是空格
    :param firstUpper:首字母是否大写
    :return:驼峰命名字符串
    """
    needUpper = firstUpper
    str = ''
    for c in data:
        if(c == splitChar):
            needUpper = True
            continue
        if(needUpper):
            str += c.upper()
            needUpper = False
        else:
            str += c.lower()
    return str

def loads_jsonp(_jsonp):
    """
        解析jsonp数据格式为json
    """
    try:
        return json.loads(re.match(".*?({.*}).*", _jsonp, re.S).group(1))
    except:
        raise ValueError('Invalid Input')


def getCurrentTimeStampStr():
    """
        获取当前时间字符串
    :return:
    """
    return datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
def getCurrentDateStr():
    """
        获取当前日期字符串
    :return:
    """
    return datetime.datetime.now().strftime('%Y-%m-%d')
def getStampToEndTime(stamp):
    """
        根据时间戳转字符串
    :param stamp:
    :return:
    """
    nows = time.time()
    times = int(nows)+stamp
    timeArray = time.localtime(times)
    otherStyleTime = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)
    return otherStyleTime

def getRandomStr(le):
    value = ''.join(random.sample(string.ascii_letters + string.digits, le))
    return value

def getTimeStampStr():
    '''
        获取当前时间戳
    '''
    return int(time.time()*1000)
def toHHmmss (stamp):
    seconds = stamp
    m, s = divmod(seconds, 60)
    h, m = divmod(m, 60)
    print("%02d:%02d:%02d" % (h, m, s))



def getUrlYunjian(url, ts_session_id):
    """
        request 链接，报错则return None
    """
    try:
        cookie = "ASP.NET_SessionId=fmrvqclf4blt4jucctdrodu4; " \
                 "Hm_lvt_b4acbb8e1c260ac6b58b8483258ff4d2=1609235184," \
                 "1609320580,1609321435,1609326606;" \
                 " Hm_lpvt_b4acbb8e1c260ac6b58b8483258ff4d2=1609326607"
        req_header = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.66',
            'Cookie': cookie,
            'Referer': 'http://www.jx3yj.com/wanbaolou.aspx',
            'X-Requested-With': 'XMLHttpRequest',
            'Accept-Encoding': 'gzip, deflate',
            'GET':'/wanbaolouxx.aspx?bid=661497870582534144 HTTP/1.1'
        }
        return requests.get(url, headers=req_header)
    except:
        # print('Error : '+url)
        return None

def qukuohao(data):
    """
        去掉前后的括号
    :param data: (ksdjkfs)
    :return:
    """
    if(re.match("^(.*)$", data) or re.match("^（.*）$", data)):
        return data[1:-1]
    return data
def createSinglePic():
    """
        创建单个奇遇图片
    :return:
    """
    filename = "D:/Projects/JPRES/Demo/Pics/奇遇图片0.png"
    img = Image.open(filename)
    size = img.size
    py = 0
    starts = [0, 226, 538, 764]
    for startx in starts:
        if (startx == 0):
            py = 41
        elif (startx == 226):
            py = 41
        elif (startx == 538):
            py = 41
        else:
            py = 0
        while (py + 49 < size[1]):
            box = (startx, py, startx + 224, py + 49)
            region = img.crop(box)
            print("({},{},{}):\"哈哈哈哈哈\",".format(0, startx, py))
            region.save('D:/Projects/JPRES/Demo/Pics/SingleQiYu/qiyu_0_{}_{}.png'.format(startx, py))
            py += 51

    filename = "D:/Projects/JPRES/Demo/Pics/奇遇图片1.png"
    img = Image.open(filename)
    size = img.size
    starts = [0, 226]
    for startx in starts:
        if (startx == 0):
            py = 0
        elif (startx == 226):
            py = 0
        while (py + 49 < size[1]):
            box = (startx, py, startx + 224, py + 49)
            region = img.crop(box)
            print("({},{},{}):\"哈哈哈哈哈\",".format(1, startx, py))
            region.save('D:/Projects/JPRES/Demo/Pics/SingleQiYu/qiyu_1_{}_{}.png'.format(startx, py))
            py += 51


    return ""
if __name__ == "__main__":
    # createSinglePic()
    pass