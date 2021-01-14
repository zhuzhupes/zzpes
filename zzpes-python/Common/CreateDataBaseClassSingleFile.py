# -*- coding=utf-8 -*-

import pymysql
import warnings
import datetime
import re
import sys
import os
warnings.filterwarnings("ignore")
from Common.utils import toUpHumer
from Common.Constant import Constant
from Common.DbHelper import getDB
from Common.DbHelper import getQryData
from Common.utils import check_create_paths


check_create_paths(Constant.DATA_BASE_CLASS_FILE_PATH)

"""
    为所有表创建一个文件类
"""
def getSchemaTab(fileName):
    """
        获取所有表信息
    :param fileName: 生成文件
    :return:
    """
    selectSql = "SELECT TABLE_NAME tableName, TABLE_COMMENT tableComment FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='{schemaName}';".format(
        schemaName=Constant.DB_NAME)
    datas = getQryData(selectSql)
    primaryKeys = getPrimary()
    with open(fileName, 'w', encoding='utf8') as f:
        f.write("from sqlalchemy.ext.declarative import declarative_base\n")
        f.write("Base = declarative_base()\n")
        f.write("from sqlalchemy import Column, Integer, String,DateTime,Text,Float, LargeBinary\n\n")

        # 写trans方法
        f.write("def trans(data):\n")
        f.write("\tif(type(data) != int):\n")
        f.write("\t\treturn \"\\\"{data}\\\"\".format(data=data)\n")
        f.write("\telse:\n")
        f.write("\t\treturn str(data)\n\n\n")

        for (tabName,tableComment) in datas:
            tableInfo = {}
            tableInfo['className'] = toUpHumer(tabName,splitChar='_',firstUpper=True)
            tableInfo['tableName'] = tabName.upper()
            tableInfo['tableComment'] = tableComment
            tableInfo['primary'] = primaryKeys[tabName.upper()]
            tableInfo['columns'] = getColumns(tabName)
            f.write(getTableClass(tableInfo))


def getTableClass(tableInfo):
    tableClass = ""
    classDefineLines = "class {className}(Base):\n".format(className=tableInfo['className'])
    tableNameLines = "\n\t# {tableComment}\n\t__tablename__ = '{tableName}'\n\n"\
        .format(tableComment=tableInfo['tableComment'],
                tableName=tableInfo['tableName'])
    tableClass += (classDefineLines)
    tableClass += tableNameLines
    primaryKey = tableInfo['primary']
    for columnInfo in tableInfo['columns']:
        tabName = columnInfo['tabName']
        colName = columnInfo['colName']
        dataType = columnInfo['dataType']
        isNull = columnInfo['isNull']
        if(isNull == 'YES'):
            isNull = ',nullable=True'
        else:
            isNull = ',nullable=False'
        comment = columnInfo['comment']
        primaryInfo = ""
        if(primaryKey == colName):
            primaryInfo = ", primary_key=True"
        columnLine = "\t{colName} = Column({dataType}{primaryKey}{nullable},name=\'{name}\',comment=\'{comment}\')\n".format(
            colName=toUpHumer(colName,'_', False),
            dataType=convertDbType(dataType),
            primaryKey=primaryInfo,
            nullable=isNull,
            name=colName,
            comment=comment)
        tableClass += columnLine
    # 开始写__repr__
    tableClass += "\n\tdef __repr__(self):\n"
    tableClass += "\t\treturn \"{{"
    isStart = True #开始的时候直接接 key:val，不是开始的话需要接个,
    keyStr = ""
    valStr = ""
    colNums = len(tableInfo['columns'])
    for columnInfo in tableInfo['columns']:
        colName = columnInfo['colName']
        propName = toUpHumer(colName,'_', False)
        if(isStart):
            keyStr += "\\\"{showKey}\\\":{{{padKey}}}".format(showKey=propName, padKey=propName)
            valStr += "{padKey}=trans(self.{propName})".format(padKey=propName, propName=propName)
            isStart = False
        else:
            keyStr += ",\\\"{showKey}\\\":{{{padKey}}}".format(showKey=propName, padKey=propName)
            valStr += ",{padKey}=trans(self.{propName})".format(padKey=propName, propName=propName)

    tableClass += keyStr
    tableClass += "}}\".format("
    tableClass += valStr
    tableClass += ")\n\n\n"
    return tableClass

