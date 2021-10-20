CREATE TABLE IF NOT EXISTS `alunos` (
  `id` varchar(255) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  `foto_usuario` varchar(200) DEFAULT 'https://media.istockphoto.com/photos/astronaut-lying-in-the-meadow-picture-id1304263738?s=612x612',
  `endereço_id` bigint(20) DEFAULT NULL,
  `tele_fone` char(10) DEFAULT NULL,
  `tele_fone_celular` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmxrgxsndlnicp97iwrxmw0axg` (`endereço_id`),
  CONSTRAINT `FKmxrgxsndlnicp97iwrxmw0axg` FOREIGN KEY (`endereço_id`) REFERENCES `endereço` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
