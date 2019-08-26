/*
Navicat MySQL Data Transfer

Source Server         : percona 172.16.106.9 30060 root abc123（Manager角色）
Source Server Version : 50725
Source Host           : 172.16.106.9:30060
Source Database       : pls_dev

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-26 13:33:15
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
INSERT INTO `mem_department` VALUES ('2', '2', '0', '0', '1', null, null, null, '2019-06-30 02:59:43', null, '2019-06-30 02:59:43', null, '1');
INSERT INTO `mem_department` VALUES ('3', '3', '0', '0', '1', null, null, null, '2019-06-30 03:22:42', null, '2019-06-30 03:22:42', null, '1');
INSERT INTO `mem_department` VALUES ('4', '4', '0', '0', '1', null, null, null, '2019-06-30 03:25:02', null, '2019-06-30 03:25:02', null, '1');
INSERT INTO `mem_department` VALUES ('5', '5', '0', '0', '1', null, null, null, '2019-06-30 03:25:13', null, '2019-06-30 03:25:13', null, '3');

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
INSERT INTO `mem_member_position` VALUES ('5', '2', '1');

-- ----------------------------
-- Table structure for mem_member_role
-- ----------------------------
DROP TABLE IF EXISTS `mem_member_role`;
CREATE TABLE `mem_member_role` (
  `ID` varchar(32) NOT NULL,
  `MEMBER_ID` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '用户角色表',
  PRIMARY KEY (`ID`),
  KEY `FK_MEMBER_ROLE_ROLE` (`ROLE_ID`),
  KEY `FK_MEMBER_ROLE_MEMBER` (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_member_role
-- ----------------------------

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
-- Table structure for mycat_sequence
-- ----------------------------
DROP TABLE IF EXISTS `mycat_sequence`;
CREATE TABLE `mycat_sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` bigint(20) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mycat_sequence
-- ----------------------------

-- ----------------------------
-- Table structure for pro_category
-- ----------------------------
DROP TABLE IF EXISTS `pro_category`;
CREATE TABLE `pro_category` (
  `ID` varchar(32) NOT NULL COMMENT 'ID标识符',
  `NAME` varchar(64) DEFAULT NULL COMMENT '种类名称',
  `EN_NAME` varchar(64) DEFAULT NULL COMMENT '英文名称',
  `TYPE` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父类ID',
  `CODE` varchar(255) DEFAULT NULL COMMENT '表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品种类';

-- ----------------------------
-- Records of pro_category
-- ----------------------------

-- ----------------------------
-- Table structure for pro_pic_info
-- ----------------------------
DROP TABLE IF EXISTS `pro_pic_info`;
CREATE TABLE `pro_pic_info` (
  `ID` varchar(32) NOT NULL COMMENT 'ID标识符',
  `PIC_URL` varchar(512) DEFAULT '' COMMENT '种类名称',
  `PIC_DESC` varchar(64) DEFAULT '',
  `IS_MASTER` tinyint(4) DEFAULT '0' COMMENT '是否为主图：0否，1是',
  `PIC_ORDER` int(11) DEFAULT '0' COMMENT '图片排序',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `PRODUCT_ID` varchar(32) DEFAULT NULL,
  `LOCATION` varchar(128) DEFAULT NULL COMMENT '图片物理地址',
  `IS_VALID` tinyint(4) DEFAULT '1' COMMENT '是否可用，0否，1是',
  PRIMARY KEY (`ID`),
  KEY `FK_PIC_INFO_TO_PRODUCT` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- ----------------------------
-- Records of pro_pic_info
-- ----------------------------

-- ----------------------------
-- Table structure for pro_product
-- ----------------------------
DROP TABLE IF EXISTS `pro_product`;
CREATE TABLE `pro_product` (
  `ID` varchar(32) NOT NULL COMMENT 'ID标识符',
  `NAME` varchar(64) DEFAULT NULL COMMENT '种类名称',
  `EN_NAME` varchar(64) DEFAULT NULL COMMENT '英文名称',
  `TYPE` int(11) DEFAULT NULL,
  `PUBLISH_STATUS` int(11) DEFAULT '0' COMMENT '上下架状态：0下架，1上架',
  `AUDIT_STATUS` int(11) DEFAULT '0' COMMENT '审核状态：0未审核，1已经审核',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父类ID',
  `CODE` varchar(255) DEFAULT NULL COMMENT '表达式',
  `CATEGORY_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCT_TO_PRO_CATEGORY` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of pro_product
-- ----------------------------

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
  `PARENT_ID` varchar(32) DEFAULT '0' COMMENT '父类ID',
  `CODE` varchar(32) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_MENU_TO_SYS_MENU` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

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
INSERT INTO `sys_permission` VALUES ('1', 'admin', '0', '0', '1', null, null, null, '2019-05-20 02:46:38', null, '2019-05-20 02:46:38', '1', null, '*');

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
INSERT INTO `sys_role` VALUES ('1', '1', '0', '0', '1', null, null, null, '2019-05-20 02:46:05', null, '2019-05-20 02:46:05', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', '', '0', '0', '1', null, null, '', '2019-05-20 02:45:51', '', '2019-06-23 10:34:31', '', '', null, '', '24');
INSERT INTO `sys_user` VALUES ('5', '5', '$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu', null, '0', '0', '1', null, null, null, '2019-05-21 08:53:01', null, '2019-05-21 08:53:14', null, null, null, null, '26');

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
INSERT INTO `sys_user_role` VALUES ('3', '3', '1');

-- ----------------------------
-- Function structure for getChildrenMemDepartment
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildrenMemDepartment`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getChildrenMemDepartment`(id VARCHAR(120)) RETURNS varchar(4000) CHARSET utf8
BEGIN
	DECLARE
		oTemp VARCHAR (4000);

DECLARE
	oTempChild VARCHAR (4000);


SET oTemp = '';


SET oTempChild = CAST(id AS CHAR);


WHILE oTempChild IS NOT NULL DO

SET oTemp = CONCAT(oTemp, ',', oTempChild);

SELECT
	GROUP_CONCAT(id) INTO oTempChild
FROM
	mem_department
WHERE
	FIND_IN_SET(parent_id, oTempChild) > 0;

END
WHILE;

RETURN oTemp;

END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for mycat_seq_currval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_currval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN
DECLARE retval VARCHAR(64);
SET retval="-999999999,null";
SELECT CONCAT(CAST(current_value AS CHAR),",",CAST(increment AS
CHAR) ) INTO retval
FROM MYCAT_SEQUENCE WHERE NAME = seq_name;
RETURN retval ;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for mycat_seq_nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_nextval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE SET current_value = current_value + increment
WHERE NAME = seq_name;
RETURN mycat_seq_currval(seq_name);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for mycat_seq_setval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_setval`(seq_name VARCHAR(50),value INTEGER) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE
SET current_value = value
WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for queryChildrenMemDepartment
-- ----------------------------
DROP FUNCTION IF EXISTS `queryChildrenMemDepartment`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `queryChildrenMemDepartment`(departmentId VARCHAR(120)) RETURNS varchar(4000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp='$';
SET sTempChd = CAST(departmentId AS CHAR);

WHILE sTempChd IS NOT NULL DO
SET sTemp= CONCAT(sTemp,',',sTempChd);
SELECT GROUP_CONCAT(id) INTO sTempChd FROM mem_department WHERE FIND_IN_SET(parent_Id,sTempChd)>0;
END WHILE;
RETURN sTemp;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for queryParentsMemDepartment
-- ----------------------------
DROP FUNCTION IF EXISTS `queryParentsMemDepartment`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `queryParentsMemDepartment`(areaId VARCHAR(120)) RETURNS varchar(4000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp='$';
SET sTempChd = CAST(areaId AS CHAR);
SET sTemp = CONCAT(sTemp,',',sTempChd);

SELECT parent_Id INTO sTempChd FROM mem_department WHERE id = sTempChd;
WHILE sTempChd <> 0 DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT parent_Id INTO sTempChd FROM mem_department WHERE id = sTempChd;
END WHILE;
RETURN sTemp;
END
;;
DELIMITER ;
