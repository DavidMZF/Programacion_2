import costa.Nieto;
import oriente.Hijo;
import sierra.Padre;

public class App {
    public static void main(String[] args) throws Exception {
        Padre p = new Padre("pepe");
        Hijo h = new Hijo("pepito");
        Nieto n = new Nieto("juanito", "juan");
        p.saludar();
        h.saludar();
        n.saludar();
    }
}
