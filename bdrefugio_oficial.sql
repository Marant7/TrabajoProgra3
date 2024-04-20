-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bdrefugio
CREATE DATABASE IF NOT EXISTS `bdrefugio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `bdrefugio`;

-- Volcando estructura para tabla bdrefugio.administrador
CREATE TABLE IF NOT EXISTS `administrador` (
  `idAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `idCargo` int(11) DEFAULT NULL,
  `DNI` varchar(50) NOT NULL DEFAULT '0',
  `contraseña` varchar(30) NOT NULL,
  PRIMARY KEY (`idAdministrador`),
  KEY `idCargo` (`idCargo`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.adoptante
CREATE TABLE IF NOT EXISTS `adoptante` (
  `idAdoptante` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `genero` enum('masculino','femenino') DEFAULT NULL,
  `ocupacion` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `edad` varchar(2) NOT NULL,
  PRIMARY KEY (`idAdoptante`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `adoptante_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `idAnimal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `fecha` date NOT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `genero` enum('macho','hembra') DEFAULT NULL,
  `tipo` enum('perro','gato') DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.distrito
CREATE TABLE IF NOT EXISTS `distrito` (
  `idDistrito` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.evidencia
CREATE TABLE IF NOT EXISTS `evidencia` (
  `idEvidencia` int(11) NOT NULL AUTO_INCREMENT,
  `Visitadomiciliaria` enum('si','no') DEFAULT 'no',
  PRIMARY KEY (`idEvidencia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.formularioadopcion
CREATE TABLE IF NOT EXISTS `formularioadopcion` (
  `idFormularioAdopcion` int(11) NOT NULL AUTO_INCREMENT,
  `idVoluntario` int(11) DEFAULT NULL,
  `idAdministrador` int(11) DEFAULT NULL,
  `idEvidencia` int(11) NOT NULL,
  `idAdoptante` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `p1` varchar(255) DEFAULT NULL,
  `p2` varchar(255) DEFAULT NULL,
  `p3` varchar(255) DEFAULT NULL,
  `p4` varchar(255) DEFAULT NULL,
  `p5` varchar(255) DEFAULT NULL,
  `estado` enum('aprobado','pendiente','rechazado') DEFAULT 'pendiente',
  PRIMARY KEY (`idFormularioAdopcion`),
  KEY `idVoluntario` (`idVoluntario`),
  KEY `idAdministrador` (`idAdministrador`),
  KEY `idEvidencia` (`idEvidencia`),
  KEY `idAdoptante` (`idAdoptante`),
  CONSTRAINT `formularioadopcion_ibfk_1` FOREIGN KEY (`idVoluntario`) REFERENCES `voluntario` (`idVoluntario`),
  CONSTRAINT `formularioadopcion_ibfk_2` FOREIGN KEY (`idAdministrador`) REFERENCES `administrador` (`idAdministrador`),
  CONSTRAINT `formularioadopcion_ibfk_3` FOREIGN KEY (`idEvidencia`) REFERENCES `evidencia` (`idEvidencia`),
  CONSTRAINT `formularioadopcion_ibfk_4` FOREIGN KEY (`idAdoptante`) REFERENCES `adoptante` (`idAdoptante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bdrefugio.voluntario
CREATE TABLE IF NOT EXISTS `voluntario` (
  `idVoluntario` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idDistrito` int(11) NOT NULL,
  `genero` enum('masculino','femenino') DEFAULT NULL,
  `ocupacion` varchar(20) DEFAULT NULL,
  `edad` varchar(2) NOT NULL,
  `clave` varchar(8) DEFAULT NULL,
  `idCargo` int(11) NOT NULL DEFAULT 2,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `DNI` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`idVoluntario`),
  KEY `idCargo` (`idCargo`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `voluntario_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`),
  CONSTRAINT `voluntario_ibfk_2` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
