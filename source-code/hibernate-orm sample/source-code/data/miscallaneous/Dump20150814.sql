-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: radio
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriptionId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,1,1,'2014-09-11 00:00:00','2014-09-30 00:00:00'),(2,1,2,'2015-05-12 00:00:00','2015-05-30 00:00:00'),(3,2,3,'2013-07-16 00:00:00','2013-07-30 00:00:00'),(4,3,4,'2014-09-05 00:00:00','2014-09-30 00:00:00'),(5,4,5,'2015-05-04 00:00:00','2015-05-30 00:00:00');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistes`
--

DROP TABLE IF EXISTS `artistes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artistes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(45) NOT NULL,
  `balance` decimal(64,0) DEFAULT NULL,
  `owedBalance` decimal(64,0) DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistes`
--

LOCK TABLES `artistes` WRITE;
/*!40000 ALTER TABLE `artistes` DISABLE KEYS */;
INSERT INTO `artistes` VALUES (1,'FETTY WAP',0,0,'2015-01-01 00:00:00'),(2,'OMARION',0,0,'2015-01-01 00:00:00'),(3,'RIHANNA',0,0,'2015-01-01 00:00:00'),(4,'J COLE',0,0,'2015-01-01 00:00:00'),(5,'BIG SEAN',0,0,'2015-01-01 00:00:00'),(6,'JIDENNA',0,0,'2015-01-01 00:00:00'),(7,'KID INK',0,0,'2015-01-01 00:00:00'),(8,'BOBBY SHMURDA ',0,0,'2015-01-01 00:00:00'),(9,'CHRIS BROWN',0,0,'2015-01-01 00:00:00'),(10,'DJ SNAKE',0,0,'2015-01-01 00:00:00'),(11,'NATALIE LA ROSE',0,0,'2015-01-01 00:00:00'),(12,'THE WEEKND',0,0,'2015-01-01 00:00:00'),(13,'WALE',0,0,'2015-01-01 00:00:00'),(14,'DAVID GUETTA',0,0,'2015-01-01 00:00:00'),(15,'NICKI MINAJ',0,0,'2015-01-01 00:00:00'),(16,'TREY SONGZ',0,0,'2015-01-01 00:00:00'),(17,'CHINX',0,0,'2015-01-01 00:00:00'),(18,'RICH HOMIE QUAN',0,0,'2015-01-01 00:00:00'),(19,'JEREMIH',0,0,'2015-01-01 00:00:00'),(20,'DEJ LOAF',0,0,'2015-01-01 00:00:00'),(21,'RICH GANG',0,0,'2015-01-01 00:00:00'),(22,'BOBY SHMURDA',0,0,'2015-01-01 00:00:00'),(23,'DJ KHALED',0,0,'2015-01-01 00:00:00'),(24,'DRAKE',0,0,'2015-01-01 00:00:00'),(25,'I LOVE MAKONNEN',0,0,'2015-01-01 00:00:00'),(26,'BEYONCE',0,0,'2015-01-01 00:00:00'),(27,'JHENE AIKO',0,0,'2015-01-01 00:00:00'),(28,'JAY Z',0,0,'2015-01-01 00:00:00'),(29,'TROY AVE',0,0,'2015-01-01 00:00:00'),(30,'YOUNG THUG',0,0,'2015-01-01 00:00:00'),(31,'TPAIN',0,0,'2015-01-01 00:00:00'),(32,'LLOYD BANKS',0,0,'2015-01-01 00:00:00'),(33,'LIL WAYNE',0,0,'2015-01-01 00:00:00'),(34,'YG',0,0,'2015-01-01 00:00:00'),(35,'Meet Sims',0,0,'2015-01-01 00:00:00'),(36,'Bebe Rexha',0,0,'2015-01-01 00:00:00'),(37,'Remy Boyz',0,0,'2015-01-01 00:00:00'),(38,'Usher',0,0,'2015-01-01 00:00:00'),(39,'TYGA',0,0,'2015-01-01 00:00:00'),(40,'Monty',0,0,'2015-01-01 00:00:00'),(41,'Rick Ross',0,0,'2015-01-01 00:00:00'),(42,'ALUNAGEORGE',0,0,'2015-01-01 00:00:00');
/*!40000 ALTER TABLE `artistes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `features`
--

DROP TABLE IF EXISTS `features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artisteId` int(11) NOT NULL,
  `subCount` int(11) DEFAULT NULL,
  `mainCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `features`
--

LOCK TABLES `features` WRITE;
/*!40000 ALTER TABLE `features` DISABLE KEYS */;
INSERT INTO `features` VALUES (1,9,2,4),(2,27,1,1),(3,24,3,1),(4,41,1,0),(5,20,1,1),(6,40,1,0),(7,19,1,1),(8,38,2,0),(9,37,1,0),(11,36,1,0),(14,35,1,0),(15,15,3,1),(16,30,1,1),(17,18,1,1),(18,39,1,0),(19,43,1,1),(22,33,1,0),(24,26,1,1),(25,32,1,0),(26,10,0,1),(27,11,0,1),(28,12,0,2),(29,13,0,1),(30,14,0,2),(31,16,0,2),(32,17,0,1),(33,21,0,2),(34,22,0,0),(35,23,0,2),(36,25,0,1),(37,28,0,0),(38,31,0,1),(39,34,0,0),(40,29,0,2),(41,42,0,1),(42,1,0,3),(43,2,0,2),(44,3,0,1),(45,4,0,1),(46,5,0,1),(47,6,0,1),(48,7,0,1),(49,8,0,1);
/*!40000 ALTER TABLE `features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,2,42,'Pure Vibes'),(2,2,43,'Pure Vibes'),(3,2,33,'Pure Vibes'),(4,2,31,'Pure Vibes'),(5,2,35,'Pure Vibes'),(6,4,20,'Morning Sunshine'),(7,4,21,'Morning Sunshine'),(8,4,22,'Morning Sunshine'),(9,4,23,'Morning Sunshine'),(10,4,24,'Morning Sunshine');
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `royalties`
--

