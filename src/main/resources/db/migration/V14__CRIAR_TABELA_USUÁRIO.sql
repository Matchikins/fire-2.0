CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_non_expired` tinyint(1) DEFAULT 1,
  `account_non_locked` tinyint(1) DEFAULT 1,
  `credentials_non_expired` tinyint(1) DEFAULT 1,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `aluno_id` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `frist_name` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k8d0f2n7n88w1a16yhua64onx` (`user_name`),
  KEY `FKtskq3hrmo6eh3jg2c72jab2i` (`aluno_id`),
  CONSTRAINT `FKtskq3hrmo6eh3jg2c72jab2i` FOREIGN KEY (`aluno_id`) REFERENCES `alunos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
