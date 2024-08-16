-- database: ../database/ReinaFis.sqlite
/*
CopyRight
autor:
fecha:
*/

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS OpcReina;
DROP TABLE IF EXISTS VotoReina;
DROP TABLE IF EXISTS Cuenta;

CREATE TABLE Sexo (
    IdSexo          INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE Persona (
    IdPersona      INTEGER PRIMARY KEY autoincrement
    ,IdSexo         INTEGER NOT NULL REFERENCES Sexo(IdSexo)
    ,Cedula         VARCHAR(10) NOT NULL UNIQUE
    ,CodigoUnico    VARCHAR(10) NOT NULL UNIQUE
    ,Nombre1        TEXT NOT NULL
    ,Nombre2        TEXT NOT NULL
    ,Apellido1      TEXT NOT NULL
    ,Apellido2      TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default (datetime('now', '-5 hours'))
);

CREATE TABLE OpcReina (
    IdOpcReina      INTEGER PRIMARY KEY autoincrement
    ,IdPersona      INTEGER REFERENCES Persona(IdPersona)
    ,Votos          INTEGER NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default (datetime('now', '-5 hours'))
);

CREATE TABLE VotoReina (
    IdVotoReina     INTEGER PRIMARY KEY autoincrement
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,IdOpcReina     INTEGER REFERENCES OpcReina(IdOpcReina)
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default (datetime('now', '-5 hours'))
);

CREATE TABLE Cuenta (
    IdPersona       INTEGER PRIMARY KEY NOT NULL UNIQUE REFERENCES Persona(IdPersona)
    ,Usuario        VARCHAR(20) NOT NULL
    ,Contrasena     VARCHAR(20) NOT NULL
    ,Correo         VARCHAR(20) NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default (datetime('now', '-5 hours'))
);