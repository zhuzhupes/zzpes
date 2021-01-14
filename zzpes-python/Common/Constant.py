import time
import datetime
import os
import multiprocessing
import threading

class Constant:

    DATA_GET_BY_NET = True #是否联网获取数据

    PROJECT_FILE_PATH = os.path.abspath(os.path.dirname(os.getcwd()) + os.path.sep + ".")

    SECONDS_TO_CLOSE_AFTER_CALL = 10 #请求关闭发送后，管道关闭间隔时间
    PIPE_PROCESS_DATA_TYPE_UPDATE_PRICE_NUM = "updatePriceNum" #更新价格数量-获取一次价格区间则更新一次价格个数

    LOG_FILE_PATH = PROJECT_FILE_PATH+"/logs/"

    DB_HOST = 'localhost'
    DB_PORT = 3306
    DB_USER = 'test123'
    DB_PASSWD = 'test123'
    DB_NAME = 'jrpes'
    DB_POOL_SIZE = 10

    # SPIDER_THREAD_NUMS = multiprocessing.cpu_count()/2
    SPIDER_THREAD_NUMS = 1

    QUEUE_DTYPE_PRICE_PERIOD_ERROR = 0 # 价格区间查询错误
    QUEUE_DTYPE_DETAIL_QRY_ERROR = 4 #详情查询报错
    QUEUE_DTYPE_PRICE_PERIOD_NUM = 1 # 价格区间数-从价格查询得到的num
    QUEUE_DTYPE_OVERALL_INFO = 2 #角色总览信息-从价格查询得到的item，只有角色id
    QUEUE_DTYPE_PRICE_QRY_INFO = 3 # 更新查询信息
    QUEUE_DTYPE_DTL_INFO = 5 # 更新查询信息


    DATA_BASE_CLASS_FILE_PATH = PROJECT_FILE_PATH + '/Common/DbEntity/'
    DATA_BASE_CLASSES_FILE_NAME = DATA_BASE_CLASS_FILE_PATH + 'DataBaseClass.py'

    JX3_ROLE_STATE_SALING = 5 #在售期
    JX3_ROLE_STATE_SHOWING = 3 #公示期

    JX3_CREATE_DATABASE_SQL_FILE_PATH = PROJECT_FILE_PATH+"/Doc/PowerDesigner/crebas.sql"
    JX3_CREATE_TABLE_SQL_FILE_PATH = PROJECT_FILE_PATH+"/WanBaoLouSpider/doc/create.sql"

    MAX_PRICE_QRY_PERIOD = 4000 #最大查询价格，4000*100

    QRY_STATE_INIT = 0 #初始
    QRY_STATE_FINISHED = 1 #完成
    QRY_STATE_FAILED = 2 #失败

    QRY_DTL_TYPES = {
        "role_adventure_info": "adventure",
        "role_appearance_info": "appearance",
        "role_equipment_info": "equip",
        "role_homeland_info": "homeland",
        "role_other_info": "designation",
        "role_pet_info": "pet"
    }
    DTL_TYPES_DBCODE = {
        'adventInfoId':'role_adventure_info',
        'aprceInfoId':'role_appearance_info',
        'petInfoId':'role_pet_info'
    }
    QRY_TYPE_APRCE = "role_appearance_info"
    QRY_TYPE_ADVNT = "role_adventure_info"
    QRY_TYPE_PET = "role_pet_info"
    QRY_RES_KEY_TYPE_APRCE = "appearance"
    QRY_RES_KEY_TYPE_ADVNT = "adventure"
    QRY_RES_KEY_TYPE_PET = "pet"

    TEST_DTL_JSONP_PATH = PROJECT_FILE_PATH +"/Demo/Data/某间查号.html"
    TEST_DTLADVNT_INFO_JSONP_PATH = PROJECT_FILE_PATH +"/Demo/Data/奇遇样例.jsonp"
    TEST_DTLAPRCE_INFO_JSONP_PATH = PROJECT_FILE_PATH +"/Demo/Data/外观样例.jsonp"
    TEST_DTLPET_INFO_JSONP_PATH = PROJECT_FILE_PATH +"/Demo/Data/宠物样例.jsonp"
    TEST_OVERALL_INFO_JSONP_PATH = PROJECT_FILE_PATH +"/Demo/Data/OverAllInfo.jsonp"

    DATA_QIYU_FILE_PATH = PROJECT_FILE_PATH+"/Demo/Pics/奇遇图片0.png"
    URL_QIYU_TYPE_OLD = "https://dl.pvp.xoyo.com/prod/icons/UICommon/LuckyMeeting2.UITex.png?v=2"
    URL_QIYU_TYPE_NEW = "https://dl.pvp.xoyo.com/prod/icons/UICommon/LuckyMeeting6.UITex.png?v=2"





    QIYU_NAME_POS_DICT = {(0,0,41):{"key":"茶馆奇缘","val":0},(0,0,92):{"key":"黑白路","val":1},(0,0,143):{"key":"三尺青锋","val":2},(0,0,194):{"key":"三山四海","val":3},(0,0,245):{"key":"生死判","val":4},(0,0,296):{"key":"少年行","val":5},(0,0,347):{"key":"阴阳两界","val":6},(0,0,398):{"key":"扶摇九天","val":7},(0,0,449):{"key":"清风捕王","val":8},(0,0,500):{"key":"关外商","val":9},(0,0,551):{"key":"儿女事","val":10},(0,0,602):{"key":"烹调法","val":11},(0,0,653):{"key":"客江干","val":12},(0,0,704):{"key":"太行道","val":13},(0,0,755):{"key":"舞众生","val":14},(0,0,806):{"key":"白日梦","val":15},(0,0,857):{"key":"白月皎","val":16},(0,226,41):{"key":"枫林酒","val":17},(0,226,92):{"key":"归乡路","val":18},(0,226,143):{"key":"孩童书","val":19},(0,226,194):{"key":"红衣歌","val":20},(0,226,245):{"key":"清茗经","val":21},(0,226,296):{"key":"胜负局","val":22},(0,226,347):{"key":"捉妖记","val":23},(0,226,398):{"key":"炼狱厨神","val":24},(0,226,449):{"key":"破晓鸣","val":25},(0,226,500):{"key":"故园风雨","val":26},(0,226,551):{"key":"锋芒展","val":27},(0,226,602):{"key":"韶华故","val":28},(0,226,653):{"key":"秘宝图","val":29},(0,226,704):{"key":"缘来会·瓜","val":30},(0,226,755):{"key":"兔江湖","val":31},(0,226,806):{"key":"瀛洲梦","val":32},(0,226,857):{"key":"话玄虚","val":33},(0,538,41):{"key":"塞外宝驹","val":34},(0,538,92):{"key":"天涯无归","val":35},(0,538,143):{"key":"沙海谣","val":36},(0,538,194):{"key":"荆轲刺","val":37},(0,538,245):{"key":"石敢当","val":38},(0,538,296):{"key":"镖行天下","val":39},(0,538,347):{"key":"虎啸山林","val":40},(0,538,398):{"key":"至尊宝","val":41},(0,538,449):{"key":"北行镖","val":42},(0,538,500):{"key":"归安志·安","val":43},(0,538,551):{"key":"归安志·志","val":44},(0,538,602):{"key":"惜往日","val":45},(0,538,653):{"key":"沧海笛","val":46},(0,538,704):{"key":"缘来会·铃","val":47},(0,538,755):{"key":"露园事","val":48},(0,538,806):{"key":"劝学记","val":49},(0,538,857):{"key":"尘网中","val":50},(0,764,0):{"key":"竹马情","val":51},(0,764,51):{"key":"兽王佩","val":52},(0,764,102):{"key":"乱世舞姬","val":53},(0,764,153):{"key":"护佑苍生","val":54},(0,764,204):{"key":"滇南行","val":55},(0,764,255):{"key":"青草歌","val":56},(0,764,306):{"key":"稚子心","val":57},(0,764,357):{"key":"平生心愿","val":58},(0,764,408):{"key":"雪山恩仇","val":59},(0,764,459):{"key":"东海客","val":60},(0,764,510):{"key":"归安志·归","val":61},(0,764,561):{"key":"济苍生","val":62},(0,764,612):{"key":"滴水恩","val":63},(0,764,663):{"key":"谜书生","val":64},(0,764,714):{"key":"江湖录","val":65},(0,764,765):{"key":"莫贪杯","val":66},(0,764,816):{"key":"争铸吴钩","val":67},(1,0,0):{"key":"白雪忆","val":68},(1,0,51):{"key":"戎马边","val":69},(1,0,102):{"key":"烟花戏·风","val":70},(1,0,153):{"key":"烟花戏·月","val":71},(1,226,0):{"key":"锻剑女","val":72},(1,226,51):{"key":"烟花戏·春","val":73},(1,226,102):{"key":"烟花戏·秋","val":74},(1,226,153):{"key":"一念间","val":75}}
    QIYU_MAX_ID = 100
    DTL_ITEM_NUMS = 40000


    TEST_DATA_VALS_MAX_LENGTH = 10000
    TEST_DATA_VALS_MIN_LENGTH = 500
    TEST_DATA_MAX_LENGTH = 40000

    TRAIN_DATA_LABEL_FILE_PATH = PROJECT_FILE_PATH+"/PriceEstimate/datas/"+datetime.datetime.now().strftime('%Y%m%d')+"/labels/"
    TRAIN_DATA_DTLS_FILE_PATH = PROJECT_FILE_PATH+"/PriceEstimate/datas/"+datetime.datetime.now().strftime('%Y%m%d')+"/dtls/"


    USE_GPU = False
if __name__ == "__main__":
    # q = {}
    # i = 0
    # for k,v in Constant.QIYU_NAME_POS_DICT.items():
    #     a,b,c = k
    #     q[(a,b,c)] = {"key":v,"val":i}
    #     i+=1
    # print(q)
    pass









