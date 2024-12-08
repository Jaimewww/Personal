package Controller.Util;

public class CostosMinutos {
    Menu menu = new Menu();

    public void showMenuCalcPrecio(){
        System.out.println("America del norte = 12");
        System.out.println("America central = 15");
        System.out.println("America del sur = 18");
        System.out.println("Europa = 19");
        System.out.println("Asia = 23");
        System.out.println("Africa = 25");
        System.out.println("Oceania = 29");
        System.out.println("Resto del mundo = 31");
    }

    public void run() {
        int option;
        do {
            showMenuCalcPrecio();
            option = menu.readInteger("Seleccione una opción (0 para salir): ");
            if (option == 0) {
                System.out.println("Saliendo...");
                break;
            }
            handleMenuOptionCostos(option);
        } while (option != 0);
    }

    public void handleMenuOptionCostos(int option) {
        for (ZonasHorarias.zonas_horarias zona : ZonasHorarias.zonas_horarias.values()) {
            if (zona.getClave() == option) {
                System.out.println("Zona seleccionada: " + zona.name());
                System.out.println("Costo por minuto: $" + zona.getCosto());
                float minutosHablados = menu.readFloat("Ingrese el numero de minutos hablados: ");
                float conversionFinal = minutosHablados * zona.getCosto();
                System.out.println("El precio final por pagar es de $"+conversionFinal);
                return;
            }
        }
        System.out.println("Opción no válida. Vuelva a ingresar.");
    }
}
