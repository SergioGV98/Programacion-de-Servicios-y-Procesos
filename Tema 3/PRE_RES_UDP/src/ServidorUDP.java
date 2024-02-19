import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ServidorUDP {
    public static void main(String[] args) {
        // Preguntas y respuestas predefinidas
        Map<String, String> preguntasRespuestas = new HashMap<>();
        preguntasRespuestas.put("Cual es la capital de Francia?", "Paris");
        preguntasRespuestas.put("Cual es el rio mas largo del mundo?", "Amazonas");
        preguntasRespuestas.put("Cual es el planeta mas grande del sistema solar?", "Jupiter");

        // Configuración del servidor
        DatagramSocket socket;
        final int PUERTO = 12345;
        byte[] buffer = new byte[1024];

        try {
            socket = new DatagramSocket(PUERTO);
            System.out.println("Servidor UDP iniciado");

            while (true) {
                // Esperar conexión del cliente
                DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteEntrada);
                InetAddress direccionCliente = paqueteEntrada.getAddress();
                int puertoCliente = paqueteEntrada.getPort();
                System.out.println("Conexión establecida con " + direccionCliente + ":" + puertoCliente);

                // Enviar pregunta aleatoria al cliente
                Random random = new Random();
                String[] keys = preguntasRespuestas.keySet().toArray(new String[0]);
                String preguntaAleatoria = keys[random.nextInt(keys.length)];
                DatagramPacket paqueteSalida = new DatagramPacket(preguntaAleatoria.getBytes(), preguntaAleatoria.getBytes().length, direccionCliente, puertoCliente);
                socket.send(paqueteSalida);

                // Esperar respuesta del cliente
                DatagramPacket respuestaCliente = new DatagramPacket(buffer, buffer.length);
                socket.receive(respuestaCliente);
                String respuesta = new String(respuestaCliente.getData(), 0, respuestaCliente.getLength());

                // Evaluar respuesta y enviar retroalimentación
                String mensaje;
                System.out.println(preguntasRespuestas.get(preguntaAleatoria));
                if (preguntasRespuestas.get(preguntaAleatoria).equalsIgnoreCase(respuesta)) {
                    mensaje = "Respuesta correcta!";
                } else if (respuesta.equalsIgnoreCase("FIN")) {
                    mensaje = "Sesion finalizada!";
                } else {
                    mensaje = "Respuesta incorrecta. Intentalo de nuevo.";
                }
                paqueteSalida = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, direccionCliente, puertoCliente);
                socket.send(paqueteSalida);

                // Si el cliente envía "FIN", cerrar la sesión
                if (respuesta.equalsIgnoreCase("FIN")) {
                    break;
                }
            }

            System.out.println("Cerrando servidor...");
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
