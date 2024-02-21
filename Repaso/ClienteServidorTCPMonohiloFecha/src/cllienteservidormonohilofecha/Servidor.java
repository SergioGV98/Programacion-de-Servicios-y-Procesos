package cllienteservidormonohilofecha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Servidor {

    public static final int PORT = 5656;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Servidor TCP iniciado.");

            GeneradorPreguntas generador = new GeneradorPreguntas();
            generador.agregarPregunta("¿Cual es la capital de Francia?", "Paris");
            generador.agregarPregunta("¿Cuantos planetas hay en el sistema solar?", "8");
            generador.agregarPregunta("¿Quien escribio 'Don Quijote de la Mancha'?", "Miguel de Cervantes");

            try (Socket cliente = server.accept(); var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); var salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true)) {
                System.out.printf("Cliente conectado desde la IP %s\n", cliente.getRemoteSocketAddress());
                while (true) {
                    Map<String, String> preguntaRandom = generador.getPreguntaRandom();
                    salida.println(preguntaRandom.keySet());
                    String str = entrada.readLine();
                    System.out.printf("Cliente: %s\n", str);
                    if (preguntaRandom.containsValue(str)) {
                        salida.println("Server: ¡Correcto!");
                    } else if (str.equalsIgnoreCase(("Destroy"))) {
                        System.out.println("Se ha cerrado el servidor");
                        break;
                    }else {
                        salida.println("Server: ¡Incorrecto!");
                    }

                    }
                }
            } catch (IOException ex) {
                System.out.printf("ERROR: %S\n", ex.getMessage());
                System.exit(-1);
            }

        }

    }
