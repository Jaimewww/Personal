package Controller.Util;

public class Cliente {
    String nombre;
    int edad;
    float porcentajeDiscapacidad;
    public Cliente(){
        nombre = "";
        edad = 0;
        porcentajeDiscapacidad = 0.0f;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getEdad(){
        return edad;
    }

    public void setPorcentajeDiscapacidad(float porcentajeDiscapacidad){
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public float getPorcentajeDiscapacidad(){
        return porcentajeDiscapacidad;
    }
}
