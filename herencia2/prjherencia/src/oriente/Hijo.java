package oriente;
import sierra.Padre;

public class Hijo extends Padre{
    private String nombre;

    public Hijo(){
        super("papá");
    }

    public Hijo(String nombre){
        super("pepin");
        this.nombre = nombre;
    }

    @Override
    public void saludar(){
        System.out.println("Hola, soy " + nombre);
        System.out.println("Mi padre es: " + getNombre());
    }

    public String getNombre() {
        return nombre;
    }
}
