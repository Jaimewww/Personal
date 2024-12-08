package Controller.Util;
public class Venta {
    Trabajador trabajador;
    Vehiculo vehiculo;
    float totalVentas;
    public Venta(Trabajador t, Vehiculo v){
        trabajador = t;
        vehiculo = v;
        totalVentas = 0;
    }

    public void realizarVenta(){
        if(vehiculo.getPrecio() > 10000){
            trabajador.comision += 250;
            trabajador.sueldoTotal += 250;
        }
        totalVentas += vehiculo.getPrecio();
    }

    public void calcularUtilidad(){
        trabajador.setUtilidad((float)(totalVentas*0.05));
        trabajador.sueldoTotal+=trabajador.getUtilidad();
    }


    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }
    public void reporteVenta(Trabajador trabajador) {
        Menu menu = new Menu();
        String nombreTrabajador = menu.readString("Ingrese el nombre del trabajador: ");
        trabajador.setNombre(nombreTrabajador);

        int autosVendidos = menu.readInteger("Ingrese el número de autos vendidos: ");

        for (int i = 1; i <= autosVendidos; i++) {
            float precioAuto = menu.readFloat("Ingrese el valor del auto " + i + ": ");
            vehiculo.setPrecio(precioAuto);
            realizarVenta();
        }

        calcularUtilidad();

        System.out.println("\n--- Reporte de Ventas ---");
        System.out.println("Nombre Trabajador: " + trabajador.getNombre());
        System.out.println("Autos Vendidos: " + autosVendidos);
        System.out.println("Venta Total: " + getTotalVentas());
        System.out.println("Sueldo Básico: " + trabajador.getSueldo());
        System.out.println("Comisión: " + trabajador.getComision());
        System.out.println("Utilidad: " + trabajador.getUtilidad());
        System.out.println("Sueldo Total: " + trabajador.getSueldoTotal());
    }
}
