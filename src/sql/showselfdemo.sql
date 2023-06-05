/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : showselfdemo

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 05/06/2023 17:11:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for show_log
-- ----------------------------
DROP TABLE IF EXISTS `show_log`;
CREATE TABLE `show_log`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `logtime` datetime(0) NULL DEFAULT NULL COMMENT '日志时间',
  `logcontext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志内容',
  `loguser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志对象',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of show_log
-- ----------------------------
INSERT INTO `show_log` VALUES (1, '2023-06-05 16:44:55', 'test333查询了test333的个人信息', 'test333');
INSERT INTO `show_log` VALUES (2, '2023-06-05 16:49:27', 'test333查询了test333的个人信息', 'test333');

-- ----------------------------
-- Table structure for show_project
-- ----------------------------
DROP TABLE IF EXISTS `show_project`;
CREATE TABLE `show_project`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目ID',
  `projectname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名',
  `projecttemplate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目使用的模板',
  `projectIp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目运行IP',
  `projectaddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目文件地址',
  `projectstate` int(5) NULL DEFAULT NULL COMMENT '0 未启动 1 启动 2异常',
  `projectowner` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目拥有者ID',
  `projectcreatetime` datetime(0) NULL DEFAULT NULL COMMENT '项目创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of show_project
-- ----------------------------

-- ----------------------------
-- Table structure for show_template
-- ----------------------------
DROP TABLE IF EXISTS `show_template`;
CREATE TABLE `show_template`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '模板ID',
  `templatename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板名',
  `templateaddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板存储地址',
  `templatecreatetime` datetime(0) NULL DEFAULT NULL COMMENT '模板创建时间',
  `templateowner` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板拥有者',
  `templateimage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板展示照片',
  `templateprofile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of show_template
-- ----------------------------

-- ----------------------------
-- Table structure for show_user
-- ----------------------------
DROP TABLE IF EXISTS `show_user`;
CREATE TABLE `show_user`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮箱',
  `sex` int(5) NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '等级',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of show_user
-- ----------------------------
INSERT INTO `show_user` VALUES ('44a601f945cf3d129b18', 'test333', 'test333', '王五', '1650548543@qq.com', 1, '18806100277', '1', '2023-06-05 14:48:32');
INSERT INTO `show_user` VALUES ('test1', 'test123', 'test123', '张三', '1650547543@qq.com', 1, '18806100277', '1', '2023-06-05 10:18:51');
INSERT INTO `show_user` VALUES ('test2', 'test222', 'test222', '李四', '1650546543@qq.com', 1, '18806100277', '1', '2023-06-05 10:18:51');

-- ----------------------------
-- Table structure for templatecontext
-- ----------------------------
DROP TABLE IF EXISTS `templatecontext`;
CREATE TABLE `templatecontext`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '模板内容ID',
  `templatecontext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板内容',
  `templatecontexttype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板内容类型',
  `templateid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模板ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of templatecontext
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
