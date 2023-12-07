/**
 * Ahora se ha convertido retirar en una sección crítica
 */

package psp.u3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class A20_Cuenta {
    int saldo;
    
    A20_Cuenta(int saldo) {
        this.saldo = saldo;
    }
    
    public synchronized boolean retirar(String color,int cantidad) {       
        String nombre=Thread.currentThread().getName();
        int intento=1;
        // Se intenta tres veces para evitar el bloqueo, esperando 2 segundos.
        while (cantidad>saldo && intento <4)
        {
            System.out.println(color + nombre + " quiere sacar " + cantidad + " Euros y no puede");
            intento++;
            try {
                wait(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(A20_Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cantidad<=saldo)
        { saldo-=cantidad;
          System.out.println(color + nombre + " ha sacado " + cantidad + " Euros");
          System.out.println("Saldo actual en cuenta: " + saldo + " Euros");
          return true;
        }
        else
        {
          System.out.println("Saldo actual en cuenta: " + saldo + " Euros");
          return false;  
        }
    }    
    
    public synchronized void ingresar(String color,int cantidad) 
    {       
        String nombre=Thread.currentThread().getName();
        System.out.println(color + nombre + " ha realizado un ingreso de " + cantidad + " Euros");
        saldo += cantidad;
        System.out.println("Saldo actual en cuenta: " + saldo + " Euros");
        notifyAll();
    }
    
    public int getSaldo() {
        return this.saldo;
    }
}
