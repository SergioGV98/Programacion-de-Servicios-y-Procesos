package actividad3_11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class ServidorUDP {

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(5555)) {
            System.out.println("Servidor encendido...");

            while (true) {
                byte[] recibidos = new byte[1024];
                DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);

                // Crear un nuevo hilo para manejar la solicitud del cliente
                Thread clientHandler = new ClienteHandler(serverSocket, paqRecibido);
                clientHandler.start();
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}
