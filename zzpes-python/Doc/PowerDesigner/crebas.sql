/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/1/4 15:18:38                            */
/*==============================================================*/


drop table if exists JX3_ADT_TYPE_KEY;

drop table if exists JX3_BODY_SHAPE_INFO;

drop table if exists JX3_CAMP_INFO;

drop table if exists JX3_DTL_INFO;

drop table if exists JX3_OCPT_INFO;

drop table if exists JX3_PRICE_PERIOD_ERROR_INFO;

drop table if exists JX3_PRICE_QRY_INFO;

drop table if exists JX3_ROLE_ADVENT_INFO;

drop table if exists JX3_ROLE_APRCE_INFO;

drop table if exists JX3_ROLE_INFO_OVERALL;

drop table if exists JX3_ROLE_PET_INFO;

drop table if exists JX3_SERVER_INFO;

/*==============================================================*/
/* Table: JX3_ADT_TYPE_KEY                                      */
/*==============================================================*/
create table JX3_ADT_TYPE_KEY
(
   DTL_TYPE             varchar(20) not null comment '详情类型',
   DTL_RES_KEY          varchar(20) comment '结果key',
   DTL_NAME             varchar(40) comment '详情类型名称',
   primary key (DTL_TYPE)
);

alter table JX3_ADT_TYPE_KEY comment '详情key和类型对应表';

INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_equipment_info', 'equip','装备');
INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_appearance_info', 'appearance','外观');
INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_adventure_info', 'adventure','奇遇');
INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_pet_info', 'pet','宠物');
INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_homeland_info', 'homeland','家园');
INSERT INTO JX3_ADT_TYPE_KEY (DTL_TYPE, DTL_RES_KEY, DTL_NAME) VALUES('role_other_info', 'designation','其他');

/*==============================================================*/
/* Table: JX3_BODY_SHAPE_INFO                                   */
/*==============================================================*/
create table JX3_BODY_SHAPE_INFO
(
   BODY_SHAPE_ID        int not null comment '体型ID',
   BODY_SHAPE_NAME      varchar(60) comment '体型名称',
   primary key (BODY_SHAPE_ID)
);

alter table JX3_BODY_SHAPE_INFO comment '剑三体型表';

INSERT INTO JX3_BODY_SHAPE_INFO (BODY_SHAPE_ID, BODY_SHAPE_NAME) VALUES (0, '成男');
INSERT INTO JX3_BODY_SHAPE_INFO (BODY_SHAPE_ID, BODY_SHAPE_NAME) VALUES (1, '成女');
INSERT INTO JX3_BODY_SHAPE_INFO (BODY_SHAPE_ID, BODY_SHAPE_NAME) VALUES (2, '萝莉');
INSERT INTO JX3_BODY_SHAPE_INFO (BODY_SHAPE_ID, BODY_SHAPE_NAME) VALUES (3, '正太');

/*==============================================================*/
/* Table: JX3_CAMP_INFO                                         */
/*==============================================================*/
create table JX3_CAMP_INFO
(
   CAMP_TYPE_ID         int not null comment '阵营id',
   CAMP_TYPE_NAME       varchar(20) comment '阵营名字',
   primary key (CAMP_TYPE_ID)
);

alter table JX3_CAMP_INFO comment '剑三阵营记录表';

INSERT INTO JX3_CAMP_INFO(CAMP_TYPE_ID, CAMP_TYPE_NAME) VALUES (0, "浩气盟");
INSERT INTO JX3_CAMP_INFO(CAMP_TYPE_ID, CAMP_TYPE_NAME) VALUES (1, "恶人谷");
INSERT INTO JX3_CAMP_INFO(CAMP_TYPE_ID, CAMP_TYPE_NAME) VALUES (2, "中立");

