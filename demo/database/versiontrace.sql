-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: versiontrace
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `versiontrace`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `versiontrace` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `versiontrace`;

--
-- Table structure for table `apkversion_info`
--

DROP TABLE IF EXISTS `apkversion_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apkversion_info` (
  `id` varchar(32) NOT NULL COMMENT 'H5离线包版本号信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `type` int DEFAULT '0' COMMENT '0为安卓，1为苹果，默认为0',
  `version_num` varchar(45) DEFAULT NULL COMMENT '版本号',
  `build_mode` varchar(45) DEFAULT NULL COMMENT '命令模式',
  `branch` varchar(45) DEFAULT NULL COMMENT '版本分支',
  `if_upload_and_encrypt` tinyint DEFAULT NULL COMMENT '是否自动上传到加固平台并且加密',
  `encrypt_policy` int DEFAULT NULL COMMENT '加固策略，对应于恒泰加固平台的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apkversion_info`
--

LOCK TABLES `apkversion_info` WRITE;
/*!40000 ALTER TABLE `apkversion_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `apkversion_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h5version_info`
--

DROP TABLE IF EXISTS `h5version_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `h5version_info` (
  `id` varchar(32) NOT NULL COMMENT 'H5离线包版本号信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `type` int DEFAULT '0' COMMENT '0为安卓，1为苹果，默认为0',
  `version_num` varchar(45) DEFAULT NULL COMMENT '版本号',
  `amr_url` varchar(245) DEFAULT NULL,
  `h5json_url` varchar(245) DEFAULT NULL COMMENT 'h5_json地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h5version_info`
--

LOCK TABLES `h5version_info` WRITE;
/*!40000 ALTER TABLE `h5version_info` DISABLE KEYS */;
INSERT INTO `h5version_info` VALUES ('fcf64b9dcbd34ec989793fa712308f05','2020-05-26 09:30:54',NULL,NULL,NULL,0,'1.1.1.1','test','test');
/*!40000 ALTER TABLE `h5version_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log` (
  `username` varchar(45) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_log`
--

LOCK TABLES `login_log` WRITE;
/*!40000 ALTER TABLE `login_log` DISABLE KEYS */;
INSERT INTO `login_log` VALUES ('admin','192.168.71.221','2020-05-27 10:02:48'),('admin-19e0be05e3d14ecdbc968bfcbda667a7','0:0:0:0:0:0:0:1','2020-05-29 08:08:42'),('admin-1e82019a4f3448eabba70975bbefb7f2','192.168.71.221','2020-05-27 11:45:26'),('admin-4bb1fba04a6648faaa8e03bf0e59db48','0:0:0:0:0:0:0:1','2020-05-29 07:57:19'),('admin-78c4f18538de4c86a3a26f1ecaaa2718','0:0:0:0:0:0:0:1','2020-05-29 08:08:53'),('admin-ab5c62cd89f14196a8d8609750f459ab','0:0:0:0:0:0:0:1','2020-05-29 08:09:05'),('admin-f9275e99dc214bdd8a25ccd115c6246a','0:0:0:0:0:0:0:1','2020-06-01 02:06:43'),('admin2a0fd99ce3c345b9a68773920711fa9b','192.168.71.221','2020-05-27 10:18:29');
/*!40000 ALTER TABLE `login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(122) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','517714860@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-01 10:41:45
