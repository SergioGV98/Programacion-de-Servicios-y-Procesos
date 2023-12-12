package ejercicio1controlalmacen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen(10000);
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        for (byte i = 1; i <= 10; i++) {
            proveedor.add(new Proveedor("Proveedor" + i, almacen));
        }

        for (byte i = 1; i <= 5; i++) {
            clientes.add(new Cliente("Cliente" + i, almacen));
        }

        for (byte i = 0; i < 15; i++) {
            try {
                Thread.sleep(12000);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
            if (i <= 9) {
                Thread hiloProveedor = new Thread(proveedor.get(i));
                hiloProveedor.start();
            }
            try {
                Thread.sleep(24000);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
            if (i <= 4) {
                Thread hiloCliente = new Thread(clientes.get(i));
                hiloCliente.start();
            }
        }

    }

}
