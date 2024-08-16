package animalEcosistema;

import animalClasificacion.Mamiferos;
import animalEcosistema.comportamiento.IAccion1;
import animalEcosistema.comportamiento.IAccionCarnibora;

public class Leon extends Mamiferos implements IAccion1,IAccionCarnibora {

    public Leon(String nombre){
        setNombre(nombre);
    }

    @Override
    public String toString(){
        return   "\n Clase : " + getClass().getName()
                +"\n Nombre : " + getNombre();
    }

    @Override
    public void comer() {
        System.out.println("Leon come hambre ...");
    }

    @Override
    public void comer(Pato alimentoPatuno) {
        System.out.println("Leon come :" + alimentoPatuno.toString());
    }

    @Override
    public void correr() {
        System.out.println("Leon correr...");
    }


}
