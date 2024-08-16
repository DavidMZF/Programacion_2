public class MaquinaExpendedora {
    private double dineroCliente;
    private double precioGalletas;
    private double precioPapas;
    private double precioSanduche;
    
    public MaquinaExpendedora(){
        this.dineroCliente = 0;
        this.precioGalletas = 0.75;
        this.precioPapas = 0.50;
        this.precioSanduche = 3.50;
    }
    
    public void mostrarMaquina(){
        System.out.println("Bienvenido...");
        System.out.println("Disponemos de: \n1) Galletas 0.75$ \n2) Papas 0.50$ \n3) Sanduche 3.50$");
        System.out.println("");

        menuMaquina();

        System.out.println("Adios, vuelva pronto.");
    }

    public void ingresoDinero(){
        int opc = -1;
        do {
            do {
                opc = -1;
                try {
                    System.out.println("Ingrese la moneda/billete: \n1) 0.25$ \n2) 0.50$ \n3) 1.00$ \n4) 5.00$ \n5) Salir");
                    opc = App.sc.nextInt();  
                } catch (Exception e) {
                    App.sc.next();
                }
            } while (opc < 1 || opc > 5);
            if (opc == 1 && this.dineroCliente < 5)
                this.dineroCliente += 0.25;
            else if (opc == 2 && this.dineroCliente < 5)
                this.dineroCliente += 0.50;
            else if (opc == 3 && this.dineroCliente < 5)
                this.dineroCliente += 1.00;
            else if (opc == 4 && this.dineroCliente < 5)
                this.dineroCliente += 5.00;
            else if (this.dineroCliente >= 5)
                System.out.println("Cantidad de dinero excedida. Regresando moneda/billete");
            System.out.println("");
            System.out.println("Su saldo es de: " + this.dineroCliente + "$");
            System.out.println("");
        } while (opc != 5);
    }

    public void seleccionCompra(){
        int opc = -1;
        do {
            do {
                try {
                    System.out.println("Comprar: \n1) Galletas 0.75$"
                                        +"\n2) Papas 0.50$"
                                        +"\n3) Sanduche 3.50$"
                                        +"\n4) Salir");
                    opc = App.sc.nextInt();  
                } catch (Exception e) {
                    App.sc.next();
                }
            } while (opc < 1 || opc > 4);
            System.out.println("");
            if (opc == 1){
                if (this.dineroCliente >= precioGalletas) {
                    System.out.println("...Entregando Galletas");
                    this.dineroCliente -= precioGalletas;
                    System.out.println("...Entregando Cambio " + this.dineroCliente + "$");
                    this.dineroCliente = 0;
                }
                else
                System.out.println("No tienes suficiente dinero");
            }
            if (opc == 2) {
                if (this.dineroCliente >= precioPapas) {
                    System.out.println("...Entregando Papas");
                    this.dineroCliente -= precioPapas;
                    System.out.println("...Entregando Cambio " + this.dineroCliente + "$");
                    this.dineroCliente = 0;
                }
                else
                    System.out.println("No tienes suficiente dinero");
            }
            if (opc == 3) {
                if (this.dineroCliente >= precioSanduche) {
                    System.out.println("...Entregando Sanduche");
                    this.dineroCliente -= precioSanduche;
                    System.out.println("...Entregando Cambio " + this.dineroCliente + "$");
                    this.dineroCliente = 0;
                }
                else
                    System.out.println("No tienes suficiente dinero");
            }
        } while (opc != 4);
        System.out.println("");
    }

    public void menuMaquina(){
        int opc = -1;
        do {
            do {
                try {
                    System.out.println("Seleccione: \n1) Ingresar monedas \n2) Realizar compra \n3) Salir");
                    opc = App.sc.nextInt();  
                } catch (Exception e) {
                    App.sc.next();
                }
            } while (opc < 1 || opc > 3);
            if (opc == 1)
                ingresoDinero();
            else if (opc == 2)
                seleccionCompra();
        } while (opc != 3);
        System.out.println("");
    }
}
