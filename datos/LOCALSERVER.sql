CREATE TABLE Administrador(
matriculaAdm CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
apellidoPaterno VARCHAR2(50) NOT NULL,
apellidoMaterno VARCHAR2(50) NOT NULL,
telefonoMovil CHAR(15),
telefonoCasa CHAR(15),
calle VARCHAR2(50) NOT NULL,
colonia VARCHAR(50) NOT NULL,
numero INT NOT NULL,
correoPersonal VARCHAR2(50) NOT NULL,
correoInstitucional VARCHAR2(50) NOT NULL,
contrasena VARCHAR2(30) NOT NULL);

INSERT INTO SYSTEM.Administrador VALUES('ADM0001','Arael','Gomez','Prueba','614-345-5474','614-123-1234','Calle Refujio',
'CENTRO',1242,'arely@hotmail.com','adm0000@inst.com','system');

CREATE TABLE Profesor(
matriculaPr CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
apellidoPaterno VARCHAR2(50) NOT NULL,
apellidoMaterno VARCHAR2(50) NOT NULL,
telefonoMovil CHAR(15),
telefonoCasa CHAR(15),
calle VARCHAR2(50) NOT NULL,
colonia VARCHAR(50) NOT NULL,
numero INT NOT NULL,
correoPersonal VARCHAR2(50) NOT NULL,
correoInstitucional VARCHAR2(50) NOT NULL,
contrasena VARCHAR2(30) NOT NULL);



INSERT INTO SYSTEM.Profesor VALUES('PR00001','Luis','Bustillos','Carmona','614-453-5474','614-754-1234','Calle Refujio dos',
'Campesina',1442,'luisa@hotmail.com','pr00001@inst.com','system');


CREATE TABLE Carrera(
idCarrera CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
descripcion VARCHAR2(60) NOT NULL);


INSERT INTO SYSTEM.Carrera VALUES('CARISHW','Ingenieria En Sistemas Hardware','Es una carrera orientada a los sistemas informaticos');
INSERT INTO SYSTEM.Carrera VALUES('CARISSW','Ingenieria En Sistemas Software','Es una carrera orientada a los sistemas en software');




CREATE TABLE Salon(
idSalon CHAR(7) NOT NULL PRIMARY KEY ,
numeroSalon INT NOT NULL,
edificio VARCHAR2(10) NOT NULL);




INSERT INTO SYSTEM.Salon VALUES('SAL0001',1,'Edificio A');
INSERT INTO SYSTEM.Salon VALUES('SAL0002',2,'Edificio A');
INSERT INTO SYSTEM.Salon VALUES('SAL0003',3,'Edificio B');




CREATE TABLE Grupo(
idGrupo CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
idSalon CHAR(7) NOT NULL,
semestre INT NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY (idCarrera) REFERENCES SYSTEM.Carrera(idCarrera),
FOREIGN KEY (idSalon) REFERENCES SYSTEM.Salon(idSalon)); 




INSERT INTO SYSTEM.Grupo VALUES('GRU0001','Hardware 1HW1','SAL0001','1','CARISHW');
INSERT INTO SYSTEM.Grupo VALUES('GRU0002','Hardware 1HW2','SAL0002','2','CARISHW');
INSERT INTO SYSTEM.Grupo VALUES('GRU0003','Software 1SW1','SAL0003','6','CARISSW');




CREATE TABLE Alumno(
matriculaAl CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
apellidoPaterno VARCHAR2(50) NOT NULL,
apellidoMaterno VARCHAR2(50) NOT NULL,
telefonoMovil CHAR(15),
telefonoCasa CHAR(15),
calle VARCHAR2(50) NOT NULL,
colonia VARCHAR(50) NOT NULL,
numero INT NOT NULL,
correoPersonal VARCHAR2(50) NOT NULL,
correoInstitucional VARCHAR2(50) NOT NULL,
contraseña VARCHAR2(30) NOT NULL,
idCarrera CHAR(7) NOT NULL,
idGrupo CHAR(7) NOT NULL,
FOREIGN KEY (idCarrera) REFERENCES SYSTEM.Carrera(idCarrera),
FOREIGN KEY (idGrupo) REFERENCES SYSTEM.Grupo(idGrupo));


