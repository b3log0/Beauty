/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : beauty

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-04-11 17:27:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for broker
-- ----------------------------
DROP TABLE IF EXISTS `broker`;
CREATE TABLE `broker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL COMMENT '客户',
  `puller` int(11) NOT NULL COMMENT '开户人',
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of broker
-- ----------------------------

-- ----------------------------
-- Table structure for buygoods
-- ----------------------------
DROP TABLE IF EXISTS `buygoods`;
CREATE TABLE `buygoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) NOT NULL COMMENT '商品ID',
  `price` float(10,2) NOT NULL COMMENT '商品价格',
  `goodsSnapshot` varchar(1024) NOT NULL COMMENT '购买商品快照',
  `createDate` datetime NOT NULL COMMENT '购买时间',
  `num` int(11) NOT NULL COMMENT '购买数量',
  `state` int(1) NOT NULL COMMENT '状态',
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buygoods
-- ----------------------------

-- ----------------------------
-- Table structure for carerecord
-- ----------------------------
DROP TABLE IF EXISTS `carerecord`;
CREATE TABLE `carerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personId` int(11) DEFAULT NULL COMMENT '客户',
  `userId` int(11) DEFAULT NULL COMMENT '技师',
  `goodsId` int(11) DEFAULT NULL COMMENT '使用产品IDs',
  `createDate` datetime DEFAULT NULL COMMENT '护理时间',
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carerecord
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `userId` int(11) DEFAULT NULL COMMENT '账号ID',
  `type` int(11) DEFAULT NULL COMMENT '用户类别  0 管理员 1用户',
  `skin` varchar(255) DEFAULT NULL COMMENT '皮肤',
  `symptom` varchar(255) DEFAULT NULL COMMENT '症状',
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('6', '朱志强', '23', '男', '123456', '456789', null, null, null, null, null, null);
INSERT INTO `person` VALUES ('7', '朱志强', '23', '男', '123', '15896731218', '7', '0', null, null, '2018-04-11 11:03:49', null);
INSERT INTO `person` VALUES ('8', '朱志强', '23', '男', 'qwer', '123', '8', '0', null, null, '2018-04-11 11:26:20', null);
INSERT INTO `person` VALUES ('9', '123', '123', '女', '132', '465', '9', '0', null, null, '2018-04-11 11:27:00', null);
INSERT INTO `person` VALUES ('10', '张赛', '23', '女', '123456', '15896731218', '10', '0', null, null, '2018-04-11 12:23:04', null);
INSERT INTO `person` VALUES ('11', '李四', '23', '女', '10322', '123', '11', '0', null, null, '2018-04-11 12:24:56', null);
INSERT INTO `person` VALUES ('12', '张', '12', '男', '132465', '123456', '12', '0', null, null, '2018-04-11 12:29:09', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '账号状态',
  `createDate` datetime DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', '123', '123', null, null, null);
INSERT INTO `user` VALUES ('7', '15896731218', '123456', '0', '2018-04-11 11:03:48', null);
INSERT INTO `user` VALUES ('8', '123', '123', '0', '2018-04-11 11:26:19', null);
INSERT INTO `user` VALUES ('9', '456', 'qwer', '0', '2018-04-11 11:27:00', null);
INSERT INTO `user` VALUES ('10', 'zhangsai', '123', '0', '2018-04-11 12:23:04', null);
INSERT INTO `user` VALUES ('11', '李四', '1223', '0', '2018-04-11 12:24:56', null);
INSERT INTO `user` VALUES ('12', '1234', '123456', '0', '2018-04-11 12:29:09', null);
