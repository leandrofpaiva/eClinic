# Host: localhost  (Version: 5.1.72-community)
# Date: 2015-09-23 00:22:48
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "enderecos_amostra"
#

DROP TABLE IF EXISTS `enderecos_amostra`;
CREATE TABLE `enderecos_amostra` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uf` varchar(5) DEFAULT NULL,
  `cidade_id` varchar(15) DEFAULT NULL,
  `cidade_nome` varchar(255) DEFAULT NULL,
  `nomeslog` varchar(255) DEFAULT NULL,
  `nomeclog` varchar(255) DEFAULT NULL,
  `bairro_nome` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `logracompl` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Data for table "enderecos_amostra"
#

/*!40000 ALTER TABLE `enderecos_amostra` DISABLE KEYS */;
INSERT INTO `tb_enderecos` (`uf`, `cidade_id`, `cidade_nome`, `nomeslog`, `nomeclog`, `bairro_nome`, `logradouro`, `cep`, `logracompl`, `latitude`, `longitude`) VALUES ('SP','8907','Araçatuba','João Antônio Vasconcelos','Rua João Antônio Vasconcelos - até 627/628','Amizade','Rua','16074320','Rua João Antônio Vasconcelos','-21.1899281837346','-50.44919796878662'),('SP','8907','Araçatuba','Amador Bueno','Rua Amador Bueno - até 680/681','Planalto','Rua','16072335','Rua Amador Bueno','-21.2027059','-50.4611835'),('SP','8907','Araçatuba','Luiz Pereira Barreto','Rua Luiz Pereira Barreto - de 563 ao fim - lado ímpar','Vila São Paulo','Rua','16015445','Rua Luiz Pereira Barreto','-21.2118474','-50.4382724'),('SP','8969','Birigüi','Nove de Julho','Avenida Nove de Julho','Novo Jardim Stábile','Avenida','16204050','Avenida Nove de Julho','-21.2995419','-50.3590989'),('SP','8969','Birigüi','Anhangüera','Rua Anhangüera','Vila Saudades','Rua','16200197','Rua Anhangüera','-21.2949850','-50.3435226'),('MS','4141','Campo Grande','Afonso Pena','Avenida Afonso Pena - de 3593 a 4711 - lado ímpar','Jardim dos Estados','Avenida','79020000','Avenida Afonso Pena','-20.4586775','-54.5849833'),('MS','4141','Campo Grande','Afonso Pena','Avenida Afonso Pena - de 1501 a 1999 - lado ímpar','Centro','Avenida','79002070','Avenida Afonso Pena','-20.4638592','-54.6185188'),('MS','4141','Campo Grande','Calarge','Rua Calarge - até 199/200','Vila Carvalho','Rua','79005100','Rua Calarge','-20.4714656','-54.6191000'),('SP','9668','São Paulo','da Sé','Praça da Sé - lado ímpar','Sé','Praça','01001000','Praça da Sé','-23.5499158','-46.6334289'),('SP','9668','São Paulo','Vinte e Cinco de Março','Rua Vinte e Cinco de Março - até 549/550','Centro','Rua','01021000','Rua Vinte e Cinco de Março','-23.5407911','-46.6320876'),('SP','9668','São Paulo','Venceslau Brás','Rua Venceslau Brás','Centro','Rua','01016000','Rua Venceslau Brás','-23.5493853','-46.6320743'),('RJ','7043','Rio de Janeiro','Teófilo Otoni','Rua Teófilo Otoni - lado par','Centro','Rua','20090070','Rua Teófilo Otoni','-22.9004045','-43.1798259'),('RJ','7043','Rio de Janeiro','Senador Dantas','Rua Senador Dantas - de 73 ao fim - lado ímpar','Centro','Rua','20031204','Rua Senador Dantas','-22.9100225','-43.1776235'),('RJ','7043','Rio de Janeiro','Uruguaiana','Rua Uruguaiana - até 043 - lado ímpar','Centro','Rua','20050093','Rua Uruguaiana','-22.9048234','-43.1796849'),('RJ','7043','Rio de Janeiro','Visconde da Gávea','Rua Visconde da Gávea','Centro','Rua','20221400','Rua Visconde da Gávea','-22.9013586','-43.1895832'),('PR','5895','Cambé','Ari Manduca','Rua Ari Manduca','Jardim Tarobá','Rua','86191270','Rua Ari Manduca','-23.2872327','-51.2636444'),('PR','5895','Cambé','Azulão','Rua Azulão','Conjunto Habitacional Waldomiro M Gomes','Rua','86182310','Rua Azulão','-23.2688305','-51.2911887'),('MG','2754','Belo Horizonte','dos Afonsos','Rua dos Afonsos','Boa Vista','Rua','31070470','Rua dos Afonsos','-19.8908558','-43.8937247'),('MG','2754','Belo Horizonte','Afonso Almeida Magalhães','Rua Afonso Almeida Magalhães','Jaraguá','Rua','31260070','Rua Afonso Almeida Magalhães','-19.8578345','-43.9484616'),('MG','2754','Belo Horizonte','Agripa de Vasconcelos','Rua Agripa de Vasconcelos','Mangabeiras','Rua','30210030','Rua Agripa de Vasconcelos','-19.9593681','-43.9173859'),('BA','988','Salvador','Adilson Leite','Travessa Adilson Leite','Alto do Cabrito','Travessa','40484560','Travessa Adilson Leite','-12.9126561','-38.4745711'),('BA','988','Salvador','Afrânio Peixoto','Avenida Afrânio Peixoto','Escada','Avenida','40710250','Avenida Afrânio Peixoto','-12.8832963','-38.4821649'),('BA','988','Salvador','Dom João VI','Avenida Dom João VI','Fazenda Coutos','Avenida','40730150','Avenida Dom João VI','-12.8493148','-38.4692511');
/*!40000 ALTER TABLE `enderecos_amostra` ENABLE KEYS */;
