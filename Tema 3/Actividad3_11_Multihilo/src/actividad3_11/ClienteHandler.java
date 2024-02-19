
package actividad3_11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

class ClienteHandler extends Thread {
    private final DatagramSocket clientSocket;
    private final InetAddress IPServidor;
    private final int puerto;

    public ClienteHandler(DatagramSocket clientSocket, InetAddress IPServidor, int puerto) {
        this.clientSocket = clientSocket;
        this.IPServidor = IPServidor;
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try {
            GeneradorPreguntas generador = new GeneradorPreguntas();

            // Obtener una nueva pregunta aleatoria para este cliente
            Map.Entry<String, String> pregunta = generador.obtenerPreguntaAleatoria();
            String preguntaString = pregunta.getKey();

            InetAddress clienteAddress = paqRecibido.getAddress();
            int clientePort = paqRecibido.getPort();
            byte[] enviados = preguntaString.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
            serverSocket.send(paqEnviado);

            // Recibir respuesta del cliente
            byte[] recibidos = new byte[1024];
            DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            serverSocket.receive(paqRecibido);
            String respuestaCliente = new String(paqRecibido.getData(), 0, paqRecibido.getLength());

            // Verificar respuesta y enviar mensaje al cliente
            String respuesta = pregunta.getValue();
            String mensaje;
            if (respuestaCliente.equalsIgnoreCase(respuesta)) {
                mensaje = "¡Respuesta correcta!\n";
            } else {
                mensaje = "Respuesta incorrecta. Inténtalo de nuevo.\n";
            }
            enviados = mensaje.getBytes();
            paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
            serverSocket.send(paqEnviado);
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}
