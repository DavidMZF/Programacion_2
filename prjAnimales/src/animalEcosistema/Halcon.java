package animalEcosistema;

import java.util.ArrayList;
import java.util.List;

import animalClasificacion.Aves;
import animalEcosistema.comportamiento.IAccion2;

public class Halcon extends Aves implements IAccion2 {

    public ArrayList<Pato> amigosPato;

    public Halcon(String nombre){
        setNombre(nombre);
        amigosPato = new ArrayList<Pato>();
    }

    @Override
    public void volar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'volar'");
    }

}
