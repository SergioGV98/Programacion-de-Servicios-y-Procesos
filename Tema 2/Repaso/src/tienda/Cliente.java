package tienda;

import java.util.ArrayList;
import java.util.Arrays;
public class Cliente implements Runnable{
    
    private final Tienda tienda;
    private final int identificador;
    private final ArrayList<String> productos;
    private final int cantidad;

    public Cliente(Tienda tienda, int identificador, int cantidad) {
        this.tienda = tienda;
        this.identificador = identificador;
        this.productos = tienda.obtenerProductos();
        this.cantidad = cantidad;
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
        
        try {
            for(int i = 0; i < productos.size(); i++){
                tienda.comprar(this, productos.get(i));
                Thread.sleep(2000);
            }
            
            tienda.compraFinalizada(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } 
    }
    
}
