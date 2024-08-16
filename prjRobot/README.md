tiene un turbo reactor ----> obligatorio
Fuente de poder cambiable ----> se puede sacar
Deriva extiende

### Arquitectura Empresarial
#### Arquitectura N-TIER

Asignar a cada capa de un programa, un computador para almacenar de forma estructurada.
Esto para evitar que el ordenador se sature y se vuelva lento.

Driver java es .jav
Descargar
SQLite

Modelar las tablas. Ordenada

### Base de Datos

Estaticos (Tablas)
Los datos deben ser atomicos. (los campos son unicos y que pertenescan al objeto)

#### REGLAS DE NORMALIZACION

Estado Bruto de los Datos (Tablas)(Columnas)

1. 1...1  Uno a uno
2. 1...*  Uno a muchos
3. *...*  Muchos a muchos

Resolucion

Todas las tablas deben tener un primari key 

Primari Key (PK)_ Puede ser un campo principal unico que no se puede repetir. No se puede podificar es estatico Ej: ID (auto numerico incremental)

For Kay

1. 1(PK)...1(PK) Enlazar tablas coger el PK de la primera tabla y agregarla a la otra.