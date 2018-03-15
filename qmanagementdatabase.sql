-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2018 a las 08:43:41
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `qmanagementdatabase`
--
CREATE DATABASE IF NOT EXISTS `qmanagementdatabase` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `qmanagementdatabase`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

DROP TABLE IF EXISTS `acceso`;
CREATE TABLE `acceso` (
  `idAccesos` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesosroles`
--

DROP TABLE IF EXISTS `accesosroles`;
CREATE TABLE `accesosroles` (
  `idAccesos` int(11) NOT NULL,
  `idRoles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
CREATE TABLE `asignacion` (
  `idasignacion` int(11) NOT NULL,
  `fechafinal` datetime DEFAULT NULL,
  `fechainicial` datetime DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `idEscenario` int(11) DEFAULT NULL,
  `idincidente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casodeprueba`
--

DROP TABLE IF EXISTS `casodeprueba`;
CREATE TABLE `casodeprueba` (
  `idCasodePrueba` int(11) NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `rutaModulo` varchar(255) DEFAULT NULL,
  `tipoDeCaso` varchar(255) DEFAULT NULL,
  `idmotivo` int(11) DEFAULT NULL,
  `tipoVisibilidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casoprueba_incidente`
--

DROP TABLE IF EXISTS `casoprueba_incidente`;
CREATE TABLE `casoprueba_incidente` (
  `idcasoprueba` int(11) NOT NULL,
  `idincidente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `core`
--

DROP TABLE IF EXISTS `core`;
CREATE TABLE `core` (
  `idCore` int(11) NOT NULL,
  `nombreCore` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejecucion`
--

DROP TABLE IF EXISTS `ejecucion`;
CREATE TABLE `ejecucion` (
  `idEjecucion` int(11) NOT NULL,
  `rutaEjecucion` varchar(255) DEFAULT NULL,
  `idCasoPrueba` int(11) DEFAULT NULL,
  `idEjecuciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejecuciones`
--

DROP TABLE IF EXISTS `ejecuciones`;
CREATE TABLE `ejecuciones` (
  `idejecuciones` int(11) NOT NULL,
  `resultadosNombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenario`
--

DROP TABLE IF EXISTS `escenario`;
CREATE TABLE `escenario` (
  `idEscenario` int(11) NOT NULL,
  `especificaciondeProyecto` varchar(255) DEFAULT NULL,
  `proyecto` varchar(255) DEFAULT NULL,
  `rutaArchivos` varchar(255) DEFAULT NULL,
  `idestado` int(11) DEFAULT NULL,
  `idprivacidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL,
  `estadoNombre` varchar(255) DEFAULT NULL,
  `estadosDescripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadocaso`
--

DROP TABLE IF EXISTS `estadocaso`;
CREATE TABLE `estadocaso` (
  `idestado` int(11) NOT NULL,
  `estadoCaso` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

DROP TABLE IF EXISTS `incidente`;
CREATE TABLE `incidente` (
  `idIncidentes` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `idCore` int(11) DEFAULT NULL,
  `idPrioridad` int(11) DEFAULT NULL,
  `naturaleza` int(11) DEFAULT NULL,
  `severidad` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motivocaso`
--

DROP TABLE IF EXISTS `motivocaso`;
CREATE TABLE `motivocaso` (
  `idmotivo` int(11) NOT NULL,
  `motivoNombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `naturaleza`
--

DROP TABLE IF EXISTS `naturaleza`;
CREATE TABLE `naturaleza` (
  `idNaturaleza` int(11) NOT NULL,
  `naturalezaNombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prioridad`
--

DROP TABLE IF EXISTS `prioridad`;
CREATE TABLE `prioridad` (
  `idprioridad` int(11) NOT NULL,
  `nombrePrioridad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privacidad`
--

DROP TABLE IF EXISTS `privacidad`;
CREATE TABLE `privacidad` (
  `idvisibilidad` int(11) NOT NULL,
  `visibilidadTipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `idRoles` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_usuarios`
--

DROP TABLE IF EXISTS `roles_usuarios`;
CREATE TABLE `roles_usuarios` (
  `idrol` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `severidad`
--

DROP TABLE IF EXISTS `severidad`;
CREATE TABLE `severidad` (
  `idseveridad` int(11) NOT NULL,
  `severidadnombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

DROP TABLE IF EXISTS `tipo`;
CREATE TABLE `tipo` (
  `idtipo` int(11) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuarios` int(11) NOT NULL,
  `activo` smallint(6) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correoElectronico` varchar(255) DEFAULT NULL,
  `nombreReal` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD PRIMARY KEY (`idAccesos`);

--
-- Indices de la tabla `accesosroles`
--
ALTER TABLE `accesosroles`
  ADD PRIMARY KEY (`idAccesos`,`idRoles`),
  ADD KEY `FK_accesosroles_idRoles` (`idRoles`);

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`idasignacion`),
  ADD KEY `FK_asignacion_idEscenario` (`idEscenario`),
  ADD KEY `FK_asignacion_idUsuario` (`idusuario`),
  ADD KEY `FK_asignacion_idincidente` (`idincidente`);

--
-- Indices de la tabla `casodeprueba`
--
ALTER TABLE `casodeprueba`
  ADD PRIMARY KEY (`idCasodePrueba`),
  ADD KEY `FK_casodeprueba_idmotivo` (`idmotivo`),
  ADD KEY `FK_casodeprueba_tipoVisibilidad` (`tipoVisibilidad`);

--
-- Indices de la tabla `casoprueba_incidente`
--
ALTER TABLE `casoprueba_incidente`
  ADD KEY `FK_asignacion_idcaroprueba` (`idcasoprueba`),
  ADD KEY `idincidente` (`idincidente`);

--
-- Indices de la tabla `core`
--
ALTER TABLE `core`
  ADD PRIMARY KEY (`idCore`);

--
-- Indices de la tabla `ejecucion`
--
ALTER TABLE `ejecucion`
  ADD PRIMARY KEY (`idEjecucion`),
  ADD KEY `FK_ejecucion_idEjecuciones` (`idEjecuciones`),
  ADD KEY `FK_ejecucion_idCasoPrueba` (`idCasoPrueba`);

--
-- Indices de la tabla `ejecuciones`
--
ALTER TABLE `ejecuciones`
  ADD PRIMARY KEY (`idejecuciones`);

--
-- Indices de la tabla `escenario`
--
ALTER TABLE `escenario`
  ADD PRIMARY KEY (`idEscenario`),
  ADD KEY `FK_escenario_idestado` (`idestado`),
  ADD KEY `FK_escenario_idprivacidad` (`idprivacidad`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `estadocaso`
--
ALTER TABLE `estadocaso`
  ADD PRIMARY KEY (`idestado`);

--
-- Indices de la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD PRIMARY KEY (`idIncidentes`),
  ADD KEY `FK_incidente_idCore` (`idCore`),
  ADD KEY `FK_incidente_idPrioridad` (`idPrioridad`),
  ADD KEY `FK_incidente_naturaleza` (`naturaleza`),
  ADD KEY `FK_incidente_tipo` (`tipo`),
  ADD KEY `FK_incidente_severidad` (`severidad`);

--
-- Indices de la tabla `motivocaso`
--
ALTER TABLE `motivocaso`
  ADD PRIMARY KEY (`idmotivo`);

--
-- Indices de la tabla `naturaleza`
--
ALTER TABLE `naturaleza`
  ADD PRIMARY KEY (`idNaturaleza`);

--
-- Indices de la tabla `prioridad`
--
ALTER TABLE `prioridad`
  ADD PRIMARY KEY (`idprioridad`);

--
-- Indices de la tabla `privacidad`
--
ALTER TABLE `privacidad`
  ADD PRIMARY KEY (`idvisibilidad`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRoles`);

--
-- Indices de la tabla `roles_usuarios`
--
ALTER TABLE `roles_usuarios`
  ADD KEY `fk_roles_usuarios` (`idrol`),
  ADD KEY `fk_usuarios_roles` (`idusuario`);

--
-- Indices de la tabla `severidad`
--
ALTER TABLE `severidad`
  ADD PRIMARY KEY (`idseveridad`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`idtipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuarios`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acceso`
--
ALTER TABLE `acceso`
  MODIFY `idAccesos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  MODIFY `idasignacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `casodeprueba`
--
ALTER TABLE `casodeprueba`
  MODIFY `idCasodePrueba` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `core`
--
ALTER TABLE `core`
  MODIFY `idCore` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ejecucion`
--
ALTER TABLE `ejecucion`
  MODIFY `idEjecucion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ejecuciones`
--
ALTER TABLE `ejecuciones`
  MODIFY `idejecuciones` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `escenario`
--
ALTER TABLE `escenario`
  MODIFY `idEscenario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estadocaso`
--
ALTER TABLE `estadocaso`
  MODIFY `idestado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `incidente`
--
ALTER TABLE `incidente`
  MODIFY `idIncidentes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `motivocaso`
--
ALTER TABLE `motivocaso`
  MODIFY `idmotivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `naturaleza`
--
ALTER TABLE `naturaleza`
  MODIFY `idNaturaleza` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prioridad`
--
ALTER TABLE `prioridad`
  MODIFY `idprioridad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `privacidad`
--
ALTER TABLE `privacidad`
  MODIFY `idvisibilidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRoles` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `severidad`
--
ALTER TABLE `severidad`
  MODIFY `idseveridad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `idtipo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuarios` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `accesosroles`
--
ALTER TABLE `accesosroles`
  ADD CONSTRAINT `FK_accesosroles_idAccesos` FOREIGN KEY (`idAccesos`) REFERENCES `acceso` (`idAccesos`),
  ADD CONSTRAINT `FK_accesosroles_idRoles` FOREIGN KEY (`idRoles`) REFERENCES `roles` (`idRoles`);

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `FK_asignacion_idEscenario` FOREIGN KEY (`idEscenario`) REFERENCES `escenario` (`idEscenario`),
  ADD CONSTRAINT `FK_asignacion_idUsuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idUsuarios`),
  ADD CONSTRAINT `FK_asignacion_idincidente` FOREIGN KEY (`idincidente`) REFERENCES `incidente` (`idIncidentes`);

--
-- Filtros para la tabla `casodeprueba`
--
ALTER TABLE `casodeprueba`
  ADD CONSTRAINT `FK_casodeprueba_idmotivo` FOREIGN KEY (`idmotivo`) REFERENCES `motivocaso` (`idmotivo`),
  ADD CONSTRAINT `FK_casodeprueba_tipoVisibilidad` FOREIGN KEY (`tipoVisibilidad`) REFERENCES `estadocaso` (`idestado`);

--
-- Filtros para la tabla `casoprueba_incidente`
--
ALTER TABLE `casoprueba_incidente`
  ADD CONSTRAINT `FK_asignacion_idcaroprueba` FOREIGN KEY (`idcasoprueba`) REFERENCES `casodeprueba` (`idCasodePrueba`),
  ADD CONSTRAINT `casoprueba_incidente_ibfk_1` FOREIGN KEY (`idincidente`) REFERENCES `incidente` (`idIncidentes`);

--
-- Filtros para la tabla `ejecucion`
--
ALTER TABLE `ejecucion`
  ADD CONSTRAINT `FK_ejecucion_idCasoPrueba` FOREIGN KEY (`idCasoPrueba`) REFERENCES `casodeprueba` (`idCasodePrueba`),
  ADD CONSTRAINT `FK_ejecucion_idEjecuciones` FOREIGN KEY (`idEjecuciones`) REFERENCES `ejecuciones` (`idejecuciones`);

--
-- Filtros para la tabla `escenario`
--
ALTER TABLE `escenario`
  ADD CONSTRAINT `FK_escenario_idestado` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idEstado`),
  ADD CONSTRAINT `FK_escenario_idprivacidad` FOREIGN KEY (`idprivacidad`) REFERENCES `privacidad` (`idvisibilidad`);

--
-- Filtros para la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD CONSTRAINT `FK_incidente_idCore` FOREIGN KEY (`idCore`) REFERENCES `core` (`idCore`),
  ADD CONSTRAINT `FK_incidente_idPrioridad` FOREIGN KEY (`idPrioridad`) REFERENCES `prioridad` (`idprioridad`),
  ADD CONSTRAINT `FK_incidente_naturaleza` FOREIGN KEY (`naturaleza`) REFERENCES `naturaleza` (`idNaturaleza`),
  ADD CONSTRAINT `FK_incidente_severidad` FOREIGN KEY (`severidad`) REFERENCES `severidad` (`idseveridad`),
  ADD CONSTRAINT `FK_incidente_tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`idtipo`);

--
-- Filtros para la tabla `roles_usuarios`
--
ALTER TABLE `roles_usuarios`
  ADD CONSTRAINT `fk_roles_usuarios` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idRoles`),
  ADD CONSTRAINT `fk_usuarios_roles` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idUsuarios`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
