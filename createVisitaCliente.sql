CREATE TABLE `visitacliente` (
  `idCliente` int NOT NULL,
  `idVisita` int NOT NULL,
  `nClienteApuntados` int NOT NULL,
  `fecha` date NOT NULL,
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `idVisita` FOREIGN KEY (`idVisita`) REFERENCES `visitaguiada` (`nVisita`)
)

