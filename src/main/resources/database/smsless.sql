-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: smsless
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `position` varchar(100) NOT NULL COMMENT '职位',
  `contact` varchar(20) NOT NULL COMMENT '联系方式',
  `location_id` int NOT NULL COMMENT '所属地点ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'张伟','店长','13800138001',1),(2,'王芳','收银主管','13900139001',1),(3,'李勇','理货员','13700137001',1),(4,'赵敏','生鲜专员','13600136001',1),(5,'刘洋','店长','13500135001',2),(6,'陈晓','收银员','13400134001',2),(7,'周杰','理货员','13300133001',2),(8,'吴婷','店长','13200132001',3),(9,'郑浩','收银员','13100131001',3),(10,'孙强','仓储主管','13000130001',4),(11,'钱明','叉车司机','12900129001',4),(12,'冯丽','库存管理员','12800128001',4),(13,'朱琳','冷链专员','12700127001',5),(14,'秦峰','装卸工','12600126001',5),(15,'何静','质检员','12500125001',5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `product_id` int NOT NULL COMMENT '商品ID',
  `location_id` int NOT NULL COMMENT '地点ID',
  `quantity` int NOT NULL DEFAULT '0' COMMENT '库存数量',
  PRIMARY KEY (`product_id`,`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,1,120),(1,2,80),(1,3,100),(1,4,500),(2,1,80),(2,2,50),(2,3,70),(2,4,300),(3,1,60),(3,2,40),(3,4,200),(4,1,200),(4,2,150),(4,3,180),(4,4,800),(5,1,150),(5,2,100),(5,3,120),(5,4,400),(5,5,600),(6,1,100),(6,3,80),(6,4,300),(6,5,400),(7,1,90),(7,2,60),(7,4,250),(8,1,70),(8,2,40),(8,3,60),(8,4,200);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` enum('store','warehouse') NOT NULL COMMENT '类型',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `address` varchar(200) NOT NULL COMMENT '地址',
  `total_capacity` decimal(10,2) NOT NULL COMMENT '总容量(立方米)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'store','中心旗舰店','市中心人民路88号',500.00),(2,'store','西城分店','西城区解放路42号',300.00),(3,'store','东湖分店','东湖区滨湖大道156号',400.00),(4,'warehouse','中央配送中心','高新开发区科技园8号',2000.00),(5,'warehouse','冷链仓库','北郊物流园B区3栋',1500.00);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `volume` decimal(10,2) NOT NULL COMMENT '单个体积(立方米)',
  `cost_price` decimal(10,2) NOT NULL COMMENT '成本价',
  `sale_price` decimal(10,2) NOT NULL COMMENT '销售价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'金龙鱼食用油5L',0.01,60.00,75.00),(2,'伊利纯牛奶250ml*24',0.04,65.00,80.00),(3,'五常大米10kg',0.07,85.00,110.00),(4,'可口可乐330ml*24',0.03,40.00,55.00),(5,'冷冻牛排200g',0.01,25.00,38.00),(6,'新鲜草莓500g',0.00,18.00,29.90),(7,'海天酱油1.9L',0.01,22.00,32.00),(8,'维达抽纸24包',0.06,90.00,120.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_id` int NOT NULL COMMENT '销售门店ID',
  `product_id` int NOT NULL COMMENT '商品ID',
  `quantity` int NOT NULL COMMENT '销售数量',
  `sale_time` datetime NOT NULL COMMENT '销售时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,1,1,15,'2025-05-20 09:30:00'),(2,1,2,8,'2025-05-20 10:15:00'),(3,1,5,12,'2025-05-20 11:20:00'),(4,1,6,20,'2025-05-20 12:45:00'),(5,2,3,5,'2025-05-20 10:05:00'),(6,2,4,18,'2025-05-20 14:30:00'),(7,2,8,6,'2025-05-20 16:20:00'),(8,3,1,10,'2025-05-20 09:45:00'),(9,3,4,15,'2025-05-20 13:15:00'),(10,3,5,8,'2025-05-20 17:30:00'),(11,3,6,15,'2025-05-20 18:20:00'),(12,1,7,10,'2025-05-20 19:05:00'),(13,1,2,5,'2025-05-19 10:30:00'),(14,2,1,7,'2025-05-19 11:20:00'),(15,3,3,4,'2025-05-19 15:40:00'),(16,1,3,6,'2025-05-15 14:20:00'),(17,2,5,9,'2025-05-14 12:30:00'),(18,3,8,4,'2025-05-13 17:50:00');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码（存储加密后的值）',
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
  `user_type` enum('admin','normal') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT 'normal' COMMENT '用户类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123456','123456@qq.com','admin'),(2,'lxy','123456','123456@qq.com','normal'),(5,'张三','01d7f40760960e7bd9443513f22ab9af','zhangsan@qq.com','normal'),(6,'李四','dc3a8f1670d65bea69b7b65048a0ac40','lisi@qq.com','normal');
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

-- Dump completed on 2025-06-18 13:54:14
