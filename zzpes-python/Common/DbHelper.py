import pymysql
from Common.Constant import Constant

def getDB():
    try:
        conn = pymysql.connect(host=Constant.DB_HOST, user=Constant.DB_USER, passwd=Constant.DB_PASSWD,charset='utf8')
        conn.autocommit(True)
        cursor = conn.cursor()  # 创建游标对象
        cursor.execute("SET NAMES utf8")
        cursor.execute("USE %s" % Constant.DB_NAME)
        return conn, cursor

    except pymysql.Error as e:
        print("Mysql Error %d: %s" % (e.args[0], e.args[1]))
        return None, None

def getQryData(sql):
    conn, curr = getDB()
    curr.execute(sql)
    datas = curr.fetchall()
    curr.close()
    conn.close()
    return datas

def getPriceQryPeriods():
    sql = "select START_PRICE start, END_PRICE end from JX3_PRICE_QRY_INFO order by START_PRICE asc"
    return getQryData(sql)

def getOrignPeriods(batchInfo=""):
    if(batchInfo != ""):
        batchInfo = f"where BATCH_ID = {batchInfo}".format(batchInfo)
    sql = f"select START_PRICE start, END_PRICE end from JX3_PRICE_QRY_INFO {batchInfo} order by START_PRICE asc".format(batchInfo)
    return getQryData(sql)


