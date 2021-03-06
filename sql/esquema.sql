DROP TABLE IF EXISTS medico;

CREATE TABLE medico (
	id	SERIAL NOT NULL PRIMARY KEY,
	nombre1	VARCHAR(30) NOT NULL,
	nombre2 VARCHAR(30),
	nombre3 VARCHAR(30),
	apellido1 VARCHAR(30) NOT NULL,
	apellido2 VARCHAR(30),
	apellido3 VARCHAR(30),
	sexo	CHAR(1) NOT NULL,
	fechanac	TIMESTAMP WITHOUT TIME ZONE,
	finado	BOOLEAN NOT NULL DEFAULT FALSE,
	cedulaprof VARCHAR(40)
);

