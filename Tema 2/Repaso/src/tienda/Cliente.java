package tienda;

import java.util.ArrayList;
import java.util.Random;
public class Cliente implements Runnable{
    
    private final Tienda tienda;
    private final int identificador;
    private final ArrayList<String> productos;
    private int cantidad;

    public Cliente(Tienda tienda, int identificador) {
        this.tienda = tienda;
        this.identificador = identificador;
        this.productos = tienda.obtenerProductos();
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<String> getProductos() {
        return productos;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            for(int i = 0; i < productos.size(); i++){
                cantidad = r.nextInt(1,5);
                tienda.comprar(this, productos.get(i));
                Thread.sleep(2000);
            }
            
            tienda.compraFinalizada(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } 
    }
    
}
