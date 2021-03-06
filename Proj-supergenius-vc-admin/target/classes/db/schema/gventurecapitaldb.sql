/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3306
 Source Schema         : gventurecapitaldb

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 21/11/2019 11:28:24
*/
USE gventurecapitaldb;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
`uid` varchar(36) NOT NULL COMMENT '唯一id',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `useruid` varchar(36) DEFAULT NULL COMMENT '评论人的uid',
  `essayuid` varchar(36) DEFAULT NULL COMMENT '帖子essayuid',
  `touseruid` varchar(36) DEFAULT NULL COMMENT '被评论人的uid',
  `name` varchar(100) DEFAULT NULL COMMENT '被评论人姓名',
  `content` text DEFAULT NULL COMMENT '评论内容',
  `rank` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论等级（0一级1二级）',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(255) DEFAULT NULL COMMENT '图片对应内容的链接',
  `imgbig` varchar(255) DEFAULT NULL COMMENT '大图',
  `imgmedium` varchar(255) DEFAULT NULL COMMENT '中图',
  `imglittle` varchar(255) DEFAULT NULL COMMENT '小图',
  `imgoriginal` varchar(255) DEFAULT NULL COMMENT '原图',
  `showtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `endshowtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `orders` int(11) NOT NULL DEFAULT 0 COMMENT '展示顺序',
  `side` tinyint(1) UNSIGNED NOT NULL COMMENT '区分创业端和投资端',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '轮播类型',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for essay
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一id',
  `useruid` varchar(36) NOT NULL COMMENT '用户uid',
  `content` text DEFAULT NULL COMMENT '内容',
  `imgbig` varchar(1000) DEFAULT NULL COMMENT '大图',
  `imgmedium` varchar(1000) DEFAULT NULL COMMENT '中图',
  `imglittle` varchar(1000) DEFAULT NULL COMMENT '小图',
  `imgoriginal` varchar(1000) DEFAULT NULL COMMENT '原图',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for feedbacks
