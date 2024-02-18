package actividad3_11;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

class ClienteUDP {

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {

            InetAddress IPServidor = InetAddress.getLocalHost();
            int puerto = 5555;
            ClienteHandler clienteHandler = new ClienteHandler(clientSocket, IPServidor, puerto);
            clienteHandler.start();

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}