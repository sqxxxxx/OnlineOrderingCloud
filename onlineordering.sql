CREATE DATABASE  IF NOT EXISTS `onlineordering` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `onlineordering`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: onlineordering
-- ------------------------------------------------------
-- Server version	5.5.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin1','123123',1),(2,'zhangsan','Zhangsan123',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `comment` text,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `c-u_idx` (`uid`),
  CONSTRAINT `u_i_u_c` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,2,1,'难吃',1),(2,2,3,1,'还行',1),(3,1,4,3,'不错',1),(4,1,5,4,'超级棒',1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ufeedback` text,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `f-u_idx` (`uid`),
  CONSTRAINT `u_i_f_u` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,'加强员工素质管理','111@qq.com','加强员工素质管理',1),(2,1,'加强酒店自身管理','111@qq.com','加强酒店自身管理',1),(3,1,'对菜品改进的建议','111@qq.com','改进菜品',1),(4,1,'对系统的建议','111@qq.com','对系统的建议',1),(5,1,'对包装的建议','111@qq.com','对包装的建议',1);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor` varchar(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '1' COMMENT '1未删除,0删除',
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (2,'青椒炒肉',12,'五香',1,1),(3,'栗子三杯鸡',56,'五香',1,1),(4,'毛血旺',50,'麻辣',1,1),(5,'菠菜拌粉丝',22,'五香',2,1),(6,'凉拌豆腐皮',19,'微辣',2,1),(7,'酱牛肉',36,'麻辣',2,1),(8,'鱼头豆腐汤',32,'五香',3,1),(9,'瘦肉鸡蛋白菜汤',30,'五香',3,1),(10,'西葫芦虾仁蒸饺',26,'五香',4,1),(11,'蛋炒饭',18,'五香',4,0),(31,'麻婆豆腐',26,'麻辣',1,1),(32,'青椒炒蛋',14,'烧烤',4,0),(33,'asfd',123,'asdf',4,0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `oid` bigint(20) DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `o-p_idx` (`oid`),
  KEY `u_i_o_u_idx` (`uid`),
  CONSTRAINT `o-p` FOREIGN KEY (`oid`) REFERENCES `orderinfo` (`orderid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `u_i_o_u` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (19,1,2021100912365075171,6,1,19),(20,1,2021100912365075171,7,2,72),(21,1,2021100912365075171,9,2,60),(22,1,2021100912365075171,10,1,26),(23,1,2021100913215861405,5,2,44),(24,1,2021100913215861405,6,2,38),(25,1,2021100913215861405,7,2,72),(26,1,2021100913215861405,9,2,60),(27,2,2021100916255846651,5,2,44),(28,2,2021100916255846651,6,2,38),(29,2,2021100916255846651,7,1,36),(30,2,2021100916255846651,8,1,32),(31,1,2021100916272715437,8,1,32),(32,1,2021100910121464060,11,3,54),(33,1,2021101210075121846,3,2,112),(34,1,2021101210075121846,5,2,44),(35,1,2021101210075121846,7,2,72),(36,1,2021101210075121846,9,2,60),(37,1,2021101211275067441,7,2,72),(38,1,2021101211275067441,8,2,64),(39,1,2021101211275067441,10,2,52),(40,1,2021101211275067441,11,1,18),(43,1,1453651182919749632,2,1,12),(44,1,1453651182919749632,6,1,19),(45,1,1453651182919749632,8,1,32),(46,1,1453651182919749632,9,1,30),(47,1,1453651182919749632,11,1,18),(48,1,1453651182919749632,10,1,26),(49,1,1455141491902124032,3,1,56),(50,1,1455141491902124032,4,2,100),(51,1,1455141491902124032,7,1,36),(52,1,1455141491902124032,9,1,30),(53,1,1455141491902124032,31,1,26),(54,1,1457626732017356800,4,1,50),(55,1,1457626732017356800,6,1,19),(56,1,1457626732017356800,8,1,32),(57,1,1457626732017356800,10,1,26),(58,1,1457626732017356800,7,1,36),(59,1,1457627101753643008,4,1,50),(60,1,1457627101753643008,6,1,19),(61,1,1457627101753643008,8,1,32),(62,1,1457627101753643008,10,1,26),(63,1,1457627219043160064,6,1,19),(64,1,1457627219043160064,8,1,32),(65,1,1457627219043160064,10,1,26),(66,1,1457627534345768960,6,1,19),(67,1,1457627534345768960,7,1,36),(68,1,1457627534345768960,9,1,30),(69,1,1457627534345768960,10,1,26),(70,1,1457627788696752128,6,1,19),(71,1,1457627788696752128,8,1,32);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `orderid` bigint(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `comments` text,
  `state` int(11) DEFAULT '0' COMMENT '0未配送，1已配送',
  `delstate` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `p-o_idx` (`orderid`),
  KEY `p-u_idx` (`uid`),
  CONSTRAINT `p-u` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES (6,1,2021100912365075171,6,177,'2021-10-09 12:36:50',NULL,NULL,1,1),(7,1,2021100913215861405,8,214,'2021-10-09 13:21:58',NULL,NULL,0,1),(8,2,2021100916255846651,6,150,'2021-10-09 16:25:58',NULL,NULL,0,1),(9,1,2021100916272715437,1,32,'2021-10-09 16:27:27',NULL,NULL,0,1),(10,1,2021100910121464060,3,54,'2021-10-09 18:12:14',NULL,NULL,0,1),(11,1,2021101210075121846,8,288,'2021-10-12 18:07:51',NULL,NULL,0,1),(12,1,2021101211275067441,7,206,'2021-10-12 19:27:50',3,'一般',0,1),(14,1,1453651182919749632,6,137,'2021-10-28 17:13:44',NULL,NULL,0,1),(15,1,1455141491902124032,6,248,'2021-11-01 19:55:41',2,'sad',0,1),(16,1,1457626732017356800,5,163,'2021-11-08 16:31:08',NULL,NULL,0,1),(17,1,1457627101753643008,4,127,'2021-11-08 16:32:37',NULL,NULL,0,1),(18,1,1457627219043160064,3,77,'2021-11-08 16:33:05',NULL,NULL,0,1),(19,1,1457627534345768960,4,111,'2021-11-08 16:34:20',NULL,NULL,1,1),(20,1,1457627788696752128,2,51,'2021-11-08 16:35:20',NULL,NULL,1,1);
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'热菜'),(2,'凉菜'),(3,'汤羹'),(4,'主食'),(5,'烘焙');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `registerdate` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zhangsan','Zhangsan123','李四','男','13576765678','2019-02-03 00:00:00','海南科技路',1),(2,'lisi','123123','李四','女','18678987676','2019-02-03 00:00:00','科技路',1),(10,'admin','123456','admin','男','15073941161','2020-02-02 00:00:00','水东江镇',1),(11,'asd','ads','asd','男','18612341234','2021-09-18 00:00:00','海南省',1),(13,'123456','123456','123456','男','18612341234','2021-09-18 00:00:00','海南省',1),(19,'张三','1','赵六','男','18612345678','2021-09-24 00:00:00','科技路',1),(20,'xiaohong','Xh123456','小红','女','18306974586','2021-11-08 16:23:00','海南省',1),(21,'lisiguang','Lisiguang123','李四光','男','18302349358','2021-11-08 17:02:03','海南省',1);
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

-- Dump completed on 2021-11-09 10:01:27
