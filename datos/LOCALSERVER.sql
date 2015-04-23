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



CREATE TABLE Carrera(
idCarrera CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
descripcion VARCHAR2(60) NOT NULL);




CREATE TABLE Grupo(
idGrupo CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
semestre INT NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY (idCarrera) REFERENCES Carrera(idCarrera));




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
FOREIGN KEY (idCarrera) REFERENCES Carrera(idCarrera),
FOREIGN KEY (idGrupo) REFERENCES Grupo(idGrupo));




CREATE TABLE Faltas(
idFalta CHAR(7) NOT NULL PRIMARY KEY,
fecha DATE NOT NULL,
justificada INT NOT NULL,
matriculaAL CHAR(7) NOT NULL,
idMateria 	CHAR(7) NOT NULL,
FOREIGN KEY(matriculaAL) REFERENCES Alumno(matriculaAL),
FOREIGN KEY(idMateria) REFERENCES Materia(idMateria));





CREATE TABLE Materia(
idMateria CHAR(7) NOT NULL PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
semestre INT NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY(idCarrera) REFERENCES Carrera(idCarrera));




CREATE TABLE HORARIO2
(
    IDHORARIO   CHAR(7),
    IDMATERIA   CHAR(7),
    IDGRUPO     CHAR(7),
    LUNES       CHAR(13),
    SALLUN      VARCHAR(10),
    MARTE       CHAR(13),
    SALMAR      VARCHAR(10),
    MIERC       CHAR(13),
    SALMIE      VARCHAR(10),
    JUEVE       CHAR(13),
    SALJUE      VARCHAR(10),
    VIERN       CHAR(13),
    SALVIE      VARCHAR(10),
    SABAD       CHAR(13),
    SALSAB      VARCHAR(10),
    FOREIGN KEY (idMateria) REFERENCES Materia(idMateria),
    FOREIGN KEY (idGrupo) REFERENCES Grupo(idGrupo)
);



CREATE TABLE Kardex(
idKardex CHAR(7) NOT NULL PRIMARY KEY,
matriculaAL CHAR(7) NOT NULL,
idCarrera CHAR(7) NOT NULL,
FOREIGN KEY (matriculaAL) REFERENCES Alumno(matriculaAL),
FOREIGN KEY (idCarrera) REFERENCES Carrera(idCarrera));



CREATE TABLE Calificaciones(
idCalificacion CHAR(7) NOT NULL PRIMARY KEY,
parcial1 NUMBER NOT NULL,
parcial2 NUMBER NOT NULL,
parcial3 NUMBER NOT NULL,
promedio NUMBER NOT NULL,
idMateria CHAR(7) NOT NULL,
idKardex CHAR(7) NOT NULL,
status VARCHAR2(10 BYTE) NOT NULL;
FOREIGN KEY (idMateria) REFERENCES Materia (idMateria),
FOREIGN KEY (idKardex) REFERENCES Kardex (idKardex));



CREATE TABLE RelProfesorMateria (
    idRelProfesorMateria CHAR(7) NOT NULL PRIMARY KEY,
    matriculaPr CHAR(7) NOT NULL,
    idMateria CHAR(7) NOT NULL,
    idGrupo CHAR(7) NOT NULL,
    FOREIGN KEY (matriculaPR) REFERENCES profesor (matriculaPR),
    FOREIGN KEY (idMateria) REFERENCES materia (idMateria),
    FOREIGN KEY (idGrupo) REFERENCES Grupo (idGrupo)
); 