/*
Navicat MySQL Data Transfer

Source Server         : 31数据库
Source Server Version : 50716
Source Host           : 10.6.71.236:3306
Source Database       : hyll_springboot

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-11-24 16:49:18
*/
use hyll_springboot;

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

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
INSERT INTO `dict` VALUES ('46', 'WAIT_USE', '待使用', 'DINING_TABLE_STATE', '1', '1');
INSERT INTO `dict` VALUES ('47', 'USE', '使用中', 'DINING_TABLE_STATE', '2', '1');
INSERT INTO `dict` VALUES ('48', 'MAINTENANCE', '维护中', 'DINING_TABLE_STATE', '3', '1');
INSERT INTO `dict` VALUES ('50', 'NORMAL', '正常', 'DINNER_TYPE', '1', '1');
INSERT INTO `dict` VALUES ('51', 'ADD', '加菜', 'DINNER_TYPE', '2', '1');
INSERT INTO `dict` VALUES ('52', 'SCORE_ADD', '积分增加', 'SCORE_TYPE', '1', '1');
INSERT INTO `dict` VALUES ('53', 'SCORE_REDUCE', '积分减少', 'SCORE_TYPE', '2', '1');
INSERT INTO `dict` VALUES ('54', 'SCORE_CANCEL', '积分取消', 'SCORE_TYPE', '3', '1');

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
INSERT INTO `role_associate_tree` VALUES ('2', '23');
INSERT INTO `role_associate_tree` VALUES ('2', '24');
INSERT INTO `role_associate_tree` VALUES ('2', '25');
INSERT INTO `role_associate_tree` VALUES ('2', '26');
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
INSERT INTO `role_associate_tree` VALUES ('1', '26');
INSERT INTO `role_associate_tree` VALUES ('1', '27');
INSERT INTO `role_associate_tree` VALUES ('1', '28');
INSERT INTO `role_associate_tree` VALUES ('1', '29');

