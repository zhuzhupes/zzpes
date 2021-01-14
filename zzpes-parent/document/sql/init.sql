


-- 病人信息表：
DROP TABLE IF EXISTS patient_info;
create table patient_info(
                             patient_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '病人seq号',
                             patient_name varchar(60) comment '病人名',
                             start_date date comment '首次时间',
                             treat_times int comment '治疗次数',
                             cure_times int comment '治愈次数',
                             last_update_time time comment '上次更新时间',
                             last_update_type varchar(5) comment '上次更新操作',
                             last_update_user varchar(20) comment '上次更新操作员',
                             constraint P_Key_1 primary key (patient_seq)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '病人信息表';

-- 操作类型：
-- appd===新增
-- cure===新增治愈
--


-- 药材信息表：
DROP TABLE IF EXISTS herb_info;
create table herb_info(
                          herb_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '药材seq',
                          herb_name varchar(60)  comment '药材中文名',
                          herb_eng_name varchar(60) comment '药材英文名字',
                          herb_function varchar(100) comment '药材功效',
                          herb_disease varchar(100) comment '对应病症',
                          constraint P_Key_1 primary key (herb_seq)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '药材信息表';


DROP TABLE IF EXISTS unit_info;
-- 计量单位表：
create table unit_info(
                          unit_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '单位seq',
                          unit_name varchar(60) comment '单位中文名',
                          unit_short_name varchar(60) comment '单位缩写',
                          create_date date comment '创建日期',
                          create_user_id bigint(20)  comment '创建用户',
                          constraint P_Key_1 primary key (unit_seq)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '计量单位表';

DROP TABLE IF EXISTS `herb_unit_info`;
-- 药品计量单位表：
create table herb_unit_info(
                               herb_unit_seq bigint(20) NOT NULL AUTO_INCREMENT comment '药品计量单位seq',
                               herb_seq int comment '药材seq',
                               unit_seq int comment '单位seq',
                               constraint P_Key_1 primary key (herb_unit_seq)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8  comment = '药品计量单位表';


-- 额外操作表：
DROP TABLE IF EXISTS operation_info;
create table operation_info(
                               operation_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '操作seq',
                               operation_name varchar(60)  comment '操作名',
                               create_date date comment '创建日期',
                               create_user_id bigint(20)  comment '创建用户',
                               constraint P_Key_1 primary key (operation_seq)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8  comment = '额外操作表';



-- 药品额外操作表：
DROP TABLE IF EXISTS herb_operation_info;
create table herb_operation_info(
                                    herb_operation_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '药品额外操作记录seq',
                                    herb_seq int comment '药材seq',
                                    operation_seq int comment '操作seq',
                                    unit_seq int comment '单位seq',
                                    constraint P_Key_1 primary key (herb_operation_seq)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '药品额外操作表';


-- 药方概述表：
DROP TABLE IF EXISTS prescription_overall_info;
create table prescription_overall_info(
                                          prescription_id  bigint(20) NOT NULL AUTO_INCREMENT  comment '开方记录id',
                                          patient_id varchar(60)  comment '用户id',
                                          prescription_last_id varchar(60) comment '上次药方记录id',
                                          prescription_next_id varchar(60) comment '下次药方记录id',
                                          final_state varchar(100) comment '最终状态',
                                          prescription_date date comment '开方时间',
                                          constraint P_Key_1 primary key (prescription_id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8  comment = '药方概述表';

-- 处方表：
DROP TABLE IF EXISTS prescription_info;
create table prescription_info(
                                  prescription_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '处方主键',
                                  prescription_id int comment '开方记录id',
                                  herb_seq int comment '药材seq',
                                  unit_seq int comment '单位seq',
                                  unit_num int comment '单位数量',
                                  operation_seq int comment '操作seq',
                                  operation_unit_seq int comment '操作单位',
                                  operation_unit_num int comment '单位次数',
                                  constraint P_Key_1 primary key (prescription_seq)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '处方表';


-- 病症表
DROP TABLE IF EXISTS symptom_info;
create table symptom_info(
                             symptom_seq  bigint(20) NOT NULL AUTO_INCREMENT  comment '病症seq',
                             symptom_name varchar(60)  comment '病症中文名',
                             constraint P_Key_1 primary key (symptom_seq)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '病症表';






INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻干");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻干燥");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻流清涕");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻流浊涕");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻鸣");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻衄");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻塞");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻咽部慢性炎症");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻痒");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻渊");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("鼻燥");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("闭合性新旧软组织损伤");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("闭经");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("痹病");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("痹痛");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("臂疼痛");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("臂痛");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便闭");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便干");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便黄而黏");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便结");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便秘");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便溏");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便溏日久");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便下脓血");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便泻");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("便血");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("表虚自汗");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("憋气");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("病后体弱");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("病后脱发");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("病后虚弱");
INSERT INTO zzpes.symptom_info (symptom_name) VALUES ("不饥");


INSERT INTO zzpes.herb_info (herb_name) VALUES ("矮地茶");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("艾叶");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("安息香");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("八角茴香");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("八角莲");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("巴豆");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("巴戟天");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("菝葜");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白扁豆");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白附子");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白果");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白花菜子");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白花蛇舌草");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白及");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白蔹");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白毛藤");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白毛夏枯草");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白茅根");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白前");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白屈菜");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白芍");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白术");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白头翁");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白薇");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白鲜皮");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白药子");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("白芷");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("百部");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("百合");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("柏子仁");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("败酱草");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("斑蝥");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("板蓝根");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("半边莲");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("半夏");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("半枝莲");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("薄荷");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("北豆根");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("北刘寄奴");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("北沙参");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("北五味子");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("荜茇");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("荜澄茄");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("蓖麻子");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("萹蓄");
INSERT INTO zzpes.herb_info (herb_name) VALUES ("扁豆花");





