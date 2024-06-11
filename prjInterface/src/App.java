import animal.Arana;
import animal.Leon;
import animal.Mosca;

public class App {
    public static void main(String[] args) throws Exception {
        Leon l = new Leon("Leo");
        System.out.println(l.comer());
        System.out.println(l.comer("filete de jirafa"));

        Arana a = new Arana("Charlote");
        Mosca m = new Mosca("pepa");

        System.out.println(a.comer());
        System.out.println(a.comer("agua"));
        System.out.println(a.comer(m));
    }
}
