CREATE DATABASE  IF NOT EXISTS `proyecto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyecto`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `facturaespecial`
--

DROP TABLE IF EXISTS `facturaespecial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturaespecial` (
  `idFactEspecial` int(10) NOT NULL,
  `Subtotal` int(10) NOT NULL,
  `Total` int(10) NOT NULL,
  `Fec_Fac` varchar(30) NOT NULL,
  `Cliente_Cod_cli` varchar(30) NOT NULL,
  `formadepago` varchar(50) NOT NULL,
  PRIMARY KEY (`idFactEspecial`),
  KEY `FKFacturaEsp322260` (`Cliente_Cod_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturaespecial`
--

LOCK TABLES `facturaespecial` WRITE;
/*!40000 ALTER TABLE `facturaespecial` DISABLE KEYS */;
INSERT INTO `facturaespecial` VALUES (1,600,600,'20/04/2017','CC0001','Contado'),(2,1200,1200,'20/04/2017','CC0001','Contado'),(3,4100,4100,'20/04/2017','CC0001','8 Cuotas'),(4,3500,3500,'20/04/2017','CC0001','7 Cuotas'),(5,3500,3500,'21/04/2017','CC0001','2'),(6,3500,3500,'21/04/2017','CC0001','Contado');
/*!40000 ALTER TABLE `facturaespecial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-21  2:14:00
