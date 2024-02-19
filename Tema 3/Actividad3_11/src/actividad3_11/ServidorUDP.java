package actividad3_11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

public class ServidorUDP {

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(5555)) {
            byte[] enviados;
            byte[] recibidos = new byte[1024];
            GeneradorPreguntas generador = new GeneradorPreguntas();
            System.out.println("Servidor encendido...");

            while (true) {
                // Obtener una nueva pregunta aleatoria para cada cliente
                Map.Entry<String, String> pregunta = generador.obtenerPreguntaAleatoria();
                String preguntaString = pregunta.getKey();
                String respuesta = pregunta.getValue();

                // Esperar conexión del cliente y enviar la pregunta
                DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);
                InetAddress clienteAddress = paqRecibido.getAddress();
                int clientePort = paqRecibido.getPort();
                
                enviados = preguntaString.getBytes();
                DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
                serverSocket.send(paqEnviado);

                // Recibir respuesta del cliente
                serverSocket.receive(paqRecibido);
                String respuestaCliente = new String(paqRecibido.getData(), 0, paqRecibido.getLength());

                // Verificar respuesta y enviar mensaje al cliente
                String mensaje;
                if (respuestaCliente.equalsIgnoreCase(respuesta)) {
                    mensaje = "¡Respuesta correcta!\n";
                } else {
                    mensaje = "Respuesta incorrecta. Intentalo de nuevo.\n";
                }
                enviados = mensaje.getBytes();
                paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
                serverSocket.send(paqEnviado);
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}
