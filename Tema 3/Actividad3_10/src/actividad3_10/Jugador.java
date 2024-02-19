package actividad3_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Jugador extends Thread {

    private final Socket socketCliente;
    private final int numeroAdivinar;

    public Jugador(Socket socketCliente) {
        Random r = new Random();
        this.socketCliente = socketCliente;
        this.numeroAdivinar = r.nextInt(1, 31);
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {
            String nombreJugador;
            int intentosRestantes = 5;
            String str;

            salida.println("Introduce nombre del jugador");
            nombreJugador = entrada.readLine();
            salida.println("Adivina el numero entre 1 y 30");

            while ((str = entrada.readLine()) != null) {
                if (intentosRestantes != 0) {
                    try {
                        int numeroAdivinado = Integer.parseInt(str);
                        if (numeroAdivinado == numeroAdivinar) {
                            salida.println("¡Felicidades, has adivinado el numero!");
                            break;
                        } else if (numeroAdivinado < numeroAdivinar) {
                            salida.printf("%s el numero es mayor, te quedan %d intentos.\n", nombreJugador, intentosRestantes);
                            intentosRestantes--;
                        } else {
                            salida.printf("%s el numero es menor, te quedan %d intentos.\n", nombreJugador, intentosRestantes);
                            intentosRestantes--;
                        }
                    } catch (NumberFormatException e) {
                        salida.println("Error en el formato: " + e.getMessage());
                        System.out.println("Error en el formato: " + e.getMessage());
                    }
                } else {
                     salida.println("¡Te has quedado sin intentos!");
                     break;
                }
            }

        } catch (IOException e) {
            System.out.printf("ERROR %s\n", e.getMessage());
        }
    }

}
