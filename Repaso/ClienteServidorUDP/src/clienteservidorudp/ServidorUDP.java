package clienteservidorudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

    public static void main(String[] args) {

        int contador = 0;
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            byte[] recibidos = new byte[1024];
            byte[] enviados = new byte[1024];
            String cadena;
            while (true) {

                System.out.println("Esperando datagrama...");

                recibidos = new byte[1024];
                DatagramPacket pagRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(pagRecibido);
                cadena = new String(pagRecibido.getData(), 0, pagRecibido.getLength()).trim();

                InetAddress IPOrigen = pagRecibido.getAddress();
                int puerto = pagRecibido.getPort();
                System.out.println("\tOrigen: " + IPOrigen + ":" + puerto);
                System.out.println("\tMensaje recibido: " + cadena.trim());

                //-----------------
                if (cadena.length() > 0) {
                    if (cadena.contains("FIN")) {
                        String cerrar = "FIN";
                        enviados = cerrar.getBytes();
                        DatagramPacket pagEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                        serverSocket.send(pagEnviado);
                        serverSocket.close();
                        System.out.println("Socket cerrado...");
                    } else {
                        //------
                        char cadenaChar = cadena.charAt(0);
                        String cadenaPrimerCaracter = cadena.substring(1);
                        System.out.println("Subcadena para convertir a entero: " + cadenaPrimerCaracter);
                        int operar = Integer.parseInt(cadenaPrimerCaracter);
                        System.out.println("Operación a realizar: " + contador + " " + operar);
                        //-------
                        if (cadenaChar == '+') {
                            contador += operar;
                        }
                        if (cadenaChar == '-') {
                            contador -= operar;
                        }
                        if (cadenaChar == '*') {
                            contador *= operar;
                        }
                        if (cadenaChar == '/') {
                            contador /= operar;
                        }
                    }
                    System.out.println("TOTAL: " + contador);
                    enviados = String.valueOf(contador).getBytes();
                    DatagramPacket pagEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                    serverSocket.send(pagEnviado);

                } else {
                    String vacio = "ERROR: Mensaje Vacio, por favor vuelve a introducir el mensaje.";
                    enviados = vacio.getBytes();
                    DatagramPacket pagEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
                    serverSocket.send(pagEnviado);
                    System.out.println("Socket cerrado...");
                }

            }
        } catch (IOException ex) {
            System.out.printf(ex.getMessage());
        }
    }
}
