package clases;

public class Empleado extends Persona{
    
    private double nomina;

    public Empleado(String nombre, byte edad, double nomina) {
        super(nombre, edad);
        this.nomina = nomina;
    }

    public double getNomina() {
        return nomina;
    }

    public void setNomina(double nomina) {
        this.nomina = nomina;
    }

    @Override
    public String toString() {
        return getNombre() + " tiene " + getEdad() + " años y gana " + nomina + " Euros";
    }

}