DROP TABLE IF EXISTS `royalties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `royalties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songRate` decimal(64,2) NOT NULL,
  `featureRate` decimal(64,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `royalties`
--

LOCK TABLES `royalties` WRITE;
/*!40000 ALTER TABLE `royalties` DISABLE KEYS */;
INSERT INTO `royalties` VALUES (1,5.00,1.50);
/*!40000 ALTER TABLE `royalties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sharedplaylists`
--

DROP TABLE IF EXISTS `sharedplaylists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharedplaylists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourceUserId` int(11) NOT NULL,
  `targetUserId` int(11) NOT NULL,
  `playlistId` varchar(45) DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sharedplaylists`
--

LOCK TABLES `sharedplaylists` WRITE;
/*!40000 ALTER TABLE `sharedplaylists` DISABLE KEYS */;
INSERT INTO `sharedplaylists` VALUES (1,2,1,'1','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `sharedplaylists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artisteId` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,1,0,'Trap Queen'),(2,2,0,'Post To Be'),(4,3,0,'Bitch Better Have My Money'),(5,4,0,'Wet Dreamz'),(6,5,0,'Blessings'),(8,6,0,'Classic Man'),(9,7,0,'Be Real'),(10,8,0,'Hot Boy'),(11,9,0,'Ayo'),(12,10,0,'You Know You Like It'),(13,42,0,'You Know You Like It'),(14,11,0,'Somebody'),(15,12,0,'Earned It'),(16,13,0,'The Matrimony'),(18,14,0,'Hey Mama'),(20,15,0,'Truffle Butter'),(21,16,0,'Touchin Lovin'),(22,17,0,'On your body'),(23,18,0,'Flex (Ooh Ooh Ooh)'),(24,19,0,'Don\'t Tell \'Em'),(25,20,0,'Try Me'),(26,21,0,'Lifestyle'),(30,23,0,'Hold You Down'),(32,29,0,'All About The Money'),(33,24,0,'0 To 100/The Catch Up'),(34,25,0,'Tuesday'),(36,26,0,'DRUNK IN LOVE'),(38,27,0,'THE WORST'),(39,43,0,'PART II (ON THE RUN)'),(42,30,0,'STONER'),(43,31,0,'UP DOWN (DO THIS ALL DAY)');
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spins`
--

DROP TABLE IF EXISTS `spins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `songId` int(11) NOT NULL,
  `artisteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spins`
--

LOCK TABLES `spins` WRITE;
/*!40000 ALTER TABLE `spins` DISABLE KEYS */;
INSERT INTO `spins` VALUES (1,2,'2015-01-11 02:00:00',2,2),(2,2,'2015-01-11 02:05:00',4,3),(3,2,'2015-01-11 02:10:00',5,4),(4,2,'2015-01-11 02:12:00',6,5),(5,2,'2015-01-11 02:14:00',7,1),(6,2,'2015-01-15 15:30:00',8,6),(7,2,'2015-01-15 15:33:00',9,7),(8,1,'2015-01-12 10:09:00',18,14),(9,1,'2015-01-12 10:11:00',20,15),(10,1,'2015-01-12 10:13:00',21,16),(11,1,'2015-01-12 10:16:00',22,17),(12,1,'2015-01-12 10:20:00',23,18),(13,1,'2015-01-12 10:22:00',24,19),(14,1,'2015-01-15 07:00:00',21,16),(15,1,'2015-01-15 07:03:00',25,20),(16,1,'2015-01-15 07:06:00',19,21),(17,1,'2015-01-17 11:10:00',28,9),(18,1,'2015-01-17 11:11:00',10,8),(19,1,'2015-01-17 11:16:00',30,23),(20,1,'2015-01-17 11:18:00',31,12),(21,1,'2015-01-17 11:22:00',32,29),(22,1,'2015-01-17 11:25:00',33,24),(23,4,'2015-01-16 10:09:00',18,14),(24,4,'2015-01-16 10:11:00',20,15),(25,4,'2015-01-16 10:13:00',21,16),(26,3,'2015-01-17 09:53:00',2,2),(27,3,'2015-01-17 09:55:00',25,20),(28,3,'2015-01-17 10:09:00',18,14),(29,3,'2015-01-17 10:11:00',20,15),(30,3,'2015-01-17 10:13:00',21,16),(31,3,'2015-01-17 10:17:00',6,5),(32,3,'2015-01-17 10:21:00',7,1),(33,3,'2015-01-17 10:30:00',8,6),(34,3,'2015-01-17 10:33:00',9,7);
/*!40000 ALTER TABLE `spins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriptions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `maximumSpins` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,'free','20'),(2,'bronze','100'),(3,'silver','200'),(4,'gold','300');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `balance` decimal(64,0) DEFAULT NULL,
  `owedBalance` decimal(64,0) DEFAULT NULL,
  `joinDate` datetime NOT NULL,
  `accountId` int(11) NOT NULL,
  `playlistId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Gertrude','McKenzie','',0,0,'2014-09-11 00:00:00',1,1),(2,'Robert','Mathis','',0,0,'2015-05-12 00:00:00',1,2),(3,'Jake','Locker','',0,0,'2013-07-16 00:00:00',1,3),(4,'Nicole','Murphy','',0,0,'2014-09-05 00:00:00',1,4),(5,'Steven','Shaw','',0,0,'2015-05-04 00:00:00',1,5);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-14 10:47:16
