/*
Navicat MySQL Data Transfer

Source Server         : 31数据库
Source Server Version : 50716
Source Host           : 10.6.71.236:3306
Source Database       : hyll_springboot

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-11-10 16:51:52
*/

USE hyll_springboot;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `is_load` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'testCode', '测试参数', 'testType', 'testValue', '0');
INSERT INTO `dict` VALUES ('33', 'fileTempPath', '上传的临时文件的保存位置', 'fileTempPath', 'E://test//', '0');
INSERT INTO `dict` VALUES ('34', 'SYSTEM_USER', '系统用户', 'USER_TYPE', '1', '1');
INSERT INTO `dict` VALUES ('35', 'MOBILE_USER', '移动端用户', 'USER_TYPE', '2', '1');
INSERT INTO `dict` VALUES ('37', 'OK', '允许', 'DICT_IS_LOAD', '1', '1');
INSERT INTO `dict` VALUES ('38', 'NOT', '不允许', 'DICT_IS_LOAD', '0', '1');
INSERT INTO `dict` VALUES ('39', 'USE', '启用', 'USER_STATE', '1', '1');
INSERT INTO `dict` VALUES ('40', 'UNUSE', '禁用', 'USER_STATE', '0', '1');
INSERT INTO `dict` VALUES ('41', 'PENDING_PAY', '待付款', 'ORDER_STATE', '1', '1');
INSERT INTO `dict` VALUES ('42', 'READY_PAY', '已付款', 'ORDER_STATE', '2', '1');
INSERT INTO `dict` VALUES ('43', 'CANCEL_ORDER', '取消订单', 'ORDER_STATE', '3', '1');
INSERT INTO `dict` VALUES ('44', 'NORMAL', '正常', 'ORDER_DETAIL_STATE', '1', '1');
INSERT INTO `dict` VALUES ('45', 'BACK', '撤单', 'ORDER_DETAIL_STATE', '2', '1');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `is_delete` varchar(255) DEFAULT NULL,
  `send_date` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '111', '11', '1', '2017-09-23 19:57:34', '1', '111');
INSERT INTO `message` VALUES ('11', '123', null, null, null, null, null);
INSERT INTO `message` VALUES ('12', '123', null, null, null, null, null);

-- ----------------------------
-- Table structure for `message_associate_user`
-- ----------------------------
DROP TABLE IF EXISTS `message_associate_user`;
CREATE TABLE `message_associate_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_delete` varchar(255) DEFAULT '1',
  `read_date` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT '0',
  `message_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaucwt2f9waols3hrbma6p40ky` (`message_id`),
  KEY `FKju1emlnuk8xc4tbt497muikhu` (`user_id`),
  CONSTRAINT `FKaucwt2f9waols3hrbma6p40ky` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`),
  CONSTRAINT `FKju1emlnuk8xc4tbt497muikhu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_associate_user
-- ----------------------------
INSERT INTO `message_associate_user` VALUES ('1', '1', null, '0', '1', '1');

-- ----------------------------
-- Table structure for `org_group`
-- ----------------------------
DROP TABLE IF EXISTS `org_group`;
CREATE TABLE `org_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `existing_num` bigint(20) DEFAULT NULL,
  `group_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `node` varchar(255) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `parent_node` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org_group
-- ----------------------------
INSERT INTO `org_group` VALUES ('3', null, 'YYB', '运营部', '001002', '20', '001');
INSERT INTO `org_group` VALUES ('9', '0', '0022', '寿宁全嘉福', '001', '222', '0');
INSERT INTO `org_group` VALUES ('10', '0', 'CYB', '餐饮部', '001001', '10', '001');
INSERT INTO `org_group` VALUES ('19', '0', 'HQB', '后勤部', '001003', '5', '001');

