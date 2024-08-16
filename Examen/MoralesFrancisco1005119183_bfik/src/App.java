import java.util.Scanner;
import mFReptiles.MFTurtleMorales;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        MFTurtleMorales oMfTurtleMorales = new MFTurtleMorales();
        MFTanqueMutacion oMfTanqueMutacion = new MFTanqueMutacion();
        oMfTanqueMutacion.mFIngresarClave();
    }
}
