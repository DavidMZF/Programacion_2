public class Cajero extends Persona {

    private String usuario;
    private String clave;
    
    public Cajero(){
        usuario = "";
        clave   = ""; 
    }

    public Cajero(String usuario, String  clave){
        setUsuario(usuario);
        setClave(clave);
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        if(usuario != null)
            this.usuario = usuario.toUpperCase();
        else
            this.usuario = "";
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        if(clave != null)
            this.clave = clave.toUpperCase();
        else
            this.clave = "";;
    }


}
