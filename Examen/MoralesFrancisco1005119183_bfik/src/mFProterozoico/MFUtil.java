package mFProterozoico;
public class MFUtil {

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m"; 
    public static String[] mFColores = new String[] {ROJO, VERDE, AMARILLO, AZUL, MAGENTA, CIAN, BLANCO, RESET}; 
        
    public void mFMostrarSpinner(int mFColor) {
        System.out.println();
        for (int i = 1; i <= 100; i++) {
            System.out.print(mFColores[mFColor] + "\r" + i + "% " + (i % 4 == 0 ? "|" : i % 4 == 1 ? "/" : i % 4 == 2 ? "-" : "\\"));
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(mFColores[mFColor]);
    }
    
}
