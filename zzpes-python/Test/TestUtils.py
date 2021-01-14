from Common.Constant import Constant
import json
import re
from Common.utils import loads_jsonp

class TestUtils:

    @staticmethod
    def getTestData(filePath):
        with open(filePath, 'r',encoding='utf8') as f:
            str = ""
            for line in f.readlines():
                str += line.replace('\n','').replace('\t','')
            return str




if __name__=="__main__":
    TestUtils.getTestData(Constant.TEST_OVERALL_INFO_JSONP_PATH)
    TestUtils.getTestData(Constant.TEST_DTLADVNT_INFO_JSONP_PATH)
    TestUtils.getTestData(Constant.TEST_DTLAPRCE_INFO_JSONP_PATH)
    TestUtils.getTestData(Constant.TEST_DTLPET_INFO_JSONP_PATH)