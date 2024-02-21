
package actividad3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClienteUDP {

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] enviados;
            byte[] recibidos = new byte[1024];

            InetAddress IPServidor = InetAddress.getLocalHost();
            int puerto = 5555;
            
            while (true) {
                // Enviar solicitud al servidor para recibir la pregunta
                enviados = new byte[0];
                DatagramPacket solicitud = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
                clientSocket.send(solicitud);

                // Recibir pregunta del servidor
                DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
                clientSocket.receive(recibo);
                String pregunta = new String(recibo.getData(), 0, recibo.getLength());
                System.out.println(pregunta);

                // Introducir respuesta
                System.out.println("Introduce la respuesta (o escribe FIN para salir): ");
                String respuesta = in.readLine();
                enviados = respuesta.getBytes();

                // Salir si la respuesta es "EXIT"
                if (respuesta.equalsIgnoreCase("FIN")) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                // Enviar respuesta al servidor
                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, recibo.getAddress(), recibo.getPort());
                clientSocket.send(envio);

                // Recibir mensaje de confirmación del servidor
                clientSocket.receive(recibo);
                String mensaje = new String(recibo.getData(), 0, recibo.getLength());
                System.out.println(mensaje);
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}