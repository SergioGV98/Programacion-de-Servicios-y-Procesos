package clienteservidortcpmultihilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 5656;

    public static void main(String[] args) {
        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        Contador contador = new Contador();

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
                Jugador worker = new Jugador(socketCliente, contador);
                worker.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
