CREATE DATABASE  IF NOT EXISTS `scouting2014` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `scouting2014`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: scouting2014
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `teameventmatch`
--

DROP TABLE IF EXISTS `teameventmatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teameventmatch` (
  `matchNumber` int(11) NOT NULL,
  `eventID` int(11) NOT NULL,
  `teamNumber` int(11) NOT NULL,
  `assists` int(11) DEFAULT NULL,
  `autoBallHigh` bit(1) DEFAULT NULL,
  `autoBallLow` bit(1) DEFAULT NULL,
  `ballShielding` varchar(200) DEFAULT NULL,
  `canCatch` bit(1) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `cycles` int(11) DEFAULT NULL,
  `defensive` int(11) DEFAULT NULL,
  `highGoalsAttempted` int(11) DEFAULT NULL,
  `highGoalsScored` int(11) DEFAULT NULL,
  `lowGoalsAttempted` int(11) DEFAULT NULL,
  `lowGoalsScored` int(11) DEFAULT NULL,
  `passes` int(11) DEFAULT NULL,
  `preloadBall` bit(1) DEFAULT NULL,
  `regularFouls` int(11) DEFAULT NULL,
  `scouter` varchar(45) DEFAULT NULL,
  `stability` varchar(200) DEFAULT NULL,
  `startingPosition` int(11) DEFAULT NULL,
  `techFouls` int(11) DEFAULT NULL,
  `trussCatch` bit(1) DEFAULT NULL,
  `trussThrow` bit(1) DEFAULT NULL,
  `unableToUnloadAutoBall` bit(1) DEFAULT NULL,
  `zoneChange` bit(1) DEFAULT NULL,
  PRIMARY KEY (`matchNumber`,`eventID`,`teamNumber`),
  KEY `eventID_idx` (`eventID`),
  KEY `teamNumber_idx` (`teamNumber`),
  CONSTRAINT `eventID_tem` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamNumber_tem` FOREIGN KEY (`teamNumber`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teameventmatch`
--

LOCK TABLES `teameventmatch` WRITE;
/*!40000 ALTER TABLE `teameventmatch` DISABLE KEYS */;
INSERT INTO `teameventmatch` VALUES (1,1,1100,0,'\0','\0','','\0','',0,1,0,0,0,0,0,'\0',0,'','',0,NULL,'\0','\0','\0','\0'),(21,1,190,0,'\0','\0','','\0','',0,1,0,0,0,0,0,'\0',0,'Ed','',0,NULL,'\0','\0','\0','\0');
/*!40000 ALTER TABLE `teameventmatch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-15 12:17:07
