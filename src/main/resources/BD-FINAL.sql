-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: idle_dev
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `multiplica_ganancia` float DEFAULT NULL,
  `ranuras_base` int DEFAULT NULL,
  `requerimiento_valores` varchar(255) DEFAULT NULL,
  `requerimiento_lenguajes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Desarrollo Web Frontend',1.5,2,'50,100,150,200,250','1,2,3'),(2,'Desarrollo Web Backend',1.5,2,'50,100,150,200,250','4,5,6,7'),(3,'Desarrollo Web FullStack',3,4,'50,100,150,200,250','1,2,3,4,5,6,7'),(4,'Desarrollo mobile',3,4,'50,100,150,200,250','8,9,10'),(5,'Mantenimiento de sistemas',3.5,3,'50,100,150,200,250','11,12'),(6,'Desarrollo de videojuegos',4,5,'50,100,150,200,250','13,14');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_partida`
--

DROP TABLE IF EXISTS `empresa_partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa_partida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int NOT NULL,
  `id_partida` int NOT NULL,
  `nivel_actual` int DEFAULT NULL,
  `desbloqueada` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_empresa_has_Partida_Partida1_idx` (`id_partida`),
  KEY `fk_empresa_has_Partida_empresa1_idx` (`id_empresa`),
  CONSTRAINT `fk_empresa_has_Partida_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`),
  CONSTRAINT `fk_empresa_has_Partida_Partida1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_partida`
--

