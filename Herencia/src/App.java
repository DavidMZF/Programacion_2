import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //argumentoMain(args);
        //flujoTeclado();
        //flujoTeclado();
        //flujoString();


        // Persona    oP = new Persona();
        // Persona    oP2 = new Persona(null, null, null);
        Cajero oC = new Cajero();
        Supervisor oS = new Supervisor();
        
        oC.setCedula("12342");
        oC.setNombre("Pepe");
        oC.setApellido(null);

        // System.out.println(oP.getCedula());
        // System.out.println(oP.getNombre());
        // System.out.println(oP.getApellido());

        System.out.println(oC.getCedula());
        System.out.println(oC.getNombre());
        System.out.println(oC.getApellido());
    }

    private static void flujoString() {
        int total = 0;
        String datos = "12-24-23";
        Scanner sc = new Scanner(datos);
        sc.useDelimiter("-");

        while(sc.hasNextInt()){
            total += sc.nextInt();    
        }
        System.out.println("La suma es: " + total);
        sc.close();
    }

    private static void flujoTeclado() {
        int total    = 0;

        System.out.println("Ingresa valores para sumar: ");
        while (sc.hasNextInt()) {
            total += sc.nextInt();    
        }

        System.out.println("La suma de todos los numeros es: " + total);
        sc.next();
    }

    private static void argumentoMain(String[] args) {
        if ((args.length == 2) && (args[0].equals("David") && args[1].equals("9876"))) {

            var entrada = Arrays.toString(args);
            System.out.println("Buen dia, estoy listo para trabajar...");
            System.out.println("Los parametros que ingresaste son: " + entrada);
        } else {
            System.out.println("Detecto que eres un intruso...!");
            System.exit(0);
        }
    }
}
