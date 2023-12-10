package alquilerdvd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Crear los dvd y asignarselos a la tienda
        var dvds = new HashMap<String, Boolean>();
        dvds.put("Harry Potter Orden del fenix", false);
        dvds.put("Juegos del hambre", false);
        dvds.put("Cronicas de narnia", false);

        Tienda tienda = new Tienda(dvds);

        while (true) {
            Random r = new Random();
            try {
                System.err.println("El siguiente cliente llega en 10 segundos.");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {

            }
            ArrayList<String> nombresDvds = new ArrayList<>(dvds.keySet());
            Cliente cliente = new Cliente(nombresDvds.get(r.nextInt(nombresDvds.size())), tienda);
            cliente.start();
        }

    }

}
