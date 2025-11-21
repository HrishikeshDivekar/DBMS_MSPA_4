-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: dbms
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums` (
  `albumid` int NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artistid` int DEFAULT NULL,
  PRIMARY KEY (`albumid`),
  KEY `artistid` (`artistid`),
  CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`artistid`) REFERENCES `artists` (`artistid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
INSERT INTO `albums` VALUES (21,'Kaemon Ache','2022-12-02','Party',12),(23,'Captain Jack','2025-02-11','Distrack',20),(31,'Mo','2025-01-01','Distrack',12),(45,'Dance_withMJ','2025-02-21','Part',12);
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artists`
--

DROP TABLE IF EXISTS `artists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artists` (
  `artistid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `isSolo` int DEFAULT '1',
  PRIMARY KEY (`artistid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artists`
--

LOCK TABLES `artists` WRITE;
/*!40000 ALTER TABLE `artists` DISABLE KEYS */;
INSERT INTO `artists` VALUES (12,'Mandar',1),(18,'Hrishikesh',1),(20,'Bhavesh Doifode',1);
/*!40000 ALTER TABLE `artists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `eventid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `organizer` varchar(150) DEFAULT NULL,
  `artistid` int DEFAULT NULL,
  PRIMARY KEY (`eventid`),
  KEY `artistid` (`artistid`),
  CONSTRAINT `events_ibfk_1` FOREIGN KEY (`artistid`) REFERENCES `artists` (`artistid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (41,'Night_With_Mandar','2025-03-21','Bhavesh_Doifide',12);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `royalties`
--

DROP TABLE IF EXISTS `royalties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `royalties` (
  `royaltyid` int NOT NULL,
  `trackid` int DEFAULT NULL,
  `eventid` int DEFAULT NULL,
  `salesamount` decimal(12,2) DEFAULT NULL,
  `streamcount` int DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`royaltyid`),
  KEY `trackid` (`trackid`),
  KEY `eventid` (`eventid`),
  CONSTRAINT `royalties_ibfk_1` FOREIGN KEY (`trackid`) REFERENCES `tracks` (`trackid`),
  CONSTRAINT `royalties_ibfk_2` FOREIGN KEY (`eventid`) REFERENCES `events` (`eventid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `royalties`
--

LOCK TABLES `royalties` WRITE;
/*!40000 ALTER TABLE `royalties` DISABLE KEYS */;
/*!40000 ALTER TABLE `royalties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracks` (
  `trackid` int NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `durationSeconds` int DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `albumid` int DEFAULT NULL,
  `artistid` int DEFAULT NULL,
  PRIMARY KEY (`trackid`),
  KEY `albumid` (`albumid`),
  KEY `artistid` (`artistid`),
  CONSTRAINT `tracks_ibfk_1` FOREIGN KEY (`albumid`) REFERENCES `albums` (`albumid`),
  CONSTRAINT `tracks_ibfk_2` FOREIGN KEY (`artistid`) REFERENCES `artists` (`artistid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracks`
--

LOCK TABLES `tracks` WRITE;
/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbms'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-21 18:07:07
