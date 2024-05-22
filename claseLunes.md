# POO
Paradigma -
Solucionar problemas
 ## 1. Conceptalización

##### Prototipado - Dibujar - Idea

### Definir propiedades(Caracteristicas) y metodos(Acciones)

### Propiedades
(Almacenar informacion - Datos) ----------> NO SALIR DEL CONTEXTO.
    Necesita un proceso de descripcion

### Metodo
(Accion - Necesita de un parametro y un Ambito)
#### Parametro
(Infromacion necesaria para la realizacion de una accion)
#### Ambito
- Public "+"(Acceso para Cualquiera)
- Private "-"
- Protect "~"(Por herencia)
- Friendly "#"(Acceso para un grupo o paquete)
## 2. Modelado - UML
Formato para describir el concepto

|------ Clase ------| 

|------ Propiedades  o  Atributos ------|

DEBE INDICAR AL INICIO EL AMBITO, EN FORMATO CAMELSCALE Y INDICAR EL TIPO DE DATO.

|------ Metodos -----|

DEBE INDICAR AL INICIO EL AMBITO, LOS PARAMETROS QUE CONTIENEN CON SU TIPO DE DATO. Y EL VALOR QUE RETORNA.

PUEDE RETORNAR VALOR O NO.
VOID (Solo interesa que realize la accion)
TIPO DE DATO (Retorno de un dato)

|------ Evento ------|

DEBE INDICAR AL INICIO EL AMBITO, NOMBRE DE OBJETO Y EL OBJETO COMO TAL.

INTERACCION CON OTRO OBJETOS

## 3. Escritura del Codigo

``` 
Public class Mujer{
    private float edad;
    public bool tieneOjos;

    protected string bailar (String Cancion, int tiempoMin, String Ritmo){
        ---------------------;
        ---------------------;
        return "Baile de maravilla":
    }
}
```

DEBER HOJA
Conceptualizar un animal salvaje
3 Propiedades y 3 Metodos
