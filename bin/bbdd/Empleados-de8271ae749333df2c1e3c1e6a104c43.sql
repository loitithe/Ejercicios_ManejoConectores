CREATE DATABASE  IF NOT EXISTS `empleados` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `empleados`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: empleados
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.12.04.1

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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `Numdep` tinyint(3) unsigned NOT NULL,
  `Nombredep` varchar(15) DEFAULT NULL,
  `Numempdep` int(10) DEFAULT NULL,
  `NSSgerente` varchar(50) DEFAULT NULL,
  `fechainicgerente` datetime DEFAULT NULL,
  PRIMARY KEY (`Numdep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Investigacion',16,'11111','1989-03-12 00:00:00'),(2,'Administracion',14,'22222','1989-02-13 00:00:00'),(3,'Dirección',2,'88888','1999-08-14 00:00:00');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento-ubi`
--

DROP TABLE IF EXISTS `departamento-ubi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento-ubi` (
  `Numdep` tinyint(3) unsigned NOT NULL,
  `Lugardep` varchar(15) NOT NULL,
  PRIMARY KEY (`Numdep`,`Lugardep`),
  KEY `DEPARTAMENTODEPARTAMENTO-UBI` (`Numdep`),
  CONSTRAINT `departamento-ubi_ibfk_1` FOREIGN KEY (`Numdep`) REFERENCES `departamento` (`Numdep`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento-ubi`
--

LOCK TABLES `departamento-ubi` WRITE;
/*!40000 ALTER TABLE `departamento-ubi` DISABLE KEYS */;
INSERT INTO `departamento-ubi` VALUES (1,'Coruña'),(1,'Santiago'),(1,'Vigo'),(2,'Lugo'),(2,'Vigo'),(3,'Vigo');
/*!40000 ALTER TABLE `departamento-ubi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `NSS` varchar(6) NOT NULL,
  `Nombre` varchar(15) DEFAULT NULL,
  `Apel1` varchar(15) DEFAULT NULL,
  `Apel2` varchar(15) DEFAULT NULL,
  `Sexo` varchar(2) DEFAULT NULL,
  `Dirección` varchar(30) DEFAULT NULL,
  `Fechanac` datetime DEFAULT NULL,
  `Salario` int(10) DEFAULT NULL,
  `Numdept` tinyint(3) unsigned DEFAULT NULL,
  `NSSsup` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`NSS`),
  KEY `DEPARTAMENTOEMPLEADO` (`Numdept`),
  KEY `EMPLEADOEMPLEADO` (`NSSsup`),
  CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`NSSsup`) REFERENCES `empleado` (`NSS`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`Numdept`) REFERENCES `departamento` (`Numdep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('11111','José','Nieto','Silva','M','C/Sol,4','1963-03-12 00:00:00',420000,1,NULL),('11122','Federico','Fuertes','Serantes','M','C/Espiga,7','1970-10-07 00:00:00',140000,2,'88888'),('11133','Carmen','Prieto','Gonzalez','F','C/Fresnos,7','1970-10-07 00:00:00',175000,1,'11111'),('22222','Federico','García','López','M','C/Luna,8','1970-04-12 00:00:00',150000,3,'11111'),('33322','Maria','Ramos','Perez','F','C/Sol,22','1965-03-03 00:00:00',120000,1,'88888'),('33333','Ana','Sanchez','Valdés','F','C/Bravo,8','1959-03-17 00:00:00',120000,1,'22222'),('44444','Jaime','Silva','Gonzalez','M','C/Dalias,7','1970-04-12 00:00:00',200000,1,'22222'),('55555','Luis','Gonzalez','Mouro','M','C/Peru, 9','1958-08-19 00:00:00',150000,2,'11111'),('66666','José','Vilan','Silva','M','C/Panama, 8','1959-12-17 00:00:00',200000,1,'11111'),('77777','Ana','López','Villa','F','C/Rosas,7','1971-04-11 00:00:00',200000,2,'22222'),('88888','Pedro','Gonzalez','Jimenez','M','C/Valle, 6','1953-03-17 00:00:00',300000,3,NULL),('99999','Ana','Silva','López','F','C/Bravo,8','1970-10-07 00:00:00',150000,1,'88888');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadoproyecto`
--

DROP TABLE IF EXISTS `empleadoproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleadoproyecto` (
  `NSS` varchar(6) NOT NULL,
  `NUMPROY` int(10) NOT NULL,
  `NUMHORAS` int(10) DEFAULT NULL,
  PRIMARY KEY (`NSS`,`NUMPROY`),
  KEY `EMPLEADOEMPLEADO-PROYECTO` (`NSS`),
  KEY `PROYECTOEMPLEADO-PROYECTO` (`NUMPROY`),
  CONSTRAINT `empleadoproyecto_ibfk_2` FOREIGN KEY (`NSS`) REFERENCES `empleado` (`NSS`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empleadoproyecto_ibfk_1` FOREIGN KEY (`NUMPROY`) REFERENCES `proyecto` (`Numproy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadoproyecto`
--

LOCK TABLES `empleadoproyecto` WRITE;
/*!40000 ALTER TABLE `empleadoproyecto` DISABLE KEYS */;
INSERT INTO `empleadoproyecto` VALUES ('11111',1,30),('11111',2,24),('11111',4,13),('22222',1,25),('22222',3,30),('22222',6,14),('44444',1,25),('44444',5,17),('44444',7,35),('66666',2,25),('77777',7,35),('88888',7,40),('99999',1,20),('99999',2,20);
/*!40000 ALTER TABLE `empleadoproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propuestas`
--

DROP TABLE IF EXISTS `propuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propuestas` (
  `IDpropuesta` int(10) NOT NULL AUTO_INCREMENT,
  `Nssempleado` varchar(6) DEFAULT NULL,
  `Descripcion` longtext,
  `FechaPropuesta` datetime DEFAULT NULL,
  PRIMARY KEY (`IDpropuesta`),
  KEY `EMPLEADOPropuestas` (`Nssempleado`),
  KEY `IDpropuesta` (`IDpropuesta`),
  CONSTRAINT `propuestas_ibfk_1` FOREIGN KEY (`Nssempleado`) REFERENCES `empleado` (`NSS`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propuestas`
--

LOCK TABLES `propuestas` WRITE;
/*!40000 ALTER TABLE `propuestas` DISABLE KEYS */;
INSERT INTO `propuestas` VALUES (1,'11111','Mejora parking','2009-01-12 00:00:00'),(2,'22222','Servicio guarderia 12 horas','2009-01-12 00:00:00');
/*!40000 ALTER TABLE `propuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `Numproy` int(10) NOT NULL,
  `Nombreproy` varchar(15) DEFAULT NULL,
  `Lugarproy` varchar(20) DEFAULT NULL,
  `departamento_Numdep` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`Numproy`),
  KEY `fk_proyecto_departamento1_idx` (`departamento_Numdep`),
  CONSTRAINT `fk_proyecto_departamento1` FOREIGN KEY (`departamento_Numdep`) REFERENCES `departamento` (`Numdep`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;


INSERT INTO `proyecto` (`Numproy`, `Nombreproy`, `Lugarproy`, `departamento_Numdep`) VALUES
(1, 'ProductoX', 'Vigo', 1),
(2, 'ProductoY', 'Santiago', 1),
(3, 'ProductoZ', 'Vigo', 1),
(4, 'Reorganización', 'Vigo', 3),
(5, 'Automatización', 'Vigo', 2),
(6, 'Nuevaspresta', 'Lugo', 2),
(7, 'ProductoW', 'Coruña', 1);

/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-24 21:00:46
