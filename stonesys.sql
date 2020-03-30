<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 05d7c36a2f432c63cbf5ef97c6da7c8174147011
/*
Navicat MySQL Data Transfer

Source Server         : 砂石
Source Server Version : 50729
Source Host           : 39.105.140.228:3306
Source Database       : stonesys

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-05 17:24:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(32) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '管理员用户名',
  `password` varchar(255) NOT NULL COMMENT '管理员密码',
  `telephone` varchar(32) DEFAULT NULL COMMENT '管理员电话',
  `super_key` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '超级管理员标识 (0,普通管理员  1,超级管理员)',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0表示未删除,1表示已经删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` char(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '公告标题',
  `content` varchar(255) DEFAULT NULL COMMENT '公告内容',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '公告时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告';

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` char(32) NOT NULL,
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `delivery` float DEFAULT NULL COMMENT '配送评分',
  `server` float DEFAULT NULL COMMENT '服务评分',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` char(32) NOT NULL,
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `sale_price` float DEFAULT NULL COMMENT '单价',
  `amount` float DEFAULT '0' COMMENT '数量',
  `monthy_sales` float DEFAULT '0' COMMENT '月销量',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  `deliver_cost` float DEFAULT NULL COMMENT '配送费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品';

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` char(32) NOT NULL,
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `delivery_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '配送时间',
  `delivery_address` varchar(255) DEFAULT NULL COMMENT '配送地址',
  `contact_name` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话或者座机号码',
  `building_nature` enum('电梯房','楼梯房') DEFAULT NULL COMMENT '楼房性质',
  `property_nature` enum('小区','写字楼','民宅') DEFAULT NULL COMMENT '楼盘性质',
  `remark` varchar(255) DEFAULT NULL COMMENT '说明',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户下单时间',
  `status` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `cancel_reason` varchar(255) DEFAULT NULL COMMENT '取消订单原因',
  `protocol_url` varchar(255) DEFAULT NULL COMMENT '协议图片路径',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0表示未删除,1表示已经删除',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Table structure for orders_goods
-- ----------------------------
DROP TABLE IF EXISTS `orders_goods`;
CREATE TABLE `orders_goods` (
  `id` char(32) NOT NULL,
  `orders_id` char(32) DEFAULT NULL COMMENT '订单id',
  `goods_id` char(32) DEFAULT NULL COMMENT '商品id',
  `purchase_quantity` float DEFAULT '0' COMMENT '购买数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(32) NOT NULL,
  `name` varchar(45) DEFAULT '未命名' COMMENT '用户微信名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '用户电话',
  `fettle` tinyint(3) unsigned DEFAULT '0' COMMENT '用户账号状态,0表示正常，1表示封禁',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `wechat_id` varchar(255) DEFAULT NULL COMMENT '用户微信id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_telephone_uindex` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` char(32) NOT NULL,
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `contact_name` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `building_nature` enum('电梯房','楼梯房') DEFAULT NULL COMMENT '楼房性质',
  `property_nature` enum('小区','写字楼','民宅') DEFAULT NULL COMMENT '楼盘性质',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';
<<<<<<< HEAD
=======
CREATE TABLE `admin` (
  `id` CHAR(32) NOT NULL,
  `name` VARCHAR(45) NOT NULL COMMENT '管理员用户名',
  `password` VARCHAR(255) NOT NULL COMMENT '管理员密码',
  `telephone` VARCHAR(32) DEFAULT NULL COMMENT '管理员电话',
  `super_key` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '超级管理员标识 (0,普通管理员  1,超级管理员)',
  `is_delete` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除,0表示未删除,1表示已经删除',
  `create_time` DATETIME DEFAULT NULL,
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_name_uindex` (`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='管理员';

CREATE TABLE `user` (
  `id` CHAR(32) NOT NULL,
  `name` VARCHAR(45) DEFAULT '未命名' COMMENT '用户微信名',
  `telephone` VARCHAR(32) DEFAULT NULL COMMENT '用户电话',
  `fettle` TINYINT(3) UNSIGNED DEFAULT '0' COMMENT '用户账号状态,0表示正常，1表示封禁',
  `avatar_url` VARCHAR(255) DEFAULT NULL COMMENT '用户头像',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_telephone_uindex` (`telephone`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户';

CREATE TABLE user_address (
  `id` CHAR(32) NOT NULL,
  user_id CHAR(32) DEFAULT NULL COMMENT '用户id',
  address VARCHAR(255) DEFAULT NULL COMMENT '详细地址',
  contact_name VARCHAR(255) DEFAULT NULL COMMENT '联系人姓名',
  contact_phone  VARCHAR(32) DEFAULT NULL COMMENT '联系人电话',
  building_nature ENUM('电梯房','楼梯房')  COMMENT '楼房性质',
  property_nature ENUM('小区','写字楼','民宅') COMMENT '楼盘性质',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

CREATE TABLE goods(
  `id` CHAR(32) NOT NULL,
  sale_price FLOAT(8) DEFAULT NULL COMMENT '单价',
  amount FLOAT(8) DEFAULT '0' COMMENT '数量',
  monthy_sales FLOAT(8) DEFAULT '0' COMMENT '月销量',
  note VARCHAR(255) DEFAULT NULL COMMENT '备注',
  image VARCHAR(255) DEFAULT NULL COMMENT '图片',
  deliver_cost INT(8) DEFAULT NULL COMMENT '配送费',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品';

CREATE TABLE orders(
  id CHAR(32) NOT NULL,
  user_id CHAR(32) DEFAULT NULL COMMENT '用户id',
  delivery_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '配送时间',
  delivery_address VARCHAR(255) DEFAULT NULL COMMENT '配送地址',
  contact_name VARCHAR(255) DEFAULT NULL COMMENT '联系人姓名',
  contact_phone  VARCHAR(32) DEFAULT NULL COMMENT '联系人电话或者座机号码',
  building_nature ENUM('电梯房','楼梯房')  COMMENT '楼房性质',
  property_nature ENUM('小区','写字楼','民宅') COMMENT '楼盘性质',
  remark VARCHAR(255) DEFAULT NULL COMMENT '说明',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '用户下单时间',
  statu VARCHAR(255) DEFAULT NULL COMMENT '订单状态',
  cancel_reason VARCHAR(255) DEFAULT NULL COMMENT '取消订单原因',
  protocol_url VARCHAR(255) DEFAULT NULL COMMENT '协议图片路径',
  is_delete TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除,0表示未删除,1表示已经删除',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单';

CREATE TABLE orders_goods(
  id CHAR(32) NOT NULL,
  orders_id CHAR(32) DEFAULT NULL COMMENT '订单id',
  goods_id CHAR(32) DEFAULT NULL COMMENT '商品id',
  purchase_quantity FLOAT(8) DEFAULT '0' COMMENT '购买数量',
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单商品表';

CREATE TABLE comments(
  id CHAR(32) NOT NULL,
  user_id CHAR(32) DEFAULT NULL COMMENT '用户id',
  content VARCHAR(255) DEFAULT NULL COMMENT '评论内容',
  delivery FLOAT(8) COMMENT '配送评分',
  server FLOAT(8) COMMENT '服务评分',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间时间',
  update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='评论';


CREATE TABLE announcement(
  id CHAR(32) NOT NULL,
  title VARCHAR(255) DEFAULT NULL COMMENT '公告标题',
  content VARCHAR(255) DEFAULT NULL COMMENT '公告内容',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '公告时间',
  update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='公告';
>>>>>>> test
=======
>>>>>>> 05d7c36a2f432c63cbf5ef97c6da7c8174147011
