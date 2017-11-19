# Host: localhost  (Version: 5.1.72-community)
# Date: 2013 00:22:59
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "cidades"
#

DROP TABLE IF EXISTS `cidades`;
CREATE TABLE `cidades` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cidade_id` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `uf` varchar(10) DEFAULT NULL,
  `ibge` varchar(15) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `populacao` varchar(255) DEFAULT NULL,
  `areakm` varchar(20) DEFAULT NULL,
  `densidade` varchar(255) DEFAULT NULL,
  `gentilico` varchar(255) DEFAULT NULL,
  `capital` varchar(255) DEFAULT NULL,
  `distancia_capital` varchar(255) DEFAULT NULL,
  `tempo_percurso` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `faixainicial1` varchar(255) DEFAULT NULL,
  `faixafinal1` varchar(255) DEFAULT NULL,
  `faixainicial2` varchar(255) DEFAULT NULL,
  `faixafinal2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "cidades"
#

;

/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `tb_cidades` (`cidade_id`, `tipo`, `nome`, `uf`, `ibge`, `cep`, `populacao`, `areakm`, `densidade`, `gentilico`, `capital`, `distancia_capital`, `tempo_percurso`, `latitude`, `longitude`, `faixainicial1`, `faixafinal1`,  `faixainicial2`, `faixafinal2`) VALUES ('8907','Municipio','Araçatuba','SP','3502804','LOC','192.757','1.167,402','155,54','araçatubense','São Paulo','569 Km + 320 metros','7 horas 6 minutos','-21.2081188','-50.4405757','160001','161299','-','-'),('8969','Municipio','Birigüi','SP','3506508','LOC','118.352','530,030','204,79','biriguiense','São Paulo','552 Km + 966 metros','6 horas 5 minutos','-21.2915812','-50.3437261','162001','162099','-','-'),('4141','Municipio','Campo Grande','MS','5002704','LOC','853.622','8.092,951','97,22','campo-grandense','Campo Grande','1 metro','1 minuto','-20.4697105','-54.6201211','790001','791299','-','-'),('9668','Municipio','São Paulo','SP','3550308','LOC','11.967.825','1.521,110','7.398,26','paulistano','São Paulo','1 metro','1 minuto','-23.5505199','-46.6333094','010001','059999','080000','084999'),('7043','Municipio','Rio de Janeiro','RJ','3304557','LOC','6.476.631','1.197,463','5.265,82','carioca','Rio de Janeiro','2 Km + 017 metros','1 minuto','-22.9116324','-43.1882863','200001','237999','-','-'),('5895','Municipio','Cambé','PR','4103701','LOC','103.822','495,376','195,47','cambeense','Curitiba','380 Km + 168 metros','4 horas 45 minutos','-23.2770520','-51.2803152','861801','861999','-','-'),('2754','Municipio','Belo Horizonte','MG','3106200','LOC','2.502.557','331,401','7.167,00','belo-horizontino','Belo Horizonte','1 metro','1 minuto','-19.9166813','-43.9344931','300001','319999','-','-'),('988','Municipio','Salvador','BA','2927408','LOC','2.921.087','692,819','3.859,44','soteropolitano','Salvador','1 metro','1 minuto','-12.9730401','-38.5023040','400001','425999','-','-');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
