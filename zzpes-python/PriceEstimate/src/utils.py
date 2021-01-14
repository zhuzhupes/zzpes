import os
def getNewModel(path):
    #获取文件夹中的所有文件
    if(not os.path.isfile(path)):
        return None
    lists = os.listdir(path)
    if(len(lists) <1):
        return None
    #对获取的文件根据修改时间进行排序
    lists.sort(key=lambda x:os.path.getmtime(path +'\\'+x), reverse = True)
    return os.path.join(path,lists[0])
