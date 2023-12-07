package tienda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Tienda {

    private final HashMap<String, Integer> inventario;

    public Tienda() {
        this.inventario = new HashMap<>();
    }

    public synchronized void agregarProducto(String producto, int cantidad) {
        inventario.put(producto, cantidad);
    }

    public synchronized void agregarCantidad(String producto) {
        Random r = new Random();
        inventario.put(producto, inventario.get(producto) + r.nextInt(1, 10));
    }

    public synchronized int consultarProducto(String producto) {
        return inventario.get(producto);
    }

    public synchronized ArrayList<String> obtenerProductos() {
        Random r = new Random();
        ArrayList<String> listaProductos = new ArrayList<>();

        for (HashMap.Entry<String, Integer> entry : inventario.entrySet()) {
            String producto = entry.getKey();
            if(r.nextBoolean()){
               listaProductos.add(producto); 
            }
        }

        return listaProductos;
    }

    public synchronized void consultarTodosProductos() {
        for (HashMap.Entry<String, Integer> entry : inventario.entrySet()) {
            String producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.printf("[Producto %s] cantidad restante %d.\n", producto, cantidad);
        }
    }

    public synchronized void reponerTodosProductos() {
        for (HashMap.Entry<String, Integer> entry : inventario.entrySet()) {
            String producto = entry.getKey();
            inventario.put(producto, 10);
        }
        System.out.println("Se han repuesto todos los productos.");
        notifyAll();
    }

    public synchronized void comprar(Cliente cliente, String producto) throws InterruptedException {
        while (!(inventario.containsKey(producto) && (consultarProducto(producto) - cliente.getCantidad()) >= 0)) {
            if (consultarProducto(producto) == 0) {
                System.out.printf("[Cliente %d] El producto [%s] está agotado.\n", cliente.getIdentificador(), producto);
            } else {
                System.out.printf("[Cliente %d] No queda suficientes suficientes productos de los que quiero comprar.\n", cliente.getIdentificador());
            }
            wait();
        }

        int cantidadActual = consultarProducto(producto);
        inventario.put(producto, cantidadActual - cliente.getCantidad());
        System.out.printf("[Cliente %d] ha comprado %d %s.\n", cliente.getIdentificador(), cliente.getCantidad(), producto);
    }

    public synchronized void compraFinalizada(Cliente cliente) {
        System.err.printf("[Cliente %d] ha terminado de comprar.\n", cliente.getIdentificador());
        consultarTodosProductos();
    }

}
