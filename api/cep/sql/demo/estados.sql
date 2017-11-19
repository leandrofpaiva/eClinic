# Host: localhost  (Version: 5.1.72-community)
# Date: 2015-09-23 00:22:41
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES latin1 */;

#
# Structure for table "estados"
#

DROP TABLE IF EXISTS `estados`;
CREATE TABLE `estados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uf_id` varchar(11) DEFAULT NULL,
  `nome` varchar(150) NOT NULL,
  `uf` varchar(6) NOT NULL DEFAULT '',
  `capital` varchar(255) DEFAULT NULL,
  `regiao` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `faixainicial1` varchar(255) DEFAULT NULL,
  `faixafinal1` varchar(255) DEFAULT NULL,
  `faixainicial2` varchar(255) DEFAULT NULL,
  `faixafinal2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

#
# Data for table "estados"
#

/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `tb_estados` (`uf_id`, `nome`, `uf`, `capital`, `regiao`, `latitude`, `longitude`, `faixainicial1`, `faixafinal1`, `faixainicial2`, `faixafinal2`) VALUES ('26','São Paulo','SP','São Paulo','Sudeste','-23.5505199','-46.6333094','01000-000','19999-999','',''),('12','Mato Grosso do Sul','MS','Campo Grande','Centro-Oeste','-20.4697105','-54.6201211','79000-000','79999-999','',''),('19','Rio de Janeiro','RJ','Rio de Janeiro','Sudeste','-22.9068467','-43.1728965','20000-000','28999-999','',''),('18','Paraná','PR','Curitiba','Sul','-25.4289541','-49.2671370','80000-000','87999-999','',''),('11','Minas Gerais','MG','Belo Horizonte','Sudeste','-19.9166813','-43.9344931','30000-000','39999-999','',''),('5','Bahia','BA','Salvador','Nordeste','-12.9730401','-38.5023040','40000-000','48999-999','','');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
