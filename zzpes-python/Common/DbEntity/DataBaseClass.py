from sqlalchemy.ext.declarative import declarative_base
Base = declarative_base()
from sqlalchemy import Column, Integer, String,DateTime,Text,Float

def trans(data):
	if(type(data) != int):
		return "\"{data}\"".format(data=data)
	else:
		return str(data)


class Jx3AprceInfo(Base):

	# 剑三外观信息表
	__tablename__ = 'JX3_APRCE_INFO'

	aprceTypeId = Column(Integer, primary_key=True,nullable=False,name='APRCE_TYPE_ID',comment='外观类型ID')
	aprceTypeName = Column(String(length=60),nullable=True,name='APRCE_TYPE_NAME',comment='外观类型名称')
	aprceTypeNameAlias = Column(String(length=300),nullable=True,name='APRCE_TYPE_NAME_ALIAS',comment='外观别称')

	def __repr__(self):
		return "{{\"aprceTypeId\":{aprceTypeId},\"aprceTypeName\":{aprceTypeName},\"aprceTypeNameAlias\":{aprceTypeNameAlias}}}".format(aprceTypeId=trans(self.aprceTypeId),aprceTypeName=trans(self.aprceTypeName),aprceTypeNameAlias=trans(self.aprceTypeNameAlias))


class Jx3BodyShapeInfo(Base):

	# 剑三体型表
	__tablename__ = 'JX3_BODY_SHAPE_INFO'

	bodyShapeId = Column(Integer, primary_key=True,nullable=False,name='BODY_SHAPE_ID',comment='体型ID')
	bodyShapeName = Column(String(length=60),nullable=True,name='BODY_SHAPE_NAME',comment='体型名称')

	def __repr__(self):
		return "{{\"bodyShapeId\":{bodyShapeId},\"bodyShapeName\":{bodyShapeName}}}".format(bodyShapeId=trans(self.bodyShapeId),bodyShapeName=trans(self.bodyShapeName))


class Jx3CampInfo(Base):

	# 剑三阵营记录表
	__tablename__ = 'JX3_CAMP_INFO'

	campTypeId = Column(Integer, primary_key=True,nullable=False,name='CAMP_TYPE_ID',comment='阵营id')
	campTypeName = Column(String(length=20),nullable=True,name='CAMP_TYPE_NAME',comment='阵营名字')

	def __repr__(self):
		return "{{\"campTypeId\":{campTypeId},\"campTypeName\":{campTypeName}}}".format(campTypeId=trans(self.campTypeId),campTypeName=trans(self.campTypeName))


class Jx3OcptInfo(Base):

	# 剑三角色职业信息表
	__tablename__ = 'JX3_OCPT_INFO'

	ocptId = Column(Integer, primary_key=True,nullable=False,name='OCPT_ID',comment='剑三职业ID')
	ocptName = Column(String(length=20),nullable=False,name='OCPT_NAME',comment='剑三职业名字')
	ocptCode = Column(String(length=20),nullable=True,name='OCPT_CODE',comment='剑三职业CODE')

	def __repr__(self):
		return "{{\"ocptId\":{ocptId},\"ocptName\":{ocptName},\"ocptCode\":{ocptCode}}}".format(ocptId=trans(self.ocptId),ocptName=trans(self.ocptName),ocptCode=trans(self.ocptCode))


class Jx3PricePeriodErrorInfo(Base):

	# 剑三价格区间查询错误表
	__tablename__ = 'JX3_PRICE_PERIOD_ERROR_INFO'

	errorId = Column(Integer, primary_key=True,nullable=False,name='ERROR_ID',comment='错误ID')
	batchId = Column(String(length=14),nullable=False,name='BATCH_ID',comment='批次号')
	startPrice = Column(Integer,nullable=True,name='START_PRICE',comment='起始价格')
	endPrice = Column(Integer,nullable=True,name='END_PRICE',comment='结束价格')
	errorState = Column(Integer,nullable=True,name='ERROR_STATE',comment='错误状态')
	errorPageNo = Column(Integer,nullable=True,name='ERROR_PAGE_NO',comment='错误page号')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='更新时间')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='错误状态')

	def __repr__(self):
		return "{{\"errorId\":{errorId},\"batchId\":{batchId},\"startPrice\":{startPrice},\"endPrice\":{endPrice},\"errorState\":{errorState},\"errorPageNo\":{errorPageNo},\"createTime\":{createTime},\"updateTime\":{updateTime}}}".format(errorId=trans(self.errorId),batchId=trans(self.batchId),startPrice=trans(self.startPrice),endPrice=trans(self.endPrice),errorState=trans(self.errorState),errorPageNo=trans(self.errorPageNo),createTime=trans(self.createTime),updateTime=trans(self.updateTime))


