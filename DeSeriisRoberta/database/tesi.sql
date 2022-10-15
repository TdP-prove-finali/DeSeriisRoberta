-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.7.3-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database tesi
CREATE DATABASE IF NOT EXISTS `tesi` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `tesi`;

-- Dump della struttura di tabella tesi.dati_regione
CREATE TABLE IF NOT EXISTS `dati_regione` (
  `regione` varchar(30) NOT NULL,
  `prodTotNEElettrica_FOTOVOLTAICO_GWh` decimal(20,6) NOT NULL,
  `produzTotNEElettrica_GWh` decimal(20,6) NOT NULL,
  `prodTotNEElettrica_EOLICO_GWh` decimal(20,6) DEFAULT NULL,
  `potenzaEfficienteLorda%FER` decimal(20,6) NOT NULL,
  `potenzaEfficienteLordaEOLICO_MW` decimal(20,6) DEFAULT NULL,
  `potenzaEfficienteLorda_SOLARE_MW` decimal(20,6) NOT NULL,
  `potenzaEfficienteLordaTotale_MW` decimal(20,6) NOT NULL,
  `numImpianti_EOLICI` smallint(6) NOT NULL,
  `numImpianti _SOLARI` mediumint(9) NOT NULL,
  `FamiglieAllacciate` smallint(6) NOT NULL,
  `SuperficieCentriAbitati_km^2` smallint(6) NOT NULL,
  `popolazioneResidenteMedia` int(11) NOT NULL,
  `consumiFinaliLordiEnergia_GWh` mediumint(9) NOT NULL,
  `consumiCopertiDaImpiantiEol` decimal(20,6) DEFAULT NULL,
  `consumiCopertiDaimpiantiSol` decimal(20,6) NOT NULL,
  `statoRegione` varchar(10) DEFAULT NULL,
  `numeroComuniConMenoDi5000Ab` int(11) DEFAULT NULL,
  PRIMARY KEY (`regione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella tesi.dati_regione: ~20 rows (circa)
/*!40000 ALTER TABLE `dati_regione` DISABLE KEYS */;
REPLACE INTO `dati_regione` (`regione`, `prodTotNEElettrica_FOTOVOLTAICO_GWh`, `produzTotNEElettrica_GWh`, `prodTotNEElettrica_EOLICO_GWh`, `potenzaEfficienteLorda%FER`, `potenzaEfficienteLordaEOLICO_MW`, `potenzaEfficienteLorda_SOLARE_MW`, `potenzaEfficienteLordaTotale_MW`, `numImpianti_EOLICI`, `numImpianti _SOLARI`, `FamiglieAllacciate`, `SuperficieCentriAbitati_km^2`, `popolazioneResidenteMedia`, `consumiFinaliLordiEnergia_GWh`, `consumiCopertiDaImpiantiEol`, `consumiCopertiDaimpiantiSol`, `statoRegione`, `numeroComuniConMenoDi5000Ab`) VALUES
	('Abruzzo', 945.500000, 6288.300000, 410.000000, 58.500000, 269.500000, 754.800000, 3550.200000, 45, 22512, 491, 513, 1289599, 5982, 0.070000, 0.160000, 'IT', 253),
	('Basilicata', 491.300000, 3733.100000, 2423.000000, 93.700000, 1293.300000, 378.100000, 2016.100000, 1417, 8894, 196, 179, 550417, 2609, 0.930000, 0.190000, 'MS', 107),
	('Calabria', 681.300000, 16264.200000, 2132.000000, 43.500000, 1187.200000, 551.900000, 6279.600000, 418, 27386, 489, 805, 1885919, 4893, 0.440000, 0.140000, 'MS', 326),
	('Campania', 981.500000, 11466.300000, 3209.000000, 53.100000, 1742.800000, 877.500000, 6034.700000, 618, 37208, 1627, 1299, 5695951, 16114, 0.200000, 0.060000, 'MS', 344),
	('Emilia-Romagna', 2401.600000, 22751.400000, 71.000000, 34.200000, 45.000000, 2170.000000, 9393.200000, 72, 97561, 1876, 1715, 4454834, 26755, 0.000000, 0.090000, 'PS', 135),
	('Friuli-Venezia Giulia', 600.100000, 7617.100000, 0.000000, 43.700000, 0.000000, 560.900000, 2799.800000, 5, 37168, 432, 688, 1202485, 9533, 0.000000, 0.060000, 'PS', 153),
	('Lazio', 1777.700000, 11995.700000, 137.000000, 27.900000, 71.300000, 1416.200000, 7416.600000, 66, 62715, 2168, 1779, 5738248, 20503, 0.010000, 0.090000, 'PS', 255),
	('Liguria', 116.600000, 2392.200000, 132.000000, 17.300000, 65.900000, 118.900000, 1734.200000, 34, 10126, 658, 526, 1517316, 5799, 0.020000, 0.020000, 'PS', 184),
	('Lombardia', 2441.000000, 48821.500000, 0.000000, 42.700000, 0.100000, 2527.100000, 20247.400000, 11, 145531, 4098, 3051, 9997297, 61798, 0.000000, 0.040000, 'PS', 1040),
	('Marche', 1351.300000, 2204.400000, 35.000000, 75.100000, 19.500000, 1117.700000, 1899.500000, 51, 30953, 578, 510, 1507039, 6478, 0.010000, 0.210000, 'IT', 160),
	('Molise', 231.200000, 3148.500000, 662.000000, 39.200000, 375.900000, 178.400000, 1754.900000, 79, 4470, 91, 115, 298532, 1308, 0.510000, 0.180000, 'MS', 128),
	('Piemonte', 1826.500000, 28723.200000, 26.000000, 46.200000, 18.800000, 1713.800000, 10545.300000, 18, 65004, 1721, 1717, 4292214, 22244, 0.000000, 0.080000, 'PS', 1046),
	('Puglia', 3839.200000, 28308.000000, 4802.000000, 46.200000, 2643.100000, 2899.900000, 12738.800000, 1176, 54271, 1335, 980, 3940118, 15726, 0.310000, 0.240000, 'MS', 87),
	('Sardegna', 1154.700000, 12342.500000, 1677.000000, 53.800000, 1087.500000, 973.800000, 4913.800000, 594, 39690, 61, 631, 1604923, 7983, 0.210000, 0.140000, 'MS', 318),
	('Sicilia', 1911.300000, 15636.600000, 2765.000000, 37.100000, 1925.200000, 1486.600000, 9804.600000, 883, 59824, 1153, 1353, 4858083, 16540, 0.170000, 0.120000, 'MS', 212),
	('Toscana', 946.400000, 16009.200000, 250.000000, 51.900000, 143.200000, 866.500000, 4560.900000, 119, 48620, 1433, 1286, 3680444, 18066, 0.010000, 0.050000, 'PS', 241),
	('Trentino-Alto Adige', 475.300000, 13413.000000, 0.000000, 94.600000, 0.400000, 454.100000, 4172.200000, 10, 26817, 267, 351, 1078265, 6439, 0.000000, 0.070000, 'PS', 119),
	('Umbria', 562.300000, 3107.900000, 3.000000, 67.200000, 2.100000, 499.000000, 1605.200000, 24, 20809, 325, 368, 867589, 4955, 0.000000, 0.110000, 'IT', 63),
	('Valle d\'Aosta', 27.800000, 3614.800000, 4.000000, 99.000000, 2.600000, 25.400000, 1064.800000, 5, 2592, 29, 58, 124465, 901, 0.000000, 0.030000, 'PS', 73),
	('Veneto', 2178.800000, 13810.000000, 23.000000, 55.500000, 13.400000, 2079.500000, 6577.100000, 15, 133687, 1813, 2375, 4865793, 29155, 0.000000, 0.070000, 'PS', 291);
/*!40000 ALTER TABLE `dati_regione` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