/*==============================================================*/
/* Table: JX3_DTL_INFO                                          */
/*==============================================================*/
create table JX3_DTL_INFO
(
   DTL_ID               integer not null auto_increment comment '详情日志ID',
   DTL_TYPE             varchar(30) comment '详情类别',
   DTL_TYPE_DTL         varchar(30) comment '详情小类',
   DTL_TYPE_ID          int comment '详情具体id',
   DTL_URL              varchar(40) comment '详情图标URL',
   DTL_ALIACE           varchar(60) comment '详情别称',
   DTL_ZHCN_NAME        varchar(60) comment '详情中文名称',
   primary key (DTL_ID)
);

alter table JX3_DTL_INFO comment '剑三详情信息表';

/*==============================================================*/
/* Table: JX3_OCPT_INFO                                         */
/*==============================================================*/
create table JX3_OCPT_INFO
(
   OCPT_ID              int not null comment '剑三职业ID',
   OCPT_NAME            varchar(20) not null comment '剑三职业名字',
   OCPT_CODE            varchar(20) comment '剑三职业CODE',
   primary key (OCPT_ID)
);

alter table JX3_OCPT_INFO comment '剑三角色职业信息表';

INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (0, '万花', 'WH');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (1, '七秀', 'QX');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (2, '少林', 'HS');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (3, '纯阳', 'CY');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (4, '天策', 'TC');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (5, '藏剑', 'CJ');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (6, '五毒', 'WD');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (7, '唐门', 'TM');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (8, '明教', 'MJ');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (9, '丐帮', 'GB');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (10, '苍云', 'CY');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (11, '长歌', 'CG');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (12, '霸刀', 'BD');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (13, '蓬莱', 'PL');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (14, '凌雪阁', 'LX');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (15, '衍天宗', 'YTZ');
INSERT INTO JX3_OCPT_INFO (OCPT_ID, OCPT_NAME, OCPT_CODE) VALUES (16, '大侠', 'DX');

/*==============================================================*/
/* Table: JX3_PRICE_PERIOD_ERROR_INFO                           */
/*==============================================================*/
create table JX3_PRICE_PERIOD_ERROR_INFO
(
   ERROR_ID             integer not null auto_increment comment '错误ID',
   BATCH_ID             varchar(14) not null comment '批次号',
   START_PRICE          int comment '起始价格',
   END_PRICE            int comment '结束价格',
   ERROR_STATE          int comment '错误状态',
   ERROR_PAGE_NO        int comment '错误page号',
   CREATE_TIME          timestamp comment '更新时间',
   UPDATE_TIME          timestamp comment '错误状态',
   primary key (ERROR_ID)
);

alter table JX3_PRICE_PERIOD_ERROR_INFO comment '剑三价格区间查询错误表';

/*==============================================================*/
/* Table: JX3_PRICE_QRY_INFO                                    */
/*==============================================================*/
create table JX3_PRICE_QRY_INFO
(
   QRY_ID               integer not null auto_increment comment '查询id主键',
   BATCH_ID             varchar(20) comment '批次号',
   START_PRICE          int comment '起始价格',
   END_PRICE            int comment '结束价格',
   PAGE_NO              int comment '当前page',
   STATE                int comment '当前状态-0初始化；1-已执行；2-执行错误',
   RANGE_TOTAL_NUMS     int comment '区间总条数',
   NOW_PAGE_DATA_NUM    int comment '本业条数',
   CREATE_TIME          timestamp comment '创建时间',
   UPDATE_TIME          timestamp comment '更新时间',
   primary key (QRY_ID)
);

alter table JX3_PRICE_QRY_INFO comment '万宝楼需要查询价格查询区间定义表';

/*==============================================================*/
/* Table: JX3_ROLE_ADVENT_INFO                                  */
/*==============================================================*/
create table JX3_ROLE_ADVENT_INFO
(
   ADVENT_INFO_ID       integer not null auto_increment comment '奇遇信息ID',
   JX3R_ID              varchar(64) comment '角色ID',
   ADVENT_INFO_CONTENT  text comment '奇遇内容',
   UPDATE_TIME          timestamp comment '更新时间',
   CREATE_TIME          timestamp comment '创建时间',
   CONTENT_SAVE_TYPE    varchar(20) comment '保存算法',
   primary key (ADVENT_INFO_ID)
);

alter table JX3_ROLE_ADVENT_INFO comment '剑三角色奇遇记录表';

