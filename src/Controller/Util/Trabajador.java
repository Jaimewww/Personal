package Controller.Util;

public class Trabajador {
    float comision, utilidad, sueldo, sueldoTotal;
    String nombre;
    public Trabajador(){
        sueldoTotal = 2500;
        sueldo = 2500;
        comision = 0;
        utilidad = 0;
        nombre = "";
    }

    public float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(float utilidad) {
        this.utilidad = utilidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public float getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(float sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public String getNombre() {
        return nombre;
    }
}
