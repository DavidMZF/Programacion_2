public class Juego {
    public Jugador      usuario;
    private String      barca;
    private String      rio;
    private String[]    ladoIzq;
    private String[]    ladoDer;
    private Boolean     vikingoEstaIzq;

    public Juego(){
        this.usuario    = new Jugador();
        
        this.rio        = "-".repeat(20);
        this.barca      = "\\-V-;-?-/";
        this.ladoIzq    = new String[] {"V","L","C","U"};
        this.ladoDer    = new String[] {"","","",""};
        this.vikingoEstaIzq = true;
    }

    public boolean jugarLobito(){
        while (mostrarMenu());
        return true;
    }

    public boolean mostrarMenu(){
        int opc=-1;
        System.out.println();
        System.out.println(  " ".repeat(10) + barca + rio);
        System.out.println(  "\n 0. Vikingo va solo "
                            +"\n 1. Lobo            "
                            +"\n 2. Capericita      "
                            +"\n 3. Uvas            "
                            +"\n 4. Salir           ");
        do {
            try {
                opc=-1;
                System.out.println("[+] Ingresa una opc: ");
                opc = App.sc.nextInt();
                if (opc == 4) {
                    System.out.println("Te vere pronto ... cobarde ..!");
                    System.exit(0);
                }
            } catch (Exception e) {App.sc.next(); }
        } while (opc>=4 || opc<0);
        //opc 0,1,2,3
        String individuo = " ";
        individuo   = (vikingoEstaIzq)
                    ? ladoIzq [opc]
                    : ladoDer [opc];
        moverBarca(individuo);
        vikingoEstaIzq = !vikingoEstaIzq;
        return true;
    }

    public void moverBarca(String individuo){
        if(vikingoEstaIzq){
            for (int i = 0; i < rio.length(); i++) {
                setBarcaRio(i, individuo);
            }
        }
        else
            for (int i = rio.length(); i >= 0; i--) {
                setBarcaRio(i, individuo);
            }
        
    }

    private void setBarcaRio(int posicionBarca, String individuo) {
        String rioBarca =     "\r"
                            + ".".repeat(posicionBarca) 
                            + barca .replace("?", individuo)
                            + ".".repeat(rio.length()-posicionBarca);
        System.out.print(rioBarca);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
}
