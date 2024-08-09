DROP DATABASE IF EXISTS ejercicios;
CREATE DATABASE ejercicios;

USE ejercicios;

CREATE TABLE persona(
	nombre TEXT,
    edad INTEGER,
    paisNacimiento TEXT,
    vivo TEXT
);

INSERT INTO persona
VALUES
("Rigoberto", 25, "Wakanda", "Si"),
("Erminia", 82, "España", "No"),
("Kratos", 2300, "Grecia", "Si"),
("Bastián", 11, "Alemania", "Si"),
("Samus", 26, "Zebes", "Si");
