## Clase 21/05/2024

Terminar el diagrama---------------

Build   Contrl + Shift + B
run F5 or [>
Debug

### Constructores

Ayuda a dar puntos de inicio al objeto (Inicializar variables)
Se ejecuta automaticamente

Mismo nombre que la clase
Siempre es publico, protegido
Esta por defecto
Es un metodo, se lo llama una sola vez.
Automatico en la misma instancia
### Ejemplo

public Perro(){
    nombre = "";
}

### Sobrecarga


Constructores
public Perro(String nombre){
    this.nombre = nombre;
    raza = "";
}

public Perro(String nom, String ra){
    nombre = nom;
    raza = ra;
}

Perrop1 = new Perro("firu")
Perrop2 = new Perro("firu", "Delmer")

#### Logica Inversa


### Recomendaciones

public class Perro(){
    private string nombre = "Firulais"  \\Esta mal no se define
}

### Relaciones

#### Asociacion

 propietario -----> Mascota
 Un propietario tiene una mascota

 propietario ----P> Mascota

    Public class Propietario {
    
        Private P;
    }

    

### Relacion, implementacion y interfaces.
#### Interfaces
            \-> Agrega comportamientos.
            \-> (Propiedades en algunos casos.)
            \-> No se instancean.
            \-> No se heredan.

    Comienza con i
    Debe ser abstracta y publica
    Solo hace acciones

Ejemplo:
    
public interface Actor().

i comportamiento natural
Simbolo

---->

## fsd
No se puede tener 2 padres