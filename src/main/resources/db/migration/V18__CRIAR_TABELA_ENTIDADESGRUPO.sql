CREATE TABLE  if not exists `entidades_grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) DEFAULT NULL,
  `nome_abreviado_string` varchar(255) DEFAULT NULL,
  `nome_completo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
