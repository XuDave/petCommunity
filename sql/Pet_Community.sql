/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : pet_community

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-05-18 10:33:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(30) NOT NULL COMMENT '登录名',
  `Password` varchar(30) NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `admire`
-- ----------------------------
DROP TABLE IF EXISTS `admire`;
CREATE TABLE `admire` (
  `PostId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  KEY `Admire_PostId_idx` (`PostId`),
  KEY `Admire_UserId_idx` (`UserId`),
  CONSTRAINT `Admire_PostId` FOREIGN KEY (`PostId`) REFERENCES `post` (`PostId`),
  CONSTRAINT `Admire_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admire
-- ----------------------------

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `CommodityId` int(11) NOT NULL,
  `CartCommodityCount` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  KEY `Cart_CommodityId_idx` (`CommodityId`),
  KEY `Cart_UserId_idx` (`UserId`),
  CONSTRAINT `Cart_CommodityId` FOREIGN KEY (`CommodityId`) REFERENCES `commodity` (`CommodityId`),
  CONSTRAINT `Cart_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `CommodityId` int(11) NOT NULL AUTO_INCREMENT,
  `CommodityPrice` decimal(6,2) NOT NULL,
  `CommodityContent` varchar(45) NOT NULL,
  `CommodityCount` int(11) NOT NULL,
  `CommodityState` int(11) NOT NULL DEFAULT '1',
  `CommodityUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`CommodityId`),
  UNIQUE KEY `CommodityId_UNIQUE` (`CommodityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `first_reply`
-- ----------------------------
DROP TABLE IF EXISTS `first_reply`;
CREATE TABLE `first_reply` (
  `FirstReplyId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstReplyContent` varchar(45) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PostId` int(11) NOT NULL,
  `FirstReplyUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`FirstReplyId`),
  UNIQUE KEY `FirstReplyId_UNIQUE` (`FirstReplyId`),
  KEY `FirstReply_UserId_idx` (`UserId`),
  KEY `FirstReply_PostId_idx` (`PostId`),
  CONSTRAINT `FirstReply_PostId` FOREIGN KEY (`PostId`) REFERENCES `post` (`PostId`),
  CONSTRAINT `FirstReply_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `OrderState` int(11) NOT NULL,
  `OrderAdress` varchar(45) NOT NULL,
  `OrderUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`OrderId`),
  UNIQUE KEY `OrderId_UNIQUE` (`OrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `order_commodity`;
CREATE TABLE `order_commodity` (
  `CommodityId` int(11) NOT NULL,
  `OrderCommodityPrice` decimal(6,2) NOT NULL,
  `OrderId` int(11) NOT NULL,
  `OrderCommodityCount` int(11) NOT NULL,
  KEY `OrderCommodity_CommodityId_idx` (`CommodityId`),
  KEY `OrderCommodity_OrderId_idx` (`OrderId`),
  CONSTRAINT `OrderCommodity_CommodityId` FOREIGN KEY (`CommodityId`) REFERENCES `commodity` (`CommodityId`),
  CONSTRAINT `OrderCommodity_OrderId` FOREIGN KEY (`OrderId`) REFERENCES `order` (`OrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `pet`
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `PetId` int(11) NOT NULL AUTO_INCREMENT,
  `PetName` varchar(45) NOT NULL,
  `PetTypeId` int(11) NOT NULL,
  `PetAge` int(11) DEFAULT '0',
  `PetSex` int(11) DEFAULT '0',
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`PetId`),
  UNIQUE KEY `PetId_UNIQUE` (`PetId`),
  KEY `Pet_UserId_idx` (`UserId`),
  KEY `Pet_PetTypeId_idx` (`PetTypeId`),
  CONSTRAINT `Pet_PetTypeId` FOREIGN KEY (`PetTypeId`) REFERENCES `pet_type` (`PetTypeId`),
  CONSTRAINT `Pet_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet
-- ----------------------------

-- ----------------------------
-- Table structure for `pet_type`
-- ----------------------------
DROP TABLE IF EXISTS `pet_type`;
CREATE TABLE `pet_type` (
  `PetTypeContent` varchar(45) DEFAULT NULL,
  `PetTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `PetTypeName` varchar(45) NOT NULL,
  PRIMARY KEY (`PetTypeId`),
  UNIQUE KEY `PetTypeName_UNIQUE` (`PetTypeName`),
  UNIQUE KEY `PetTypeId_UNIQUE` (`PetTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pet_type
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `PostId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `PostTitle` varchar(45) NOT NULL,
  `PostContent` varchar(45) NOT NULL,
  `PostImagePath` varchar(100) DEFAULT NULL,
  `PostUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`PostId`),
  UNIQUE KEY `PostId_UNIQUE` (`PostId`),
  KEY `Post_UserId_idx` (`UserId`),
  CONSTRAINT `Post_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'title1', 'title1', null, '2017-05-15 17:42:22');
INSERT INTO `post` VALUES ('2', '1', 'title2', 'title2', null, '2017-05-15 17:42:29');
INSERT INTO `post` VALUES ('3', '1', 'title3', 'title3', null, '2017-05-15 17:42:37');
INSERT INTO `post` VALUES ('4', '1', 'title4', 'title4', null, '2017-05-15 17:42:44');
INSERT INTO `post` VALUES ('5', '1', 'title5', 'title5', null, '2017-05-15 17:42:52');
INSERT INTO `post` VALUES ('6', '1', 'title6', 'title6', null, '2017-05-15 17:42:59');
INSERT INTO `post` VALUES ('7', '1', 'title7', 'title7', null, '2017-05-15 17:43:06');
INSERT INTO `post` VALUES ('8', '1', 'title8', 'title8', null, '2017-05-15 17:43:14');

-- ----------------------------
-- Table structure for `second_reply`
-- ----------------------------
DROP TABLE IF EXISTS `second_reply`;
CREATE TABLE `second_reply` (
  `SecondReplyId` int(11) NOT NULL AUTO_INCREMENT,
  `SecondReplyContent` varchar(45) NOT NULL,
  `FirstReplyId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PointerUserId` int(11) NOT NULL,
  `SecondReplyUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`SecondReplyId`),
  UNIQUE KEY `SecondReplyId_UNIQUE` (`SecondReplyId`),
  KEY `SecondReply_FirstReplyId_idx` (`FirstReplyId`),
  KEY `SecondReply_UserId_idx` (`UserId`),
  KEY `SecondReply_PointerUserId_idx` (`PointerUserId`),
  CONSTRAINT `SecondReply_FirstReplyId` FOREIGN KEY (`FirstReplyId`) REFERENCES `first_reply` (`FirstReplyId`),
  CONSTRAINT `SecondReply_PointerUserId` FOREIGN KEY (`PointerUserId`) REFERENCES `user` (`UserId`),
  CONSTRAINT `SecondReply_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `UserPassword` varchar(45) NOT NULL,
  `UserSex` int(11) DEFAULT '0',
  `UserAge` int(11) DEFAULT '0',
  `UserPhone` varchar(11) DEFAULT NULL,
  `UserAddress` varchar(45) DEFAULT NULL,
  `UserUpdateTime` datetime NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserId_UNIQUE` (`UserId`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', 'test', '0', '0', null, null, '2017-05-15 00:31:39');
INSERT INTO `user` VALUES ('2', '', '', '0', '0', null, null, '2017-05-15 20:16:23');
INSERT INTO `user` VALUES ('3', '舒服舒服', '是是', '0', '0', null, null, '2017-05-15 20:23:30');
INSERT INTO `user` VALUES ('4', '顺风顺水', '是是是', '0', '0', null, null, '2017-05-15 20:25:30');
INSERT INTO `user` VALUES ('5', '啊发发', '啊啊', '0', '0', null, null, '2017-05-15 20:26:40');
INSERT INTO `user` VALUES ('6', 'ddd', '(null肥嘟嘟)', '0', '0', null, null, '2017-05-15 21:29:48');
INSERT INTO `user` VALUES ('7', '发达', '(null)啊  ', '0', '0', null, null, '2017-05-15 21:32:56');
INSERT INTO `user` VALUES ('8', '阿发', '(null)顶顶顶顶', '0', '0', null, null, '2017-05-15 21:33:39');
