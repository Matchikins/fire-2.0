CREATE TABLE if not exists atividades
(
    id            INT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(255)       NULL,
    nota          DOUBLE             NULL,
    disciplina_id INT                NULL,
    data          datetime           NULL,
    CONSTRAINT pk_atividades PRIMARY KEY (id)
);

ALTER TABLE atividades
    ADD CONSTRAINT FK_ATIVIDADES_ON_DISCIPLINAID FOREIGN KEY (disciplina_id) REFERENCES disciplinas (id);