import java.util.Scanner;

public class Menu {

    private Scanner sc;

    // Códigos de color ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Menu(Scanner sc) {
        this.sc = sc;
    }

    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            int opcion = 0;
            boolean opcionValida = false;

            System.out.println(ANSI_BLUE + "------  MAQUINA EXPENDEDORA ----------" + ANSI_RESET +
                                "\n" + ANSI_YELLOW + " *Esta maquina solo acepta monedas y billetes de: 0.25 ctvs, 0.50 ctvs, 1.00 dolar, 5.00 dolares * " + ANSI_RESET +
                                "\n" + ANSI_GREEN + " 1. PAPAS    ---------------------------- 0.50 ctvs " + ANSI_RESET +
                                "\n" + ANSI_GREEN + " 2. GALLETAS ---------------------------- 0.75 ctvs " + ANSI_RESET +
                                "\n" + ANSI_GREEN + " 3. SANDUCHE ---------------------------- 3.50 dolares " + ANSI_RESET +
                                "\n" + ANSI_GREEN + " 4. SALIR ---------------------------- " + ANSI_RESET);

            while (!opcionValida) {
                System.out.print("Seleccione una opción: ");
                try {
                    opcion = Integer.parseInt(sc.next());
                    opcionValida = true;
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Entrada no válida. Por favor, ingrese una opción válida." + ANSI_RESET);
                }
            }

            double precio = 0;
            switch (opcion) {
                case 1:
                    precio = 0.50;
                    System.out.println(ANSI_RED + "Selecciono Papas, introduzca " + precio + " dolares" + ANSI_RESET);
                    break;
                case 2:
                    precio = 0.75;
                    System.out.println(ANSI_RED + "Selecciono Galleta, introduzca " + precio + " dolares" + ANSI_RESET);
                    break;
                case 3:
                    precio = 3.50;
                    System.out.println(ANSI_RED + "Selecciono Sanduche, introduzca " + precio + " dolares" + ANSI_RESET);
                    break;
                case 4:
                    System.out.println("Gracias por usar la maquina expendedora. Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Opción no válida." + ANSI_RESET);
                    return;
            }

            if (continuar) {
                recibirDinero(precio);
            }
        }
    }

    public void recibirDinero(double precio) {
        double dineroRecibido = 0.0;

        while (dineroRecibido < precio) {
            System.out.print("Introduzca una moneda o billete (0.25, 0.50, 1.00, 5.00): ");
            String input = sc.next();

            // Validar el formato de monto X.XX
            if (esFormatoValido(input)) {
                try {
                    double monto = Double.parseDouble(input);
                    if (monto == 0.25 || monto == 0.50 || monto == 1.00 || monto == 5.00) {
                        dineroRecibido += monto;
                        if (dineroRecibido < precio) {
                            System.out.println(ANSI_YELLOW + "Faltan " + (precio - dineroRecibido) + " dólares" + ANSI_RESET);
                        }
                    } else {
                        System.out.println(ANSI_RED + "Monto no aceptado. Dinero devuelto: " + monto + " dólares" + ANSI_RESET);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "Formato incorrecto. Por favor, introduzca un valor válido (X.XX)." + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "Formato incorrecto. Por favor, introduzca un valor válido (X.XX)." + ANSI_RESET);
            }
        }

        double cambio = dineroRecibido - precio;
        System.out.println(ANSI_GREEN + "Completado. Gracias por su compra." + ANSI_RESET);

        // Mostrar barra de carga mientras se procesa la compra
        try {
            new BarraCarga().mostrarBarra();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_GREEN + "Retire su producto." + ANSI_RESET);
        if (cambio > 0) {
            System.out.println(ANSI_YELLOW + "Su cambio es: " + cambio + " dólares." + ANSI_RESET);
        }
    }

    private boolean esFormatoValido(String monto) {
        int puntoIndex = monto.indexOf('.');
        if (puntoIndex == -1) {
            return false;
        }
        // Validar que solo haya un punto decimal y que tenga dos dígitos después del punto
        if (monto.lastIndexOf('.') != puntoIndex || (monto.length() - puntoIndex - 1) != 2) {
            return false;
        }
        // Validar que todos los caracteres sean dígitos o un único punto decimal
        for (char c : monto.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
    }
}
