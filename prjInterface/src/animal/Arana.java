package animal;

import clasificacionAnimal.Insecto;

public class Arana extends Insecto implements IComportamientoNatural, IComportamientoInsecto{

    
    public Arana(String nombre){
        setNombre(nombre);
        nacer();
        }

    @Override
    public void nacer() {
        System.out.println("Araña naciendo...");
    }

    @Override
    public String comer(String comida) {
        return "Esta araña ha comido " + comida;
        }

        @Override
    public String comer() {
        return "Esta araña no ha comido nada";
    }

    @Override
    public String comer(Mosca mosca) {
        return "Esta araña esta comiendo una mosca muerta: " + mosca.getNombre();
    }
}