-- ----------------------------
DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `useruid` varchar(36) NOT NULL COMMENT '举报(反馈)人的uid',
  `username` varchar(255) DEFAULT NULL COMMENT '举报(反馈)人的名字',
  `userside` varchar(255) DEFAULT NULL COMMENT '举报(反馈)人的身份',
  `toid` varchar(36) NOT NULL COMMENT '被举报人的uid或者被举报的帖子的id',
  `toname` varchar(255) DEFAULT NULL COMMENT '被举报人的名字或者被举报的帖子的名字',
  `tostatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '被举报人的账户状态或者被举报的帖子的账户状态',
  `reporttype` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '举报类型(项目或人)',
  `reason` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '举报原因',
  `content` varchar(1000) DEFAULT NULL COMMENT '举报(反馈)内容',
  `images` varchar(1000) DEFAULT NULL COMMENT '举报(反馈)图片以json的方式记录',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `handle` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '处理结果',
  `revieweruid` varchar(36) DEFAULT NULL COMMENT '审核人id',
  `reviewer` varchar(255) DEFAULT NULL COMMENT '审核人名字',
  `reviewtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核时间',
  `secondrevieweruid` varchar(36) DEFAULT NULL COMMENT '复审人id',
  `secondreviewer` varchar(255) DEFAULT NULL COMMENT '复审人名字',
  `secondreviewtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '复审时间',
  `secondreview` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '复审状态',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for financing
-- ----------------------------
DROP TABLE IF EXISTS `financing`;//融资
CREATE TABLE `financing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一id',
  `pid` varchar(36) NOT NULL COMMENT '项目id',
  `rounds` bigint(20) DEFAULT 0 COMMENT '轮次',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '日期',
  `currencytype` tinyint(1) UNSIGNED DEFAULT 0 COMMENT '币种类型',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '金额',
  `investor` varchar(1000) DEFAULT NULL COMMENT '投资方',
  `platform` tinyint(1) UNSIGNED DEFAULT 0 COMMENT '融资平台',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一id',
  `useruid` varchar(36) NOT NULL COMMENT '用户uid',
  `name` varchar(255) DEFAULT NULL COMMENT '基金名称',
  `buildtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '基金成立时间',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '基金规模',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '基金规模的币种类型',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for incubator
-- ----------------------------
DROP TABLE IF EXISTS `incubator`;
CREATE TABLE `incubator`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `images` varchar(1000) DEFAULT NULL COMMENT '原图',
  `tag` varchar(255) DEFAULT NULL COMMENT '地区标签',
  `area` varchar(255) DEFAULT NULL COMMENT '区域',
  `summary` varchar(1000) DEFAULT NULL COMMENT '孵化器简介',
  `characteristic` varchar(1000) DEFAULT NULL COMMENT '孵化器特色',
  `address` varchar(1000) DEFAULT NULL COMMENT '孵化器地址',
  `companycount` int(11)  DEFAULT 0 COMMENT '入驻企业数量',
  `showtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '上线时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)r
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for investment
-- ----------------------------
DROP TABLE IF EXISTS `investment`;//投资人
CREATE TABLE `investment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `kind` tinyint(1) DEFAULT NULL COMMENT '会员身份类别',
  `field` varchar(1000) DEFAULT NULL COMMENT '投资领域',
  `rounds` bigint(20) DEFAULT 0 COMMENT '投资轮次',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '币种类型',
  `amountup` decimal(18, 2) DEFAULT 0.00 COMMENT '投资金额上限',
  `amountdown` decimal(18, 2) DEFAULT 0.00 COMMENT '投资金额下限',
  `area` varchar(1000) DEFAULT NULL COMMENT '投资地区',
  `summary` text DEFAULT NULL COMMENT '完善信息时所填写的简介',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `useruid` (`useruid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` varchar(36) NOT NULL COMMENT '即为订单号',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '发票类型',
  `head` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '发票抬头',
  `content` varchar(255) DEFAULT NULL COMMENT '发票内容',
  `company` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `taxnumber` varchar(255) DEFAULT NULL COMMENT '单位税号',
  `mobile` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `addressee` varchar(255) DEFAULT NULL COMMENT '收件人',
  `address` varchar(255) DEFAULT NULL COMMENT '收件地址',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '申请时间',
  `invoicetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开票时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `oid` (`oid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `name` varchar(255) DEFAULT NULL COMMENT '标签名字',
  `orders` int(11) NOT NULL DEFAULT 0 COMMENT '标签顺序',
  `type` tinyint(1) DEFAULT 0 COMMENT '标签类型',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `images` varchar(1000) DEFAULT NULL COMMENT '图片',
  `tag` varchar(255) DEFAULT NULL COMMENT '区域标签',
  `address` varchar(1000) DEFAULT NULL COMMENT '详细地址',
  `area` int(11)  DEFAULT 0 COMMENT '面积',
  `price` decimal(18, 2) DEFAULT 0.00 COMMENT '价格（元/小时）',
  `number` int(11) DEFAULT 0 COMMENT '会议室可容纳人数（座位数）',
  `opentime` tinyint(1) DEFAULT 0 COMMENT '会议室使用时间（全年|法定节假日...）',
  `starttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预约的开始时间',
  `overtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预约的结束时间',
  `showtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '上线时间',
  `summoney` decimal(18, 2) DEFAULT 0.00 COMMENT '盈利即总金额',
  `timeinterval` int(11) DEFAULT 0 COMMENT '间隔时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for memorandum
-- ----------------------------
DROP TABLE IF EXISTS `memorandum`;
CREATE TABLE `memorandum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `fromuid` varchar(36) DEFAULT NULL COMMENT '发送者uid',
  `touid` varchar(36) DEFAULT NULL COMMENT '接收者uid',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text DEFAULT NULL COMMENT '发送内容',
  `kind` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型（0系统1个人）',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `type` tinyint(1) UNSIGNED     COMMENT '类型',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orders 地址，认证编码
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` varchar(36) NOT NULL COMMENT '唯一oid,订单号',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `authcode` varchar(36) NOT NULL COMMENT '认证编码',
  `commodityid` varchar(36) NOT NULL COMMENT '商品id',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `isused` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否使用视频',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '购买金额',
  `site` tinyint(1) DEFAULT NULL COMMENT '付款方式',
  `type` tinyint(1) DEFAULT NULL COMMENT '订单类型',
  `needinvoice` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否需要开发票',
  `invoicestatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '发票状态',
  `orderstatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态',
  `refundtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '退款时间',
  `reviewstatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核状态',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `oid` (`oid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `buildtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '机构成立时间',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '币种类型',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '机构规模',
  `capitaltype` tinyint(1) DEFAULT 0 COMMENT '资本类型',
  `form` tinyint(1) DEFAULT 0 COMMENT '组织形式',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `useruid` (`useruid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` varchar(36) NOT NULL COMMENT '项目唯一pid',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `projectcode` varchar(255) DEFAULT NULL COMMENT '项目编号',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `avatarbig` varchar(255) DEFAULT NULL COMMENT '大图',
  `avatarmedium` varchar(255) DEFAULT NULL COMMENT '中图',
  `avatarlittle` varchar(255) DEFAULT NULL COMMENT '小图',
  `original` varchar(255) DEFAULT NULL COMMENT '原图',
  `field` varchar(1000) DEFAULT NULL COMMENT '所属行业',
  `area` varchar(1000) DEFAULT NULL COMMENT '所属地区',
  `display` text DEFAULT NULL COMMENT '创业展示',
  `company` varchar(1000) DEFAULT NULL COMMENT '所属公司',
  `summary` text DEFAULT NULL COMMENT '简介',
  `slogan` varchar(1000) DEFAULT NULL COMMENT '标语',
  `stage` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '阶段',
  `overview` text DEFAULT NULL COMMENT '项目概述',
  `analysis` text DEFAULT NULL COMMENT '市场分析',
  `profit` text DEFAULT NULL COMMENT '盈利模式',
  `prospect` text DEFAULT NULL COMMENT '前景展望',
  `projectdisplay` text DEFAULT NULL COMMENT '项目展示',
  `sharestock` varchar(100) DEFAULT NULL COMMENT '转售股份占比',
  `estimate` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '评价是否可见',
  `projecttype` varchar(255) DEFAULT NULL COMMENT '转售项目或是融资项目',
  `resalestatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '转售状态',
  `reportcount` int(11) DEFAULT 0 COMMENT '举报次数',
  `followcount` int(11) DEFAULT 0 COMMENT '关注量',
  `freezecount` int(11) DEFAULT 0 COMMENT '冻结次数',
  `finacingstatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '融资状态',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `pid` (`pid`)
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for projectinfo
-- ----------------------------
DROP TABLE IF EXISTS `projectinfo`;
CREATE TABLE `projectinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` varchar(36) NOT NULL COMMENT '项目唯一pid',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '融资金额',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '币种类型',
  `saleup` varchar(100) DEFAULT NULL COMMENT '欲出售股权范围上限',
  `saledown` varchar(100) DEFAULT NULL COMMENT '欲出售股权范围下限',
  `rounds` bigint(20) DEFAULT 0 COMMENT '融资轮次',
  `exitmode` tinyint(1) DEFAULT NULL COMMENT '目标退出方式',
  `nexttime` varchar(100) DEFAULT NULL COMMENT '预计下轮融资需要的时间',
  `financing` tinyint(1) DEFAULT NULL COMMENT '资金短缺时首选融资方式',
  `videouid` varchar(36) DEFAULT NULL COMMENT '路演视频uid',
  `videobuy` int(11) NULL DEFAULT 0 COMMENT '路演视频是否购买',
  `videoupload` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '路演视频是否上传',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pid` (`pid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `rounds` bigint(20) DEFAULT 0 COMMENT '轮次',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '币种',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '金额',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '投资日期',
  `type` tinyint(1) DEFAULT 0 COMMENT '记录类型',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `followperson` text DEFAULT NULL COMMENT '关注人：Map<(人)+id,时间戳>',
  `followproject` text DEFAULT NULL COMMENT '关注项目：Map<(项目)+id,时间戳>',
  `top` varchar(36) DEFAULT NULL COMMENT '置顶人的唯一uid',
  `black` text DEFAULT NULL COMMENT '黑名单：Map<uid,时间戳>',
  `remark` text DEFAULT NULL COMMENT '备注：Map<uid,备注名>',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for settled
-- ----------------------------
DROP TABLE IF EXISTS `settled`;
CREATE TABLE `settled`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `incubatoruid` varchar(36) NOT NULL COMMENT '孵化器uid',
  `useruid` varchar(36) NOT NULL COMMENT '申请人的唯一uid',
  `field` varchar(1000) DEFAULT NULL COMMENT '所属行业',
  `peoplenumber` int(11) DEFAULT 0 COMMENT '人员数量',
  `amount` decimal(18, 2) DEFAULT 0.00 COMMENT '估值',
  `currencytype` tinyint(1) DEFAULT 0 COMMENT '币种类型',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '入驻日期',
  `area` int(11) DEFAULT 0 COMMENT '会议室面积',
  `worknumber` int(11) DEFAULT 0 COMMENT '工位数量',
  `mobile` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `settledtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '入驻具体日期',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否入驻',
  `adminuid` varchar(36) DEFAULT NULL COMMENT '操作人uid',
  `adminname` varchar(100) DEFAULT NULL COMMENT '操作人name',
  `reviewtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核时间',
  `situation` varchar(255) DEFAULT NULL COMMENT '企业状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '企业备注',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for signup
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `trainactivityid` varchar(36) NOT NULL COMMENT '路演活动或企业培训的ID',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '申请时间',
  `reviewstatus` tinyint(1) DEFAULT 0 COMMENT '审核状态',
  `reviewer` varchar(255) DEFAULT NULL COMMENT '审核人',
  `reviewtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sn` varchar(36) DEFAULT NULL COMMENT '预约编号',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `meetingid` varchar(36) NOT NULL COMMENT '会议室唯一uid',
  `starttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预约开始时间',
  `overtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '预约结束时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sn` (`sn`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `pid` varchar(36) NOT NULL COMMENT '项目唯一pid',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `education` varchar(100) DEFAULT NULL COMMENT '学历',
  `major` varchar(100) DEFAULT NULL COMMENT '专业',
  `position` varchar(100) DEFAULT NULL COMMENT '职位',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `content` varchar(255) DEFAULT NULL COMMENT '发送内容',
  `description` varchar(255) DEFAULT NULL COMMENT '条件描述说明',
  `name` varchar(255) DEFAULT NULL COMMENT '模板名称',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for trainactivity
-- ----------------------------
DROP TABLE IF EXISTS `trainactivity`;
CREATE TABLE `trainactivity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `images` varchar(1000) DEFAULT NULL COMMENT '图片',
  `starttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `overtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  `signtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '报名开始时间',
  `endtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '报名结束时间',
  `pernumber` int(11) DEFAULT 0 COMMENT '人数名额',
  `mechnumber` int(11) DEFAULT 0 COMMENT '企业机构名额',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `notice` varchar(1000) DEFAULT NULL COMMENT '须知',
  `price` decimal(18, 2) DEFAULT 0.00 COMMENT '课程价格',
  `course` varchar(1000) DEFAULT NULL COMMENT '课程表json',
  `process` varchar(1000) DEFAULT NULL COMMENT '活动流程',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '类型（路演|企业培训）',
  `coursecount` int(11) DEFAULT 0 COMMENT '课程数量',
  `summoney` decimal(18, 2) DEFAULT 0.00 COMMENT '盈利即总金额',
  `showtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '上线时间',
  `activitystatus` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '活动状态',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user`issupergenius` tinyint(1) DEFAULT 0,
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `idcardimg` text COMMENT '证件照的照片',
  `idcardimgbig` text COMMENT '证件照的大照片',
  `idcardimgmedium` text COMMENT '证件照的中照片',
  `idcardimglittle` text COMMENT '证件照的小照片',
  `businesscode` varchar(255) DEFAULT NULL COMMENT '企业工商代码',
  `corporation` varchar(255) DEFAULT NULL COMMENT '法人姓名',
  `kind` tinyint(1) DEFAULT NULL COMMENT '会员身份类别',
  `financingcount` int(11) DEFAULT 0 COMMENT '成功融资次数',
  `followcount` int(11) DEFAULT 0 COMMENT '关注量',
  `freezecount` int(11) DEFAULT 0 COMMENT '冻结次数',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `useruid` (`useruid`)
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `useruid` varchar(36) NOT NULL COMMENT '用户唯一uid',
  `authcode` varchar(36) DEFAULT NULL COMMENT '认证编码',
  `authtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '认证时间',
  `identity` tinyint(1) DEFAULT 0 COMMENT '身份',
  `applytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '申请时间',
  `reviewer` varchar(255) DEFAULT NULL COMMENT '审核人',
  `reviewtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核时间',
  `reviewstatus` tinyint(1) DEFAULT 0 COMMENT '审核状态',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for video
-- -------------------------Investment---
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(36) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态',
  `data` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pid` (`pid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
