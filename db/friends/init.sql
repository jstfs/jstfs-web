--登录root用户

--创建数据库
DROP DATABASE IF EXISTS `friends`;
CREATE DATABASE `friends`;

--创建用户
DROP USER IF EXISTS `jstfs-web`;
CREATE USER 'jstfs-web'@'localhost' IDENTIFIED BY '密码';

--授权用户数据库权限
GRANT ALL PRIVILEGES ON friends.* TO 'jstfs-web'@'localhost' WITH GRANT OPTION;


--登录jstfs-web用户

--创建'朋友类型'表
DROP TABLE IF EXISTS `friend_type`;
CREATE TABLE `friend_type` (
	`type_id`		INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
	`type_name`		VARCHAR(50) NOT NULL,
	`context`		VARCHAR(500),
	`creat_time` 	DATETIME,
	`created_by`	VARCHAR(50) DEFAULT 'system',
	`update_time`	DATETIME,
	`updated_by`	VARCHAR(50) DEFAULT 'system'
);

--创建'朋友'表
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
	`friend_id`			INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
	`type_id`			INT NOT NULL,
	`friend_name`		VARCHAR(50) NOT NULL,
	`friend_address`	VARCHAR(50) NOT NULL,
	`friend_tel`		VARCHAR(20) NOT NULL,
	`context`			VARCHAR(500),
	`creat_time` 		DATETIME,
	`created_by`		VARCHAR(50) DEFAULT 'system',
	`update_time`		DATETIME,
	`updated_by`		VARCHAR(50) DEFAULT 'system'
);

--插入基础数据
INSERT INTO `friend_type` VALUES(NULL, '小学同学','6-12岁期间', now(), DEFAULT, now(), DEFAULT);
INSERT INTO `friend_type` VALUES(NULL, '中学同学','13-18岁期间', now(), DEFAULT, now(), DEFAULT);
INSERT INTO `friend_type` VALUES(NULL, '大学同学','19-22岁期间', now(), DEFAULT, now(), DEFAULT);
INSERT INTO `friend_type` VALUES(NULL, '公司A的同事','在公司A任职期间', now(), DEFAULT, now(), DEFAULT);
INSERT INTO `friend_type` VALUES(NULL, '公司B的同事','在公司B任职期间', now(), DEFAULT, now(), DEFAULT);
commit;