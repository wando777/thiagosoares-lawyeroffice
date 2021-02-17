CREATE TABLE jogadores(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	cpf VARCHAR(50) NOT NULL
); --ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO jogadores (nome, email, cpf) values ('Jose','teste@gmail.com','12345678910');
INSERT INTO jogadores (nome, email, cpf) values ('Pedro','teste@gmail.com','12345678910');
