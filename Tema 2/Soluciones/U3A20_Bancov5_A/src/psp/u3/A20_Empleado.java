/*
 * Ejemplo de ejecución paralela. 
 * Los empleados van a actuar de forma concurrente
 * Se ha cambiado el método retirar por el método run que ejecutará el hilo
 */
package psp.u3;
import java.util.Random;

public class A20_Empleado implements Runnable {
    private final String nombre;
    private final String color;
    private final int numOperaciones;
    private int totalRetirado;
    private int totalIngresado;
    private final A20_Cuenta cuenta;
    
    A20_Empleado(String nombre, int numOperaciones, A20_Cuenta cuenta, String color) {
        this.nombre = nombre;
        this.color=color;
        this.numOperaciones = numOperaciones;
        this.totalRetirado = 0;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(nombre);
        for (int i=0; i<numOperaciones; i++) {
            int cantidad = (int)(Math.random()*150+50);
            boolean op = new Random().nextBoolean();
            if (op)
            {
                   if (cuenta.retirar(color,cantidad)) 
                   {
                      totalRetirado += cantidad;
                   }
            }
            else
            {
                cuenta.ingresar(color,cantidad);
                totalIngresado += cantidad;
            }           
        }
    }

    public int getTotalRetirado() {
        return totalRetirado;
    }
    
    public int getTotalIngresado() {
        return totalIngresado;
    }
    
    public String getNombre() {
        return nombre;
    }

}
