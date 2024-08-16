import java.util.Random;

public class MFTanqueMutacion {

    public boolean mFIngresarClave(){
        for (;;) {
            System.out.println("Ingrese la clave para realizar la MUTACION DE UN TURTLE: ");
            try {
                if (App.sc.next().equals("321mutar")){
                    mFMutar("David");                    
                    return true;
                }
                else
                    System.out.println("LA CLAVE INGRESADA ES INCORRECTA");
            } catch (Exception ERRORCLAVEINGRESADA) {}
        }
    }

    public void mFMutar(String mFNombreAnimal){
        Random generadorAleatorios = new Random();
        int mFNumeroAleatorio = 100 + generadorAleatorios.nextInt(1000);

        System.out.println(mFNombreAnimal + " es un Turtle / " + mFNombreAnimal + " en proceso de mutacion.");
        System.out.println("Irradiando: ");
        System.out.println(" ");
        for (int i = 0; i <= mFNumeroAleatorio; i++) {
            System.out.print( "\r" 
                                + "_".repeat(i/100) 
                                + " ".repeat(10-(i/100))  
                                + " "
                                + i
                                + "de " 
                                + mFNumeroAleatorio 
                                + " (mSv)");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {}
        }  
    }
}
