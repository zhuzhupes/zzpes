/*==============================================================*/
/* 万宝楼数据库创建、用户创建                                        */
/*==============================================================*/
drop database if exists jrpes;
create database jrpes;

drop USER if exists 'test123';
flush privileges;
create user 'test123'@'%' identified by 'test123';
grant ALl privileges ON  jrpes.*  TO  'test123'@'%';
flush privileges;
