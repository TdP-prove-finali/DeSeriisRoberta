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

-- Dump della struttura di tabella tesi.consumi
CREATE TABLE IF NOT EXISTS `consumi` (
  `regione` varchar(30) NOT NULL,
  `famiglie` double NOT NULL DEFAULT 0,
  `superficieCA` varchar(10) NOT NULL,
  `popolazioneResM` int(11) NOT NULL,
  `consumiFLE` varchar(10) NOT NULL,
  `consumiCopE` varchar(10) DEFAULT NULL,
  `consumiCopS` varchar(10) DEFAULT NULL,
  `statoRegione` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella tesi.consumi: ~32 rows (circa)
/*!40000 ALTER TABLE `consumi` DISABLE KEYS */;
REPLACE INTO `consumi` (`regione`, `famiglie`, `superficieCA`, `popolazioneResM`, `consumiFLE`, `consumiCopE`, `consumiCopS`, `statoRegione`) VALUES
	('Piemonte', 1721, '1717', 4292214, '22243,6', '0%', '8%', 'PS'),
	('Valle d\'Aosta/Vall?e d\'Aoste', 29, '57,7', 124465, '901,2', '0%', '3%', 'PS'),
	('Lombardia', 4098, '3050,8', 9997297, '61798,4', '0%', '4%', 'PS'),
	('Trentino-Alto Adige/Sdtirol', 267, '351,4', 1078265, '6438,7', '0%', '7%', 'PS'),
	('Veneto', 1813, '2375,3', 4865793, '29154,6', '0%', '7%', 'PS'),
	('Friuli-Venezia Giulia', 432, '688,3', 1202485, '9533,1', '0%', '6%', 'PS'),
	('Liguria', 658, '525,7', 1517316, '5798,7', '2%', '2%', 'PS'),
	('Emilia-Romagna', 1876, '1714,7', 4454834, '26754,5', '0%', '9%', 'PS'),
	('Toscana', 1433, '1286,2', 3680444, '18065,6', '1%', '5%', 'PS'),
	('Umbria', 325, '368', 867589, '4954,7', '0%', '11%', 'IT'),
	('Marche', 578, '509,9', 1507039, '6477,9', '1%', '21%', 'IT'),
	('Lazio', 2168, '1778,9', 5738248, '20503,2', '1%', '9%', 'PS'),
	('Abruzzo', 491, '513,5', 1289599, '5981,9', '7%', '16%', 'IT'),
	('Molise', 91, '114,6', 298532, '1307,9', '51%', '18%', 'MS'),
	('Campania', 1627, '1298,7', 5695951, '16114,3', '20%', '6%', 'MS'),
	('Puglia', 1335, '979,6', 3940118, '15726', '31%', '24%', 'MS'),
	('Basilicata', 196, '179,2', 550417, '2608,5', '93%', '19%', 'MS'),
	('Calabria', 489, '805,4', 1885919, '4893,3', '44%', '14%', 'MS'),
	('Sicilia', 1153, '1353,5', 4858083, '16539,6', '17%', '12%', 'MS'),
	('Sardegna', 61, '630,5', 1604923, '7983', '21%', '14%', 'MS'),
	('Italia', 20841, '20298,6', 59449527, '283778,7', '7%', '9%', NULL),
	('    - Nord', 10894, '10480,8', 27532667, '130069,6', '0%', '8%', NULL),
	('        - Nord-ovest', 6506, '5351,1', 15931291, '114097,8', '0%', '4%', NULL),
	('        - Nord-est', 4388, '5129,7', 11601376, '15971,8', '1%', '35%', NULL),
	('    - Centro', 4504, '3942,9', 11793320, '55573,5', '1%', '8%', NULL),
	('    - Centro-Nord', 15398, '14423,7', 39325987, '185643,1', '0%', '8%', NULL),
	('    - Mezzogiorno', 5443, '5874,9', 20123541, '71154,5', '25%', '14%', NULL),
	('        - Sud', 4229, '3890,9', 13660535, '46631,9', '29%', '15%', NULL),
	('        - Isole', 1214, '1984', 6463006, '24522,6', '18%', '13%', NULL),
	('    - Regioni piu\' sviluppate', 14495, '13545,9', 36951359, '168638,4', '', '', NULL),
	('    - Regioni in transizione', 1394, '1391,3', 3664227, '17414,5', '', '', NULL),
	('    - Regioni meno sviluppate', 4952, '5361,4', 18833942, '65172,6', '', '', NULL);
/*!40000 ALTER TABLE `consumi` ENABLE KEYS */;

-- Dump della struttura di tabella tesi.energia
CREATE TABLE IF NOT EXISTS `energia` (
  `regione` varchar(30) DEFAULT NULL,
  `prodTotNEELett_GWh` varchar(10) DEFAULT NULL,
  `prodNEElett_Eol_GWh` varchar(10) DEFAULT NULL,
  `prodNEElett_Sol_GWh` varchar(10) DEFAULT NULL,
  `potEffLordaPerc` varchar(10) DEFAULT NULL,
  `potEffLordaTot_MW` varchar(10) DEFAULT NULL,
  `potEffLordaEol_MW` varchar(10) DEFAULT NULL,
  `potEffLordaSol_MW` varchar(10) DEFAULT NULL,
  `numImpiantiEol` varchar(10) DEFAULT NULL,
  `numImpiantiSol` varchar(10) DEFAULT NULL,
  `rendimentoEolPerc` varchar(10) DEFAULT NULL,
  `rendimentoSolPerc` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dump dei dati della tabella tesi.energia: ~46 rows (circa)
/*!40000 ALTER TABLE `energia` DISABLE KEYS */;
REPLACE INTO `energia` (`regione`, `prodTotNEELett_GWh`, `prodNEElett_Eol_GWh`, `prodNEElett_Sol_GWh`, `potEffLordaPerc`, `potEffLordaTot_MW`, `potEffLordaEol_MW`, `potEffLordaSol_MW`, `numImpiantiEol`, `numImpiantiSol`, `rendimentoEolPerc`, `rendimentoSolPerc`) VALUES
	('Piemonte', '28723,2', '26', '1826,5', '46,2', '10545,3', '18,8', '1713,8', '18', '65004', ' 15,79 ', ' 12,17 '),
	('Valle d\'Aosta/Vall?e d\'Aoste', '3614,8', '3,7', '27,8', '99', '1064,8', '2,6', '25,4', '5', '2592', ' 16,25 ', ' 12,49 '),
	('Lombardia', '48821,5', '0', '2441', '42,7', '20247,4', '0,1', '2527,1', '11', '145531', '0', ' 11,03 '),
	('Trentino-Alto Adige/Sdtirol', '13413', '0', '475,3', '94,6', '4172,2', '0,4', '454,1', '10', '26817', '0', ' 11,95 '),
	('Veneto', '13810', '22,6', '2178,8', '55,5', '6577,1', '13,4', '2079,5', '15', '133687', ' 19,25 ', ' 11,96 '),
	('Friuli-Venezia Giulia', '7617,1', '0', '600,1', '43,7', '2799,8', '0', '560,9', '5', '37168', '0', ' 12,21 '),
	('Liguria', '2392,2', '132,2', '116,6', '17,3', '1734,2', '65,9', '118,9', '34', '10126', ' 22,90 ', ' 11,19 '),
	('Emilia-Romagna', '22751,4', '71,3', '2401,6', '34,2', '9393,2', '45', '2170', '72', '97561', ' 18,09 ', ' 12,63 '),
	('Toscana', '16009,2', '250,2', '946,4', '51,9', '4560,9', '143,2', '866,5', '119', '48620', ' 19,95 ', ' 12,47 '),
	('Umbria', '3107,9', '2,5', '562,3', '67,2', '1605,2', '2,1', '499', '24', '20809', ' 13,59 ', ' 12,86 '),
	('Marche', '2204,4', '35,2', '1351,3', '75,1', '1899,5', '19,5', '1117,7', '51', '30953', ' 20,61 ', ' 13,80 '),
	('Lazio', '11995,7', '136,6', '1777,7', '27,9', '7416,6', '71,3', '1416,2', '66', '62715', ' 21,87 ', ' 14,33 '),
	('Abruzzo', '6288,3', '410,2', '945,5', '58,5', '3550,2', '269,5', '754,8', '45', '22512', ' 17,38 ', ' 14,30 '),
	('Molise', '3148,5', '662', '231,2', '39,2', '1754,9', '375,9', '178,4', '79', '4470', ' 20,10 ', ' 14,79 '),
	('Campania', '11466,3', '3209,2', '981,5', '53,1', '6034,7', '1742,8', '877,5', '618', '37208', ' 21,02 ', ' 12,77 '),
	('Puglia', '28308', '4801,9', '3839,2', '46,2', '12738,8', '2643,1', '2899,9', '1176', '54271', ' 20,74 ', ' 15,11 '),
	('Basilicata', '3733,1', '2423', '491,3', '93,7', '2016,1', '1293,3', '378,1', '1417', '8894', ' 21,39 ', ' 14,83 '),
	('Calabria', '16264,2', '2132,4', '681,3', '43,5', '6279,6', '1187,2', '551,9', '418', '27386', ' 20,50 ', ' 14,09 '),
	('Sicilia', '15636,6', '2765,4', '1911,3', '37,1', '9804,6', '1925,2', '1486,6', '883', '59824', ' 16,40 ', ' 14,68 '),
	('Sardegna', '12342,5', '1677,1', '1154,7', '53,8', '4913,8', '1087,5', '973,8', '594', '39690', ' 17,60 ', ' 13,54 '),
	('Italia', '271647,9', '18761,6', '24941,5', '47,5', '119108,9', '10906,8', '21650,1', '5660', '935838', ' 19,64 ', ' 13,15 '),
	('    - Nord', '141143,2', '255,8', '10067,7', '47,6', '56534', '146,2', '9649,7', '170', '518486', ' 19,97 ', ' 11,91 '),
	('        - Nord-ovest', '83551,7', '161,9', '4411,9', '44,3', '33591,7', '87,4', '4385,2', '68', '223253', ' 21,15 ', ' 11,49 '),
	('        - Nord-est', '57591,5', '93,9', '5655,8', '52,4', '22942,3', '58,8', '5264,5', '102', '295233', ' 18,23 ', ' 12,26 '),
	('    - Centro', '33317,2', '424,5', '4637,7', '44,8', '15482,2', '236,1', '3899,4', '260', '163097', ' 20,52 ', ' 13,58 '),
	('    - Centro-Nord', '174460,4', '680,3', '14705,4', '47', '72016,2', '382,3', '13549,1', '430', '681583', ' 20,31 ', ' 12,39 '),
	('    - Mezzogiorno', '97187,5', '18081,2', '10236', '48,3', '47092,7', '10524,5', '8101', '5230', '254255', ' 19,61 ', ' 14,42 '),
	('        - Sud', '69208,4', '13638,7', '7170', '50,9', '32374,3', '7511,8', '5640,6', '3753', '154741', ' 20,73 ', ' 14,51 '),
	('        - Isole', '27979,1', '4442,5', '3066', '42,7', '14718,4', '3012,7', '2460,4', '1477', '99514', ' 16,83 ', ' 14,23 '),
	('    - Regioni pi? sviluppate', '169148,1', '642,6', '12791,8', '127,3', '68511,5', '360,7', '11932,4', '355', '629821', ' 20,34 ', ' 12,24 '),
	('    - Regioni in transizione', '17308', '174,3', '3691,3', '170,2', '10921,3', '92,9', '3032,9', '141', '114477', ' 21,42 ', ' 13,89 '),
	('    - Regioni meno sviluppate', '90899,2', '17671', '9290,5', '366,5', '43542,5', '10255', '7346,2', '5185', '231743', ' 19,67 ', ' 14,44 '),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', ''),
	('', '', '', '', '', '', '', '', '', '', '', '');
/*!40000 ALTER TABLE `energia` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
