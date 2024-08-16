public class BarraCarga {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    

    public void mostrarBarra() throws InterruptedException {

        
        int total = 100;
        System.out.print("Procesando: [");
        for (int i = 0; i <= total; i++) {
            Thread.sleep(50); 
            System.out.print("\rProcesando: [");
            int porcentaje = (i * 100) / total;
            for (int j = 0; j <= i; j++) {
                System.out.print(ANSI_GREEN + "=" + ANSI_RESET);
            }
            for (int j = i + 1; j <= total; j++) {
                System.out.print(" ");
            }
            System.out.print("] " + porcentaje + "%");
        }
        System.out.print("\r"); 
    }
}
