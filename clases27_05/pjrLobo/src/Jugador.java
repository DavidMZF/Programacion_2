public class Jugador {
    
    private String usuario;
    private String nombre;
    private String clave;

    public Jugador(){
        setClave("1234");
        setUsuario("dav12");
        setNombre("david");
    }

    public boolean login(){
        String usuario = "";
        String clave = "";
        boolean sinLogeo = true;

        do {
            System.out.println("Ingresa el usuario: ");
            usuario = App.sc.nextLine();
            System.out.println("Ingresa la clave: ");
            clave = App.sc.nextLine();

            if (this.usuario.equalsIgnoreCase(usuario) 
                && this.clave.equalsIgnoreCase(clave))
                return true;

                System.out.println("Para sinLogeo (s): ");
                if (App.sc.nextLine().toUpperCase().equals("S")) {
                    sinLogeo = false;                   
                }
            
        } while (sinLogeo);
            return false;
        }




    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre.toUpperCase();
        else
            this.nombre = "";
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

}
