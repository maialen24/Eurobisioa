-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: eurobisioa
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.2

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
-- Table structure for table `Artista`
--

DROP TABLE IF EXISTS `Artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Artista` (
  `izenArtistikoa` varchar(240) NOT NULL,
  `partaideKop` int DEFAULT NULL,
  PRIMARY KEY (`izenArtistikoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Artista`
--

LOCK TABLES `Artista` WRITE;
/*!40000 ALTER TABLE `Artista` DISABLE KEYS */;
INSERT INTO `Artista` VALUES ('Iris',NULL),('Ivi Adamou',NULL),('Litesound',NULL),('Maya Sar',NULL),('Roman Lob',NULL),('Rona Nishliu',NULL),('Sabina Bayeva',NULL),('Sofi Marinova',NULL),('Trackshittaz',NULL);
/*!40000 ALTER TABLE `Artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bozkaketa`
--

DROP TABLE IF EXISTS `Bozkaketa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bozkaketa` (
  `bozkatuaIzanDa` varchar(240) NOT NULL,
  `bozkatuDu` varchar(240) NOT NULL,
  `urtea` int NOT NULL,
  `puntuak` int DEFAULT NULL,
  PRIMARY KEY (`bozkatuaIzanDa`,`bozkatuDu`,`urtea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bozkaketa`
--

LOCK TABLES `Bozkaketa` WRITE;
/*!40000 ALTER TABLE `Bozkaketa` DISABLE KEYS */;
INSERT INTO `Bozkaketa` VALUES ('Albania','Belgika',2019,1),('Alemania','Albania',2020,5),('Azerbaiyán','Belgika',2019,1),('Chipre','Belgika',2019,3);
/*!40000 ALTER TABLE `Bozkaketa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Herrialde`
--

DROP TABLE IF EXISTS `Herrialde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Herrialde` (
  `izena` varchar(240) NOT NULL,
  `bandera` varchar(240) DEFAULT NULL,
  `tv` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`izena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Herrialde`
--

LOCK TABLES `Herrialde` WRITE;
/*!40000 ALTER TABLE `Herrialde` DISABLE KEYS */;
INSERT INTO `Herrialde` VALUES ('Albania','albania',NULL),('Alemania','alemania',NULL),('Austria','austria',NULL),('Azerbaiyán','azerbaiyan',NULL),('Belgika','belgika',NULL),('Bielorrusia','bielorrusia',NULL),('Bosnia','bosnia',NULL),('Bulgaria','bulgaria',NULL),('Chipre','chipre',NULL);
/*!40000 ALTER TABLE `Herrialde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ordezkaritza`
--

DROP TABLE IF EXISTS `Ordezkaritza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ordezkaritza` (
  `artista` varchar(240) NOT NULL,
  `herrialdea` varchar(240) NOT NULL,
  `urtea` int NOT NULL,
  `abestia` varchar(240) DEFAULT NULL,
  `puntuak` int DEFAULT NULL,
  PRIMARY KEY (`artista`,`herrialdea`,`urtea`),
  CONSTRAINT `fkartista` FOREIGN KEY (`artista`) REFERENCES `Artista` (`izenArtistikoa`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ordezkaritza`
--

LOCK TABLES `Ordezkaritza` WRITE;
/*!40000 ALTER TABLE `Ordezkaritza` DISABLE KEYS */;
INSERT INTO `Ordezkaritza` VALUES ('Iris','Belgika',2019,'Would you?',0),('Iris','Belgika',2020,'Would you?',0),('Ivi Adamou','Chipre',2019,'La la love',3),('Ivi Adamou','Chipre',2020,'La la love',0),('Litesound','Bielorrusia',2019,'We are the heroes',0),('Litesound','Bielorrusia',2020,'We are the heroes',0),('Maya Sar','Bosnia/Herzegov.',2019,'Korake ti znam',0),('Maya Sar','Bosnia/Herzegov.',2020,'Korake ti znam',0),('Roman Lob','Alemania',2019,'Standing still',0),('Roman Lob','Alemania',2020,'Standing still',5),('Rona Nishliu','Albania',2019,'Suus',1),('Rona Nishliu','Albania',2020,'Suus',0),('Sabina Bayeva','Azerbaiyán',2019,'When music dies',1),('Sabina Bayeva','Azerbaiyán',2020,'When music dies',0),('Sofi Marinova','Bulgaria',2019,'Love unlimited',0),('Sofi Marinova','Bulgaria',2020,'Love unlimited',0),('Trackshittaz','Austria',2019,'Woki mit deim ',0),('Trackshittaz','Austria',2020,'Woki mit deim ',0);
/*!40000 ALTER TABLE `Ordezkaritza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ParteHartzea`
--

DROP TABLE IF EXISTS `ParteHartzea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ParteHartzea` (
  `izena` varchar(240) NOT NULL,
  `urtea` int NOT NULL,
  `etorrikoDa` enum('BAI','EZ') DEFAULT NULL,
  PRIMARY KEY (`izena`,`urtea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ParteHartzea`
--

LOCK TABLES `ParteHartzea` WRITE;
/*!40000 ALTER TABLE `ParteHartzea` DISABLE KEYS */;
/*!40000 ALTER TABLE `ParteHartzea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-11 17:54:01
