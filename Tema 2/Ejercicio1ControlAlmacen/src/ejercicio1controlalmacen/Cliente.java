
package ejercicio1controlalmacen;

import java.util.Random;

public class Cliente extends Thread{
    
    private final String nombre;
    private final int piezas;
    private final Almacen almacen;

    public Cliente(String nombre, Almacen almacen) {
        Random r = new Random();
        this.nombre = nombre;
        this.piezas = r.nextInt(2000,2501);
        this.almacen = almacen;
    }

    public int getPiezas() {
        return piezas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            almacen.reparto(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } catch (Throwable ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
