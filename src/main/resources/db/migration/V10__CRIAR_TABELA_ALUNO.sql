CREATE TABLE IF NOT EXISTS alunos
(
    id                VARCHAR(255)                                                                                                             NOT NULL,
    name              VARCHAR(255)                                                                                                             NULL,
    data_nanscimento  datetime                                                                                                                 NULL,
    last_name         VARCHAR(255)                                                                                                             NULL,
    nacionalidade     VARCHAR(255)                                                                                                             NULL,
    email             VARCHAR(255)                                                                                                             NULL,
    sexo              VARCHAR(255)                                                                                                             NULL,
    estado_civil      VARCHAR(255)                                                                                                             NULL,
    tele_fone_celular CHAR(11)                                                                                                                 NULL,
    tele_fone         CHAR(10)                                                                                                                 NULL,
    enabled           TINYINT(1)   DEFAULT 1                                                                                                   NOT NULL,
    foto_usuario      VARCHAR(200) DEFAULT 'https://media.istockphoto.com/photos/astronaut-lying-in-the-meadow-picture-id1304263738?s=612x612' NULL,
    `endereço_id`     BIGINT                                                                                                                   NULL,
    CONSTRAINT pk_alunos PRIMARY KEY (id)
);

ALTER TABLE alunos
    ADD CONSTRAINT `FK_ALUNOS_ON_ENDEREÇO` FOREIGN KEY (`endereço_id`) REFERENCES `endereço` (id);