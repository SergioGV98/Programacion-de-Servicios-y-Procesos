
package ejercicio1controlalmacen;

import java.util.Random;

public class Proveedor extends Thread{
    
    private final String nombre;
    private final int piezas;
    private final Almacen almacen;

    public Proveedor(String nombre, Almacen almacen) {
        Random r = new Random();
        this.nombre = nombre;
        this.piezas = r.nextInt(400,1001);
        this.almacen = almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPiezas() {
        return piezas;
    }

    @Override
    public void run() {
        try {
            almacen.descarga(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