def convertDbType(type):
    if('varchar(' in type):
        leng = re.findall(r"\((.+?)\)",type)[0]
        str = "String(length=%s)" % leng
        return str
    elif('varchar' == type):
        return "String(length=1)"
    elif('char(1)' == type):
        return "String(length=1)"
    elif('int' == type):
        return 'Integer'
    elif ('int(' in type):
        return 'Integer'
    elif('timestamp' == type):
        return 'DateTime'
    elif('float' == type):
        return 'Float'
    elif('text' == type):
        return 'Text'
    elif('blob' == type):
        return 'LargeBinary(length=65535)'
    else:
        return type


def getPrimary():
    """
        获取数据库中所有表的主键
    :return: {"表名":"主键列名"}
    """
    selectSql = "SELECT TABLE_NAME tabName, COLUMN_NAME colName FROM  INFORMATION_SCHEMA.KEY_COLUMN_USAGE " \
                "WHERE CONSTRAINT_SCHEMA='{schemaName}' AND CONSTRAINT_NAME='PRIMARY';".format(schemaName=Constant.DB_NAME)
    conn, curr = getDB()
    curr.execute(selectSql)
    datas = curr.fetchall()
    curr.close()
    conn.close()
    info = {}
    for (tabName, colName) in datas:
        info[tabName.upper()] = colName.upper()
    return info


def getColumns(tabName):
    selectSql = "SELECT  table_name tabName, \
        COLUMN_NAME colName, \
        COLUMN_TYPE dataType, \
        IS_NULLABLE isNull, \
        COLUMN_COMMENT colComment \
    FROM information_schema. COLUMNS \
    WHERE TABLE_SCHEMA = '{schemaName}' \
    AND table_name = '{tabName}';".format(schemaName=Constant.DB_NAME, tabName=tabName)
    datas = getQryData(selectSql)
    columnInfo = []
    for tabName,colName,dataType,isNull,comment in datas:
        tempColInfo = {}
        tempColInfo['tabName'] = tabName
        tempColInfo['colName'] = colName
        tempColInfo['dataType'] = dataType
        tempColInfo['isNull'] = isNull
        tempColInfo['comment'] = comment
        columnInfo.append(tempColInfo)
    return columnInfo

def createDictClass(filePath):
    with open(filePath + 'TransDict.py', 'w', encoding='utf8') as f:
        f.write("\"\"\"\n")
        f.write("\t本文件是数据库所有key和Map对应的所有实体类\n")
        f.write("\"\"\"\n")
        f.write(createBodyDict())
        f.write(createOccupDict())
        f.write(createCampDict())
        f.write(createDtlDict())
        f.write(createServiceDict())


def createCampDict():
    """
        创建阵营翻译文件
    :return:
    """
    selectSql = "SELECT CAMP_TYPE_ID campId, CAMP_TYPE_NAME campName FROM JX3_CAMP_INFO;"
    datas = getQryData(selectSql)
    return saveDictFile('CampDict', '剑三阵营翻译实体类', datas, 'body', 'int')

def createServiceDict():
    """
        创建服务器key和名字翻译对照文件
    :return:
    """
    selectSql = "SELECT SERVER_ID id, SERVER_NAME name  FROM JX3_SERVER_INFO;"
    datas = getQryData(selectSql)
    return saveDictFile('ServiceDict', '服务器类型和key翻译实体类', datas, '', 'str')

def createDtlDict():
    """
        创建详情key和type翻译对照文件
    :return:
    """
    selectSql = "SELECT DTL_TYPE dtlType, DTL_RES_KEY dtlKey  FROM JX3_ADT_TYPE_KEY;"
    datas = getQryData(selectSql)
    return saveDictFile('DtlDict', '查询类型和key翻译实体类', datas, '', 'str')


