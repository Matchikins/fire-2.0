INSERT INTO `atividades`
(`id`,`data`,`nome`,`nota`,`disciplina_id`)
VALUES
(1,CURRENT_TIMESTAMP,"prova_Teste",7,1),
(2,CURRENT_TIMESTAMP,"atividade_Teste",1,1),
(3,CURRENT_TIMESTAMP,"Trabalho_Teste",1,1),
(4,CURRENT_TIMESTAMP,"Participação_Teste",1,1);

INSERT INTO `disciplinas_atividade_id`
(`disciplinas_data_id`,`atividade_id_id`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4);

