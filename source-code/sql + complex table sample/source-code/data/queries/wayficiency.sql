-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: wayficiency
-- ------------------------------------------------------
-- Server version	5.6.25-log
create database wayficiency;

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
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `passengerSocialSecurityNumber` int(11) NOT NULL,
  `passengerFirstName` varchar(45) NOT NULL,
  `passengerLastName` varchar(45) NOT NULL,
  PRIMARY KEY (`passengerSocialSecurityNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1000001,'Chan','Salomon'),(1000002,'Celestine','Beyers2'),(1000003,'Dalia','Cassady'),(1000004,'Elisa','Goll'),(1000005,'Carter','Janz'),(1000006,'Leroy','Mannon'),(1000007,'Larhonda','Eakin'),(1000008,'Rod','Pereira2'),(1000009,'Dudley','Binford\n'),(1000010,'Jonna','Defrancisco'),(1000011,'Darlene','Dines'),(1000012,'Ami','Giroir'),(1000013,'Jeniffer','Varnell'),(1000014,'Dulcie','Mebane'),(1000015,'Kristofer','Sena'),(1000016,'Kirstie','Maberry\n'),(1000017,'Ileen','Bibb2'),(1000018,'Harry0','Randell'),(1000019,'Kermit','Pryor'),(1000020,'Luther','Hoda'),(1000021,'Iva','Calcagno'),(1000022,'Arica','Legrande'),(1000023,'Wade','Petrarca'),(1000024,'Kacy','Nunez');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `routeId` int(11) NOT NULL AUTO_INCREMENT,
  `routeName` varchar(45) NOT NULL,
  `routeLeaveTime` datetime NOT NULL,
  `routeArrivalTime` datetime NOT NULL,
  `traversalId` int(11) NOT NULL,
  PRIMARY KEY (`routeId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'MONB >>> KING','2015-07-21 04:00:00','2015-07-21 06:00:00',1),(2,'KING >>> MNTB','2015-07-21 06:30:00','2015-07-21 07:00:00',2),(3,'MNTB >>> OCHI','2015-07-21 08:00:00','2015-07-21 09:00:00',3),(4,'OCHI >>> BLRV','2015-07-21 09:00:00','2015-07-21 10:30:00',4),(5,'BLRV >>> NGRL','2015-07-21 12:00:00','2015-07-21 12:30:00',5),(6,'NGRL >>> MONB','2015-07-21 16:00:00','2015-07-21 16:30:00',6),(7,'KING >>> MNTB','2015-07-21 04:00:00','2015-07-21 04:30:00',7),(8,'MNTB >>> BLRV','2015-07-21 06:00:00','2015-07-21 08:00:00',8),(9,'BLRV >>> OCHI','2015-07-21 10:00:00','2015-07-21 11:00:00',9),(10,'OCHI >>> MONB','2015-07-21 13:30:00','2015-07-21 14:00:00',10),(11,'MONB >>> NGRL','2015-07-21 16:00:00','2015-07-21 16:30:00',11),(12,'NGRL >>> KING','2015-07-21 18:00:00','2015-07-21 20:00:00',12),(13,'NGRL >>> MONB','2015-07-21 06:00:00','2015-07-21 06:30:00',13),(14,'MONB >>> OCHI','2015-07-21 10:00:00','2015-07-21 11:00:00',14),(15,'OCHI >>> MNTB','2015-07-21 12:00:00','2015-07-21 12:30:00',15),(16,'MNTB >>> KING','2015-07-21 14:00:00','2015-07-21 14:30:00',16),(17,'KING >>> BLRV','2015-07-21 16:00:00','2015-07-21 17:00:00',17),(18,'BLRV >>> NGRL','2015-07-21 18:30:00','2015-07-21 19:30:00',18);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `stationId` int(11) NOT NULL AUTO_INCREMENT,
  `stationName` varchar(45) NOT NULL,
  `stationLocation` varchar(45) NOT NULL,
  PRIMARY KEY (`stationId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'KING','Kingston'),(2,'MNTB','Morant Bay'),(3,'OCHI','Ocho Rios'),(4,'MONB','Montego Bay'),(5,'NGRL','Negril'),(6,'BLRV','Black River');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `routeId` int(11) NOT NULL,
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `ticketId` int(11) NOT NULL AUTO_INCREMENT,
  `routeId` int(11) NOT NULL,
  `passengerSocialSecurityNumber` decimal(64,0) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`ticketId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (27,1,1000001,'2015-01-10 00:00:00'),(28,18,1000002,'2015-08-22 00:00:00'),(29,14,1000003,'2015-07-17 00:00:00'),(30,1,1000004,'2015-01-10 00:00:00'),(31,18,1000005,'2015-08-22 00:00:00'),(32,14,1000006,'2015-07-17 00:00:00'),(33,1,1000007,'2015-01-10 00:00:00'),(34,18,1000008,'2015-08-22 00:00:00'),(35,14,1000009,'2015-07-17 00:00:00'),(36,1,1000010,'2015-01-10 00:00:00'),(37,18,1000011,'2015-08-22 00:00:00'),(38,14,1000012,'2015-07-17 00:00:00'),(39,1,1000013,'2015-01-10 00:00:00'),(41,14,1000015,'2015-07-17 00:00:00'),(42,1,1000016,'2015-01-10 00:00:00'),(43,18,1000017,'2015-08-22 00:00:00'),(44,14,1000018,'2015-07-17 00:00:00'),(45,1,1000019,'2015-01-10 00:00:00'),(46,18,1000020,'2015-08-22 00:00:00'),(47,14,1000021,'2015-07-17 00:00:00'),(48,1,1000022,'2015-01-10 00:00:00'),(49,18,1000023,'2015-08-22 00:00:00'),(50,14,1000024,'2015-07-17 00:00:00'),(53,15,1000024,'2015-07-17 00:00:00'),(54,14,1000021,'2015-07-17 00:00:00');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `trainId` int(11) NOT NULL AUTO_INCREMENT,
  `trainCapacity` int(11) NOT NULL,
  `trainName` varchar(45) NOT NULL,
  PRIMARY KEY (`trainId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,100,'train1'),(2,75,'train2'),(3,200,'train3');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traversal`
--

DROP TABLE IF EXISTS `traversal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traversal` (
  `traversalId` int(11) NOT NULL AUTO_INCREMENT,
  `stationId0` int(11) NOT NULL,
  `stationId1` int(11) NOT NULL,
  `traversalCost` decimal(64,0) NOT NULL,
  `trainId` int(11) NOT NULL,
  PRIMARY KEY (`traversalId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traversal`
--

LOCK TABLES `traversal` WRITE;
/*!40000 ALTER TABLE `traversal` DISABLE KEYS */;
INSERT INTO `traversal` VALUES (1,4,1,300,1),(2,1,2,50,1),(3,2,3,100,1),(4,3,6,100,1),(5,6,5,50,1),(6,5,4,50,1),(7,1,2,50,2),(8,2,6,300,2),(9,6,3,100,2),(10,3,4,50,2),(11,4,5,50,2),(12,5,1,300,2),(13,5,4,50,3),(14,4,3,100,3),(15,3,2,50,3),(16,2,1,50,3),(17,4,3,100,3),(18,6,5,50,3);
/*!40000 ALTER TABLE `traversal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-21 16:17:48
