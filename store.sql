/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 21/06/2019 10:42:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('41de3ddcb7e54e79880bf57aa3d1031e', '笔记本电脑');
INSERT INTO `category` VALUES ('93ddbe4426864ea58467fcdd2e985ed2', '小米摄像头');
INSERT INTO `category` VALUES ('9711522363b44c079dc90f4e27e8e32f', '华为手机');
INSERT INTO `category` VALUES ('a9742e2a627d4891b0185fb3bee5ebe2', '耳机');
INSERT INTO `category` VALUES ('b7c86f9bcfb048f690f19843ab98aebe', '平板电脑');
INSERT INTO `category` VALUES ('d8612b50639d4b4da1cfa93d05b4a67d', '小米手机');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `itemid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `oid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ordertime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pimage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pflag` int(11) DEFAULT NULL,
  `cid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `cp` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('39d4409f19ec400da52739a0a9ba52bf', 'HUAWEI P30 Pro', '77dd067b6f224f8497f0f2fad8281f9a.jpg', '2019年06月20日 21:46:33', '特别好用。', 4999, 4999, 1, NULL, '9711522363b44c079dc90f4e27e8e32f');
INSERT INTO `product` VALUES ('3c251f8830e84083a73ea54cfaba5b0f', 'MI9', 'a380b065b9364dc3adcb247e35374b46.png', '2019年06月20日 21:49:33', '旗舰机中低于3000元！！！', 2999, 3000, 1, NULL, 'd8612b50639d4b4da1cfa93d05b4a67d');
INSERT INTO `product` VALUES ('47bfeeccbfba45f6a1540350ebfcf153', '小米平板', '1dc27888b28944988e46edd29efe440a.jpg', '2019年06月20日 21:48:20', '性价比高', 1950, 2000, 1, NULL, 'b7c86f9bcfb048f690f19843ab98aebe');
INSERT INTO `product` VALUES ('500a8c25cf18468f91ce54bc13857f47', 'IPand', '5efd21982652487083e34a3e93cbec2d.jpg', '2019年06月20日 21:47:29', '太贵了。。。', 4500, 5000, 1, NULL, 'b7c86f9bcfb048f690f19843ab98aebe');
INSERT INTO `product` VALUES ('59d1509514924d388ebd34b8bab424ef', '小米摄像头', '14e16b1e2a76477d915fb37712653a6a.jpg', '2019年06月20日 21:44:48', '还很好用的。', 2313, 2000, 1, NULL, '93ddbe4426864ea58467fcdd2e985ed2');
INSERT INTO `product` VALUES ('97808a7ed7ea4ee0b4a876b18544ee06', '小米铁圈耳机', 'c40a164147174485a1ccc287dee7f866.jpg', '2019年06月20日 21:30:15', '很好用', 195, 200, 1, NULL, '41de3ddcb7e54e79880bf57aa3d1031e');
INSERT INTO `product` VALUES ('adae65f0c61148dab8c876eb9e847704', '酷狗耳机', '238731d7098647b7b9845e2f67706fcf.jpg', '2019年06月20日 21:41:42', '还是可以的。', 100, 120, 1, NULL, 'a9742e2a627d4891b0185fb3bee5ebe2');
INSERT INTO `product` VALUES ('db4a54a1365e4a9c9157c85327ae2a31', '索尼耳机', '377b2b87acd14c45924f63a5185b919a.jpg', '2019年06月20日 21:38:00', '一般般啦。', 200, 250, 1, NULL, 'a9742e2a627d4891b0185fb3bee5ebe2');
INSERT INTO `product` VALUES ('f5edc95e791b4ed0b15ce07c90e67990', '联想电脑', 'cd3bca23e5c14e7b908bee78f2aef4de.jpg', '2019年06月20日 21:43:12', '还可以的.', 4500, 5000, 1, NULL, '41de3ddcb7e54e79880bf57aa3d1031e');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1f4c9e9a07824f0e828fe3a0bc7372ed', 'xiaobai', '123456', '白小鹏', '234123@qq.com', NULL, 'male', '2019-06-05');
INSERT INTO `user` VALUES ('50dcdcefea854414b0e893c0af6baf65', 'xiaohei', '123123', '黑子', 'adfadf@qq.com', NULL, 'male', '2019-06-13');

SET FOREIGN_KEY_CHECKS = 1;
