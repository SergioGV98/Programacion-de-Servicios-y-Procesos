package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad3_9 {

    public static void main(String[] args) {

        try (ServerSocket socketServidor = new ServerSocket(4404)) {
            System.out.println("Escuchando: " + socketServidor);
            while (true) {
                Socket socketCliente = socketServidor.accept();
                System.out.println("Conexión aceptada: " + socketCliente);

                Thread clienteThread = new Cliente(socketCliente);
                clienteThread.start();
            }

        } catch (IOException e) {
            System.out.printf("No puede escuchar en el puerto: %d\n", 4404);
            System.exit(-1);
        }
    }
}
