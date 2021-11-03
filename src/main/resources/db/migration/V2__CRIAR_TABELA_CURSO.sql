CREATE TABLE IF NOT EXISTS curso
(
    id        INT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)       NULL,
    is_online BIT(1)             NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);