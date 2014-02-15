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
-- Table structure for table `eventmatch`
--

DROP TABLE IF EXISTS `eventmatch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventmatch` (
  `matchNumber` int(11) NOT NULL,
  `eventID` int(11) NOT NULL,
  `redOne` int(11) DEFAULT NULL,
  `redTwo` int(11) DEFAULT NULL,
  `redThree` int(11) DEFAULT NULL,
  `blueOne` int(11) DEFAULT NULL,
  `blueTwo` int(11) DEFAULT NULL,
  `blueThree` int(11) DEFAULT NULL,
  `redScore` int(11) DEFAULT NULL,
  `blueScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`matchNumber`,`eventID`),
  KEY `eventID_em_idx` (`eventID`),
  KEY `teamRedOne_em_idx` (`redOne`),
  KEY `teamRedTwo_em_idx` (`redTwo`),
  KEY `teamRedThree_em_idx` (`redThree`),
  KEY `teamBlueOne_em_idx` (`blueOne`),
  KEY `teamBlueTwo_em_idx` (`blueTwo`),
  KEY `teamBlueThree_em_idx` (`blueThree`),
  CONSTRAINT `eventID_em` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamBlueOne_em` FOREIGN KEY (`blueOne`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamBlueThree_em` FOREIGN KEY (`blueThree`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamBlueTwo_em` FOREIGN KEY (`blueTwo`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamRedOne_em` FOREIGN KEY (`redOne`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamRedThree_em` FOREIGN KEY (`redThree`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamRedTwo_em` FOREIGN KEY (`redTwo`) REFERENCES `team` (`teamnumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventmatch`
--

LOCK TABLES `eventmatch` WRITE;
/*!40000 ALTER TABLE `eventmatch` DISABLE KEYS */;
INSERT INTO `eventmatch` VALUES (12,1,1100,190,126,125,118,467,245,105);
/*!40000 ALTER TABLE `eventmatch` ENABLE KEYS */;
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
