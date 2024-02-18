package psp.u4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkerJuego extends Thread {

    public static final int NUMEROMINIMO = 1;
    private Socket socketCliente;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;
    private int intentosMaximos;
    private int numeroMaximo;

    public WorkerJuego(Socket socketCliente, int intentosMaximos, int numeroMaximo) {
        this.socketCliente = socketCliente;
        this.intentosMaximos = intentosMaximos;
        this.numeroMaximo = numeroMaximo;
    }

    public WorkerJuego() {
    }

    public int getIntentosMaximos() {
        return intentosMaximos;
    }

    @Override
    public void run() {

        try {
            String nombre;
            int numeroSecreto;
            int numeroRespuesta;
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socketCliente.getOutputStream())), true);
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));

            salida.println("Introduce nombre del jugador");
            nombre = entrada.readLine();

            salida.println("Adivina un numero entre 1 y " + numeroMaximo
                    + " (tienes " + intentosMaximos + " intentos)");

            numeroSecreto = (int) (Math.random()
                    * (numeroMaximo - NUMEROMINIMO)) + NUMEROMINIMO;
            System.out.println("El numero secreto es:" + numeroSecreto); 
            
            intentosMaximos--;
            while (true) {
                while (intentosMaximos != -1) {
                    numeroRespuesta = Integer.parseInt(entrada.readLine());
                    if (numeroRespuesta > numeroSecreto) {
                        salida.println(nombre + " el numero es menor");
                        salida.println("Te quedan " + intentosMaximos + " intentos");
                        intentosMaximos--;
                    } else if (numeroRespuesta < numeroSecreto) {
                        salida.println(nombre + " el numero es mayor");
                        salida.println("Te quedan " + intentosMaximos + " intentos");
                        intentosMaximos--;
                    } else {
                        salida.println("Enhorabuena " + nombre + " lo has acertado");
                        //salida.println(intentosMaximos);
                        break;
                    }
                }
                salida.println("EXIT");
                break;
            }
            salida.close();
            entrada.close();
            socketCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
