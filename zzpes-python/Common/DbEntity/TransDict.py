"""
	本文件是数据库所有key和Map对应的所有实体类
"""
class BodyDict:
	# 剑三体型翻译实体类
	keyPad = "body"
	keyType = "int"
	jsonData = {}
	jsonData['body0'] = "成男"
	jsonData['成男'] = "0"
	jsonData['body1'] = "成女"
	jsonData['成女'] = "1"
	jsonData['body2'] = "萝莉"
	jsonData['萝莉'] = "2"
	jsonData['body3'] = "正太"
	jsonData['正太'] = "3"

	def trans(data):
		"""
			返回对应的值，如果传入key，则返回val，否则返回key
			:param data:
			:return:
		"""
		if(BodyDict.keyPad+str(data) in BodyDict.jsonData.keys()):
			return BodyDict.jsonData[BodyDict.keyPad+str(data)]
		elif(data in BodyDict.jsonData.keys()):
			return (eval(BodyDict.keyType)(BodyDict.jsonData[data]))
		else:
			return None


class OcptDict:
	# 剑三职业翻译实体类
	keyPad = "ocpt"
	keyType = "int"
	jsonData = {}
	jsonData['ocpt0'] = "万花"
	jsonData['万花'] = "0"
	jsonData['ocpt1'] = "七秀"
	jsonData['七秀'] = "1"
	jsonData['ocpt2'] = "少林"
	jsonData['少林'] = "2"
	jsonData['ocpt3'] = "纯阳"
	jsonData['纯阳'] = "3"
	jsonData['ocpt4'] = "天策"
	jsonData['天策'] = "4"
	jsonData['ocpt5'] = "藏剑"
	jsonData['藏剑'] = "5"
	jsonData['ocpt6'] = "五毒"
	jsonData['五毒'] = "6"
	jsonData['ocpt7'] = "唐门"
	jsonData['唐门'] = "7"
	jsonData['ocpt8'] = "明教"
	jsonData['明教'] = "8"
	jsonData['ocpt9'] = "丐帮"
	jsonData['丐帮'] = "9"
	jsonData['ocpt10'] = "苍云"
	jsonData['苍云'] = "10"
	jsonData['ocpt11'] = "长歌"
	jsonData['长歌'] = "11"
	jsonData['ocpt12'] = "霸刀"
	jsonData['霸刀'] = "12"
	jsonData['ocpt13'] = "蓬莱"
	jsonData['蓬莱'] = "13"
	jsonData['ocpt14'] = "凌雪阁"
	jsonData['凌雪阁'] = "14"
	jsonData['ocpt15'] = "衍天宗"
	jsonData['衍天宗'] = "15"
	jsonData['ocpt16'] = "大侠"
	jsonData['大侠'] = "16"

	def trans(data):
		"""
			返回对应的值，如果传入key，则返回val，否则返回key
			:param data:
			:return:
		"""
		if(OcptDict.keyPad+str(data) in OcptDict.jsonData.keys()):
			return OcptDict.jsonData[OcptDict.keyPad+str(data)]
		elif(data in OcptDict.jsonData.keys()):
			return (eval(OcptDict.keyType)(OcptDict.jsonData[data]))
		else:
			return None


class CampDict:
	# 剑三阵营翻译实体类
	keyPad = "body"
	keyType = "int"
	jsonData = {}
	jsonData['body0'] = "浩气盟"
	jsonData['浩气盟'] = "0"
	jsonData['body1'] = "恶人谷"
	jsonData['恶人谷'] = "1"
	jsonData['body2'] = "中立"
	jsonData['中立'] = "2"

	def trans(data):
		"""
			返回对应的值，如果传入key，则返回val，否则返回key
			:param data:
			:return:
		"""
		if(CampDict.keyPad+str(data) in CampDict.jsonData.keys()):
			return CampDict.jsonData[CampDict.keyPad+str(data)]
		elif(data in CampDict.jsonData.keys()):
			return (eval(CampDict.keyType)(CampDict.jsonData[data]))
		else:
			return None


