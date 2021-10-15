CREATE TABLE IF NOT EXISTS `atividades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nota` double DEFAULT 00,
  `disciplina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK489otcnyqrcj4arrxw5doounc` (`disciplina_id`),
  CONSTRAINT `FK489otcnyqrcj4arrxw5doounc` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplinas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `disciplinas_atividade_id` (
  `disciplinas_data_id` int(11) NOT NULL,
  `atividade_id_id` int(11) NOT NULL,
  UNIQUE KEY `UK_s2qqge619h2n12o0qtu7fdpii` (`atividade_id_id`),
  KEY `FK7712inwm4udcpgbiox4b4upnu` (`disciplinas_data_id`),
  CONSTRAINT `FK3fesam5ltj26eubjcm8phwcho` FOREIGN KEY (`atividade_id_id`) REFERENCES `atividades` (`id`),
  CONSTRAINT `FK7712inwm4udcpgbiox4b4upnu` FOREIGN KEY (`disciplinas_data_id`) REFERENCES `disciplinas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
