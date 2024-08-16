import animalEcosistema.Leon;
import animalEcosistema.Pato;

public class App {
    public static void main(String[] args) throws Exception {
        Pato p = new Pato("Donalds");
        Leon l = new Leon("Simba");
        System.out.println(p.toString());
        System.out.println(l.toString());
    }
}
