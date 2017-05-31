/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : sports

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-05-30 20:31:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for breakfastinfo
-- ----------------------------
DROP TABLE IF EXISTS `breakfastinfo`;
CREATE TABLE `breakfastinfo` (
  `breakfastId` varchar(20) NOT NULL,
  `breakfastName` varchar(20) NOT NULL,
  `breakfastCalorie` double(50,0) NOT NULL,
  PRIMARY KEY (`breakfastId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of breakfastinfo
-- ----------------------------
INSERT INTO `breakfastinfo` VALUES ('1', '牛奶排包', '299');
INSERT INTO `breakfastinfo` VALUES ('2', '小米粥', '46');
INSERT INTO `breakfastinfo` VALUES ('3', '面包', '313');
INSERT INTO `breakfastinfo` VALUES ('4', '煮鸡蛋', '151');
INSERT INTO `breakfastinfo` VALUES ('5', '煎鸡蛋', '209');
INSERT INTO `breakfastinfo` VALUES ('6', '豆浆', '16');
INSERT INTO `breakfastinfo` VALUES ('7', '茴香包子', '197');
INSERT INTO `breakfastinfo` VALUES ('8', '豆腐脑', '15');
INSERT INTO `breakfastinfo` VALUES ('9', '油条', '388');

-- ----------------------------
-- Table structure for lunchinfo
-- ----------------------------
DROP TABLE IF EXISTS `lunchinfo`;
CREATE TABLE `lunchinfo` (
  `lunchId` varchar(20) NOT NULL,
  `lunchName` varchar(20) NOT NULL,
  `lunchCalorie` double(50,0) NOT NULL,
  PRIMARY KEY (`lunchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lunchinfo
-- ----------------------------
INSERT INTO `lunchinfo` VALUES ('1', '鸡汤面条', '132');
INSERT INTO `lunchinfo` VALUES ('10', '醋拌甘蓝', '29');
INSERT INTO `lunchinfo` VALUES ('11', '炒土豆丝', '115');
INSERT INTO `lunchinfo` VALUES ('12', '过桥米线', '92');
INSERT INTO `lunchinfo` VALUES ('13', '鸡肉沙拉', '65');
INSERT INTO `lunchinfo` VALUES ('14', '鸡肉丸子汤', '20');
INSERT INTO `lunchinfo` VALUES ('15', '麻辣水煮鱼', '153');
INSERT INTO `lunchinfo` VALUES ('16', '鱼香肉丝', '154');
INSERT INTO `lunchinfo` VALUES ('17', '水煮牛肉', '94');
INSERT INTO `lunchinfo` VALUES ('18', '三鲜饺子', '240');
INSERT INTO `lunchinfo` VALUES ('19', '红烧茄子', '74');
INSERT INTO `lunchinfo` VALUES ('2', '兰州拉面', '357');
INSERT INTO `lunchinfo` VALUES ('20', '凉拌茄子', '40');
INSERT INTO `lunchinfo` VALUES ('3', '老北京炸酱面', '163');
INSERT INTO `lunchinfo` VALUES ('4', '紫菜包饭', '143');
INSERT INTO `lunchinfo` VALUES ('5', '豆豉蒸排骨', '250');
INSERT INTO `lunchinfo` VALUES ('6', '肉末茄子', '172');
INSERT INTO `lunchinfo` VALUES ('7', '素炒小白菜', '46');
INSERT INTO `lunchinfo` VALUES ('8', '辣白菜豆腐汤', '38');
INSERT INTO `lunchinfo` VALUES ('9', '胡萝卜炒木耳', '75');

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
INSERT INTO `sportsinfo` VALUES ('42a39d832f3e448ba9f5', '4d368235c4bbb791718d', '3600', '500', '60', '80', '3000', '5');

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
INSERT INTO `userprofile` VALUES ('4d368235c4bbb791718d', 'xiaoxuehua', '骑行', 'one doctor a day', '减肥', '167', '60', '20', '1', '60', '90');

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
INSERT INTO `vegetableinfo` VALUES ('1', '炒茄子', '106');
INSERT INTO `vegetableinfo` VALUES ('10', '菜心肉圆', '257');
INSERT INTO `vegetableinfo` VALUES ('11', '菠菜饺子', '194');
INSERT INTO `vegetableinfo` VALUES ('12', '白菜烧粉丝', '84');
INSERT INTO `vegetableinfo` VALUES ('13', '辣子鸡', '189');
INSERT INTO `vegetableinfo` VALUES ('14', '玉米花', '406');
INSERT INTO `vegetableinfo` VALUES ('15', '洋葱牛肉', '165');
INSERT INTO `vegetableinfo` VALUES ('16', '山药干', '101');
INSERT INTO `vegetableinfo` VALUES ('17', '酸辣莲藕', '107');
INSERT INTO `vegetableinfo` VALUES ('18', '肥牛金针菇', '127');
INSERT INTO `vegetableinfo` VALUES ('19', '干煸四季豆', '117');
INSERT INTO `vegetableinfo` VALUES ('2', '海带炖肉', '316');
INSERT INTO `vegetableinfo` VALUES ('20', '排骨白萝卜汤', '193');
INSERT INTO `vegetableinfo` VALUES ('4', '煮碗豆', '107');
INSERT INTO `vegetableinfo` VALUES ('5', '香菇鸡笋', '150');
INSERT INTO `vegetableinfo` VALUES ('6', '雪菜炒黄豆', '124');
INSERT INTO `vegetableinfo` VALUES ('7', '竹笋焖肉', '290');
INSERT INTO `vegetableinfo` VALUES ('8', '孜然羊羔肉', '233');
INSERT INTO `vegetableinfo` VALUES ('9', '鲜虾芦笋', '162');
