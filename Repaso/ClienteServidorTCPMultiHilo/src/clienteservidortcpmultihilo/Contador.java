
package clienteservidortcpmultihilo;


public class Contador {
    
    private int contador;

    public Contador() {
        this.contador = 0;
    }

    public int getContador() {
        return contador;
    }

    public synchronized void sumar(int numero){
        contador += numero;
    }
    
    public synchronized void restar(int numero){
        contador -= numero;
    }
    
    @Override
    public String toString() {
        return "Contador{" + "contador=" + contador + '}';
    }
}
