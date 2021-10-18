CREATE TABLE  if not exists `entidades_grupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(11) DEFAULT NULL,
  `nome_abreviado_string` varchar(255) DEFAULT NULL,
  `nome_completo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
