
package servidorudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClienteUDP {
    
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        try(DatagramSocket clienteSocket = new DatagramSocket()){
            
            byte [] recibidos = new byte[1024];
            byte [] enviados = new byte[1024];
            
            
            InetAddress IPServidor = InetAddress.getLocalHost();
            int puerto = 9876;
            
            System.out.println("Introduce un mensaje");
            String cadena = in.readLine();
            enviados = cadena.getBytes();
            
            System.out.println("Enviando " + enviados.length + " bytes al servidor.");
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
            clienteSocket.send(envio);
            
            DatagramPacket recibido = new DatagramPacket(recibidos, recibidos.length);
            System.out.println("Esperando datagramas...");
            clienteSocket.receive(recibido);
            String mayuscula = new String(recibido.getData());
            
            InetAddress IPOrigen = recibido.getAddress();
            int puertoOrigen = recibido.getPort();
            System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen);
            System.out.println("\tDatos: " + mayuscula.trim());
            
            clienteSocket.close();       
        } catch(SocketException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } catch(IOException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
    }

}
