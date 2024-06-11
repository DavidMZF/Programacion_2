package animal;

import clasificacionAnimal.Insecto;

public class Mosca extends Insecto {

    public Mosca(String nombre){
        setNombre(nombre);
        System.out.println("Nacio una mosca " + getNombre());
    }

}
