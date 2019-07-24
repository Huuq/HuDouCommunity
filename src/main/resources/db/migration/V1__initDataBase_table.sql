/*
 Navicat Premium Data Transfer

 Source Server         : CQUT
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : hudoucommunity

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 24/07/2019 10:44:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gmt_create` bigint(50) NULL DEFAULT NULL,
  `gmt_modified` bigint(50) NULL DEFAULT NULL,
  `creator` int(4) NULL DEFAULT NULL,
  `comment_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `view_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `like_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '发布问题测试12333', '发布问题测试内容1233223', 1563630926510, 0, 1, 0002, 0052, 0032, '2322523');
INSERT INTO `question` VALUES (2, '发布问题测试', '发布问题测试内容', 1563630967289, 1563630967289, 1, 0002, 0045, 0045, '测试');
INSERT INTO `question` VALUES (3, '发布问题测试', '发布问题测试内容', 1563631274000, 1563631274000, 1, 0002, 0052, 0025, '测试');
INSERT INTO `question` VALUES (4, '发布问题测试', '发布问题测试内容', 1563635073254, 1563635073254, 1, 0005, 0047, 0025, '测试');
INSERT INTO `question` VALUES (5, '发布问题测试', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0005, 0058, 0025, '测试');
INSERT INTO `question` VALUES (6, '发布问题测', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0005, 0045, 0023, '测试');
INSERT INTO `question` VALUES (7, '发布问题测', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0008, 0012, 0008, '测试');
INSERT INTO `question` VALUES (8, '发布问题测', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0005, 0057, 0021, '测试');
INSERT INTO `question` VALUES (9, '发布问题测', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0006, 0074, 0021, '测试');
INSERT INTO `question` VALUES (10, '发布问题测', '发布问题测试内容', 1563636605284, 1563636605284, 1, 0008, 0032, 0012, '测试');
INSERT INTO `question` VALUES (11, 'springBoot快速入门开发', 'SpringBoot可以减少开发中Xml文件的配置，减少工作量', 1563800476490, 1563800476490, 1, 0000, 0000, 0000, 'SpringBoot');
INSERT INTO `question` VALUES (12, '登录问题修复', '修改gitHub登录问题', 1563880927826, 1563880927826, 1, NULL, NULL, NULL, '修复登录');
INSERT INTO `question` VALUES (13, '24254', '2542542', 1563893700361, 1563893700361, 1, NULL, NULL, NULL, '2435444212');
INSERT INTO `question` VALUES (14, '34343', '4535434', 1563894279560, 1563894279560, 1, NULL, NULL, NULL, '3543543');
INSERT INTO `question` VALUES (15, 'lalalalaka', 'lalalalala', 1563895166810, 1563895166810, 1, NULL, NULL, NULL, 'lalalal');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` bigint(50) NULL DEFAULT NULL,
  `gmt_modified` bigint(50) NULL DEFAULT NULL,
  `bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '49520650', 'Mr_Right', '123456', 'fa292125-96f3-4722-9e84-fdce2e217857', 1563883897150, 1563866474705, '小白成长历险记', 'https://avatars1.githubusercontent.com/u/49520650?v=4', '权琅科技', 'hudou.qh.club', '重庆');

SET FOREIGN_KEY_CHECKS = 1;
