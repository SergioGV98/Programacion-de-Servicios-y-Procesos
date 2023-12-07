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

        int identificador = 0;
        int reponedor = 70000;
        int tiempoLlegada = 0;
        while (true) {
            try {
                tiempoLlegada = r.nextInt(1000, 20001);
                System.out.printf("%sTiempo de llegada de un nuevo cliente es %d segundos\n", "\u001B[31m", tiempoLlegada / 1000);
                Thread.sleep(tiempoLlegada);
                Cliente cliente = new Cliente(tienda, identificador++);
                new Thread(cliente).start();
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }

            if (reponedor <= 0) {
                reponedor = 0;
            }
            System.out.printf("Tiempo restante hasta que se repongan todos los productos %d segundos.\n", reponedor / 1000);
            reponedor -= tiempoLlegada;

            if (reponedor <= 0) {
                tienda.reponerTodosProductos();
                reponedor = 70000;
            }
        }

    }

}
