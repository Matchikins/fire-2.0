CREATE TABLE IF NOT EXISTS `disciplinas` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `carga_estagio` int(4) DEFAULT 0,
  `carga_teoria` int(4) DEFAULT 0,
  `carga_total` int(4) DEFAULT 0,
  `requisito_estagio` bit(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
