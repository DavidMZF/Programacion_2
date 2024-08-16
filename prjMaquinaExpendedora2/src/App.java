import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu(sc);
        menu.mostrarMenu();    
    
    }
}
