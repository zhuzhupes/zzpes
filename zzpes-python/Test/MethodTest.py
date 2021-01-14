from Common.DbEntity.DataBaseClass import *
from Common.DbEntity.TransDict import *
import json
import os
def test():
    print(os.getcwd())
    pwd = os.getcwd()
    father_path=os.path.abspath(os.path.dirname(pwd)+os.path.sep+".")
    print(father_path)
    pass

if __name__ == "__main__":
    test()