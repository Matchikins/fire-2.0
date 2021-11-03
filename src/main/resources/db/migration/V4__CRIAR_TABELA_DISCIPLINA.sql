CREATE TABLE IF NOT EXISTS disciplinas
(
    id                INT AUTO_INCREMENT   NOT NULL,
    name              VARCHAR(255)         NULL,
    carga_teoria      INT        DEFAULT 0 NULL,
    carga_estagio     INT        DEFAULT 0 NULL,
    carga_total       INT DEFAULT 0 NULL,
    requisito_estagio BIT(1)               NULL,
    CONSTRAINT pk_disciplinas PRIMARY KEY (id)
);