-- ----------------------------
-- Table structure for `role_associate_tree`
-- ----------------------------
DROP TABLE IF EXISTS `role_associate_tree`;
CREATE TABLE `role_associate_tree` (
  `role_id` bigint(20) NOT NULL,
  `tree_id` bigint(20) NOT NULL,
  KEY `FKdslec8iii7ggslupebobmpu4` (`tree_id`),
  KEY `FKgkuemjgtln0vlvcokl9pn38f7` (`role_id`),
  CONSTRAINT `FKdslec8iii7ggslupebobmpu4` FOREIGN KEY (`tree_id`) REFERENCES `tree` (`id`),
  CONSTRAINT `FKgkuemjgtln0vlvcokl9pn38f7` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_associate_tree
-- ----------------------------
INSERT INTO `role_associate_tree` VALUES ('2', '17');
INSERT INTO `role_associate_tree` VALUES ('1', '1');
INSERT INTO `role_associate_tree` VALUES ('1', '2');
INSERT INTO `role_associate_tree` VALUES ('1', '7');
INSERT INTO `role_associate_tree` VALUES ('1', '8');
INSERT INTO `role_associate_tree` VALUES ('1', '9');
INSERT INTO `role_associate_tree` VALUES ('1', '10');
INSERT INTO `role_associate_tree` VALUES ('1', '17');
INSERT INTO `role_associate_tree` VALUES ('1', '23');
INSERT INTO `role_associate_tree` VALUES ('1', '24');
INSERT INTO `role_associate_tree` VALUES ('1', '25');

-- ----------------------------
-- Table structure for `t_dinner`
-- ----------------------------
DROP TABLE IF EXISTS `t_dinner`;
CREATE TABLE `t_dinner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单流水ID',
  `name` varchar(100) DEFAULT NULL COMMENT '菜名',
  `good_type_id` int(11) DEFAULT NULL COMMENT '菜品类型ID',
  `good_type_name` varchar(50) DEFAULT NULL COMMENT '菜品类型名字',
  `price` double DEFAULT NULL COMMENT '价格',
  `sels` int(11) DEFAULT NULL COMMENT '销量',
  `image_url` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人ID',
  `preferential_price` double DEFAULT NULL COMMENT '优惠价格',
  `is_preferential` varchar(2) DEFAULT NULL COMMENT '是否优惠（1：是；2：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='主要保存菜品信息';

-- ----------------------------
-- Records of t_dinner
-- ----------------------------
INSERT INTO `t_dinner` VALUES ('3', '饺子', '3', '肉品', '53', '0', '1111', '2017-11-09 10:30:12', 'linzf', '1', '48', '1');

-- ----------------------------
-- Table structure for `t_food_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_food_type`;
CREATE TABLE `t_food_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品流水',
  `type` varchar(50) DEFAULT NULL COMMENT '菜品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='主要用于存放菜品类型的数据比如肉、青菜等类型';

-- ----------------------------
-- Records of t_food_type
-- ----------------------------
INSERT INTO `t_food_type` VALUES ('3', '肉品');
INSERT INTO `t_food_type` VALUES ('4', '水产');
INSERT INTO `t_food_type` VALUES ('5', '蔬菜');
INSERT INTO `t_food_type` VALUES ('6', '干粮杂货');
INSERT INTO `t_food_type` VALUES ('7', '糕点');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL COMMENT '订单流水ID',
  `order_num` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `order_price` double DEFAULT NULL COMMENT '订单价格',
  `real_income` double DEFAULT NULL COMMENT '实际收入',
  `table_num` varchar(5) DEFAULT NULL COMMENT '桌号',
  `private_room` varchar(50) DEFAULT NULL COMMENT '包间名字',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `state` varchar(5) DEFAULT NULL COMMENT '订单状态（1：待付款；2：已付款；3：订单取消）',
  `order_user` varchar(50) DEFAULT NULL COMMENT '下单人',
  `order_user_id` int(11) DEFAULT NULL COMMENT '下单人ID',
  `consume_user` varchar(50) DEFAULT NULL COMMENT '消费人',
  `consume_user_id` int(11) DEFAULT NULL COMMENT '消费人ID',
  `consume_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '消费时间',
  `score` int(11) DEFAULT NULL COMMENT '产生积分',
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主要用于保存用户下的订单的信息';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '201711101648', '550', '550', '1', '海通上合', '2017-11-09 16:42:31', '2', '林泽锋', '1', '林瑾', '1', '2017-11-10 16:47:21', '550', '下次给优惠这个顾客');

-- ----------------------------
-- Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点餐列表流水ID',
  `dinner_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `price` double DEFAULT NULL COMMENT '单价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `image_url` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `good_type_name` varchar(50) DEFAULT NULL COMMENT '菜品类型名字',
  `name` varchar(100) DEFAULT NULL COMMENT '菜名',
  `preferential_price` double DEFAULT NULL COMMENT '优惠价格',
  `is_preferential` varchar(2) DEFAULT NULL COMMENT '是否优惠（1：是；2：否）',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `state` varchar(2) DEFAULT '1' COMMENT '状态（1：正常；2：撤单）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='主要用于存放用户的点餐明细';

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '1', '1', '100', '4', '#', '肉类', '小鸡炖蘑菇', '100', '1', '2017-11-10 15:56:24', '2');
INSERT INTO `t_order_detail` VALUES ('2', '1', '1', '50', '3', '#', '菜类', '炒白菜', '50', '1', '2017-11-10 09:38:33', '1');

