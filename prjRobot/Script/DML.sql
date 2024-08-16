-- database: ../database/ExaBot2k24.sqlite


INSERT INTO IABot( Nombre   ,Observacion) VALUES
    ('IA-RUSO', '');
    
INSERT INTO PersonaTipo( Nombre) VALUES
    ('Soldado')
    ,('Mecanico')
    ,('Experto Ingles')
    ,('Experto Espanol');

INSERT INTO ExaBot( IdIABot, Nombre, Serie) VALUES
    (1,'Maquina1','Model-001')
    ,(1,'Maquina2','Model-002')
    ,(1,'Maquina3','Model-003');

INSERT INTO Persona( IdPersonaTipo, Cedula, Nombre1, Nombre2, Apellido1) VALUES
    (1, 1005119183, 'Ivan',  'Sergeyevich', 'Petrov')
    ,(3, 1473284289, 'Maria', 'Aleksandrovna', 'Sokolova')
    ,(2, 1329348239, 'Pavel', 'Andreyevich', 'Volkov')
    ,(4, 1374982323, 'Ekaterina', 'Mikhailovna', 'Ivanova')
    ,(1, 1243289384, 'Alexei', 'Viktorovich', 'Kuznetsov');

INSERT INTO UsoExotraje( IdExaBot, IdPersona, FechaUso) VALUES
    (1, 1, '2024-01-01 12:22:12')
    ,(2, 1, '2024-06-21 09:12:31')
    ,(3, 5, '2024-08-12 07:59:02')
    ,(2, 5, '2024-01-03 13:11:33');

INSERT INTO Mantenimiento( IdExaBot, IdPersona, Descripcion, FechaMant) VALUES
    (1, 3, 'Revision de arma lazer', '2024-02-28 23:22:02')
    ,(3, 2, 'Ensenansa Ingles', '2024-07-12 14:05:33')
    ,(2, 3, 'Cambio de Fuente de Energia', '2024-01-14 08:11:43');

SELECT *
FROM Persona
WHERE IdPersonaTipo = 1;

SELECT Serie
FROM ExaBot;

UPDATE Mantenimiento
SET FechaMant = '2024-09-07 11:05:33'
WHERE IdMantenimiento = 3;

UPDATE Persona
SET Estado = 'X'
WHERE IdPersona = 4;