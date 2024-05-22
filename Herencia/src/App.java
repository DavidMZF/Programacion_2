public class App {
    public static void main(String[] args) throws Exception {
        Persona    oP = new Persona();
        Persona    oP2 = new Persona(null, null, null);
        //Supervisor oS = new Supervisor();
        
        oP.setCedula("12342"); //Deberia realizar un proceso de validacion
        oP.setNombre("Pepe");
        oP.setApellido(null);

        System.out.println(oP.getCedula());
        System.out.println(oP.getNombre());
        System.out.println(oP.getApellido());

        System.out.println(oP2.getCedula());
        System.out.println(oP2.getNombre());
        System.out.println(oP2.getApellido());
    }
}
