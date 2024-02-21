package clienteservidortcpmultihilolibreria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

    public static final int PORT = 5656;

    public static void main(String[] args) {

        Map<String, Integer> libros = new HashMap<>();
        libros.put("Nacidos de la bruma: El Imperio final", 10);
        libros.put("Harry Potter: Las Reliquias de la muerte", 15);
        libros.put("Juego de trono", 20);

        Libreria libreria = new Libreria("Academia azul", libros);

        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.err.println("No puede escucharse el puerto " + PORT);
            System.exit(-1);
        }

        System.out.println("Escuchando: " + socketServidor);

        try {

            while (true) {
                socketCliente = socketServidor.accept();
                System.out.println("Conexión aceptada " + socketCliente);
                Comprador worker = new Comprador(socketCliente, libreria);
                worker.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
