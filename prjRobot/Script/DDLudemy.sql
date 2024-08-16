-- database: ../database/Udemy.sqlite
/*
CopyRight
autor:
fecha:
*/

DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS Localidad;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Cursos;
DROP TABLE IF EXISTS CursosAlumno;
DROP TABLE IF EXISTS CursosTutor;
DROP TABLE IF EXISTS Cuenta;

CREATE TABLE CatalogoTipo (
    IdCatalogoTipo INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
);

CREATE TABLE Catalogo (
    IdCatalogo     INTEGER PRIMARY KEY autoincrement
    ,IdCatalogoTipo INTEGER NOT NULL REFERENCES CatalogoTipo(IdCatalogoTipo)
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
);

CREATE TABLE Localidad (
    IdLocalidad    INTEGER PRIMARY KEY autoincrement
    ,IdPadreLocalidad INTEGER REFERENCES Localidad(IdLocalidad)
    ,IdCatalogo     INTEGER NOT NULL REFERENCES Catalogo(idCatalogo)
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT current_timestamp
);

CREATE TABLE Persona (
    IdPersona      INTEGER PRIMARY KEY autoincrement
    ,IdSexo         INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,IdLocalidad    INTEGER NOT NULL REFERENCES Localidad(IdLocalidad)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre1        TEXT NOT NULL
    ,Nombre2        TEXT NOT NULL
    ,Apellido1      TEXT NOT NULL
    ,Apellido2      TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default current_timestamp
);

CREATE TABLE Cursos (
    IdCursos       INTEGER PRIMARY KEY autoincrement
    ,IdCatalogo     INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,Titulo         TEXT NOT NULL
    ,Descripcion    TEXT NOT NULL
    ,Valor          REAL NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default current_timestamp
);

CREATE TABLE CursosAlumno (
    IdCursosAlumno INTEGER PRIMARY KEY autoincrement
    ,IdCursos       INTEGER NOT NULL REFERENCES Cursos(IdCursos)
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,IdFormaPago    INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    ,FechaInscrip   datetime NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default current_timestamp
);

CREATE TABLE CursosTutor (
    IdCursosTutor INTEGER PRIMARY KEY autoincrement
    ,IdCursos       INTEGER NOT NULL REFERENCES Cursos(IdCursos)
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,Ingresos       REAL NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default current_timestamp
);

CREATE TABLE Cuenta (
    IdCuenta       INTEGER PRIMARY KEY autoincrement
    ,IdPersona      INTEGER NOT NULL UNIQUE REFERENCES Persona(IdPersona)
    ,Usuario        VARCHAR(20) NOT NULL
    ,Contrasena     VARCHAR(20) NOT NULL
    ,Correo         VARCHAR(30) NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default current_timestamp
);