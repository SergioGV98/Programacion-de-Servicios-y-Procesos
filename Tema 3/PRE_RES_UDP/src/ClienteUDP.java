import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class ClienteUDP {
    public static void main(String[] args) {
        // Configuración del cliente
        DatagramSocket socket;
        final int PUERTO = 12345;
        byte[] buffer = new byte[1024];

        try {
            socket = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName("127.0.0.1");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Conectarse al servidor
                socket.send(new DatagramPacket("Conexión establecida".getBytes(), "Conexión establecida".getBytes().length, direccionServidor, PUERTO));

                // Recibir pregunta del servidor
                DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteEntrada);
                String pregunta = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Pregunta: " + pregunta);

                // Enviar respuesta al servidor
                String respuesta = reader.readLine();
                socket.send(new DatagramPacket(respuesta.getBytes(), respuesta.getBytes().length, direccionServidor, PUERTO));

                // Recibir retroalimentación del servidor
                DatagramPacket paqueteSalida = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteSalida);
                String mensaje = new String(paqueteSalida.getData(), 0, paqueteSalida.getLength());
                System.out.println("Servidor: " + mensaje);

                // Verificar si se quiere finalizar la sesión
                if (respuesta.equalsIgnoreCase("FIN")) {
                    break;
                }
            }

            System.out.println("Cerrando cliente...");
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


