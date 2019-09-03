/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3307
Source Database       : pls_dev

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-09-03 22:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mem_department
-- ----------------------------
DROP TABLE IF EXISTS `mem_department`;
CREATE TABLE `mem_department` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父类ID',
  PRIMARY KEY (`ID`),
  KEY `FK_MEM_DEPARTMENT_TO_MEM_DEPARTMENT` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_department
-- ----------------------------
INSERT INTO `mem_department` VALUES ('1', '1', '0', '0', '1', null, null, '', '2019-04-30 11:10:14', '', '2019-04-30 11:10:14', '', '');

-- ----------------------------
-- Table structure for mem_member
-- ----------------------------
DROP TABLE IF EXISTS `mem_member`;
CREATE TABLE `mem_member` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `NICK_NAME` varchar(32) DEFAULT NULL COMMENT '昵称',
  `WECHAT` varchar(32) DEFAULT NULL,
  `MOBILE` varchar(16) DEFAULT NULL COMMENT '电话',
  `SEX` tinyint(4) DEFAULT NULL COMMENT '性别',
  `EMAIL` varchar(64) DEFAULT NULL,
  `OPEN_ID` varchar(512) DEFAULT NULL,
  `UNION_ID` varchar(512) DEFAULT NULL,
  `LOGIN_NAME` varchar(32) DEFAULT NULL COMMENT '登录名',
  `ID_CARD` varchar(24) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_member
-- ----------------------------
INSERT INTO `mem_member` VALUES ('1', '1', '0', '0', '1', null, null, '', '2019-04-30 11:09:55', '', '2019-04-30 11:09:55', '', '', '', '', null, '', '', '', '', '');

-- ----------------------------
-- Table structure for mem_member_position
-- ----------------------------
DROP TABLE IF EXISTS `mem_member_position`;
CREATE TABLE `mem_member_position` (
  `ID` varchar(32) NOT NULL,
  `MEMBER_ID` varchar(32) DEFAULT NULL,
  `POSTION_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MEM_MEMBER_POSITION_TO_MEMBER` (`MEMBER_ID`),
  KEY `FK_MEM_MEMBER_POSITION_TO_POSTION` (`POSTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_member_position
-- ----------------------------
INSERT INTO `mem_member_position` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for mem_postion
-- ----------------------------
DROP TABLE IF EXISTS `mem_postion`;
CREATE TABLE `mem_postion` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `CODE` varchar(32) DEFAULT NULL COMMENT '代码',
  `DEPT_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MEM_POSTION_TO_MEM_DEPARTMENT` (`DEPT_ID`),
  CONSTRAINT `FK_MEM_POSTION_TO_MEM_DEPARTMENT` FOREIGN KEY (`DEPT_ID`) REFERENCES `mem_department` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_postion
-- ----------------------------
INSERT INTO `mem_postion` VALUES ('1', '1', '0', '0', '1', null, null, '', '2019-04-30 11:10:02', '', '2019-04-30 11:10:02', '', '', '1');

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `LOGIN_TIMES` int(32) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_LOGIN_LOG_TO_USER` (`USER_ID`),
  CONSTRAINT `FK_SYS_LOGIN_LOG_TO_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父类ID',
  `CODE` varchar(32) DEFAULT NULL,
  `URL` varchar(45) DEFAULT NULL COMMENT '界面URL地址',
  `ICON` varchar(45) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_MENU_TO_SYS_MENU` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'test', '0', '0', '1', null, null, '', '2019-04-30 10:14:25', '', '2019-04-30 10:14:25', 'test', '', 'test', null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '0', '0', '1', null, null, null, '2019-09-03 19:53:08', null, '2019-09-03 19:53:08', null, null, 'system_manage', null, null);
INSERT INTO `sys_menu` VALUES ('3', '用户管理', '0', '0', '1', null, null, null, '2019-09-03 19:53:08', null, '2019-09-03 19:53:08', null, '2', 'user manage', null, null);
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '0', '0', '1', null, null, null, '2019-09-03 19:53:08', null, '2019-09-03 19:53:08', null, '2', 'role manage', null, null);
INSERT INTO `sys_menu` VALUES ('5', '权限管理', '0', '0', '1', null, null, null, '2019-09-03 20:45:40', null, '2019-09-03 20:45:40', null, '2', 'permission manage', null, null);
INSERT INTO `sys_menu` VALUES ('6', '菜单管理', '0', '0', '1', null, null, null, '2019-09-03 20:45:57', null, '2019-09-03 20:45:57', null, '2', 'menu manage', null, null);

