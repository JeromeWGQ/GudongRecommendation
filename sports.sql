/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : sports

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-05-01 10:55:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sportsinfo
-- ----------------------------
DROP TABLE IF EXISTS `sportsinfo`;
CREATE TABLE `sportsinfo` (
  `sportsId` varchar(20) NOT NULL,
  `userId` varchar(20) NOT NULL,
  `length` varchar(30) DEFAULT NULL,
  `caloria` double DEFAULT NULL,
  `bupin` int(11) DEFAULT NULL,
  `bufu` int(11) DEFAULT NULL,
  `steps` int(11) DEFAULT NULL,
  `avgspeed` double DEFAULT NULL,
  PRIMARY KEY (`sportsId`),
  KEY `foreign2` (`userId`),
  KEY `FK8F54AD4C2D0236` (`userId`),
  KEY `FK8F54AD49B00B9B` (`userId`),
  CONSTRAINT `FK8F54AD49B00B9B` FOREIGN KEY (`userId`) REFERENCES `userlogininfo` (`userId`),
  CONSTRAINT `FK8F54AD4C2D0236` FOREIGN KEY (`userId`) REFERENCES `userlogininfo` (`userId`),
  CONSTRAINT `foreign2` FOREIGN KEY (`userId`) REFERENCES `userlogininfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sportsinfo
-- ----------------------------
INSERT INTO `sportsinfo` VALUES ('46cb8177c233c48de32f', '4d368235c4bbb791718d', '3600', '500', '60', '80', '3000', '5');

-- ----------------------------
-- Table structure for userimg
-- ----------------------------
DROP TABLE IF EXISTS `userimg`;
CREATE TABLE `userimg` (
  `userid` varchar(255) NOT NULL,
  `imgbase64` mediumtext,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userimg
-- ----------------------------
INSERT INTO `userimg` VALUES ('4d368235c4bbb791718d', 'dsdaffgadsdsdsd');

-- ----------------------------
-- Table structure for userlogininfo
-- ----------------------------
DROP TABLE IF EXISTS `userlogininfo`;
CREATE TABLE `userlogininfo` (
  `userId` varchar(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlogininfo
-- ----------------------------
INSERT INTO `userlogininfo` VALUES ('4d368235c4bbb791718d', 'gaofeng', '943238EC6649F542B2846BF01CBB3A70');
INSERT INTO `userlogininfo` VALUES ('4fd799d5016b3e2f9071', 'baixue', '11F0CB3BC121135F3274E772CDB81B5E');

-- ----------------------------
-- Table structure for userprofile
-- ----------------------------
DROP TABLE IF EXISTS `userprofile`;
CREATE TABLE `userprofile` (
  `userid` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `interest` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `pWeight` double DEFAULT NULL,
  `pDays` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprofile
-- ----------------------------
INSERT INTO `userprofile` VALUES ('4d368235c4bbb791718d', 'feng', 'chifan', 'chihaofan', 'chihaoduofan', '175', '120', '22', '1', '130', '30');

-- ----------------------------
-- Table structure for vegetableinfo
-- ----------------------------
DROP TABLE IF EXISTS `vegetableinfo`;
CREATE TABLE `vegetableinfo` (
  `vegetableId` varchar(20) NOT NULL,
  `vegetableName` varchar(20) NOT NULL,
  `vegetableCalorie` double(50,0) NOT NULL,
  PRIMARY KEY (`vegetableId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vegetableinfo
-- ----------------------------
INSERT INTO `vegetableinfo` VALUES ('1', '茄子', '250');
INSERT INTO `vegetableinfo` VALUES ('10', '菜心', '400');
INSERT INTO `vegetableinfo` VALUES ('11', '菠菜', '220');
INSERT INTO `vegetableinfo` VALUES ('12', '白菜', '150');
INSERT INTO `vegetableinfo` VALUES ('13', '辣椒', '630');
INSERT INTO `vegetableinfo` VALUES ('14', '玉米', '710');
INSERT INTO `vegetableinfo` VALUES ('15', '洋葱', '410');
INSERT INTO `vegetableinfo` VALUES ('16', '山药', '720');
INSERT INTO `vegetableinfo` VALUES ('17', '莲藕', '740');
INSERT INTO `vegetableinfo` VALUES ('18', '金针菇', '410');
INSERT INTO `vegetableinfo` VALUES ('19', '四季豆', '260');
INSERT INTO `vegetableinfo` VALUES ('2', '海带', '160');
INSERT INTO `vegetableinfo` VALUES ('20', '白萝卜', '170');
INSERT INTO `vegetableinfo` VALUES ('4', '豌豆', '167');
INSERT INTO `vegetableinfo` VALUES ('5', '芹菜', '110');
INSERT INTO `vegetableinfo` VALUES ('6', '雪菜', '600');
INSERT INTO `vegetableinfo` VALUES ('7', '竹笋', '400');
INSERT INTO `vegetableinfo` VALUES ('8', '红萝卜', '380');
INSERT INTO `vegetableinfo` VALUES ('9', '芦笋', '270');
