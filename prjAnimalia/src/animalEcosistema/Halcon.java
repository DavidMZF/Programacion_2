package animalEcosistema;

import java.util.ArrayList;
import java.util.List;

import animalClasificacion.Ave;
import animalClasificacion.Mamifero;
import animalEcosistema.comportamiento.IAccion2;

public class Halcon extends Ave implements IAccion2 {
    public List<Pato> amigosPato;
    public List<Mamifero> amigos;

    public Halcon(String nombre) {
        setNombre(nombre);
        amigosPato = new ArrayList<Pato>();
    }

    @Override
    public void volar() {
        System.out.println("Halcón está volando...");
    }
    
    @Override
    public String toString(){
        return    "\n Clase: " + getClass().getName()
                + "\n Nombre: " + getNombre()
                + "\n NroAlas: " + getNroAla();
    }
}
