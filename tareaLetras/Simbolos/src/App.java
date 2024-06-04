import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        MoralesFrancisco oMfFiguras = new MoralesFrancisco();
        oMfFiguras.setSimboloLinea("_");
        oMfFiguras.setmfSimboloMas("+");
        oMfFiguras.setmfSimboloMenos("-");
        oMfFiguras.mfF10(mfLecturaNivel(), oMfFiguras.getmfSimboloMas(), oMfFiguras.getmfSimboloMenos(), oMfFiguras.getSimboloLinea());
        oMfFiguras.mfF11(mfLecturaNivel(), oMfFiguras.getmfSimboloMenos(), oMfFiguras.getSimboloLinea());
        oMfFiguras.mfF12(mfLecturaNivel());
        oMfFiguras.mfF13(mfLecturaNivel());
        oMfFiguras.mfF14(mfLecturaNivel());
        oMfFiguras.mfF15(mfLecturaNivel());
        oMfFiguras.mfF16(mfLecturaNivel(), oMfFiguras.getmfSimboloMenos(), oMfFiguras.getmfSimboloMas());
        oMfFiguras.mfF17(mfLecturaNivel());
    }

    private static int mfLecturaNivel() {
        
        int mfNivel         = 0;
        boolean mfControl   = true;
        
        do {
            System.out.println("Ingresa el nivel que tendra la figura: ");
            try{
                mfNivel     = sc.nextInt();
                mfControl   = false;
            }catch(Exception e){
                System.out.println("EL NIVEL INTRODUCIDO NO ES UN NUMERO VUELVA A INTENTARLO.");
                sc.next();
            }
        } while (mfControl || mfNivel < 0);
        sc.next();
        return mfNivel;
    }
}
