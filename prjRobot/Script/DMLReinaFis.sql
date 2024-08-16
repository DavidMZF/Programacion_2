-- database: ../database/ReinaFis.sqlite

INSERT INTO Sexo( Nombre) VALUES
    ('Masculino')
    ,('Femenino')
    ,('Hibrido');

INSERT INTO Persona( IdSexo, Cedula, CodigoUnico, Nombre1, Nombre2, Apellido1, Apellido2) VALUES
    (1, '170456789', '2012480213', 'Juan', 'Pablo', 'Garcia', 'Estrada')
    ,(2, '176245733', '2020364333', 'Mariana', 'Rosa', 'Apuente', 'Moreno')
    ,(2, '174579237', '2021889393', 'Maria', 'Alexandra', 'Flores', 'Jimenez')
    ,(1, '100532950', '2022839183', 'Pedro', 'Ernesto', 'Campo', 'Chicaiza')
    ,(1, '173533450', '2022236346', 'Diego', 'David', 'Mera', 'Ramos');

INSERT INTO OpcReina( IdPersona, Votos) VALUES
    (2, 2)
    ,(3, 1)
    ,(Null, 2);

INSERT INTO VotoReina( IdPersona, IdOpcReina) VALUES
    (1, 2)
    ,(2, 3)
    ,(3, 3)
    ,(4, 1)
    ,(5, 1);

INSERT INTO Cuenta( IdPersona, Usuario, Contrasena, Correo) VALUES
    (1, 'juanpablo', 'safr332', 'juanpablo@gmail.com')
    ,(2, 'marianita', 'gdfht4', 'mariana@gmail.com')
    ,(3, 'mari', 'Holas111', 'maria@gmail.com')
    ,(4, 'pedro', 'zzzol', 'pedro@gmail.com')
    ,(5, 'diogo', '15hres', 'diego@gmail.com');

SELECT Correo 
FROM Cuenta;

UPDATE Cuenta
SET Usuario = 'diego2'
WHERE IdPersona = '5';

UPDATE Sexo
SET Estado = 'X'
WHERE IdSexo = 3;

SELECT *
FROM Sexo
WHERE Estado = 'A';