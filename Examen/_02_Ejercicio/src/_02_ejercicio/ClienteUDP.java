
package _02_ejercicio;

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
            int puerto = 12345;
            
            while (true) {
                enviados = new byte[0];
                DatagramPacket solicitud = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
                clientSocket.send(solicitud);

                DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
                clientSocket.receive(recibo);
                String respuestaServidor = new String(recibo.getData(), 0, recibo.getLength());
                System.out.println(respuestaServidor);

                String respuesta = in.readLine();
                enviados = respuesta.getBytes();
                
                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, recibo.getAddress(), recibo.getPort());
                clientSocket.send(envio);

                clientSocket.receive(recibo);
                String mensaje = new String(recibo.getData(), 0, recibo.getLength());
                System.out.println(mensaje);
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}