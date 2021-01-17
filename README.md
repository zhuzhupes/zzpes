# zzpes
### Zhu Zhu Prie Estimate System-ZZPES
**猪猪价格估计/估算系统**，简称<u>**猪猪估价**</u>



========

该系统的目录结构

## 代码目录结构

```
├── zzpes-parent 后端Java代码
├── zzpes-python Python代码（包括数据采集以及数据训练方法）
    ├── Common 公用方法
        ├── DbEntity 数据库生成的Python实体对象
            ├── DataBaseClass.py 所有实体对象形成的class（基于sqlalchemy）
            └── TransDict.py 能翻译的字段（区服、体型、职业等）
        ├── CodeCracker.py 验证码破解（都还没写）
        ├── Constant.py 一些静态变量
        ├── CreateDataBaseClassSingleFile.py 初始化脚本，包括：1.执行sql 2.生成实体类 3.生成transDict对象
        ├── CreateDtlFile.py 创建详情文件（将数据库中的信息创建dtl文件）
        ├── DataUtils.py 数据工具（奇遇是一个图，它是坐标进行获取）
        ├── DbHelper.py 数据库基础工具：连接和关闭
        ├── DBSession.py 主要数据库操作：数据保存和查询等
        ├── fileappend.py 大概是没啥用的
        ├── LocalFileAdapter.py 大概也是没啥用的
        ├── logger.py 日志类： spiderLog：数据获取日志（从网络获取） ，dbLog：存储数据库过程中的日志，peLog：价格估计模型训练过程中的日志           
        ├── utils.py 一些日志
    ├── Demo 一些样例数据
    ├── Doc 数据库设计Powerdesign 工作空间文件
    ├── PriceEstimate 价格估计（Pytorch训练项目）
    ├── Test 随便一些test方法
    └── WanBaoLouSpider 数据获取代码目录
├── zzpes-web 前端项目
       
```
## 启动步骤





## 一些话说
1. 数据采集方面，简单使用Python

2. 模型训练（还没开始）准备使用pytorch

3. web和后端使用mall项目，很方便
   [macrozheng/mall项目](https://github.com/macrozheng/mall)

4. mall项目自带的代码生成器不能生成controller，而且各人也不喜欢getting和setting，因此**在其基础上**进行修改，参考
   [代码生成器](www.baidu.com)  并修改controller和comment等最后形成代码生成器