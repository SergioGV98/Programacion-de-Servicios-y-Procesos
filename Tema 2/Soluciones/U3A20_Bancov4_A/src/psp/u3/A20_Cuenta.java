/**
 * Ahora se ha convertido retirar en una sección crítica
 */

package psp.u3;

public class A20_Cuenta {
    int saldo;
    
    A20_Cuenta(int saldo) {
        this.saldo = saldo;
    }
    
    public synchronized boolean retirar(int cantidad) {       
        if (cantidad<=saldo)
        {
            saldo -= cantidad;
            return true;
        }
        else
        {
            return false;
        }
    }    
    
    public synchronized void ingresar(int cantidad) 
    {       
        saldo += cantidad;
    }
    
    public int getSaldo() {
        return this.saldo;
    }
}
