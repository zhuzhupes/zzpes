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

"""
    为每个表创建一个文件类
"""
def getSchemaTab(filePath):
    """
        获取所有表信息
    :param filePath: 生成文件路径
    :return:
    """
    selectSql = "SELECT TABLE_NAME tableName, TABLE_COMMENT tableComment FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='{schemaName}';".format(
        schemaName=Constant.DB_NAME)
    datas = getQryData(selectSql)
    primaryKeys = getPrimary()
    for (tabName,tableComment) in datas:
        tableInfo = {}
        tableInfo['className'] = toUpHumer(tabName,splitChar='_',firstUpper=True)
        tableInfo['tableName'] = tabName.upper()
        tableInfo['tableComment'] = tableComment
        tableInfo['primary'] = primaryKeys[tabName.upper()]
        tableInfo['columns'] = getColumns(tabName)
        createTableCLass(filePath, tableInfo)


def createTableCLass(filePath, tableInfo):
    fileName = filePath + tableInfo['className']+'.py'
    with open(fileName, 'w',encoding='utf8') as f:
        f.write("from sqlalchemy.ext.declarative import declarative_base\n")
        f.write("Base = declarative_base()\n")
        f.write("from sqlalchemy import Column, Integer, String,DateTime,Text,Float\n\n")
        classDefineLines = "class {className}(Base):\n".format(className=tableInfo['className'])
        tableNameLines = "\t# {tableComment}\n\t__tablename__ = '{tableName}'\n\n\n"\
            .format(tableComment=tableInfo['tableComment'],
                    tableName=tableInfo['tableName'])
        f.write(classDefineLines)
        f.write(tableNameLines)
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
            f.write(columnLine)
        # 开始写__repr__
        f.write("\n\tdef __repr__(self):\n")
        f.write("\t\treturn \"{{")
        isStart = True #开始的时候直接接 key:val，不是开始的话需要接个,
        keyStr = ""
        valStr = ""
        colNums = len(tableInfo['columns'])
        for columnInfo in tableInfo['columns']:
            colName = columnInfo['colName']
            propName = toUpHumer(colName,'_', False)
            if(isStart):
                keyStr += "\\\"{showKey}\\\":{{{padKey}}}".format(showKey=propName, padKey=propName)
                valStr += "{padKey}=self.trans(self.{propName})".format(padKey=propName, propName=propName)
                isStart = False
            else:
                keyStr += ",\\\"{showKey}\\\":{{{padKey}}}".format(showKey=propName, padKey=propName)
                valStr += ",{padKey}=self.trans(self.{propName})".format(padKey=propName, propName=propName)

        f.write(keyStr)
        f.write("}}\".format(")
        f.write(valStr)
        f.write(")\n\n")

        # 写trans方法
        f.write("\tdef trans(self, data):\n")
        f.write("\t\tif(type(data) != int):\n")
        f.write("\t\t\treturn \"\\\"{data}\\\"\".format(data=data)\n")
        f.write("\t\telse:\n")
        f.write("\t\t\treturn str(data)\n")

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


def createBodyDict(filePath):
    """
        创建体型翻译文件
    :param filePath: 生成文件路径
    :return:
    """
    selectSql = "SELECT BODY_TYPE_ID bodyId, BODY_TYPE_NAME bodyName FROM JX3_BODY_TYPE_INFO;"
    datas = getQryData(selectSql)
    saveDictFile(filePath, 'BodyDict', '剑三体型翻译文件', datas, 'body', 'int')

def createOccupDict(filePath):
    """
        创建职业翻译文件
    :param filePath: 生成文件路径
    :return:
    """
    selectSql = "SELECT OCCUP_ID ocptId, OCCUP_NAME ocptName FROM JX3_ROLE_OCCUP_INFO;"
    datas = getQryData(selectSql)
    saveDictFile(filePath, 'OcptDict','剑三职业翻译文件', datas, 'ocpt', 'int')




def saveDictFile(filePath, className, zhcnName, datas, keyPad="", keyType='str'):
    with open(filePath + className +'.py', 'w', encoding='utf8') as f:
        f.write("class BodyDict:\n")
        f.write("\t# {zhcnName}\n".format(zhcnName=zhcnName))
        f.write("\tdef __init__(self):\n")
        f.write(f"\t\tself.keyPad = \"{keyPad}\"\n".format(keyPad))
        f.write(f"\t\tself.keyType = \"{keyType}\"\n".format(keyType))
        f.write("\t\tself.jsonData = {}\n")
        for (bodyId, bodyName) in datas:
            f.write("\t\tself.jsonData['{keyPad}{key}'] = \"{val}\"\n".format(keyPad=keyPad, key=bodyId, val=bodyName))
        f.write("\n\tdef trans(self, data):\n")
        f.write("\t\t\"\"\"\n")
        f.write("\t\t\t返回对应的值，如果传入key，则返回val，否则返回key\n")
        f.write("\t\t\t:param data:\n")
        f.write("\t\t\t:return:\n")
        f.write("\t\t\"\"\"\n")
        f.write("\t\tif(self.keyPad+str(data) in self.jsonData.keys()):\n")
        f.write("\t\t\treturn self.jsonData[self.keyPad+str(data)]\n")
        f.write("\t\telif(data in self.jsonData.keys()):\n")
        f.write("\t\t\treturn (eval(self.keyType)(self.jsonData[data]))\n")
        f.write("\t\telse:\n")
        f.write("\t\t\treturn None\n")
    return None

def createInitQryPriceInfo(endPrice):
    """
        创建初始化价格查询区间
    :param endPrice: 结束价格/100， 因为是以100作为查询区间，万宝楼起始价格是100
    :return:
    """
    conn, curr = getDB()
    curr.execute('delete from JX3_PRICE_QRY_INFO where START_PRICE>0')
    inserIntoSql = 'INSERT ignore INTO JX3_PRICE_QRY_INFO (START_PRICE, PRICE_END) VALUES (%s,%s);'
    valuesList = []
    for start in range(1, endPrice):
        valueTup = (start*100, start*100+99)
        valuesList.append(valueTup)
    curr.executemany(inserIntoSql, valuesList)
    print("创建start：{start}   到end：{end}成功".format(start=1, end=endPrice))

getSchemaTab(Constant.DATA_BASE_CLASS_FILE_PATH)
createBodyDict(Constant.DATA_BASE_CLASS_FILE_PATH)
createOccupDict(Constant.DATA_BASE_CLASS_FILE_PATH)
createInitQryPriceInfo(400)