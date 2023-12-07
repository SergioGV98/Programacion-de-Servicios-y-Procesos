package tienda;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        Random r = new Random();
        Tienda tienda = new Tienda();
        
        tienda.agregarProducto("Patatas", 10);
        tienda.agregarProducto("Fresas", 10);
        tienda.agregarProducto("Lasaña", 10);
        tienda.agregarProducto("Carne", 10);
        tienda.agregarProducto("Pescado", 10);
        tienda.agregarProducto("Bebida", 10);
        
        int i = 0;
        int reponedor = 70000;
        while (true) {            
            try {
                int tiempoLlegada = r.nextInt(1000,20001);
                System.out.printf("%sTiempo de llegada de un nuevo cliente es %d segundos\n","\u001B[31m", tiempoLlegada/1000);
                Thread.sleep(tiempoLlegada);
                Cliente cliente = new Cliente(tienda, i++, r.nextInt(1,5));
                new Thread(cliente).start();
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
            
            System.out.printf("Tiempo restante hasta que se repongan todos los productos %d segundos.\n", reponedor/1000);
            reponedor -= 10000;
            
            if(reponedor == 0){
                tienda.reponerTodosProductos();
                reponedor = 70000;
            }
        }
        
        
    }
    
}