/*==============================================================*/
/* Table: JX3_ROLE_APRCE_INFO                                   */
/*==============================================================*/
create table JX3_ROLE_APRCE_INFO
(
   APRCE_INFO_ID        integer not null auto_increment comment '外观信息ID',
   JX3R_ID              varchar(64) comment '角色ID',
   APRCE_INFO_CONTENT   text comment '外观内容',
   UPDATE_TIME          timestamp comment '更新时间',
   CREATE_TIME          timestamp comment '创建时间',
   CONTENT_SAVE_TYPE    varchar(20) comment '保存算法',
   primary key (APRCE_INFO_ID)
);

alter table JX3_ROLE_APRCE_INFO comment '剑三角色外观记录表';

/*==============================================================*/
/* Table: JX3_ROLE_INFO_OVERALL                                 */
/*==============================================================*/
create table JX3_ROLE_INFO_OVERALL
(
   JX3R_ID              varchar(64) not null comment '剑三角色ID',
   OCPT_ID              int not null comment '职业类型ID',
   BODY_SHAPE_ID        int not null comment '体型类型ID',
   PRICE                float comment '价格',
   FOLLOW_NUM           int comment '关注数',
   EXP_POINT            int comment '资历',
   EQUIP_POINT          int comment '装备分数',
   CAMP_TYPE_ID         int comment '阵营',
   SERVER_ID            varchar(50) comment '服务器ID',
   STATE                char comment '状态',
   DTL_INFO_CONTENT     blob comment '详情信息',
   DTL_INFO_UPDATE_TIME timestamp comment '详情信息更新时间',
   CREATE_TIME          timestamp comment '创建时间',
   UPDATE_TIME          timestamp comment '更新时间',
   REMAINING_TIME       int comment '剩余时间',
   END_TIME             timestamp comment '到期时间-将剩余时间转成时间的',
   primary key (JX3R_ID)
);

alter table JX3_ROLE_INFO_OVERALL comment '剑三角色信息总览';

/*==============================================================*/
/* Table: JX3_ROLE_PET_INFO                                     */
/*==============================================================*/
create table JX3_ROLE_PET_INFO
(
   PET_INFO_ID          int not null auto_increment comment '宠物信息ID',
   JX3R_ID              varchar(64) comment '角色ID',
   PET_INFO_CONTENT     text comment '宠物内容',
   UPDATE_TIME          timestamp comment '更新时间',
   CREATE_TIME          timestamp comment '创建时间',
   CONTENT_SAVE_TYPE    varchar(20) comment '保存算法',
   primary key (PET_INFO_ID)
);

alter table JX3_ROLE_PET_INFO comment '剑三角色宠物记录表';

/*==============================================================*/
/* Table: JX3_SERVER_INFO                                       */
/*==============================================================*/
create table JX3_SERVER_INFO
(
   SERVER_ID            varchar(50) not null comment '服务器ID',
   SERVER_NAME          varchar(100) comment '服务器名称',
   SERVER_ALIAS         varchar(100) comment '服务器别称',
   primary key (SERVER_ID)
);

alter table JX3_SERVER_INFO comment '剑三服务器信息表';

INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z01gate0101', '电信一区-长安城', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z01gate0115', '电信一区-龙争虎斗', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z01gate0126', '电信一区-蝶恋花', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0502', '电信五区-梦江南', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0505', '电信五区-唯我独尊', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0514', '电信五区-乾坤一掷', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0515', '电信五区-斗转星移', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0519', '电信五区-幽月轮', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0524', '电信五区-剑胆琴心', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z05gate0530', '电信五区-执子之手', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z08gate0807', '电信八区-绝代天骄', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z21gate2106', '双线一区-破阵子', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z21gate2107', '双线一区-天鹅坪', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z22gate2204', '双线二区-飞龙在天', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z24gate2402', '双线四区-青梅煮酒', NULL);
INSERT INTO jx3_server_info(SERVER_ID, SERVER_NAME, SERVER_ALIAS)VALUES('z24gate2411', '双线四区-奉天证道', NULL);

