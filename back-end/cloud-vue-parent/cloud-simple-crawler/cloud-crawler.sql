/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : cloud-vue

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-27 16:08:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for TEAM_CRAWLER
-- ----------------------------
DROP TABLE IF EXISTS `TEAM_CRAWLER`;
CREATE TABLE `TEAM_CRAWLER` (
  `uuid` varchar(110) NOT NULL,
  `name` varchar(110) DEFAULT NULL,
  `status` varchar(110) DEFAULT NULL,
  `fail_count` int(5) DEFAULT 0,
  `create_time` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for IMAGE_CRAWLER
-- ----------------------------
DROP TABLE IF EXISTS `IMAGE_CRAWLER`;
CREATE TABLE `IMAGE_CRAWLER` (
  `group_uuid` varchar(110) NOT NULL,
  `uuid` varchar(110) NOT NULL,
  `name` varchar(110) DEFAULT NULL,
  `type` varchar(110) DEFAULT NULL,
  `path` varchar(110) DEFAULT NULL,
  `local_path` varchar(110) DEFAULT NULL,
  `create_time` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for VIDEO_CRAWLER
-- ----------------------------
DROP TABLE IF EXISTS `VIDEO_CRAWLER`;
CREATE TABLE `VIDEO_CRAWLER` (
  `group_uuid` varchar(11) NOT NULL,
  `uuid` varchar(110) NOT NULL,
  `name` varchar(110) DEFAULT NULL,
  `type` varchar(110) DEFAULT NULL,
  `path` varchar(110) DEFAULT NULL,
  `create_time` TIMESTAMP  NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

