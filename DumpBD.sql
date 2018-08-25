-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: mypcdb
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cpu`
--

DROP TABLE IF EXISTS `cpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cpu` (
  `ID_CPU` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) DEFAULT NULL,
  `Socket` varchar(12) DEFAULT NULL,
  `Core` varchar(12) DEFAULT NULL,
  `Number_cores` int(12) DEFAULT NULL,
  `Process_tech_nm` int(12) DEFAULT NULL,
  `Frequency_MGz` int(12) DEFAULT NULL,
  `System_bus` varchar(12) DEFAULT NULL,
  `Fabricator_ID_Fab` int(11) NOT NULL,
  PRIMARY KEY (`ID_CPU`),
  KEY `fk_CPU_Fabricator_idx` (`Fabricator_ID_Fab`),
  CONSTRAINT `fk_CPU_Fabricator` FOREIGN KEY (`Fabricator_ID_Fab`) REFERENCES `fabricator` (`id_fab`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu`
--

LOCK TABLES `cpu` WRITE;
/*!40000 ALTER TABLE `cpu` DISABLE KEYS */;
INSERT INTO `cpu` VALUES (2,'FX-6300','AM3+','Vishera',6,32,3500,'HT',3),(3,'FX-8320','AM3+','Vishera',8,32,3500,'HT',3),(4,'Core i5','LGA1150','Haswell',4,22,3200,'DMI',4),(5,'Core i3-8100','LGA1151','Coffee Lake',4,14,3600,'DMI',4);
/*!40000 ALTER TABLE `cpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpu_has_pc`
--

DROP TABLE IF EXISTS `cpu_has_pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cpu_has_pc` (
  `CPU_ID_CPU` int(11) NOT NULL,
  `PC_ID_PC` int(11) NOT NULL,
  PRIMARY KEY (`CPU_ID_CPU`,`PC_ID_PC`),
  KEY `fk_CPU_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_CPU_has_PC_CPU1_idx` (`CPU_ID_CPU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu_has_pc`
--

LOCK TABLES `cpu_has_pc` WRITE;
/*!40000 ALTER TABLE `cpu_has_pc` DISABLE KEYS */;
INSERT INTO `cpu_has_pc` VALUES (2,1),(2,2),(3,3),(4,4),(2,5),(2,6),(3,7),(4,8),(2,9),(2,10),(3,11),(4,12),(3,13);
/*!40000 ALTER TABLE `cpu_has_pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddr`
--

DROP TABLE IF EXISTS `ddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ddr` (
  `ID_DDR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) DEFAULT NULL,
  `DDR_type` varchar(12) DEFAULT NULL,
  `Form` varchar(12) DEFAULT NULL,
  `Frequency_MGz` int(12) DEFAULT NULL,
  `Size_Gb` int(12) DEFAULT NULL,
  `Fabricator_ID_Fab` int(11) NOT NULL,
  PRIMARY KEY (`ID_DDR`),
  KEY `fk_DDR_Fabricator1_idx` (`Fabricator_ID_Fab`),
  CONSTRAINT `fk_DDR_Fabricator1` FOREIGN KEY (`Fabricator_ID_Fab`) REFERENCES `fabricator` (`id_fab`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddr`
--

LOCK TABLES `ddr` WRITE;
/*!40000 ALTER TABLE `ddr` DISABLE KEYS */;
INSERT INTO `ddr` VALUES (1,'Kingston HX316C10F*/8','DDR3','DIMM',1600,8,6),(2,'Hynix DDR3','DDR3','DIMM',1600,4,7),(3,'Crusial BLT8G3D1869DT1TX0CEU','DD3','DIMM',1866,8,8);
/*!40000 ALTER TABLE `ddr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddr_has_pc`
--

DROP TABLE IF EXISTS `ddr_has_pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ddr_has_pc` (
  `DDR_ID_DDR` int(11) NOT NULL,
  `PC_ID_PC` int(11) NOT NULL,
  PRIMARY KEY (`DDR_ID_DDR`,`PC_ID_PC`),
  KEY `fk_DDR_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_DDR_has_PC_DDR1_idx` (`DDR_ID_DDR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddr_has_pc`
--

LOCK TABLES `ddr_has_pc` WRITE;
/*!40000 ALTER TABLE `ddr_has_pc` DISABLE KEYS */;
INSERT INTO `ddr_has_pc` VALUES (1,1),(1,2),(2,3),(3,4),(1,5),(2,6),(3,7),(3,8),(2,9),(2,10),(2,11),(1,12),(3,13);
/*!40000 ALTER TABLE `ddr_has_pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricator`
--

DROP TABLE IF EXISTS `fabricator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fabricator` (
  `ID_Fab` int(11) NOT NULL AUTO_INCREMENT,
  `Name_Fab` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Fab`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricator`
--

LOCK TABLES `fabricator` WRITE;
/*!40000 ALTER TABLE `fabricator` DISABLE KEYS */;
INSERT INTO `fabricator` VALUES (1,'Gigabyte'),(2,'ASUS'),(3,'AMD'),(4,'Intel'),(5,'Sapphire'),(6,'Kingston'),(7,'Hunix'),(8,'Crusial');
/*!40000 ALTER TABLE `fabricator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mb`
--

DROP TABLE IF EXISTS `mb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mb` (
  `ID_MB` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `CPU_socket` varchar(12) DEFAULT NULL,
  `chipset` varchar(12) DEFAULT NULL,
  `memory_type` varchar(45) DEFAULT NULL,
  `memory_stots` int(12) DEFAULT NULL,
  `memory_max_Gb` int(12) DEFAULT NULL,
  `VGA_sup` varchar(12) DEFAULT NULL,
  `Fabricator_ID_Fab` int(11) NOT NULL,
  PRIMARY KEY (`ID_MB`),
  KEY `fk_MB_Fabricator1_idx` (`Fabricator_ID_Fab`),
  CONSTRAINT `fk_MB_Fabricator1` FOREIGN KEY (`Fabricator_ID_Fab`) REFERENCES `fabricator` (`id_fab`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mb`
--

LOCK TABLES `mb` WRITE;
/*!40000 ALTER TABLE `mb` DISABLE KEYS */;
INSERT INTO `mb` VALUES (1,'GA-970A-DS3P','AM3, AM3+','AMD 970','DDR3 DIMM',4,32,'PCI-E 16x',1),(2,'M5A97 R2.0','AM3+','AMD 970','DDR3 DIMM',4,32,'PCI-E 16x',2),(3,'M5A78L-M LE','AM3+','AMD 760G','DDR3 DIMM',4,32,'PCI-E 16x',2);
/*!40000 ALTER TABLE `mb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mb_has_pc`
--

DROP TABLE IF EXISTS `mb_has_pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mb_has_pc` (
  `MB_ID_MB` int(11) NOT NULL,
  `PC_ID_PC` int(11) NOT NULL,
  PRIMARY KEY (`MB_ID_MB`,`PC_ID_PC`),
  KEY `fk_MB_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_MB_has_PC_MB1_idx` (`MB_ID_MB`),
  CONSTRAINT `fk_MB_has_PC_MB1` FOREIGN KEY (`MB_ID_MB`) REFERENCES `mb` (`id_mb`),
  CONSTRAINT `fk_MB_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mb_has_pc`
--

LOCK TABLES `mb_has_pc` WRITE;
/*!40000 ALTER TABLE `mb_has_pc` DISABLE KEYS */;
INSERT INTO `mb_has_pc` VALUES (1,1),(2,2),(2,3),(3,4),(1,5),(3,6),(1,7),(2,8),(3,9),(3,10);
/*!40000 ALTER TABLE `mb_has_pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pc` (
  `ID_PC` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_ID_USERS` int(11) NOT NULL,
  `Create_Date` date DEFAULT NULL,
  `Is_Active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_PC`),
  KEY `fk_PC_USERS1_idx` (`USERS_ID_USERS`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
INSERT INTO `pc` VALUES (1,1,'2018-05-03',''),(2,1,'2018-05-01',''),(3,1,'2018-05-27',''),(4,1,'2018-05-06',''),(5,1,'2018-02-03',''),(6,1,'2018-03-10',''),(7,1,'2018-05-17',''),(8,1,'2018-05-10',''),(9,1,'2018-05-01',''),(10,1,'2018-05-19','');
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
  `ID_USER_INFO` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `isActive` varchar(45) DEFAULT NULL,
  `USERS_ID_USERS` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER_INFO`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'Oleg','Galskiy','30',NULL,'qwerty@tut.by','true',1),(2,'Ksusha','Prokopchik','25','Minsk','ksu@mail.ru','true',2),(6,'Zedd','Zeddikus','300','asdas','23421@tut.by','true',19),(7,'OLeg','Gal','30','Minsk','qwerty@tut.by','true',20),(8,'Old','Name','56','qwer','xxx@gmail.com','true',21),(9,'xxx','xxx','60','xxx','xxx@gmail.com','true',24),(10,'asd','asd','19','asd','1231@as','false',25),(11,'Red','Falkon','12','Minsk','red@red.by','true',26),(12,'Fedor','Sumkin','54','Shirr','bighobbit@shirr.me','true',27),(13,'Zed','ccc','12','asd','ter@ter.by','true',28);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id_user` int(11) NOT NULL,
  `role` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'USER'),(1,'ADMIN');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `ID_USERS` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_USERS`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Malkom','qwerty'),(2,'Ksu_ksu_smail','1234'),(19,'Kell','kell11'),(20,'ffrreezz','qwe'),(21,'Gen','ttt'),(24,'xxx','xxx'),(25,'asd','asd'),(26,'OGG','ogg'),(27,'Fedia','tut'),(28,'Zed','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vga`
--

DROP TABLE IF EXISTS `vga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vga` (
  `ID_VGA` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) DEFAULT NULL,
  `Graph_proc` varchar(20) DEFAULT NULL,
  `Frenq_proc_MGz` int(12) DEFAULT NULL,
  `Interface` varchar(12) DEFAULT NULL,
  `VRAM_Mb` int(12) DEFAULT NULL,
  `Type_VRAM` varchar(12) DEFAULT NULL,
  `Shaders` varchar(10) DEFAULT NULL,
  `Fabricator_ID_Fab` int(11) NOT NULL,
  PRIMARY KEY (`ID_VGA`),
  KEY `fk_VGA_Fabricator1_idx` (`Fabricator_ID_Fab`),
  CONSTRAINT `fk_VGA_Fabricator1` FOREIGN KEY (`Fabricator_ID_Fab`) REFERENCES `fabricator` (`id_fab`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vga`
--

LOCK TABLES `vga` WRITE;
/*!40000 ALTER TABLE `vga` DISABLE KEYS */;
INSERT INTO `vga` VALUES (1,'Pulse','AMD Radeon RX 550',1432,'3.0',2024,'GDDR5','5.0',5),(2,'NVIDIA GeForce GTX 1060','GeForce GTX 1060',1632,'3.0',6144,'GDDR5','5.0',1);
/*!40000 ALTER TABLE `vga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vga_has_pc`
--

DROP TABLE IF EXISTS `vga_has_pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vga_has_pc` (
  `VGA_ID_VGA` int(11) NOT NULL,
  `PC_ID_PC` int(11) NOT NULL,
  PRIMARY KEY (`VGA_ID_VGA`,`PC_ID_PC`),
  KEY `fk_VGA_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_VGA_has_PC_VGA1_idx` (`VGA_ID_VGA`),
  CONSTRAINT `fk_VGA_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vga_has_pc`
--

LOCK TABLES `vga_has_pc` WRITE;
/*!40000 ALTER TABLE `vga_has_pc` DISABLE KEYS */;
INSERT INTO `vga_has_pc` VALUES (1,1),(1,2),(2,3),(1,4),(2,5),(2,6),(1,7),(1,8),(2,9),(1,10);
/*!40000 ALTER TABLE `vga_has_pc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-25  8:17:13