class Jx3PricePeriodInfo(Base):

	# 万宝楼价格区间记录表
	__tablename__ = 'JX3_PRICE_PERIOD_INFO'

	batchId = Column(String(length=14),nullable=False,name='BATCH_ID',comment='批次号-本次运行程序时间')
	startPrice = Column(Integer, primary_key=True,nullable=False,name='START_PRICE',comment='起始价格')
	endPrice = Column(Integer,nullable=True,name='END_PRICE',comment='结束价格')
	roleNum = Column(Integer,nullable=True,name='ROLE_NUM',comment='角色数量')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')

	def __repr__(self):
		return "{{\"batchId\":{batchId},\"startPrice\":{startPrice},\"endPrice\":{endPrice},\"roleNum\":{roleNum},\"createTime\":{createTime},\"updateTime\":{updateTime}}}".format(batchId=trans(self.batchId),startPrice=trans(self.startPrice),endPrice=trans(self.endPrice),roleNum=trans(self.roleNum),createTime=trans(self.createTime),updateTime=trans(self.updateTime))


class Jx3PriceQryInfo(Base):

	# 万宝楼需要查询价格查询区间定义表
	__tablename__ = 'JX3_PRICE_QRY_INFO'

	qryId = Column(Integer, primary_key=True,nullable=False,name='QRY_ID',comment='查询id主键')
	batchId = Column(String(length=20),nullable=True,name='BATCH_ID',comment='批次号')
	startPrice = Column(Integer,nullable=True,name='START_PRICE',comment='起始价格')
	endPrice = Column(Integer,nullable=True,name='END_PRICE',comment='结束价格')
	pageNo = Column(Integer,nullable=True,name='PAGE_NO',comment='当前page')
	state = Column(Integer,nullable=True,name='STATE',comment='当前状态-0初始化；1-已执行；2-执行错误')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')

	def __repr__(self):
		return "{{\"qryId\":{qryId},\"batchId\":{batchId},\"startPrice\":{startPrice},\"endPrice\":{endPrice},\"pageNo\":{pageNo},\"state\":{state},\"createTime\":{createTime},\"updateTime\":{updateTime}}}".format(qryId=trans(self.qryId),batchId=trans(self.batchId),startPrice=trans(self.startPrice),endPrice=trans(self.endPrice),pageNo=trans(self.pageNo),state=trans(self.state),createTime=trans(self.createTime),updateTime=trans(self.updateTime))


class Jx3RoleAdventInfo(Base):

	# 剑三角色奇遇记录表
	__tablename__ = 'JX3_ROLE_ADVENT_INFO'

	adventInfoId = Column(Integer, primary_key=True,nullable=False,name='ADVENT_INFO_ID',comment='奇遇信息ID')
	jx3rId = Column(String(length=64),nullable=True,name='JX3R_ID',comment='角色ID')
	adventInfoContent = Column(Text,nullable=True,name='ADVENT_INFO_CONTENT',comment='奇遇内容')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')

	def __repr__(self):
		return "{{\"adventInfoId\":{adventInfoId},\"jx3rId\":{jx3rId},\"adventInfoContent\":{adventInfoContent},\"updateTime\":{updateTime},\"createTime\":{createTime}}}".format(adventInfoId=trans(self.adventInfoId),jx3rId=trans(self.jx3rId),adventInfoContent=trans(self.adventInfoContent),updateTime=trans(self.updateTime),createTime=trans(self.createTime))


class Jx3RoleAprceInfo(Base):

	# 剑三角色外观记录表
	__tablename__ = 'JX3_ROLE_APRCE_INFO'

	aprceInfoId = Column(Integer, primary_key=True,nullable=False,name='APRCE_INFO_ID',comment='外观信息ID')
	jx3rId = Column(String(length=64),nullable=True,name='JX3R_ID',comment='角色ID')
	aprceInfoContent = Column(Text,nullable=True,name='APRCE_INFO_CONTENT',comment='外观内容')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')

	def __repr__(self):
		return "{{\"aprceInfoId\":{aprceInfoId},\"jx3rId\":{jx3rId},\"aprceInfoContent\":{aprceInfoContent},\"updateTime\":{updateTime},\"createTime\":{createTime}}}".format(aprceInfoId=trans(self.aprceInfoId),jx3rId=trans(self.jx3rId),aprceInfoContent=trans(self.aprceInfoContent),updateTime=trans(self.updateTime),createTime=trans(self.createTime))


