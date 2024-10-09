import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean flag = true;

        Scanner InputUser = new Scanner(System.in);
        ConsoleInteract.clearConsole();
        while (flag){

            MenuUser menu = new MenuUser();
            menu.ProcesarSeleccion();
            APIInteract API = new APIInteract("https://v6.exchangerate-api.com/v6/","19e09bcc966c4cd8e9762db8", menu.getDivisaOrigen(), menu.getDivisaObjetivo());
            System.out.println(menu.getCantidadDivisa() + menu.getDivisaOrigen() + " --> " + (API.getExchangeRate() * menu.getCantidadDivisa()) + menu.getDivisaOrigen());
            System.out.println("Desea realizar una nueva conversion? Y/N");
            String inputUser = InputUser.next();
            if (Objects.equals(inputUser, "N") | Objects.equals(inputUser, "n")) {
                flag = false;
            }
        }
        Loader.startLoader(20,200,"Cerrando Sistema...  ");
        System.out.println("\nGRACIAS POR USAR NUESTROS SERVICIOS");
        InputUser.close();
        System.exit(0);
    }

}

