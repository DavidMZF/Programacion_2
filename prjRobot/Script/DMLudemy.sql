-- database: ../database/Udemy.sqlite

INSERT INTO CatalogoTipo( Nombre) VALUES
    ('Sexo')
    ,('Curso Tipo')
    ,('Localidad Tipo')
    ,('Forma Pago');

INSERT INTO Catalogo( IdCatalogoTipo, Nombre) VALUES
    ( 1, 'Masculino')
    ,( 1, 'Femenino')
    ,( 1, 'Hibrido')
    ,( 2, 'Desarrollo')
    ,( 2, 'Negocios')
    ,( 2, 'Finanzas')
    ,( 2, 'Informatica')
    ,( 2, 'Diseño')
    ,( 2, 'Música')
    ,( 3, 'Pais')
    ,( 3, 'Provincia')
    ,( 3, 'Cantón')
    ,( 4, 'Efectivo')
    ,( 4, 'Diferido')
    ,( 4, 'Tarjeta Credito');

INSERT INTO Localidad( IdPadreLocalidad, IdCatalogo, Nombre) VALUES
    ( NULL, 10, 'Colombia')
    ,( NULL, 10, 'Ecuador')
    ,( 2, 11, 'Imbabura')
    ,( 2, 11, 'Pichincha')
    ,( 2, 11, 'Guayas')
    ,( 3, 12, 'Ibarra')
    ,( 4, 12, 'Quito')
    ,( 5, 12, 'Guayaquil');

INSERT INTO Persona( IdSexo, IdLocalidad, Cedula, Nombre1, Nombre2, Apellido1, Apellido2) VALUES
    ( 1, 7, '1799847204', 'Juan', 'Antonio', 'Menendez', 'Arturio')
    ,( 2, 6, '1003820342', 'Maria', 'Alexandra', 'Flores', 'Jimenez')
    ,( 1, 8, '1700375720', 'Pedro', 'Ernesto', 'Campo', 'Chicaiza');

INSERT INTO Cursos( IdCatalogo, Titulo, Descripcion, Valor) VALUES
    ( 5, 'Comercio Exterior', 'Conocimientos de Comercio Exterior y Logística', 40.99)
    ,( 7, 'Curso de Linux', '9 horas de curso para administrar sistemas.', 79.99)
    ,( 9, 'Aprende Teoria Musical', 'Aprende conceptos básicos de música y sonido', 19.99);

INSERT INTO CursosAlumno( IdCursos, IdPersona, IdFormaPago, FechaInscrip) VALUES
    (1, 2, 14, '2024-05-20 23:28:11')
    ,(2, 3, 15, '2024-06-04 14:51:33')
    ,(3, 3, 13, '2024-06-29 11:54:05');

INSERT INTO CursosTutor( IdCursos, IdPersona, Ingresos) VALUES
    (1, 1, 120.23)
    ,(2, 1, 210.93);

INSERT INTO Cuenta( IdPersona, Usuario, Contrasena, Correo) VALUES
    (1, 'Juanin', '12Ar32', 'juan1232@gmail.com')
    ,(2, 'AlexMari', 'Contrasena', 'alexita@gmail.com')
    ,(3, 'ElpedrO', 'P120211', 'pedr012@gmail.com');

SELECT * 
FROM Catalogo
WHERE IdCatalogoTipo = 2;

SELECT Usuario
FROM Cuenta
WHERE IdPersona = 1 OR IdPersona = 3;

UPDATE Persona
SET Nombre2 = 'Alex'
WHERE IdPersona = 2;

UPDATE Catalogo
SET Estado = 'X'
WHERE IdCatalogo = 3;