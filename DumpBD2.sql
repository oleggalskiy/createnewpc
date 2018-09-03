CREATE DATABASE  IF NOT EXISTS `mynewpcdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mynewpcdb`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: mynewpcdb
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu`
--

LOCK TABLES `cpu` WRITE;
/*!40000 ALTER TABLE `cpu` DISABLE KEYS */;
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
  `PC_ID_PC` bigint(20) NOT NULL,
  PRIMARY KEY (`CPU_ID_CPU`,`PC_ID_PC`),
  KEY `fk_CPU_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_CPU_has_PC_CPU1_idx` (`CPU_ID_CPU`),
  CONSTRAINT `fk_CPU_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu_has_pc`
--

LOCK TABLES `cpu_has_pc` WRITE;
/*!40000 ALTER TABLE `cpu_has_pc` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddr`
--

LOCK TABLES `ddr` WRITE;
/*!40000 ALTER TABLE `ddr` DISABLE KEYS */;
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
  `PC_ID_PC` bigint(20) NOT NULL,
  PRIMARY KEY (`DDR_ID_DDR`,`PC_ID_PC`),
  KEY `fk_DDR_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_DDR_has_PC_DDR1_idx` (`DDR_ID_DDR`),
  CONSTRAINT `fk_DDR_has_PC_DDR1` FOREIGN KEY (`DDR_ID_DDR`) REFERENCES `ddr` (`id_ddr`),
  CONSTRAINT `fk_DDR_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddr_has_pc`
--

LOCK TABLES `ddr_has_pc` WRITE;
/*!40000 ALTER TABLE `ddr_has_pc` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricator`
--

LOCK TABLES `fabricator` WRITE;
/*!40000 ALTER TABLE `fabricator` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mb`
--

LOCK TABLES `mb` WRITE;
/*!40000 ALTER TABLE `mb` DISABLE KEYS */;
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
  `PC_ID_PC` bigint(20) NOT NULL,
  PRIMARY KEY (`MB_ID_MB`,`PC_ID_PC`),
  KEY `fk_MB_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_MB_has_PC_MB1_idx` (`MB_ID_MB`),
  CONSTRAINT `fk_MB_has_PC_MB1` FOREIGN KEY (`MB_ID_MB`) REFERENCES `mb` (`id_mb`),
  CONSTRAINT `fk_MB_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mb_has_pc`
--

LOCK TABLES `mb_has_pc` WRITE;
/*!40000 ALTER TABLE `mb_has_pc` DISABLE KEYS */;
/*!40000 ALTER TABLE `mb_has_pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pc` (
  `ID_PC` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID_USER` bigint(20) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `active` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_PC`),
  KEY `fk_PC_USERS1_idx` (`USER_ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
INSERT INTO `pc` VALUES (1,1,'2018-05-01','true'),(2,1,'2018-05-01','true'),(3,2,'2018-05-01','true'),(4,1,'2018-03-10','true'),(5,1,'2018-03-10','true'),(6,2,'2018-05-19','true'),(7,1,'2018-05-19','true'),(8,2,'2018-05-19','true');
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_user` bigint(20) NOT NULL,
  `role` set('USER','ADMIN') NOT NULL,
  PRIMARY KEY (`idroles`),
  KEY `user_id_user` (`user_id_user`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_User_ID_USER` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'USER'),(2,1,'ADMIN'),(3,2,'USER'),(4,3,'USER'),(5,4,'USER'),(6,5,'USER'),(7,6,'USER'),(8,7,'USER'),(9,8,'USER'),(10,8,'ADMIN'),(11,9,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `ID_USER` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Malkom','3F2191DB18AA4446A83A119387A17BA0'),(2,'Garry','3F2191DB18AA4446A83A119387A17BA0'),(3,'Tessy','3F2191DB18AA4446A83A119387A17BA0'),(4,'Lock','3F2191DB18AA4446A83A119387A17BA0'),(5,'Red','3F2191DB18AA4446A83A119387A17BA0'),(6,'Green','3F2191DB18AA4446A83A119387A17BA0'),(7,'Garry','3F2191DB18AA4446A83A119387A17BA0'),(8,'Admin','3F2191DB18AA4446A83A119387A17BA0'),(9,'Ted','AD1F438BC309CAE626256A5C3A13443E');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
  `ID_USER_INFO` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `age` int(12) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `isactive` varchar(10) DEFAULT NULL,
  `USER_ID_USER` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_USER_INFO`,`USER_ID_USER`),
  KEY `fk_USER_INFO_USER1_idx` (`USER_ID_USER`),
  CONSTRAINT `fk_USER_INFO_ID_USER` FOREIGN KEY (`USER_ID_USER`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (2,'Oleg','Galskiy',30,'Minsk','qwerty@tut.by','true',1),(3,'Malkom','C.',20,'St.Emc 20, 86','redfreezomg@gmail.com','true',2),(4,'Malkom','C.',666,'Berlin','redfreezomg@gmail.com','true',3),(5,'Malkom','C.',666,'Berlin','redfreezomg@gmail.com','true',4),(6,'Malkom','C.',666,'Berlin','redfreezomg@gmail.com','true',5),(7,'Malkom','C.',666,'Berlin','redfreezomg@gmail.com','true',6),(8,'Malkom','C.',20,'Keln 20, 86','redfreezomg@gmail.com','true',7),(9,'Malkom','C.',30,'Minsk, Esenina 20, 86','qwerty@gmail.com','true',8),(10,'Ted','test',30,'','test@test.com','true',9);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vga`
--

LOCK TABLES `vga` WRITE;
/*!40000 ALTER TABLE `vga` DISABLE KEYS */;
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
  `PC_ID_PC` bigint(20) NOT NULL,
  PRIMARY KEY (`VGA_ID_VGA`,`PC_ID_PC`),
  KEY `fk_VGA_has_PC_PC1_idx` (`PC_ID_PC`),
  KEY `fk_VGA_has_PC_VGA1_idx` (`VGA_ID_VGA`),
  CONSTRAINT `fk_VGA_has_PC_PC1` FOREIGN KEY (`PC_ID_PC`) REFERENCES `pc` (`id_pc`),
  CONSTRAINT `fk_VGA_has_PC_VGA1` FOREIGN KEY (`VGA_ID_VGA`) REFERENCES `vga` (`id_vga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vga_has_pc`
--

LOCK TABLES `vga_has_pc` WRITE;
/*!40000 ALTER TABLE `vga_has_pc` DISABLE KEYS */;
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

-- Dump completed on 2018-09-03 17:36:43
