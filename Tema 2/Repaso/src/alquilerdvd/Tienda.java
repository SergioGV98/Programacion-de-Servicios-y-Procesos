package alquilerdvd;

import java.util.HashMap;

public class Tienda {

    private final HashMap<String, Boolean> dvds;

    public Tienda(HashMap<String, Boolean> dvds) {
        this.dvds = dvds;
    }

    public synchronized void alquilar(Cliente cliente, String pelicula) throws InterruptedException {
        while (dvds.get(pelicula)) {
            System.out.printf("El cliente con Identificador %s ha intentado alquilar la pelicula %s.\n", cliente.getIdentificador(), pelicula);
            wait();
        }
        System.out.printf("Cliente con Identificador %s ha alquilado la pelicula %s\n", cliente.getIdentificador(), pelicula);
        dvds.put(pelicula, true);
    }

    public synchronized void devolver(Cliente cliente, String pelicula) {
        System.out.printf("%sCliente con Identificador %s ha devuelto la pelicula %s\n","\u001B[33m", cliente.getIdentificador(), pelicula);
        dvds.put(pelicula, false);
        notifyAll();
    }

}
