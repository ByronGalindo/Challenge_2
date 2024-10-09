import java.util.Scanner;

public class MenuUser {


    private String divisaOrigen;
    private String divisaObjetivo;
    private Integer userSelection;
    private Double cantidadDivisa;
    private  boolean flag;

    public String getDivisaOrigen() {
        return divisaOrigen;
    }

    public String getDivisaObjetivo() {
        return divisaObjetivo;
    }

    public Double getCantidadDivisa() {
        return cantidadDivisa;
    }

    public MenuUser() {
        this.divisaObjetivo = "";
        this.divisaOrigen = "";
        this.userSelection = 0;
        this.cantidadDivisa = 0.0;
        this.flag = true;

    }

    public void MostrarMenu() throws InterruptedException {

        System.out.println("***** BIENVENIDO USUARIO *****");
        System.out.println("Ingresando al sistema de conversion de divisas");
        Loader.startLoader(20,200);

        System.out.println("\n");
        System.out.println("MENU DE CONVERSIONES:");
        System.out.println("1: \t Dolar Americano --> Peso Colombiano (USD -> COP)");
        System.out.println("2: \t Peso Colombiano --> Dolar Americano (COP -> USD)");
        System.out.println("3: \t Dolar Americano --> Euro (USD -> EUR)");
        System.out.println("4: \t Euro --> Dolar Americano (EUR -> USD)");
        System.out.println("5: \t Euro --> Peso Colombiano (EUR -> COP)");
        System.out.println("6: \t Peso Colombiano --> Euro (COP -> EUR)");
        System.out.println("7: \t Dolar Canadiense --> Dolar Americano (CAD -> USD)");
        System.out.println("8: \t Dolar Americano --> Dolar Canadiense (USD -> CAD)");
        System.out.println("9: \t Peso Mexicano --> Peso Colombiano (MXN -> COP)");
        System.out.println("10:  Peso Mexicano --> Dolar Americano (MXN -> USD)");
        System.out.println("0: \t SALIR...");

    }

    public void ProcesarSeleccion() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        while(flag){
            ConsoleInteract.clearConsole();
            MostrarMenu();
            System.out.println("Seleccione la conversion que desea realizar: ");
            userSelection = scanner.nextInt();
            switch (userSelection){
                case 0:
                    Loader.startLoader(20,200,"Cerrando Sistema...  ");
                    System.out.println("\nGRACIAS POR USAR NUESTROS SERVICIOS");
                    scanner.close();
                    System.exit(0);
                    return;
                case 1:
                    this.flag = false; this.divisaOrigen = "USD"; this.divisaObjetivo = "COP";
                    break;

                case 2:
                    this.flag = false; this.divisaOrigen = "COP"; this.divisaObjetivo = "USD";
                    break;

                case 3:
                    this.flag = false; this.divisaOrigen = "USD"; this.divisaObjetivo = "EUR";
                    break;

                case 4:
                    this.flag = false; this.divisaOrigen = "EUR"; this.divisaObjetivo = "USD";
                    break;

                case 5:
                    this.flag = false; this.divisaOrigen = "EUR"; this.divisaObjetivo = "COP";
                    break;

                case 6:
                    this.flag = false; this.divisaOrigen = "COP"; this.divisaObjetivo = "EUR";
                    break;

                case 7:
                    this.flag = false; this.divisaOrigen = "CAD"; this.divisaObjetivo = "USD";
                    break;

                case 8:
                    this.flag = false; this.divisaOrigen = "USD"; this.divisaObjetivo = "CAD";
                    break;

                case 9:
                    this.flag = false; this.divisaOrigen = "MXN"; this.divisaObjetivo = "COP";
                    break;

                case 10:
                    this.flag = false; this.divisaOrigen = "MXN"; this.divisaObjetivo = "USD";
                    break;

                default:
                    System.out.println("Opcion invalida, reintente.....");
            }
        }

        ConsoleInteract.clearConsole();
        System.out.println("Ingrese la cantidad de " + this.divisaOrigen + " que desea convertir a " + this.divisaObjetivo + ": ");
        this.cantidadDivisa = scanner.nextDouble();

        ConsoleInteract.clearConsole();
        String message = "Convirtiendo " + this.cantidadDivisa + " " + this.divisaOrigen + " -> " + this.divisaObjetivo + " ";
        Loader.startLoader(20, 250, message);

    }
}
