package clienteservidortcpmultihilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Jugador extends Thread {

    private final Socket socketCliente;
    private final Contador contador;

    public Jugador(Socket socketCliente, Contador contador) {
        this.socketCliente = socketCliente;
        this.contador = contador;
    }

    @Override
    public void run() {
        try (var entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {
            String linea;
            while (true) {
                 salida.println("Bienvenido al servidor. Por favor, elija una opción:\n\t1. Sumar al contador\n\t2. Restar al contador\n\tCualquier otro numero cerrara el servidor.");
                
                linea = entrada.readLine();
                System.out.println(linea);

                int opcion = Integer.parseInt(linea);

                switch (opcion) {
                    case 1 -> {
                        salida.println("Introduce la cantidad que quieres sumar:");
                        int cantidadSumar = Integer.parseInt(entrada.readLine());
                        contador.sumar(cantidadSumar);
                        salida.println("Suma realizada. El contador ahora es: " + contador.getContador());
                    }
                    case 2 -> {
                        salida.println("Introduce la cantidad que quieres restar:");
                        int cantidadRestar = Integer.parseInt(entrada.readLine());
                        contador.restar(cantidadRestar); // Aquí estaba el error, debería ser contador.restar(cantidadRestar)
                        salida.println("Resta realizada. El contador ahora es: " + contador.getContador());
                    }
                    default -> {
                        salida.println("Opción no válida. Desconectando del servidor.");
                        System.out.println("Desconectando del servidor.");
                        return;
                    }
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
            System.exit(-1);
        }
    }

}
