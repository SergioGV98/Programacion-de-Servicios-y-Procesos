package servidorudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {

    public static void main(String[] args) {
        
        try(DatagramSocket serverSocket =  new DatagramSocket(9876)){
            
            byte [] recibidos = new byte[1024];
            byte [] enviados = new byte[1024];
            String cadena;
            
            while (true) {                
                System.out.println("Esperando datagrama.....");
                
                recibidos = new byte[1024];
                DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);
                cadena = new String(paqRecibido.getData());
                
                InetAddress IPOrigen = paqRecibido.getAddress();
                int puerto = paqRecibido.getPort();
                System.out.println("\tOrigen: " + IPOrigen + ":" +puerto);
                System.out.println("\tMensaje recibido: " + cadena.trim());
                
                String mayuscula = cadena.trim().toUpperCase();
                enviados = mayuscula.getBytes();
                
                DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                serverSocket.send(paqEnviado);
                
                if(cadena.trim().contains("*")){
                    break;
                }
            }
            serverSocket.close();
            System.out.println("Socket cerrado...");
        } catch(SocketException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } catch(IOException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}
