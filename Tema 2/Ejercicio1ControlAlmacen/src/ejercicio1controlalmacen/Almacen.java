
package ejercicio1controlalmacen;

public class Almacen {
    
    private final int piezasMaximas;
    private int piezas;

    public Almacen(int piezasMaximas) {
        this.piezasMaximas = piezasMaximas;
        this.piezas = 4000;
    }
    
    public synchronized void descarga(Proveedor proveedor) throws InterruptedException{
        while ((piezas + proveedor.getPiezas()) > piezasMaximas) {  
            System.out.printf("%sSe ha llegado a la capacidad maxima de almacenaje. Esperando a que se vacie...\n", "\u001B[31m");
            wait();
        }
        
        System.out.printf("%s%s entrega %d piezas al almacen\n", "\u001B[31m",proveedor.getNombre(), proveedor.getPiezas());
        piezas += proveedor.getPiezas();
        System.out.printf("Hay %d piezas en el almacen\n", piezas);
        notifyAll();
    }
    
    public synchronized void reparto(Cliente cliente) throws InterruptedException{ //Falta los intentos
        while ((piezas - cliente.getPiezas()) < 0) {            
            System.out.printf("%s%s necesita %d piezas, pero no hay suficiente en el almacen\n", "\u001B[32m", cliente.getNombre(), cliente.getPiezas());
            wait();
        }
        
        System.out.printf("%s%s saca %d piezas del almacen\n", "\u001B[32m", cliente.getNombre(), cliente.getPiezas());
        piezas -= cliente.getPiezas();
        System.out.printf("Hay %d piezas en el almacen\n", piezas);
    }
    
    public synchronized void pararHilo(){
        
    }
    
}
