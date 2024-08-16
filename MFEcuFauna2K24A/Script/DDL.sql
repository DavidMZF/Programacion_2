-- database: ../DataBase/FMEcuFauna.sqlite
/*
|------------------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.                     |
| francisco.morales01@epn.edu.ec        Francisco Morales    |
|------------------------------------------------------------|
Autor : Francisco Morales 
Fecha : 15.agosto.2k24
Script: Creacion de la estructura de datos para MFEcuFauna
*/

DROP TABLE IF EXISTS MFHormiga;
DROP TABLE IF EXISTS MFAlimento;
DROP TABLE IF EXISTS MFLocalidad;
DROP TABLE IF EXISTS MFCatalogo;
DROP TABLE IF EXISTS MFCatalogoTipo;

CREATE TABLE MFCatalogoTipo (
     IdCatalogoTipo     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(15) NOT NULL UNIQUE

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE MFCatalogo (
     IdCatalogo         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo     INTEGER     NOT NULL REFERENCES MFCatalogoTipo (IdCatalogoTipo)
    ,Nombre             VARCHAR(15) NOT NULL UNIQUE

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE MFLocalidad (
     IdLocalidad        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidadPadre   INTEGER
    ,IdCatalogo         INTEGER     NOT NULL REFERENCES MFCatalogo (IdCatalogo)
    ,Nombre             VARCHAR(20) NOT NULL UNIQUE

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME

    ,FOREIGN KEY (IdLocalidadPadre) REFERENCES MFLocalidad(IdLocalidad)
);

CREATE TABLE MFAlimento (
     IdAlimento         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogo         INTEGER     NOT NULL REFERENCES MFCatalogo (IdCatalogo)
    ,Nombre             VARCHAR(15) NOT NULL UNIQUE

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE MFHormiga (
     IdHormiga          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdTipoHormiga      INTEGER     NOT NULL REFERENCES MFCatalogo (IdCatalogo)
    ,IdSexo             INTEGER     REFERENCES MFCatalogo (IdCatalogo)
    ,IdProvincia        INTEGER     NOT NULL REFERENCES MFLocalidad (IdLocalidad)
    ,IdGenoAlimento     INTEGER     REFERENCES MFAlimento (IdAlimento)
    ,IdIngestaNativa    INTEGER     REFERENCES MFAlimento (IdAlimento)

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);