
package ejercicio2cajaherramientas;

import java.util.Random;

public class Trabajador extends Thread{
    
    private final String nombre;
    private final Herramienta herramientas;

    public Trabajador(String nombre, Herramienta herramienta) {
        this.nombre = nombre;
        this.herramientas = herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            herramientas.tomarMartillo(this);
            herramientas.tomarGuante(this);
            Thread.sleep(r.nextInt(1000, 5001)); //Se tarda en clavar un clavo entre 1 y 5 segundos. 
            herramientas.devolver(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
