
package clienteservidorudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {

    public static void main(String[] args) {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int contador = 0;
        boolean seguir = true;
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] enviados = new byte[1024];
            byte[] recibidos = new byte[1024];
            while (seguir) {
                InetAddress IPServidor = InetAddress.getLocalHost();
                int puerto = 9876;
                System.out.println("Almacen de numero, contador en " + contador + ".\nDame una operacion simple (suma, resta, division o multiplicacion)\nEjemplo: +5, -70, *8, /2");
                String cadena = in.readLine();
                enviados = cadena.getBytes();

                //--------------------------
                System.out.println("Enviando " + enviados.length + " bytes al servidor.");
                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
                clientSocket.send(envio);

                //--------------------------
                DatagramPacket recibido = new DatagramPacket(recibidos, recibidos.length);
                System.out.println("Esperando diagrama...");
                clientSocket.receive(recibido);
                String numero = new String(recibido.getData(), 0, recibido.getLength()).trim();

                if (numero.equals("FIN")) {
                    seguir = false;
                } else {
                    InetAddress IPOrigen = recibido.getAddress();
                    int puertoOrigen = recibido.getPort();
                    System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen);
                    System.out.println("\tDatos: " + numero.trim());
                    if (numero.equals("ERROR: Mensaje Vacio, por favor vuelve a introducir el mensaje.")) {

                    } else {
                        contador = Integer.parseInt(numero);
                    }
                }
                //-----------------------------

            }

            clientSocket.close();
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
