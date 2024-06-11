package animal;

import clasificacionAnimal.Vertebrado;

public class Leon extends Vertebrado implements IComportamientoNatural{

    public Leon(String nombre){
        setNombre(nombre);
        nacer();
    }

    @Override
    public void nacer() {
        System.out.println("Leon Naciendo...");
    }

    @Override
    public String comer(String comida) {
        return "Este leon ha comido " + comida;
    }

    @Override
    public String comer() {
        return "Este leon no ha comido nada";
    }

}