-- ----------------------------
-- Table structure for `t_dining_table`
-- ----------------------------
DROP TABLE IF EXISTS `t_dining_table`;
CREATE TABLE `t_dining_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '桌号流水',
  `name` varchar(50) DEFAULT NULL COMMENT '桌名',
  `state` varchar(2) DEFAULT NULL COMMENT '状态（1：待使用；2：使用中；3：维护中）',
  `image` varchar(50) DEFAULT NULL COMMENT '图片地址',
  `crt_date` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `crt_user_id` int(11) DEFAULT NULL COMMENT '创建人流水ID',
  `dining_describe` varchar(200) DEFAULT NULL COMMENT '描述',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='餐桌维护';

-- ----------------------------
-- Records of t_dining_table
-- ----------------------------
INSERT INTO `t_dining_table` VALUES ('1', '中和殿', '1', '/images/desk/02.jpg', '2017-11-14 10:18:07', 'linzf', '1', '中和殿介绍', '中和殿备注', '1');
INSERT INTO `t_dining_table` VALUES ('2', '保和殿', '1', '/images/desk/03.jpg', '2017-11-14 10:22:27', 'linzf', '1', '保和殿介绍', '保和殿备注', '8');
INSERT INTO `t_dining_table` VALUES ('3', '乾清宫', '1', '/images/desk/04.jpg', '2017-11-14 10:22:42', 'linzf', '1', '乾清宫', '乾清宫', '5');
INSERT INTO `t_dining_table` VALUES ('4', '交泰殿', '1', '/images/desk/05.jpg', '2017-11-14 10:22:59', 'linzf', '1', '交泰殿', '交泰殿', null);
INSERT INTO `t_dining_table` VALUES ('5', '坤宁宫', '1', '/images/desk/06.jpg', '2017-11-14 10:23:14', 'linzf', '1', '坤宁宫', '坤宁宫', '10');
INSERT INTO `t_dining_table` VALUES ('6', '储秀宫', '1', '/images/desk/07.jpg', '2017-11-14 10:23:29', 'linzf', '1', '储秀宫', '储秀宫', '11');
INSERT INTO `t_dining_table` VALUES ('7', '养心殿', '1', '/images/desk/08.jpg', '2017-11-14 10:23:44', 'linzf', '1', '养心殿', '养心殿', '18');

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='主要保存菜品信息';

-- ----------------------------
-- Records of t_dinner
-- ----------------------------
INSERT INTO `t_dinner` VALUES ('3', '饺子', '3', '肉品', '53', '4', '/images/2.jpg', '2017-11-23 17:29:06', 'linzf', '1', '48', '1');
INSERT INTO `t_dinner` VALUES ('4', '红烧肉', '3', '肉品', '80', '3', '/images/1.jpg', '2017-11-23 17:29:06', 'linzf', '1', '80', '1');
INSERT INTO `t_dinner` VALUES ('5', '清炒苦瓜', '5', '蔬菜', '12', '0', '/images/18.jpg', '2017-11-14 11:45:09', 'linzf', '1', '12', '1');
INSERT INTO `t_dinner` VALUES ('6', '爆炒猪耳', '3', '肉品', '30', '2', '/images/2.jpg', '2017-11-22 09:42:20', 'linzf', '1', '30', '1');
INSERT INTO `t_dinner` VALUES ('7', '爆炒牛肉', '3', '肉品', '45', '6', '/images/4.jpg', '2017-11-23 17:29:06', 'linzf', '1', '45', '1');
INSERT INTO `t_dinner` VALUES ('8', '红烧猪肋', '3', '肉品', '25', '7', '/images/5.jpg', '2017-11-23 17:29:06', 'linzf', '1', '25', '1');
INSERT INTO `t_dinner` VALUES ('9', '爆炒肉肠', '3', '肉品', '18', '0', '/images/6.jpg', '2017-11-14 11:45:18', 'linzf', '1', '18', '1');
INSERT INTO `t_dinner` VALUES ('10', '红烧鲫鱼', '4', '水产', '30', '0', '/images/7.jpg', '2017-11-14 11:45:20', 'linzf', '1', '30', '1');
INSERT INTO `t_dinner` VALUES ('11', '油闷大虾', '4', '水产', '60', '0', '/images/8.jpg', '2017-11-14 11:45:22', 'linzf', '1', '60', '1');
INSERT INTO `t_dinner` VALUES ('12', '海鲜盛宴', '4', '水产', '168', '0', '/images/9.jpg', '2017-11-14 11:45:24', 'linzf', '1', '168', '1');
INSERT INTO `t_dinner` VALUES ('13', '炒上海青', '5', '蔬菜', '8', '0', '/images/13.jpg', '2017-11-14 11:45:25', 'linzf', '1', '8', '1');
INSERT INTO `t_dinner` VALUES ('14', '炒毛豆', '5', '蔬菜', '8', '0', '/images/17.jpg', '2017-11-14 11:45:27', 'linzf', '1', '8', '1');
INSERT INTO `t_dinner` VALUES ('15', '白米饭', '6', '干粮杂货', '2', '0', '/images/21.jpg', '2017-11-14 11:45:31', 'linzf', '1', '2', '1');
INSERT INTO `t_dinner` VALUES ('16', '黑米饭', '6', '干粮杂货', '2', '0', '/images/22.jpg', '2017-11-14 11:45:32', 'linzf', '1', '2', '1');
INSERT INTO `t_dinner` VALUES ('17', '黄米饭', '6', '干粮杂货', '2', '0', '/images/23.jpg', '2017-11-14 11:45:34', 'linzf', '1', '2', '1');
INSERT INTO `t_dinner` VALUES ('18', '米糕', '7', '糕点', '5', '1', '/images/24.jpg', '2017-11-16 16:19:50', 'linzf', '1', '5', '1');
INSERT INTO `t_dinner` VALUES ('19', '红米糕', '7', '糕点', '5', '2', '/images/26.jpg', '2017-11-16 16:19:50', 'linzf', '1', '5', '1');
INSERT INTO `t_dinner` VALUES ('20', '蓝米糕', '7', '糕点', '5', '1', '/images/25.jpg', '2017-11-16 16:19:50', 'linzf', '1', '5', '1');
INSERT INTO `t_dinner` VALUES ('21', '慕斯', '7', '糕点', '6', '1', '/images/25.jpg', '2017-11-16 16:19:50', 'linzf', '1', '6', '1');
INSERT INTO `t_dinner` VALUES ('22', '爆炒花蛤', '4', '水产', '16', '0', '/images/10.jpg', '2017-11-14 11:45:43', 'linzf', '1', '16', '1');
INSERT INTO `t_dinner` VALUES ('23', '青瓜炒蛋', '5', '蔬菜', '9', '0', '/images/16.jpg', '2017-11-14 11:45:45', 'linzf', '1', '9', '1');

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
-- Table structure for `t_mobile_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_mobile_user`;
CREATE TABLE `t_mobile_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点餐用户流水ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `phone` varchar(30) DEFAULT NULL COMMENT '电话',
  `pass` varchar(30) DEFAULT NULL COMMENT '密码',
  `score` int(11) DEFAULT NULL COMMENT '积分',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别（男 或者 女）',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `consume_time` datetime DEFAULT NULL COMMENT '最近消费时间',
  `consume_money` double DEFAULT NULL COMMENT '最近消费金额',
  `token` varchar(50) DEFAULT NULL COMMENT '登陆的token',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='存放移动端的用户';

