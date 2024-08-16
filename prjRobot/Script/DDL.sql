-- database: ../database/ExaBot2k24.sqlite
/*
CopyRight
autor:
fecha:
*/

DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;
DROP TABLE IF EXISTS UsoExotraje;
DROP TABLE IF EXISTS Mantenimiento;

CREATE TABLE IABot (
    IdIABot        INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
);
CREATE TABLE ExaBot (
    IdExaBot       INTEGER PRIMARY KEY autoincrement
    ,IdIABot        INTEGER NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
    ,CONSTRAINT     fk_IABot FOREIGN KEY (IdIABot) REFERENCES  IABot(IdIABot)
);
CREATE TABLE PersonaTipo (
    IdPersonaTipo  INTEGER PRIMARY KEY autoincrement
    ,Nombre         TEXT NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
);
CREATE TABLE Persona (
    IdPersona      INTEGER PRIMARY KEY autoincrement
    ,IdPersonaTipo  INTEGER NOT NULL REFERENCES PersonaTipo(IdPersonaTipo)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre1        TEXT NOT NULL UNIQUE
    ,Nombre2        TEXT NOT NULL UNIQUE
    ,Apellido1      TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      datetime default (datetime('now', '-5 hours'))
);
CREATE TABLE UsoExotraje (
    IdUsoExotraje  INTEGER PRIMARY KEY autoincrement
    ,IdExaBot       INTEGER NOT NULL REFERENCES ExaBot(IdExaBot)
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,FechaUso       DATETIME NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
);

CREATE TABLE Mantenimiento (
    IdMantenimiento INTEGER PRIMARY KEY autoincrement
    ,IdExaBot       INTEGER NOT NULL REFERENCES ExaBot(IdExaBot)
    ,IdPersona      INTEGER NOT NULL REFERENCES Persona(IdPersona)
    ,Descripcion    TEXT NOT NULL
    ,FechaMant      DATETIME NOT NULL
    ,Estado         VARCHAR(1) DEFAULT('A') CHECK (Estado  IN ('A','X'))
    ,FechaCrea      DATETIME DEFAULT (datetime('now', '-5 hours'))
);
