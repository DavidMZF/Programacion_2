package animalEcosistema;

import animalClasificacion.Aves;
import animalEcosistema.comportamiento.IAccion1;
import animalEcosistema.comportamiento.IAccion2;
import animalEcosistema.comportamiento.IAccion3;

public class Pato extends Aves implements IAccion1,IAccion2,IAccion3{

    public Halcon amigHalcon;
    

    public Pato(String nombre) {
        setNombre(nombre);
        this.amigHalcon = new Halcon("Haconsillo");
    }

    @Override
    public String toString(){
        return   "\n Clase : " + getClass().getName()
                +"\n Nombre : " + getNombre() 
                +"\n NroAlas : " + getNombre();
    }

    @Override
    public void nadar() {
        System.out.println("Pato Nada...");
    }

    @Override
    public void volar() {
        System.out.println("Pato Vuela...");
    }

    @Override
    public void correr() {
        System.out.println("Pato correr...");
    }

}