LOCK TABLES `empresa_partida` WRITE;
/*!40000 ALTER TABLE `empresa_partida` DISABLE KEYS */;
INSERT INTO `empresa_partida` VALUES (1,1,1,0,0),(2,1,2,1,1),(9,1,18,3,1),(10,2,18,3,1),(11,3,18,3,1),(12,4,18,2,1),(13,5,18,0,0),(14,6,18,1,1),(15,1,17,0,0),(16,2,17,0,0),(17,3,17,0,0),(18,4,17,0,0),(19,5,17,0,0),(20,6,17,0,0),(21,1,16,0,0),(22,2,16,0,0),(23,3,16,0,0),(24,4,16,0,0),(25,5,16,0,0),(26,6,16,0,0),(33,1,28,0,0),(34,2,28,0,0),(35,3,28,0,0),(36,4,28,0,0),(37,5,28,0,0),(38,6,28,0,0),(45,1,32,0,0),(46,2,32,0,0),(47,3,32,0,0),(48,4,32,0,0),(49,5,32,0,0),(50,6,32,0,0),(51,1,33,0,0),(52,2,33,0,0),(53,3,33,0,0),(54,4,33,0,0),(55,5,33,0,0),(56,6,33,0,0),(57,1,34,0,0),(58,2,34,0,0),(59,3,34,0,0),(60,4,34,0,0),(61,5,34,0,0),(62,6,34,0,0),(99,1,36,0,0),(100,2,36,0,0),(101,3,36,0,0),(102,4,36,0,0),(103,5,36,0,0),(104,6,36,0,0);
/*!40000 ALTER TABLE `empresa_partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lenguaje`
--

DROP TABLE IF EXISTS `lenguaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `beneficio_base` float DEFAULT NULL,
  `ratio_incremento` float DEFAULT NULL,
  `dinero_desbloqueo` float DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lenguaje`
--

LOCK TABLES `lenguaje` WRITE;
/*!40000 ALTER TABLE `lenguaje` DISABLE KEYS */;
INSERT INTO `lenguaje` VALUES (1,'HTML',1.67,1.07,3.7,'HTML es el lenguaje esqueleto de cualquier web, con el podrás comenzar a construir la estructura de una web','http://localhost:8080/languages/html.svg'),(2,'CSS',20,1.15,60,'CSS te permitirá dotar de estilos a tu web. Hazla brillar e impresiona a todo el mundo con tus animaciones','http://localhost:8080/languages/css.svg'),(3,'Javascript',90,1.14,720,'JS es el nucleo duro de toda página web. Con el podras dotar a tu web de interactividad.','http://localhost:8080/languages/js.svg'),(4,'NodeJS',360,1.13,8640,'¿Por que no montar nuestro servidor usando también JS? Node lo hará posible?','http://localhost:8080/languages/nodejs.svg'),(5,'Java',2160,1.12,103680,'Java fue durante mucho tiempo uno de los lenguajes mas usados del mundo y aún hoy se usa mucho. Piensa, hasta minecraft está hecho en Java','http://localhost:8080/languages/java.svg'),(6,'PHP',6480,1.11,1244160,'PHP es un lenguaje ampliamente usado en web desde la parte del servidor ¿Te gusta concatenar con un punto? Con PHP tienes la oportunidad','http://localhost:8080/languages/php.svg'),(7,'Python',25920,1.1,4976640,'Python esta cogiendo cada vez mas fuerza en el mundo del desarrollo backend. ¿Te gusta hacer codigo libremente sin cosas molestas como los tipos? Pues unete al código pitón','http://localhost:8080/languages/python.svg'),(8,'Kotlin',129600,1.09,24883200,'¿Harto de lo complicado que se hace programar en java? Kotlin llega a tu rescate suavizando esas 1000 lineas que tenias que escribir en Java','http://localhost:8080/languages/kotlin.svg'),(9,'Swift',777600,1.08,149299000,'Si te gustan las aplicaciones móviles Swift es tu mejor aliado','http://localhost:8080/languages/swift.svg'),(10,'React Native',5443200,1.07,1045090000,'Imaginate toda la potencia de React pero en desarrollo móvil... Con React Native ya es una realidad','http://localhost:8080/languages/react-native.svg'),(11,'Despliegue',43545600,1.06,8360720000,'¿De que sirve tanto desarrollo si no podemos pasar nuestras aplicaciones a producción? El despliegue es una parte fundamental del desarrollo de una app','http://localhost:8080/languages/production.svg'),(12,'S.O.',391910000,1.05,75246500000,'Todos sabemos manejar Windows, pero, ¿Que hacer cuando la solución no es simplemente reiniciar?','http://localhost:8080/languages/os.svg'),(13,'Unity',3919100000,1.04,752465000000,'Bienvenido al desarrollo de videojuegos. Unity es uno de los motores de desarrollo mas importantes para juegos indies y no tan indies','http://localhost:8080/languages/unity.svg'),(14,'Unreal Engine',43110100000,1.03,8277120000000,'Unreal Engine, un motor de desarrollo de videojuegos que busca el realismo ante todo. Pronto no distinguiremos la persona real del npc','http://localhost:8080/languages/unreal-engine.svg');
/*!40000 ALTER TABLE `lenguaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lenguaje_partida`
--

DROP TABLE IF EXISTS `lenguaje_partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguaje_partida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_lenguaje` int NOT NULL,
  `id_partida` int NOT NULL,
  `desbloqueado` tinyint DEFAULT NULL,
  `cantidad` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Lenguaje_has_Partida_Partida1_idx` (`id_partida`),
  KEY `fk_Lenguaje_has_Partida_Lenguaje1_idx` (`id_lenguaje`),
  CONSTRAINT `fk_Lenguaje_has_Partida_Lenguaje1` FOREIGN KEY (`id_lenguaje`) REFERENCES `lenguaje` (`id`),
  CONSTRAINT `fk_Lenguaje_has_Partida_Partida1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lenguaje_partida`
--

LOCK TABLES `lenguaje_partida` WRITE;
/*!40000 ALTER TABLE `lenguaje_partida` DISABLE KEYS */;
INSERT INTO `lenguaje_partida` VALUES (7,1,16,1,4),(8,2,16,0,0),(9,3,16,0,0),(10,4,16,0,0),(11,5,16,0,0),(12,6,16,0,0),(19,1,18,1,153),(20,2,18,1,155),(21,3,18,1,150),(22,4,18,1,150),(23,5,18,1,154),(24,6,18,1,152),(25,7,18,1,152),(26,8,18,1,104),(27,9,18,1,100),(28,10,18,1,100),(29,11,18,1,20),(30,12,18,1,20),(31,13,18,1,50),(32,14,18,1,75),(33,1,17,0,0),(34,2,17,0,0),(35,3,17,0,0),(36,4,17,0,0),(37,5,17,0,0),(38,6,17,0,0),(39,7,17,0,0),(40,8,17,0,0),(41,9,17,0,0),(42,10,17,0,0),(43,11,17,0,0),(44,12,17,0,0),(45,13,17,0,0),(46,14,17,0,0),(61,1,28,0,0),(62,2,28,0,0),(63,3,28,0,0),(64,4,28,0,0),(65,5,28,0,0),(66,6,28,0,0),(67,7,28,0,0),(68,8,28,0,0),(69,9,28,0,0),(70,10,28,0,0),(71,11,28,0,0),(72,12,28,0,0),(73,13,28,0,0),(74,14,28,0,0),(89,1,32,1,55),(90,2,32,1,33),(91,3,32,1,23),(92,4,32,1,0),(93,5,32,1,0),(94,6,32,1,0),(95,7,32,1,0),(96,8,32,0,0),(97,9,32,0,0),(98,10,32,0,0),(99,11,32,0,0),(100,12,32,0,0),(101,13,32,0,0),(102,14,32,0,0),(103,1,33,0,0),(104,2,33,0,0),(105,3,33,0,0),(106,4,33,0,0),(107,5,33,0,0),(108,6,33,0,0),(109,7,33,0,0),(110,8,33,0,0),(111,9,33,0,0),(112,10,33,0,0),(113,11,33,0,0),(114,12,33,0,0),(115,13,33,0,0),(116,14,33,0,0),(117,1,34,0,0),(118,2,34,0,0),(119,3,34,0,0),(120,4,34,0,0),(121,5,34,0,0),(122,6,34,0,0),(123,7,34,0,0),(124,8,34,0,0),(125,9,34,0,0),(126,10,34,0,0),(127,11,34,0,0),(128,12,34,0,0),(129,13,34,0,0),(130,14,34,0,0),(131,1,36,1,3),(132,2,36,1,2),(133,3,36,1,2),(134,4,36,1,1),(135,5,36,1,1),(136,6,36,1,0),(137,7,36,0,0),(138,8,36,0,0),(139,9,36,0,0),(140,10,36,0,0),(141,11,36,0,0),(142,12,36,0,0),(143,13,36,0,0),(144,14,36,0,0);
/*!40000 ALTER TABLE `lenguaje_partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mejora`
--

DROP TABLE IF EXISTS `mejora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mejora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_lenguaje` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nivel_desbloqueo` enum('basico','intermedio','avanzado','junior','senior','maestro') DEFAULT NULL,
  `mejora_generacion` tinyint DEFAULT NULL,
  `descuento_compra` tinyint DEFAULT NULL,
  `extra_pa` tinyint DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Mejora_Lenguaje1_idx` (`id_lenguaje`),
  CONSTRAINT `fk_Mejora_Lenguaje1` FOREIGN KEY (`id_lenguaje`) REFERENCES `lenguaje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mejora`
--

LOCK TABLES `mejora` WRITE;
/*!40000 ALTER TABLE `mejora` DISABLE KEYS */;
INSERT INTO `mejora` VALUES (1,1,'Emmet','HTML un 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/emmet.svg'),(2,1,'HTML5','Generación dinero HTML +20%','junior',1,0,0,'http://localhost:8080/upgrades/html5.svg'),(3,1,'Canvas','Generación PA HTML +20%','senior',0,0,1,'http://localhost:8080/upgrades/canvas.svg'),(4,2,'Sass','Generación PA CSS +20%','intermedio',0,0,1,'http://localhost:8080/upgrades/sass.svg'),(5,2,'Bootstrap','CSS un 5% mas barato','junior',0,1,0,'http://localhost:8080/upgrades/bootstrap.svg'),(6,2,'Tailwind','Generación dinero CSS +20%','senior',1,0,0,'http://localhost:8080/upgrades/tailwind.svg'),(7,3,'TypeScript','JS un 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/typescript.svg'),(8,3,'React','Generación dinero JS +20%','junior',1,0,0,'http://localhost:8080/upgrades/react.svg'),(9,3,'Vue','Generación PA JS +20%','senior',0,0,1,'http://localhost:8080/upgrades/vuejs.svg'),(10,4,'Express','Generación dinero NodeJS +20%','intermedio',1,0,0,'http://localhost:8080/upgrades/express.svg'),(11,4,'Nest','NodeJS un 5% mas barato','junior',0,1,0,'http://localhost:8080/upgrades/nestjs.svg'),(12,4,'Sails','Generación PA NodeJS +20%','senior',0,0,1,'http://localhost:8080/upgrades/sail.svg'),(13,5,'Springboot','Generación PA Java +20%','intermedio',0,0,1,'http://localhost:8080/upgrades/springboot.svg'),(14,5,'Hibernate','Java un 5% mas barato','junior',0,1,0,'http://localhost:8080/upgrades/hibernate.svg'),(15,5,'JavaServer Faces','Generación dinero Java +20%','senior',1,0,0,'http://localhost:8080/upgrades/javaSF.svg'),(16,6,'Laravel','Generación dinero PHP +20%','intermedio',1,0,0,'http://localhost:8080/upgrades/laravel.svg'),(17,6,'Codeigniter','Generación PA PHP +20%','junior',0,0,1,'http://localhost:8080/upgrades/codeigniter.svg'),(18,6,'Symfony','PHP un 5% mas barato','senior',0,1,0,'http://localhost:8080/upgrades/symfony.svg'),(19,7,'Django','Generación dinero Python +20%','intermedio',1,0,0,'http://localhost:8080/upgrades/django.svg'),(20,7,'Flask','Python 5% mas barato','junior',0,1,0,'http://localhost:8080/upgrades/flask.svg'),(21,7,'Pyramid','Generación PA Python +20%','senior',0,0,1,'http://localhost:8080/upgrades/pyramid.svg'),(22,8,'Spring','Generación PA Kotlin +20%','intermedio',0,0,1,'http://localhost:8080/upgrades/spring.svg'),(23,8,'Vert.x','Kotlin 5% mas barato','junior',0,1,0,'http://localhost:8080/upgrades/vertx.svg'),(24,8,'Spark','Generación dinero Kotlin +20%','senior',1,0,0,'http://localhost:8080/upgrades/spark.svg'),(25,9,'Eureka','Swift 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/eureka.svg'),(26,9,'Foundation','Generación PA Swift +20%','junior',0,0,1,'http://localhost:8080/upgrades/foundation.svg'),(27,9,'Realm','Generación dinero Swift +20%','senior',1,0,0,'http://localhost:8080/upgrades/realm.svg'),(28,10,'Paper','Generación PA RN + 20%','intermedio',0,0,1,'http://localhost:8080/upgrades/paper.svg'),(29,10,'Elements','Generación dinero RN + 20%','junior',1,0,0,'http://localhost:8080/upgrades/elements.svg'),(30,10,'Maps','RN 5% mas barato','senior',0,1,0,'http://localhost:8080/upgrades/maps.svg'),(31,11,'Docker','Despliegue 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/docker.svg'),(32,11,'Netlify','Generación PA Despliegue +20%','junior',0,0,1,'http://localhost:8080/upgrades/netlify.svg'),(33,11,'Railway','Generación dinero Despliegue +20%','senior',1,0,0,'http://localhost:8080/upgrades/railway.svg'),(34,12,'Windows','S.O. 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/windows.svg'),(35,12,'Linux','Generación dinero S.O. +20%','junior',1,0,0,'http://localhost:8080/upgrades/linux.svg'),(36,12,'Mac','Generación PA S.O. +20%','senior',0,0,1,'http://localhost:8080/upgrades/mac.svg'),(37,13,'Plastic scm','Generacion dinero Unity +20%','intermedio',0,0,1,'http://localhost:8080/upgrades/plastic.svg'),(38,13,'Enterprise','Generación PA Unity +20%','junior',1,0,0,'http://localhost:8080/upgrades/enterprise.svg'),(39,13,'Maestro en C#','Unity 5% mas barato','senior',0,1,0,'http://localhost:8080/upgrades/csharp.svg'),(40,14,'Maestro en C++','Unreal Engine 5% mas barato','intermedio',0,1,0,'http://localhost:8080/upgrades/cplusplus.svg'),(41,14,'ZBrush','Generación PA Unreal Engine +20% ','junior',0,0,1,'http://localhost:8080/upgrades/zbrush.svg'),(42,14,'Modelos CAD','Generación dinero Unreal Engine +20%','senior',1,0,0,'http://localhost:8080/upgrades/cad.svg');
/*!40000 ALTER TABLE `mejora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dinero` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPartida_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (1,40000),(2,12000),(3,20),(16,15.662210464477539),(17,0),(18,4.662990918185035e17),(27,0),(28,0),(32,6668562.78723546),(33,0),(34,1),(35,0),(36,1732122.6498700017);
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int DEFAULT NULL,
  `id_partida` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `generacion_pa` float DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Trabajador_Partida1_idx` (`id_partida`),
  KEY `fk_Trabajador_empresa_partida1_idx` (`id_empresa`),
  CONSTRAINT `fk_Trabajador_empresa_partida1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa_partida` (`id`),
  CONSTRAINT `fk_Trabajador_Partida1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (91,NULL,18,'Valeria Mendez',1.51,'F','http://localhost:8080/workers-avatars/woman5.svg'),(92,NULL,18,'Luz Castillo',3.14,'F','http://localhost:8080/workers-avatars/woman2.svg'),(94,NULL,18,'Rafael Vicente',3.95,'M','http://localhost:8080/workers-avatars/man16.svg'),(95,NULL,18,'Cordell Morales',2.78,'M','http://localhost:8080/workers-avatars/man14.svg'),(96,NULL,18,'Miguel Redondo',3.67,'M','http://localhost:8080/workers-avatars/man6.svg'),(97,NULL,18,'Esther Ortiz',2.11,'F','http://localhost:8080/workers-avatars/woman2.svg'),(99,NULL,17,'Gwendoline Diaz',4.18,'F','http://localhost:8080/workers-avatars/woman8.svg'),(100,NULL,16,'Bruna Herrero',4.03,'F','http://localhost:8080/workers-avatars/woman4.svg'),(101,NULL,27,'Miguel Castillo',4.78,'M','http://localhost:8080/workers-avatars/man15.svg'),(104,NULL,28,'Amina Suarez',4.03,'F','http://localhost:8080/workers-avatars/woman11.svg'),(106,NULL,32,'Alba Ruiz',2.35,'F','http://localhost:8080/workers-avatars/woman5.svg'),(107,NULL,33,'Samuel Martin',4.69,'M','http://localhost:8080/workers-avatars/man16.svg'),(108,NULL,34,'Joaquín Espinosa',4.34,'M','http://localhost:8080/workers-avatars/man11.svg'),(109,NULL,18,'Adrián Garcia',2.14,'M','http://localhost:8080/workers-avatars/man18.svg'),(110,NULL,18,'Maximiliano Marin',2,'M','http://localhost:8080/workers-avatars/man8.svg'),(111,NULL,36,'Carmen Molina',3.92,'F','http://localhost:8080/workers-avatars/woman3.svg');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador_lenguaje`
--

DROP TABLE IF EXISTS `trabajador_lenguaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador_lenguaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_trabajador` int NOT NULL,
  `id_lenguaje` int NOT NULL,
  `nivel` enum('basico','intermedio','avanzado','junior','senior','maestro') DEFAULT NULL,
  `experiencia_lenguaje` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Trabajador_has_Lenguaje_Lenguaje1_idx` (`id_lenguaje`),
  KEY `fk_Trabajador_has_Lenguaje_Trabajador1_idx` (`id_trabajador`),
  CONSTRAINT `fk_Trabajador_has_Lenguaje_Lenguaje1` FOREIGN KEY (`id_lenguaje`) REFERENCES `lenguaje` (`id`),
  CONSTRAINT `fk_Trabajador_has_Lenguaje_Trabajador1` FOREIGN KEY (`id_trabajador`) REFERENCES `trabajador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador_lenguaje`
--

LOCK TABLES `trabajador_lenguaje` WRITE;
/*!40000 ALTER TABLE `trabajador_lenguaje` DISABLE KEYS */;
INSERT INTO `trabajador_lenguaje` VALUES (106,91,6,'intermedio',0),(107,92,13,'intermedio',0),(109,94,2,'senior',0),(110,92,2,'intermedio',0),(111,94,9,'basico',0),(112,91,4,'intermedio',0),(113,95,11,'intermedio',0),(114,96,7,'junior',0),(115,91,1,'intermedio',0),(116,97,3,'intermedio',0),(117,95,4,'basico',0),(118,91,3,'intermedio',0),(119,91,2,'intermedio',0),(120,91,8,'basico',0),(121,91,5,'basico',0),(122,92,6,'intermedio',0),(123,97,6,'intermedio',0),(124,96,6,'intermedio',0),(125,99,9,'avanzado',0),(126,99,1,'intermedio',0),(129,104,1,'avanzado',0),(130,92,1,'avanzado',0),(131,92,5,'basico',0),(132,92,8,'basico',0),(133,96,8,'avanzado',0),(134,97,12,'intermedio',0),(135,95,7,'basico',0),(137,106,10,'intermedio',0),(138,106,7,'intermedio',0),(139,107,9,'intermedio',0),(140,108,4,'intermedio',0),(141,92,4,'basico',0),(142,109,6,'avanzado',0),(143,110,3,'intermedio',0),(144,110,11,'basico',0),(145,111,11,'intermedio',0),(146,110,14,'basico',0),(147,109,10,'basico',0),(148,96,3,'basico',0),(149,95,14,'basico',0);
/*!40000 ALTER TABLE `trabajador_lenguaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador_mejora`
--

DROP TABLE IF EXISTS `trabajador_mejora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador_mejora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_trabajador` int NOT NULL,
  `id_mejora` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Trabajador_has_Mejora_Mejora1_idx` (`id_mejora`),
  KEY `fk_Trabajador_has_Mejora_Trabajador1_idx` (`id_trabajador`),
  CONSTRAINT `fk_Trabajador_has_Mejora_Mejora1` FOREIGN KEY (`id_mejora`) REFERENCES `mejora` (`id`),
  CONSTRAINT `fk_Trabajador_has_Mejora_Trabajador1` FOREIGN KEY (`id_trabajador`) REFERENCES `trabajador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador_mejora`
--

LOCK TABLES `trabajador_mejora` WRITE;
/*!40000 ALTER TABLE `trabajador_mejora` DISABLE KEYS */;
INSERT INTO `trabajador_mejora` VALUES (13,91,16),(14,92,37),(15,94,4),(16,95,31),(17,96,19),(18,97,7),(19,96,20),(20,91,1),(21,91,10),(22,91,7),(23,91,4),(24,92,16),(25,97,16),(26,96,16),(27,99,25),(28,99,1),(30,104,1),(31,92,4),(32,92,1),(33,96,22),(34,94,5),(35,106,28),(36,106,19),(37,107,25),(38,108,10),(39,94,6),(40,109,16),(41,110,7),(42,91,13),(43,110,31),(45,92,22),(46,92,13),(47,97,34),(49,111,31);
/*!40000 ALTER TABLE `trabajador_mejora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_partida` int DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idusuarios_UNIQUE` (`id`),
  KEY `fk_Usuario_Partida1_idx` (`id_partida`),
  CONSTRAINT `fk_Usuario_Partida1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (7,16,'lagordita','Gordita33@gmail.com','$2a$10$i1d1PsBsJW66vMIGIlZYaejKUIN9ZxgPMZWakZVCFD4jxzjZR6/Vm','http://localhost:8080/files/1685538152548_Foto-cv.png'),(8,17,'Proxyman','proxyman@gmail.com','$2a$10$zL8a/zcKxXduNgOvBlW1ueCQ5HBF868kIjhEQmGz2/mAwJoXFo9D2',NULL),(9,18,'baldy_dev','Baldy_dev@gmail.com','$2a$10$gHBQLeJSFnNxLVa1ROGkBOnjIApH.rs0hoWvMPJFno08JV81mXXP6','http://localhost:8080/files/1686328851146_goma-pequeño.png'),(14,28,'pollo','pollo33@gmail.com','$2a$10$u3Lu4j6kmgv8jbUcf9jd/OM399WvSutMmI2g3TMYDNWsRyJ/lYqNW',NULL),(19,NULL,'danitest',NULL,'$2a$10$l0AnJtDMnv7hL.VaF6YQNeZxUDGrLO1eOj8wI5adWTCwZGXSJM1jm',NULL),(20,35,'paco01','paco01@gmail.com','$2a$10$Th7h4o9vDzs8DbC/nGpKGuCEWkHBepRm0WfxW8C/JSIKlu7z1g6vK',NULL),(21,36,'alfonso12','alfonso12@gmail.com','$2a$10$XbirHbd/V6ERUyg6kcJEIOghWYZgS4gz4ofdbEPq10o8wqTgZRoP.',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-11 21:09:54
