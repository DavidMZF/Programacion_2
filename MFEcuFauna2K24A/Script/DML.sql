-- database: ../DataBase/FMEcuFauna.sqlite


INSERT INTO MFCatalogoTipo
 (Nombre            ) VALUES
 ('TipoHormiga'     )
,('Sexo'            )
,('LocalidadTipo'   )
,('Alimento'        );

INSERT INTO MFCatalogo
(IdCatalogoTipo  ,Nombre            ) VALUES
(1               ,'Reina'           )
,(1              ,'Larva'           )
,(1              ,'Rastrera'        )
,(1              ,'Soldado'         )
,(1              ,'Obrera'          )
,(2              ,'Macho'           )
,(2              ,'Hembra'          )
,(2              ,'Asexual'         )
,(3              ,'Pais'            )
,(3              ,'Region'          )
,(3              ,'Provincia'       )
,(4              ,'IngestaNativa'   )
,(4              ,'GenoAlimento'    );

INSERT INTO MFLocalidad
(IdLocalidadPadre  ,IdCatalogo              ,Nombre                          ) VALUES
(NULL              ,9                      ,'Ecuador'                       );

INSERT INTO MFLocalidad
(IdLocalidadPadre  ,IdCatalogo              ,Nombre                          ) VALUES
(1                 ,10                      ,'Costa'                         )
,(1                ,10                      ,'Sierra'                        )
,(1                ,10                      ,'Oriente'                       )
,(1                ,10                      ,'Insular'                       );

INSERT INTO MFLocalidad
(IdLocalidadPadre  ,IdCatalogo              ,Nombre                          ) VALUES
 (2                ,11                      ,'Esmeraldas'                    )
,(2                ,11                      ,'Santo Domingo de los Tsáchilas')
,(2                ,11                      ,'Manabí'                        )
,(2                ,11                      ,'Los Ríos'                      )
,(2                ,11                      ,'Guayas'                        )
,(2                ,11                      ,'Santa Elena'                   )
,(2                ,11                      ,'El Oro'                        )

,(3                ,11                      ,'Carchi'                        )
,(3                ,11                      ,'Imbabura'                      )
,(3                ,11                      ,'Pichincha'                     )
,(3                ,11                      ,'Cotopaxi'                      )
,(3                ,11                      ,'Tungurahua'                    )
,(3                ,11                      ,'Bolívar'                       )
,(3                ,11                      ,'Chimborazo'                    )
,(3                ,11                      ,'Cañar'                         )
,(3                ,11                      ,'Azuay'                         )
,(3                ,11                      ,'Loja'                          )

,(4                ,11                      ,'Sucumbíos'                     )
,(4                ,11                      ,'Napo'                          )
,(4                ,11                      ,'Orellana'                      )
,(4                ,11                      ,'Pastaza'                       )
,(4                ,11                      ,'Morona Santiago'               )
,(4                ,11                      ,'Zamora Chinchipe'              )

,(5                ,11                      ,'Galápagos'                     );

INSERT INTO MFAlimento
(IdCatalogo               ,Nombre    ) VALUES
 (12                      ,'Carnívoro'   ) 
,(12                      ,'Herbívoro'   ) 
,(12                      ,'Omnívoro'    ) 
,(12                      ,'Insectívoros') 
,(13                      ,'X'           ) 
,(13                      ,'XX'          ) 
,(13                      ,'XY'          );

INSERT INTO MFHormiga
(IdTipoHormiga, IdSexo, IdProvincia, IdGenoAlimento, IdIngestaNativa) VALUES
 (2, 6, 15, 5, 1);