def createBodyDict():
    """
        创建体型翻译文件
    :param filePath: 生成文件路径
    :return:
    """
    selectSql = "SELECT BODY_SHAPE_ID bodyShapeId, BODY_SHAPE_NAME bodyShapeName FROM JX3_BODY_SHAPE_INFO;"
    datas = getQryData(selectSql)
    return saveDictFile('BodyDict', '剑三体型翻译实体类', datas, 'body', 'int')

def createOccupDict():
    """
        创建职业翻译文件
    :return:
    """
    selectSql = "SELECT OCPT_ID ocptId, OCPT_NAME ocptName FROM JX3_OCPT_INFO;"
    datas = getQryData(selectSql)
    return saveDictFile('OcptDict','剑三职业翻译实体类', datas, 'ocpt', 'int')




def saveDictFile(className, zhcnName, datas, keyPad="", keyType='str'):
    classData = ""
    classData +="class {className}:\n".format(className=className)
    classData +="\t# {zhcnName}\n".format(zhcnName=zhcnName)
    classData +=f"\tkeyPad = \"{keyPad}\"\n".format(keyPad)
    classData +=f"\tkeyType = \"{keyType}\"\n".format(keyType)
    classData +="\tjsonData = {}\n"
    for (bodyId, bodyName) in datas:
        classData +="\tjsonData['{keyPad}{key}'] = \"{val}\"\n".format(keyPad=keyPad, key=bodyId, val=bodyName)
        classData +="\tjsonData['{val}'] = \"{key}\"\n".format(key=bodyId, val=bodyName)
    classData +="\n\tdef trans(data):\n"
    classData +="\t\t\"\"\"\n"
    classData +="\t\t\t返回对应的值，如果传入key，则返回val，否则返回key\n"
    classData +="\t\t\t:param data:\n"
    classData +="\t\t\t:return:\n"
    classData +="\t\t\"\"\"\n"
    classData +="\t\tif({className}.keyPad+str(data) in {className}.jsonData.keys()):\n".format(className=className)
    classData +="\t\t\treturn {className}.jsonData[{className}.keyPad+str(data)]\n".format(className=className)
    classData +="\t\telif(data in {className}.jsonData.keys()):\n".format(className=className)
    classData +="\t\t\treturn (eval({className}.keyType)({className}.jsonData[data]))\n".format(className=className)
    classData +="\t\telse:\n"
    classData +="\t\t\treturn None\n\n\n"
    return classData

def createInitQryPriceInfo(endPrice):
    """
        创建初始化价格查询区间
    :param endPrice: 结束价格/100， 因为是以100作为查询区间，万宝楼起始价格是100
    :return:
    """
    conn, curr = getDB()
    curr.execute('delete from JX3_PRICE_QRY_INFO where START_PRICE>0')
    inserIntoSql = 'INSERT ignore INTO JX3_PRICE_QRY_INFO (START_PRICE, END_PRICE) VALUES (%s,%s);'
    valuesList = []
    for start in range(1, endPrice):
        valueTup = (start*100, start*100+99)
        valuesList.append(valueTup)
    curr.executemany(inserIntoSql, valuesList)
    print("创建start：{start}   到end：{end}成功".format(start=1, end=endPrice))

def excuteSqlFile(sqlName):
    conn_alg, cur_alg = getDB()
    with open(sqlName, 'r+', encoding='utf8') as f:
        # every sql job last line marked;
        sql_list = f.read().split(';')[:-1]
        sql_list = [x.replace('\n', ' ') if '\n' in x else x for x in sql_list]
    for sql_item in sql_list:
        print(sql_item)
        try:
            effect_row = cur_alg.execute(sql_item)
            conn_alg.commit()
            print('effect rows is {}'.format(effect_row))
        except Exception as e:
            print(e)

# excuteSqlFile(Constant.JX3_CREATE_TABLE_SQL_FILE_PATH)
excuteSqlFile(Constant.JX3_CREATE_DATABASE_SQL_FILE_PATH)
getSchemaTab(Constant.DATA_BASE_CLASSES_FILE_NAME)
createDictClass(Constant.DATA_BASE_CLASS_FILE_PATH)
# createInitQryPriceInfo(400)
