package Controller.Util;
import java.util.Scanner;
public class Menu {
    Scanner sc = new Scanner(System.in);
    public void run(){
        int option;
        do{
            showMenu();
            option = readInteger("Seleccione una opcion: ");
            handleMenuOption(option);
        }while (option!=0);
    }
    public void handleMenuOption(int option){
        switch(option){
            case 0:
                System.out.println("Saliendo...");
                break;
            case 1:
                Trabajador trabajador = new Trabajador();
                Vehiculo vehiculo = new Vehiculo();
                Venta venta = new Venta(trabajador, vehiculo);
                venta.reporteVenta(trabajador);
                break;
            case 2:
                CostosMinutos run = new CostosMinutos();
                run.run();
                break;
            case 3:
                ServAguaPotable ejecutar = new ServAguaPotable();
                ejecutar.run();
                break;
            case 4:
                Serie serie = new Serie();
                serie.run();
                break;
            default:
                System.out.println("Opcion no valida, ingrese de nuevo");
                 break;
        }
    }

    public void showMenu(){
        System.out.println("0. Salir");
        System.out.println("1. Reporte venta");
        System.out.println("2. Costo minutos");
        System.out.println("3. Servicio de agua potable");
        System.out.println("4. Generar serie");
    }

    public int readInteger(String message){
        while(true){
            System.out.print(message);
            String input = sc.next();
            if(validador.validarInt(input)){
                return casts.transformStringInt(input);
            } else {
                System.out.println("Ingrese un numero entero valido");
            }
        }
    }
    public float readFloat(String message){
        while (true){
            System.out.print(message);
            String input = sc.next();
            if(validador.validarFloat(input)){
                return casts.transformStringFloat(input);
            } else{
                System.out.println("Ingrese un numero valido");
            }
        }
    }
    public String readString(String message){
        System.out.print(message);
        return sc.next();
    }

}
