/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : db_ticket

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-11-25 08:40:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_city
-- ----------------------------
INSERT INTO `tb_city` VALUES ('1', '武汉');
INSERT INTO `tb_city` VALUES ('2', '深圳');
INSERT INTO `tb_city` VALUES ('3', '天津');
INSERT INTO `tb_city` VALUES ('4', '北京');

-- ----------------------------
-- Table structure for tb_station
-- ----------------------------
DROP TABLE IF EXISTS `tb_station`;
CREATE TABLE `tb_station` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `station_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`station_id`),
  KEY `FK_r1` (`city_id`),
  CONSTRAINT `FK_r1` FOREIGN KEY (`city_id`) REFERENCES `tb_city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_station
-- ----------------------------
INSERT INTO `tb_station` VALUES ('1', '1', '武昌');
INSERT INTO `tb_station` VALUES ('2', '1', '汉口');
INSERT INTO `tb_station` VALUES ('3', '1', '武汉');

-- ----------------------------
-- Table structure for tb_train
-- ----------------------------
DROP TABLE IF EXISTS `tb_train`;
CREATE TABLE `tb_train` (
  `train_id` int(11) NOT NULL AUTO_INCREMENT,
  `train_name` varchar(20) DEFAULT NULL,
  `train_type` varchar(20) DEFAULT NULL,
  `train_seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_train
-- ----------------------------

-- ----------------------------
-- Table structure for tb_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_line`;
CREATE TABLE `tb_line` (
  `train_id` int(11) NOT NULL,
  `station_id` int(11) NOT NULL,
  `cur_time` datetime DEFAULT NULL,
  `seat_num` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`train_id`,`station_id`),
  KEY `FK_r7` (`station_id`),
  CONSTRAINT `FK_r6` FOREIGN KEY (`train_id`) REFERENCES `tb_train` (`train_id`),
  CONSTRAINT `FK_r7` FOREIGN KEY (`station_id`) REFERENCES `tb_station` (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_line
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_name` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `idcard` char(18) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------



-- ----------------------------
-- Table structure for tb_ticket
-- ----------------------------
DROP TABLE IF EXISTS `tb_ticket`;
CREATE TABLE `tb_ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_station` int(11) NOT NULL,
  `end_station` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `train_id` int(11) NOT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `FK_Relationship_5` (`train_id`),
  KEY `FK_goal_station` (`end_station`),
  KEY `FK_r2` (`user_id`),
  KEY `FK_start_station` (`start_station`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`train_id`) REFERENCES `tb_train` (`train_id`),
  CONSTRAINT `FK_goal_station` FOREIGN KEY (`end_station`) REFERENCES `tb_station` (`station_id`),
  CONSTRAINT `FK_r2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `FK_start_station` FOREIGN KEY (`start_station`) REFERENCES `tb_station` (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ticket
-- ----------------------------
