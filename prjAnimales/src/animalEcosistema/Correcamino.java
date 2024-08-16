package animalEcosistema;

import animalClasificacion.Aves;
import animalEcosistema.comportamiento.IAccion1;

public class Correcamino extends Aves implements IAccion1 {

    public Correcamino(String nombre){
        setNombre(nombre);
    }

    @Override
    public void correr() {
        System.out.println("Correcaminos esta corriendo");        
    }

    @Override
    public String toString(){
        return   "\n Clase : " + getClass().getName()
                +"\n Nombre : " + getNombre() 
                +"\n NroAlas : " + getNombre();
    }

}
