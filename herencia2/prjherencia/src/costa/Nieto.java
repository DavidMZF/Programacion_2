package costa;
import oriente.Hijo;

public class Nieto extends Hijo {
    private String nombre;

    public Nieto(String nombre, String nombrePapa) {
        super(nombrePapa);
        this.nombre = nombre;
    }

    @Override
    public void saludar(){
        System.out.println("oe flaco, soy: " + nombre);
        System.out.println("Soy hijo de: " + getNombre());
        System.out.println("Mi abuelo es: " + getNombreAbuelo());
    }
}