-- ----------------------------
-- Records of t_mobile_user
-- ----------------------------
INSERT INTO `t_mobile_user` VALUES ('1', '林泽锋', '18559405027', '123456', '125', null, '男', '18', null, null, null, null);
INSERT INTO `t_mobile_user` VALUES ('3', '测试123333', '15080499412', '123456733', '0', null, '2233', '122233', null, null, null, null);

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单流水ID',
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
  `consume_user_phone` varchar(50) DEFAULT NULL COMMENT '消费人手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='主要用于保存用户下的订单的信息';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '201711101648', '1400', '550', '1', '海通上合', '2017-11-09 16:42:31', '1', '林泽锋', '1', '林瑾', '1', '2017-11-10 16:47:21', '550', '下次给优惠这个顾客', null);
INSERT INTO `t_order` VALUES ('5', '20171115163000603', '383', null, '3', '乾清宫', '2017-11-15 16:30:01', '1', '福建好运联联', '2', null, '0', '2017-11-15 16:23:40', '0', null, null);
INSERT INTO `t_order` VALUES ('6', '20171115164051680', '26', '26', '5', '坤宁宫', '2017-11-15 16:40:52', '2', '福建好运联联', '2', '', '0', '2017-11-16 16:26:10', '26', null, null);
INSERT INTO `t_order` VALUES ('7', '20171116112402035', '158', '158', '2', '保和殿', '2017-11-16 11:24:02', '2', '福建好运联联', '2', '', '0', '2017-11-16 16:22:41', '158', null, null);
INSERT INTO `t_order` VALUES ('8', '20171116175717312', '65', null, '2', '保和殿', '2017-11-16 17:57:17', '1', '福建好运联联', '2', null, '0', '2017-11-16 17:50:56', '0', null, null);
INSERT INTO `t_order` VALUES ('9', '20171117214920853', '125', '125', '4', '交泰殿', '2017-11-17 21:49:21', '2', '福建好运联联', '2', '林泽锋', '0', '2017-11-22 09:48:30', '125', null, '18559405027');
INSERT INTO `t_order` VALUES ('10', '20171123154909424', '192', null, '5', '坤宁宫', '2017-11-23 15:49:09', '1', '福建好运联联', '2', null, '0', '2017-11-23 15:42:57', '0', null, null);
INSERT INTO `t_order` VALUES ('11', '20171123165113169', '229', null, '6', '储秀宫', '2017-11-23 16:51:13', '1', '福建好运联联', '2', null, '0', '2017-11-23 16:45:01', '0', null, null);
INSERT INTO `t_order` VALUES ('12', '20171123172445179', '93', '93', '7', '养心殿', '2017-11-23 17:24:44', '2', '福建好运联联', '2', '', '0', '2017-11-23 17:26:02', '93', null, '');
INSERT INTO `t_order` VALUES ('13', '20171123172914714', '140', '140', '7', '养心殿', '2017-11-23 17:29:15', '2', '福建好运联联', '2', '', '0', '2017-11-23 17:30:23', '140', null, '');
INSERT INTO `t_order` VALUES ('14', '20171123173044449', '153', '153', '7', '养心殿', '2017-11-23 17:30:44', '2', '福建好运联联', '2', '', '0', '2017-11-23 17:32:21', '153', null, '');
INSERT INTO `t_order` VALUES ('15', '20171123173238817', '268', '268', '7', '养心殿', '2017-11-23 17:32:39', '2', '福建好运联联', '2', '', '0', '2017-11-23 17:35:19', '268', null, '');
INSERT INTO `t_order` VALUES ('16', '20171123173535314', '150', null, '7', '养心殿', '2017-11-23 17:35:35', '3', '福建好运联联', '2', null, '0', '2017-11-23 17:36:08', '0', null, null);
INSERT INTO `t_order` VALUES ('17', '20171123173711224', '70', null, '7', '养心殿', '2017-11-23 17:37:11', '3', '福建好运联联', '2', null, '0', '2017-11-23 17:38:29', '0', null, null);
INSERT INTO `t_order` VALUES ('18', '20171123173848404', '156', null, '7', '养心殿', '2017-11-23 17:38:48', '1', '福建好运联联', '2', null, '0', '2017-11-23 17:32:36', '0', null, null);

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
  `type` varchar(2) DEFAULT NULL COMMENT '点餐类型（1：正常；2：加菜）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COMMENT='主要用于存放用户的点餐明细';

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '1', '1', '100', '4', '#', '肉类', '小鸡炖蘑菇', '100', '1', '2017-11-10 15:56:24', '2', '1');
INSERT INTO `t_order_detail` VALUES ('2', '1', '1', '50', '3', '#', '菜类', '炒白菜', '50', '1', '2017-11-10 09:38:33', '1', '1');
INSERT INTO `t_order_detail` VALUES ('3', '3', '1', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-15 15:06:52', '1', '2');
INSERT INTO `t_order_detail` VALUES ('4', '4', '1', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-15 15:06:52', '1', '2');
INSERT INTO `t_order_detail` VALUES ('5', '3', '1', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-15 15:13:38', '1', '2');
INSERT INTO `t_order_detail` VALUES ('6', '4', '1', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-15 15:13:38', '1', '2');
INSERT INTO `t_order_detail` VALUES ('7', '6', '1', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-15 15:25:03', '1', '2');
INSERT INTO `t_order_detail` VALUES ('8', '8', '1', '25', '2', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-15 15:25:03', '1', '2');
INSERT INTO `t_order_detail` VALUES ('9', '9', '1', '18', '3', '/images/6.jpg', '肉品', '爆炒肉肠', '18', '1', '2017-11-15 15:25:03', '1', '2');
INSERT INTO `t_order_detail` VALUES ('10', '5', '1', '12', '1', '/images/18.jpg', '蔬菜', '清炒苦瓜', '12', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('11', '13', '1', '8', '1', '/images/13.jpg', '蔬菜', '炒上海青', '8', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('12', '14', '1', '8', '1', '/images/17.jpg', '蔬菜', '炒毛豆', '8', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('13', '15', '1', '2', '1', '/images/21.jpg', '干粮杂货', '白米饭', '2', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('14', '16', '1', '2', '1', '/images/22.jpg', '干粮杂货', '黑米饭', '2', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('15', '17', '1', '2', '1', '/images/23.jpg', '干粮杂货', '黄米饭', '2', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('16', '18', '1', '5', '1', '/images/24.jpg', '糕点', '米糕', '5', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('17', '19', '1', '5', '1', '/images/26.jpg', '糕点', '红米糕', '5', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('18', '20', '1', '5', '1', '/images/25.jpg', '糕点', '蓝米糕', '5', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('19', '21', '1', '6', '1', '/images/25.jpg', '糕点', '慕斯', '6', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('20', '23', '1', '9', '1', '/images/16.jpg', '蔬菜', '青瓜炒蛋', '9', '1', '2017-11-15 15:25:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('21', '7', '1', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-15 15:29:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('22', '3', '1', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-15 15:32:19', '1', '2');
INSERT INTO `t_order_detail` VALUES ('23', '9', '1', '18', '1', '/images/6.jpg', '肉品', '爆炒肉肠', '18', '1', '2017-11-15 15:32:33', '1', '2');
INSERT INTO `t_order_detail` VALUES ('24', '3', '1', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-15 15:34:18', '1', '2');
INSERT INTO `t_order_detail` VALUES ('25', '8', '1', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-15 15:34:27', '1', '2');
INSERT INTO `t_order_detail` VALUES ('37', '4', '5', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-15 16:30:01', '1', '1');
INSERT INTO `t_order_detail` VALUES ('38', '7', '5', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-15 16:30:01', '1', '1');
INSERT INTO `t_order_detail` VALUES ('39', '8', '5', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-15 16:30:01', '1', '1');
INSERT INTO `t_order_detail` VALUES ('40', '4', '5', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-15 16:40:15', '1', '2');
INSERT INTO `t_order_detail` VALUES ('41', '18', '6', '5', '1', '/images/24.jpg', '糕点', '米糕', '5', '1', '2017-11-15 16:40:52', '1', '1');
INSERT INTO `t_order_detail` VALUES ('42', '19', '6', '5', '2', '/images/26.jpg', '糕点', '红米糕', '5', '1', '2017-11-15 16:40:52', '1', '1');
INSERT INTO `t_order_detail` VALUES ('43', '20', '6', '5', '1', '/images/25.jpg', '糕点', '蓝米糕', '5', '1', '2017-11-15 16:40:52', '1', '1');
INSERT INTO `t_order_detail` VALUES ('44', '21', '6', '6', '1', '/images/25.jpg', '糕点', '慕斯', '6', '1', '2017-11-15 16:40:52', '1', '1');
INSERT INTO `t_order_detail` VALUES ('45', '13', '1', '8', '1', '/images/13.jpg', '蔬菜', '炒上海青', '8', '1', '2017-11-16 10:39:35', '1', '2');
INSERT INTO `t_order_detail` VALUES ('46', '14', '1', '8', '1', '/images/17.jpg', '蔬菜', '炒毛豆', '8', '1', '2017-11-16 10:39:35', '1', '2');
INSERT INTO `t_order_detail` VALUES ('47', '15', '1', '2', '1', '/images/21.jpg', '干粮杂货', '白米饭', '2', '1', '2017-11-16 10:39:35', '1', '2');
INSERT INTO `t_order_detail` VALUES ('48', '16', '1', '2', '1', '/images/22.jpg', '干粮杂货', '黑米饭', '2', '1', '2017-11-16 10:39:35', '1', '2');
INSERT INTO `t_order_detail` VALUES ('49', '3', '7', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-16 11:24:02', '1', '1');
INSERT INTO `t_order_detail` VALUES ('50', '4', '7', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-16 11:24:02', '1', '1');
INSERT INTO `t_order_detail` VALUES ('51', '6', '7', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-16 11:24:02', '1', '1');
INSERT INTO `t_order_detail` VALUES ('52', '16', '1', '2', '1', '/images/22.jpg', '干粮杂货', '黑米饭', '2', '1', '2017-11-16 15:25:12', '1', '2');
INSERT INTO `t_order_detail` VALUES ('53', '17', '1', '2', '1', '/images/23.jpg', '干粮杂货', '黄米饭', '2', '1', '2017-11-16 15:25:12', '1', '2');
INSERT INTO `t_order_detail` VALUES ('54', '6', '1', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-16 15:33:56', '1', '2');
INSERT INTO `t_order_detail` VALUES ('55', '3', '5', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-16 15:39:18', '1', '2');
INSERT INTO `t_order_detail` VALUES ('56', '4', '5', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-16 15:39:18', '1', '2');
INSERT INTO `t_order_detail` VALUES ('57', '8', '5', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-16 15:39:18', '1', '2');
INSERT INTO `t_order_detail` VALUES ('58', '6', '8', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-16 17:57:17', '1', '1');
INSERT INTO `t_order_detail` VALUES ('59', '8', '8', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-16 17:57:17', '1', '1');
INSERT INTO `t_order_detail` VALUES ('60', '19', '8', '5', '1', '/images/26.jpg', '糕点', '红米糕', '5', '1', '2017-11-16 17:57:42', '1', '2');
INSERT INTO `t_order_detail` VALUES ('61', '20', '8', '5', '1', '/images/25.jpg', '糕点', '蓝米糕', '5', '1', '2017-11-16 17:57:42', '1', '2');
INSERT INTO `t_order_detail` VALUES ('62', '3', '1', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-17 21:47:31', '1', '2');
INSERT INTO `t_order_detail` VALUES ('63', '4', '1', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-17 21:47:31', '1', '2');
INSERT INTO `t_order_detail` VALUES ('64', '6', '1', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-17 21:47:31', '1', '2');
INSERT INTO `t_order_detail` VALUES ('65', '6', '9', '30', '1', '/images/2.jpg', '肉品', '爆炒猪耳', '30', '1', '2017-11-17 21:49:21', '1', '1');
INSERT INTO `t_order_detail` VALUES ('66', '7', '9', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-17 21:49:21', '1', '1');
INSERT INTO `t_order_detail` VALUES ('67', '8', '9', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-17 21:49:21', '1', '1');
INSERT INTO `t_order_detail` VALUES ('68', '8', '9', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-17 21:49:43', '1', '2');
INSERT INTO `t_order_detail` VALUES ('69', '7', '10', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 15:49:09', '1', '1');
INSERT INTO `t_order_detail` VALUES ('70', '8', '10', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 15:49:09', '1', '1');
INSERT INTO `t_order_detail` VALUES ('71', '7', '10', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 15:50:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('72', '8', '10', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 15:50:49', '1', '2');
INSERT INTO `t_order_detail` VALUES ('73', '8', '10', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 16:41:26', '1', '2');
INSERT INTO `t_order_detail` VALUES ('74', '23', '10', '9', '1', '/images/16.jpg', '蔬菜', '青瓜炒蛋', '9', '1', '2017-11-23 16:41:26', '1', '2');
INSERT INTO `t_order_detail` VALUES ('75', '9', '10', '18', '1', '/images/6.jpg', '肉品', '爆炒肉肠', '18', '1', '2017-11-23 16:42:28', '1', '2');
INSERT INTO `t_order_detail` VALUES ('76', '4', '11', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-23 16:51:13', '1', '1');
INSERT INTO `t_order_detail` VALUES ('77', '8', '11', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 16:51:13', '1', '1');
INSERT INTO `t_order_detail` VALUES ('78', '7', '11', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 16:52:55', '1', '2');
INSERT INTO `t_order_detail` VALUES ('79', '7', '11', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 16:57:40', '1', '2');
INSERT INTO `t_order_detail` VALUES ('80', '5', '11', '12', '1', '/images/18.jpg', '蔬菜', '清炒苦瓜', '12', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('81', '13', '11', '8', '1', '/images/13.jpg', '蔬菜', '炒上海青', '8', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('82', '14', '11', '8', '1', '/images/17.jpg', '蔬菜', '炒毛豆', '8', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('83', '15', '11', '2', '1', '/images/21.jpg', '干粮杂货', '白米饭', '2', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('84', '16', '11', '2', '1', '/images/22.jpg', '干粮杂货', '黑米饭', '2', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('85', '17', '11', '2', '1', '/images/23.jpg', '干粮杂货', '黄米饭', '2', '1', '2017-11-23 16:58:16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('86', '3', '12', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-23 17:24:41', '1', '1');
INSERT INTO `t_order_detail` VALUES ('87', '7', '12', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:24:41', '1', '1');
INSERT INTO `t_order_detail` VALUES ('88', '7', '13', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:29:15', '1', '1');
INSERT INTO `t_order_detail` VALUES ('89', '8', '13', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:29:15', '1', '1');
INSERT INTO `t_order_detail` VALUES ('90', '7', '13', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:29:58', '1', '2');
INSERT INTO `t_order_detail` VALUES ('91', '8', '13', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:29:58', '1', '2');
INSERT INTO `t_order_detail` VALUES ('92', '3', '14', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-23 17:30:44', '1', '1');
INSERT INTO `t_order_detail` VALUES ('93', '4', '14', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-23 17:30:44', '1', '1');
INSERT INTO `t_order_detail` VALUES ('94', '8', '14', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:30:44', '1', '1');
INSERT INTO `t_order_detail` VALUES ('95', '7', '15', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:32:39', '1', '1');
INSERT INTO `t_order_detail` VALUES ('96', '8', '15', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:32:39', '1', '1');
INSERT INTO `t_order_detail` VALUES ('97', '4', '15', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-23 17:33:30', '1', '2');
INSERT INTO `t_order_detail` VALUES ('98', '8', '15', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:33:30', '1', '2');
INSERT INTO `t_order_detail` VALUES ('99', '3', '15', '53', '1', '/images/2.jpg', '肉品', '饺子', '48', '1', '2017-11-23 17:35:04', '1', '2');
INSERT INTO `t_order_detail` VALUES ('100', '7', '15', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:35:04', '1', '2');
INSERT INTO `t_order_detail` VALUES ('101', '4', '16', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-23 17:35:35', '1', '1');
INSERT INTO `t_order_detail` VALUES ('102', '7', '16', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:35:35', '1', '1');
INSERT INTO `t_order_detail` VALUES ('103', '8', '16', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:35:35', '1', '1');
INSERT INTO `t_order_detail` VALUES ('104', '7', '17', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:37:11', '1', '1');
INSERT INTO `t_order_detail` VALUES ('105', '8', '17', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:37:11', '1', '1');
INSERT INTO `t_order_detail` VALUES ('106', '4', '18', '80', '1', '/images/1.jpg', '肉品', '红烧肉', '80', '1', '2017-11-23 17:38:48', '1', '1');
INSERT INTO `t_order_detail` VALUES ('107', '7', '18', '45', '1', '/images/4.jpg', '肉品', '爆炒牛肉', '45', '1', '2017-11-23 17:38:48', '1', '1');
INSERT INTO `t_order_detail` VALUES ('108', '8', '18', '25', '1', '/images/5.jpg', '肉品', '红烧猪肋', '25', '1', '2017-11-23 17:38:48', '1', '1');
INSERT INTO `t_order_detail` VALUES ('109', '15', '18', '2', '1', '/images/21.jpg', '干粮杂货', '白米饭', '2', '1', '2017-11-23 17:39:12', '1', '2');
INSERT INTO `t_order_detail` VALUES ('110', '16', '18', '2', '1', '/images/22.jpg', '干粮杂货', '黑米饭', '2', '1', '2017-11-23 17:39:12', '1', '2');
INSERT INTO `t_order_detail` VALUES ('111', '17', '18', '2', '1', '/images/23.jpg', '干粮杂货', '黄米饭', '2', '1', '2017-11-23 17:39:12', '1', '2');

-- ----------------------------
-- Table structure for `t_score_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_score_detail`;
CREATE TABLE `t_score_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分流水ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `type` varchar(2) DEFAULT NULL COMMENT '积分类型（1：增加积分；2：扣除积分；3：积分取消）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `score` int(11) DEFAULT NULL COMMENT '消耗积分',
  `order_no` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='记录积分的明细记录';

-- ----------------------------
-- Records of t_score_detail
-- ----------------------------
INSERT INTO `t_score_detail` VALUES ('1', '9', '1', '1', '2017-11-22 09:48:30', '125', '20171117214920853', '林泽锋');

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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

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
INSERT INTO `tree` VALUES ('24', 'dinerListManager', 'fa fa-fw fa-book', '菜单管理', '17', '2', 'dinerList', '1');
INSERT INTO `tree` VALUES ('25', 'orderManager', 'fa fa-fw fa-book', '订单管理', '17', '3', 'orderList', '1');
INSERT INTO `tree` VALUES ('26', 'diningTableManager', 'fa fa-fw fa-tree', '餐桌维护', '17', '4', 'diningTableList', '1');
INSERT INTO `tree` VALUES ('27', 'userManagerTop', 'fa fa-user', '用户维护', '0', '3', '#', '1');
INSERT INTO `tree` VALUES ('28', 'mobileUserManager', 'fa fa-user-circle', '移动用户', '27', '1', 'mobileUser', '1');
INSERT INTO `tree` VALUES ('29', 'scoreDetailManager', 'fa fa-user-circle', '积分明细', '27', '2', 'scoreDetailList', '1');

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
INSERT INTO `user` VALUES ('1', 'hyll', '140b6ce18716153fba3bf98a52722bd5', 'linzf', '福建省福州市晋安区铜盘路29号超大大厦', '餐饮小兵', '10', null, '福州市', '晋安区', '福建省', '铜盘路29号超大大厦', '1', '1', '2017-11-23 17:38:22');
INSERT INTO `user` VALUES ('2', 'hyll144', '140b6ce18716153fba3bf98a52722bd5', '福建好运联联', '北京市北京市市辖区东城区阿道夫的辐射大', '餐饮小兵', '10', null, '北京市市辖区', '东城区', '北京市', '阿道夫的辐射大', '1', '1', '2017-11-23 17:38:36');
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
INSERT INTO `user_associate_role` VALUES ('1', '1');
INSERT INTO `user_associate_role` VALUES ('1', '2');
INSERT INTO `user_associate_role` VALUES ('2', '3');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'ROLE_ADMIN', '系统管理员');
INSERT INTO `user_role` VALUES ('2', 'ROLE_USER', '普通用户');
INSERT INTO `user_role` VALUES ('3', 'ROLE_DINER', '点菜人员');
