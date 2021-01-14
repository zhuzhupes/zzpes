# JRPES
Jx3 Role Price Estimate System-JRPES

**剑三角色价格估算系统**，简称<u>**瞎猪估价系统**</u>

========

该系统的目录结构

## 代码目录结构

```
├── Common 项目Python公共方法
   ├── Constant.py 静态变量
   ├── CreateDataBaseClassSingleFile.py 生成单个数据库实体类DbEntity文件夹下的所有，以及创建表
   ├── DBSession.py 爬虫处理过程中数据库操作类
   ├── logger.py 日志处理类
   ├── utils.py 工具类
   └── DbEntity 数据库实体类（包括dict翻译类以及数据表类，都是生成的）
       ├── DataBaseClass.py  所有表的实体
       └── TransDict.py      所有中文翻译Dict
├── Doc 项目文档
   └── PowerDesigner 数据库设计
       ├── testdata.sql  		创建insert语句
       └── 工作空间.sws           PowerDesigner工作空间
├── Test 测试文件目录
   └── MethodTest.py 临时测试文件
├── WanBaoLouSpider 万宝楼数据获取项目
   ├── main.py
   ├── src Python资源文件
       ├── ...
   └── doc 文档目录
       └── create.sql  		创建数据库和用户
       
```
## 启动步骤