class Jx3RoleInfoOverall(Base):

	# 剑三角色信息总览
	__tablename__ = 'JX3_ROLE_INFO_OVERALL'

	jx3rId = Column(String(length=64), primary_key=True,nullable=False,name='JX3R_ID',comment='剑三角色ID')
	ocptId = Column(Integer,nullable=False,name='OCPT_ID',comment='职业类型ID')
	bodyShapeId = Column(Integer,nullable=False,name='BODY_SHAPE_ID',comment='体型类型ID')
	price = Column(Float,nullable=True,name='PRICE',comment='价格')
	followNum = Column(Integer,nullable=True,name='FOLLOW_NUM',comment='关注数')
	expPoint = Column(Integer,nullable=True,name='EXP_POINT',comment='资历')
	equipPoint = Column(Integer,nullable=True,name='EQUIP_POINT',comment='装备分数')
	campTypeId = Column(Integer,nullable=True,name='CAMP_TYPE_ID',comment='阵营')
	serverId = Column(String(length=50),nullable=True,name='SERVER_ID',comment='服务器ID')
	state = Column(String(length=1),nullable=True,name='STATE',comment='状态')
	aprceInfoId = Column(Integer,nullable=True,name='APRCE_INFO_ID',comment='外观信息记录ID')
	aprceUpdateTime = Column(DateTime,nullable=False,name='APRCE_UPDATE_TIME',comment='外观信息更新时间')
	petInfoId = Column(Integer,nullable=True,name='PET_INFO_ID',comment='宠物信息记录ID')
	petUpdateTime = Column(DateTime,nullable=False,name='PET_UPDATE_TIME',comment='宠物信息更新时间')
	adventInfoId = Column(Integer,nullable=True,name='ADVENT_INFO_ID',comment='奇遇信息记录ID')
	adventUpdateTime = Column(DateTime,nullable=False,name='ADVENT_UPDATE_TIME',comment='奇遇信息更新时间')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')
	remainingTime = Column(Integer,nullable=True,name='REMAINING_TIME',comment='剩余时间')
	endTime = Column(DateTime,nullable=False,name='END_TIME',comment='到期时间-将剩余时间转成时间的')

	def __repr__(self):
		return "{{\"jx3rId\":{jx3rId},\"ocptId\":{ocptId},\"bodyShapeId\":{bodyShapeId},\"price\":{price},\"followNum\":{followNum},\"expPoint\":{expPoint},\"equipPoint\":{equipPoint},\"campTypeId\":{campTypeId},\"serverId\":{serverId},\"state\":{state},\"aprceInfoId\":{aprceInfoId},\"aprceUpdateTime\":{aprceUpdateTime},\"petInfoId\":{petInfoId},\"petUpdateTime\":{petUpdateTime},\"adventInfoId\":{adventInfoId},\"adventUpdateTime\":{adventUpdateTime},\"createTime\":{createTime},\"updateTime\":{updateTime},\"remainingTime\":{remainingTime},\"endTime\":{endTime}}}".format(jx3rId=trans(self.jx3rId),ocptId=trans(self.ocptId),bodyShapeId=trans(self.bodyShapeId),price=trans(self.price),followNum=trans(self.followNum),expPoint=trans(self.expPoint),equipPoint=trans(self.equipPoint),campTypeId=trans(self.campTypeId),serverId=trans(self.serverId),state=trans(self.state),aprceInfoId=trans(self.aprceInfoId),aprceUpdateTime=trans(self.aprceUpdateTime),petInfoId=trans(self.petInfoId),petUpdateTime=trans(self.petUpdateTime),adventInfoId=trans(self.adventInfoId),adventUpdateTime=trans(self.adventUpdateTime),createTime=trans(self.createTime),updateTime=trans(self.updateTime),remainingTime=trans(self.remainingTime),endTime=trans(self.endTime))


class Jx3RolePetInfo(Base):

	# 剑三角色宠物记录表
	__tablename__ = 'JX3_ROLE_PET_INFO'

	petInfoId = Column(Integer, primary_key=True,nullable=False,name='PET_INFO_ID',comment='宠物信息ID')
	jx3rId = Column(String(length=64),nullable=True,name='JX3R_ID',comment='角色ID')
	petInfoContent = Column(Text,nullable=True,name='PET_INFO_CONTENT',comment='宠物内容')
	updateTime = Column(DateTime,nullable=False,name='UPDATE_TIME',comment='更新时间')
	createTime = Column(DateTime,nullable=False,name='CREATE_TIME',comment='创建时间')

	def __repr__(self):
		return "{{\"petInfoId\":{petInfoId},\"jx3rId\":{jx3rId},\"petInfoContent\":{petInfoContent},\"updateTime\":{updateTime},\"createTime\":{createTime}}}".format(petInfoId=trans(self.petInfoId),jx3rId=trans(self.jx3rId),petInfoContent=trans(self.petInfoContent),updateTime=trans(self.updateTime),createTime=trans(self.createTime))


class Jx3ServerInfo(Base):

	# 剑三服务器信息表
	__tablename__ = 'JX3_SERVER_INFO'

	serverId = Column(String(length=50), primary_key=True,nullable=False,name='SERVER_ID',comment='服务器ID')
	serverName = Column(String(length=100),nullable=True,name='SERVER_NAME',comment='服务器名称')
	serverAlias = Column(String(length=100),nullable=True,name='SERVER_ALIAS',comment='服务器别称')

	def __repr__(self):
		return "{{\"serverId\":{serverId},\"serverName\":{serverName},\"serverAlias\":{serverAlias}}}".format(serverId=trans(self.serverId),serverName=trans(self.serverName),serverAlias=trans(self.serverAlias))


