import java.util.Arrays;

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

    public void jugarLobito(){
        System.out.println("Bienvenido al juego de 'El Lobito y el Vikingo'");
        if ( !usuario.login())
            System.exit(0);        
        do {
            short opcMenu = (mostrarMenu());
    
            String individuo = " ";
            if (vikingoEstaIzq){
                individuo = ladoIzq [opcMenu];
                ladoIzq [opcMenu] = " ";
            }
            else{
                individuo = ladoDer [opcMenu];
                ladoDer [opcMenu] = " ";
            }

            moverBarca(individuo);
            vikingoEstaIzq = !vikingoEstaIzq;

            if (vikingoEstaIzq){
                ladoIzq [opcMenu] = individuo;
                setBarcaRio(1, " ");
            }
            else{
                ladoDer [opcMenu] = individuo;
                setBarcaRio(rio.length(), " ");
            }

            verificarReglas();
        } while (true);
    }

    private void verificarReglas(){
        String msg = "";

        //Reglas con las que se pierde el juego
        if(vikingoEstaIzq){
            if(ladoDer[1].equals("L") && ladoDer[2].equals("C"))
                msg += "\n Marcho la Caperucia";
            if(ladoDer[2].equals("C") && ladoDer[3].equals("U"))
                msg += "\n Marcharon las uvas";
        }else{
            if(ladoDer[1].equals("L") && ladoDer[2].equals("C"))
                msg += "\n Marcho la Caperucia";
            if(ladoDer[2].equals("C") && ladoDer[3].equals("U"))
                msg += "\n Marcharon las uvas";
        }

        if( ladoDer[1].equals("L") && ladoDer[2].equals("C") && ladoDer[3].equals("U"))
            msg = "\n Lo lograste campeon...!";

        if (!msg.isEmpty()) {
            System.out.println(msg);
            System.exit(0);
        }
    }

    public short mostrarMenu(){
        int opc=-1;
        //System.out.println(  " ".repeat(10) + barca + rio);
        System.out.println(  "\n 0. Vikingo va solo "
                            +"\n 1. Lobo            "
                            +"\n 2. Capericita      "
                            +"\n 3. Uvas            "
                            +"\n 4. Salir           ");
        do {
            try {
                opc=-1;
                String personaje = "";
                System.out.println("[+] Ingresa una opc: ");
                opc = App.sc.nextInt();
                // verificar que exista personaje
                personaje   = (vikingoEstaIzq)
                            ? ladoIzq [opc]
                            : ladoDer [opc];

                if(personaje.trim().isEmpty() && opc > 0){
                    opc=-1;
                    System.out.println("No existe ese personaje en el lado que este la barca");
                }

                if (opc == 4) {
                    System.out.println("Te vere pronto ... cobarde ..!");
                    System.exit(0);
                }
            } catch (Exception e) {App.sc.next(); }
        } while (opc>=4 || opc<0);
        return (short) opc;
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
        String personajeIzq = Arrays.toString(ladoIzq);
        String personajeDer = Arrays.toString(ladoDer);
        String rioBarca =     "\r"
                            + personajeIzq 
                            + ".".repeat(posicionBarca) 
                            + barca .replace("?", individuo)
                            + ".".repeat(rio.length()-posicionBarca)
                            + personajeDer;
        System.out.print(rioBarca);
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {}
    }
}