INSERT INTO SYSTEM.Alumno VALUES('AL00001','Juan','Jimenez','Lozano','614-542-7523','625-623-7432','Rio Colorado',
'Rios',1241,'juan_lo@hotmail.com','AL00001@inst.com','system1234','CARISSW','GRU0003');




CREATE TABLE Faltas(
idFalta CHAR(7) NOT NULL PRIMARY KEY,
fecha DATE NOT NULL,
justificada INT NOT NULL,
matriculaAL CHAR(7) NOT NULL,
FOREIGN KEY(matriculaAL) REFERENCES SYSTEM.Alumno(matriculaAL));


INSERT INTO SYSTEM.Faltas VALUES('FALT001',TO_DATE('27-05-2015','DD-MM-YYYY'),0,'AL00001');
INSERT INTO SYSTEM.Faltas VALUES('FALT002',TO_DATE('22-05-2015','DD-MM-YYYY'),1,'AL00001');




CREATE TABLE Materia(
idMateria CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
semestre INT NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY(idCarrera) REFERENCES SYSTEM.Carrera(idCarrera));


INSERT INTO SYSTEM.Materia VALUES('MAT0001','Legislacion de la informatica',6,'CARISHW');
INSERT INTO SYSTEM.Materia VALUES('MAT0002','Calculo Integral y Diferencial ',1,'CARISSW');


CREATE TABLE Horario(
idHorario CHAR(7) NOT NULL PRIMARY KEY,
idMateria CHAR(7) NOT NULL,
idGrupo CHAR(7) NOT NULL,
dia INT NOT NULL,
matriculaPr CHAR(7) NOT NULL,
horaInicio CHAR(5) NOT NULL,
horaFin CHAR(5) NOT NULL,
FOREIGN KEY (idMateria) REFERENCES SYSTEM.Materia(idMateria),
FOREIGN KEY (idGrupo) REFERENCES SYSTEM.Grupo(idGrupo),
FOREIGN KEY (matriculaPr) REFERENCES SYSTEM.Profesor(matriculaPr));

INSERT INTO SYSTEM.Horario VALUES('HOR0001','MAT0001','GRU0001',1,'PR00001','15:00','16:00');



CREATE TABLE Kardex(
idKardex CHAR(7) NOT NULL PRIMARY KEY,
matriculaAL CHAR(7) NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY (matriculaAL) REFERENCES SYSTEM.Alumno(matriculaAL),
FOREIGN KEY (idCarrera) REFERENCES SYSTEM.Carrera(idCarrera));

INSERT INTO SYSTEM.Kardex VALUES ('KAR0001','AL00001','CARISHW');


CREATE TABLE Calificaciones(
idCalificacion CHAR(7) NOT NULL PRIMARY KEY,
parcial1 NUMBER NOT NULL,
parcial2 NUMBER NOT NULL,
parcial3 NUMBER NOT NULL,
promedio NUMBER NOT NULL,
idMateria CHAR(7) NOT NULL,
idKardex CHAR(7) NOT NULL,
FOREIGN KEY (idMateria) REFERENCES SYSTEM.Materia (idMateria),
FOREIGN KEY (idKardex) REFERENCES SYSTEM.Kardex (idKardex));

INSERT INTO SYSTEM.Calificaciones VALUES('CAL0001',7,4,8,5,'MAT0001','KAR0001');



CREATE TABLE RelProfesorMateria (
    idRelProfesorMateria CHAR(7) NOT NULL PRIMARY KEY,
    matriculaPr CHAR(7) NOT NULL,
    idMateria CHAR(7) NOT NULL,
    idGrupo CHAR(7) NOT NULL,
    FOREIGN KEY (matriculaPR) REFERENCES profesor (matriculaPR),
    FOREIGN KEY (idMateria) REFERENCES materia (idMateria),
    FOREIGN KEY (idGrupo) REFERENCES Grupo (idGrupo)
); 