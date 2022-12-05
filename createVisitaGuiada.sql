CREATE TABLE `visitaguiada` (
  `nVisita` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `maxVisitantes` int NOT NULL,
  `puntoPartida` varchar(45) NOT NULL,
  `cursoAcademico` varchar(45) NOT NULL,
  `tematica` varchar(45) NOT NULL,
  `coste` double NOT NULL,
  `idEmpleado` int NOT NULL,
  PRIMARY KEY (`nVisita`),
  CONSTRAINT `idEmpleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleadoproyect` (`idEmpleado`)
) 

