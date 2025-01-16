CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    data_nascimento DATE,
    genero VARCHAR(20),
    email VARCHAR(100),
    PRIMARY KEY(id)
);
