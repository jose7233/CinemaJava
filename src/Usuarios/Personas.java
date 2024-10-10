
package Usuarios;

public class Personas {
private String nombre;
private int edad;
private int dinero ;

    public Personas() {
    }

    public Personas(String nombre, int edad, int dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dinero=" + dinero +
                '}';
    }
}