-- ----------------------------
-- Table structure for `tree`
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `p_id` bigint(20) DEFAULT NULL,
  `tree_order` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tree
-- ----------------------------
INSERT INTO `tree` VALUES ('1', '#', 'fa fa-fw fa-cogs', '系统管理', '0', '1', '#', '1');
INSERT INTO `tree` VALUES ('2', null, 'fa fa-fw fa-tree', '菜单管理', '1', '1', 'treeList', '1');
INSERT INTO `tree` VALUES ('7', 'groupManager', 'fa fa-fw fa-group', '组织架构', '1', '2', 'groupList', '1');
INSERT INTO `tree` VALUES ('8', 'userRoleManager', 'fa fa-fw fa-user-secret', '角色管理', '1', '3', 'userRoleList', '1');
INSERT INTO `tree` VALUES ('9', 'userManager', 'fa fa-fw fa-user', '用户维护', '1', '4', 'userList', '1');
INSERT INTO `tree` VALUES ('10', 'dictManager', 'fa fa-fw fa-book', '字典维护', '1', '5', 'dictList', '0');
INSERT INTO `tree` VALUES ('17', 'sysManager', 'fa fa-fw fa-desktop', '菜单维护', '0', '2', '#', '1');
INSERT INTO `tree` VALUES ('23', 'foodTypeManager', 'fa fa-fw fa-tree', '菜品维护', '17', '1', 'foodTypeList', '1');
INSERT INTO `tree` VALUES ('24', 'dinerListManager', 'fa fa-fw fa-book', '菜单管理', '17', '2', '/dinerList', '1');
INSERT INTO `tree` VALUES ('25', 'orderManager', 'fa fa-fw fa-book', '订单管理', '17', '3', 'orderList', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgcws90nffc311tac0vg2xy6cw` (`group_id`),
  CONSTRAINT `FKgcws90nffc311tac0vg2xy6cw` FOREIGN KEY (`group_id`) REFERENCES `org_group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hyll', '140b6ce18716153fba3bf98a52722bd5', 'linzf', '福建省福州市晋安区铜盘路29号超大大厦', '餐饮小兵', '10', null, '福州市', '晋安区', '福建省', '铜盘路29号超大大厦', '1', '1', '2017-11-10 16:46:55');
INSERT INTO `user` VALUES ('2', 'hyll144', '140b6ce18716153fba3bf98a52722bd5', '福建好运联联', '北京市北京市市辖区东城区阿道夫的辐射大', '餐饮小兵', '10', null, '北京市市辖区', '东城区', '北京市', '阿道夫的辐射大', '1', '1', null);
INSERT INTO `user` VALUES ('9', 'linzhefeng23', '140b6ce18716153fba3bf98a52722bd5', '林泽锋', '福建省福州市晋安区秀山路188号', '餐饮主管', '10', null, '福州市', '晋安区', '福建省', '秀山路188号', '0', '1', null);
INSERT INTO `user` VALUES ('20', 'linzf1', '140b6ce18716153fba3bf98a52722bd5', 'linzf2', '福建省福州市晋安区linzf12', 'linzf2', '9', null, '福州市', '晋安区', '福建省', 'linzf12', '1', null, null);

-- ----------------------------
-- Table structure for `user_associate_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_associate_role`;
CREATE TABLE `user_associate_role` (
  `user_id` int(11) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK4kspd00l9tn3oi6swv1cjf7vh` (`role_id`),
  KEY `FKl7kmw86eevxmoxwxu55poq7bm` (`user_id`),
  CONSTRAINT `FK4kspd00l9tn3oi6swv1cjf7vh` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`),
  CONSTRAINT `FKl7kmw86eevxmoxwxu55poq7bm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_associate_role
-- ----------------------------
INSERT INTO `user_associate_role` VALUES ('20', '1');
INSERT INTO `user_associate_role` VALUES ('9', '2');
INSERT INTO `user_associate_role` VALUES ('2', '2');
INSERT INTO `user_associate_role` VALUES ('1', '1');
INSERT INTO `user_associate_role` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'ROLE_ADMIN', '系统管理员');
INSERT INTO `user_role` VALUES ('2', 'ROLE_USER', '普通用户');
