package clases;

public class Persona {

    private String nombre;
    private byte edad;

    public Persona(String nombre, byte edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " tiene " + edad + " años";
    }

    public boolean estaJubilado(byte edad) {
        if (edad >= 65) {
            return true;
        }
        return false;
    }
}