-- ----------------------------
-- Table structure for sys_ope_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_ope_log`;
CREATE TABLE `sys_ope_log` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  `PARAMETERS` varchar(1024) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_OPE_TO_SYS_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_ope_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父类ID',
  `CODE` varchar(255) DEFAULT NULL COMMENT '权限表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '测试', '0', '0', '1', null, null, '', '2019-04-27 15:50:12', '', '2019-04-27 15:50:12', '', '', '*');
INSERT INTO `sys_permission` VALUES ('10', '系统管理-角色管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '8', 'system:role:add');
INSERT INTO `sys_permission` VALUES ('11', '系统管理-角色管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '8', 'system:role:update');
INSERT INTO `sys_permission` VALUES ('12', '系统管理-角色管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '8', 'system:role:delete');
INSERT INTO `sys_permission` VALUES ('13', '系统管理-权限管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '2', '');
INSERT INTO `sys_permission` VALUES ('14', '系统管理-权限管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '13', 'system:permission:select');
INSERT INTO `sys_permission` VALUES ('15', '系统管理-权限管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '13', 'system:permission:add');
INSERT INTO `sys_permission` VALUES ('16', '系统管理-权限管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '13', 'system:permission:update');
INSERT INTO `sys_permission` VALUES ('17', '系统管理-权限管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '13', 'system:permission:delete');
INSERT INTO `sys_permission` VALUES ('18', '系统管理-菜单管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '2', '');
INSERT INTO `sys_permission` VALUES ('19', '系统管理-菜单管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '18', 'system:menu:select');
INSERT INTO `sys_permission` VALUES ('2', '系统管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, null, '');
INSERT INTO `sys_permission` VALUES ('20', '系统管理-菜单管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '18', 'system:menu:add');
INSERT INTO `sys_permission` VALUES ('21', '系统管理-菜单管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '18', 'system:menu:update');
INSERT INTO `sys_permission` VALUES ('22', '系统管理-菜单管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '18', 'system:menu:delete');
INSERT INTO `sys_permission` VALUES ('3', '系统管理-用户管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '2', '');
INSERT INTO `sys_permission` VALUES ('4', '系统管理-用户管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '3', 'system:user:select');
INSERT INTO `sys_permission` VALUES ('5', '系统管理-用户管理-添加', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '3', 'system:user:add');
INSERT INTO `sys_permission` VALUES ('6', '系统管理-用户管理-修改', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '3', 'system:user:update');
INSERT INTO `sys_permission` VALUES ('7', '系统管理-用户管理-删除', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '3', 'system:user:delete');
INSERT INTO `sys_permission` VALUES ('8', '系统管理-角色管理', '0', '0', '1', '1', null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '2', '');
INSERT INTO `sys_permission` VALUES ('9', '系统管理-角色管理-查询', '0', '0', '1', null, null, null, '2019-09-03 20:00:16', null, '2019-09-03 20:00:16', null, '8', 'system:role:select');

-- ----------------------------
-- Table structure for sys_permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_menu`;
CREATE TABLE `sys_permission_menu` (
  `ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) DEFAULT NULL,
  `PERMISSION_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_PERMISSION_MENU_TO_PERMISSION` (`PERMISSION_ID`),
  KEY `FK_SYS_PERMISSION_MENU_TO_MENU` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_menu
-- ----------------------------
INSERT INTO `sys_permission_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_menu` VALUES ('10', '5', '13');
INSERT INTO `sys_permission_menu` VALUES ('11', '6', '18');
INSERT INTO `sys_permission_menu` VALUES ('2', '2', '2');
INSERT INTO `sys_permission_menu` VALUES ('8', '3', '3');
INSERT INTO `sys_permission_menu` VALUES ('9', '4', '8');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '', '0', '0', '1', null, null, '', '2019-04-27 15:50:06', '', '2019-04-27 15:50:06', '');
INSERT INTO `sys_role` VALUES ('2', '资料员', '0', '0', '1', null, null, null, '2019-09-03 21:20:02', null, '2019-09-03 21:20:02', null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `ID` varchar(32) NOT NULL,
  `PERMISSION_ID` varchar(32) NOT NULL,
  `ROLE_ID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SYS_ROLE_PERMISSION_TO_PERMISSION` (`PERMISSION_ID`) USING BTREE,
  KEY `SYS_ROLE_PERMISSION_TO_ROLE` (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '3', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '8', '2');
INSERT INTO `sys_role_permission` VALUES ('4', '13', '2');
INSERT INTO `sys_role_permission` VALUES ('5', '18', '2');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL,
  `LOGIN_NAME` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `REAL_NAME` varchar(32) DEFAULT NULL,
  `IS_EXPIRED` tinyint(4) DEFAULT '0',
  `IS_LOCKED` tinyint(4) DEFAULT '0',
  `IS_ENABLED` tinyint(4) DEFAULT '1',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `SEX` tinyint(1) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL,
  `SORT` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  KEY `SYS_USER_LOGIN_NAME_INDEX` (`LOGIN_NAME`) USING BTREE,
  KEY `SYS_USER_EMAIL_INDEX` (`EMAIL`) USING BTREE,
  KEY `SYS_USER_MOBILE_INDEX` (`MOBILE`) USING BTREE,
  KEY `SYS_USER_SORT_INDEX` (`SORT`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:06', null, '2019-05-04 01:59:06', null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('10', '10', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:09:38', null, '2019-05-04 02:09:38', null, null, null, null, '2');
INSERT INTO `sys_user` VALUES ('11', '11', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:09:43', null, '2019-05-04 02:09:43', null, null, null, null, '3');
INSERT INTO `sys_user` VALUES ('12', '12', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:09:48', null, '2019-05-04 02:09:48', null, null, null, null, '4');
INSERT INTO `sys_user` VALUES ('15', '15', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:10:01', null, '2019-05-04 02:10:01', null, null, null, null, '5');
INSERT INTO `sys_user` VALUES ('19', '19', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:11:42', null, '2019-05-04 02:11:42', null, null, null, null, '6');
INSERT INTO `sys_user` VALUES ('2', '2', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:15', null, '2019-05-04 01:59:15', null, null, null, null, '7');
INSERT INTO `sys_user` VALUES ('20', '20', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 02:11:48', null, '2019-05-04 02:11:48', null, null, null, null, '8');
INSERT INTO `sys_user` VALUES ('23', '1', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 04:06:29', null, '2019-05-04 04:06:29', null, null, null, null, '9');
INSERT INTO `sys_user` VALUES ('24', '1', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 04:06:32', null, '2019-05-04 04:06:32', null, null, null, null, '10');
INSERT INTO `sys_user` VALUES ('27', '1', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 04:06:43', null, '2019-05-04 04:06:43', null, null, null, null, '11');
INSERT INTO `sys_user` VALUES ('28', 'ziliaoyuan', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-09-03 21:20:35', null, '2019-09-03 21:20:47', null, null, null, null, '16');
INSERT INTO `sys_user` VALUES ('3', '3', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:20', null, '2019-05-04 01:59:20', null, null, null, null, '12');
INSERT INTO `sys_user` VALUES ('4', '5', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:25', null, '2019-05-04 01:59:25', null, null, null, null, '13');
INSERT INTO `sys_user` VALUES ('7', '7', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:36', null, '2019-05-04 01:59:36', null, null, null, null, '14');
INSERT INTO `sys_user` VALUES ('9', '9', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-04 01:59:47', null, '2019-05-04 01:59:47', null, null, null, null, '15');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL,
  `USER_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_USER_ROLE_TO_USER` (`USER_ID`),
  KEY `FK_SYS_USER_ROLE_TO_ROLE` (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '1');
INSERT INTO `sys_user_role` VALUES ('3', '28', '2');
