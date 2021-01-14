/*==============================================================*/
/* 猪猪估价创建、用户创建                                        */
/*==============================================================*/
drop database if exists zzpes;
create database zzpes;

drop USER if exists 'test123';
flush privileges;
create user 'test123'@'%' identified by 'test123';
grant ALl privileges ON  zzpes.*  TO  'test123'@'%';
flush privileges;
use zzpes;
