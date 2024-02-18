package psp.u4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJuego {

    public static final int PORT = 1234;

    public static void main(String[] args){

        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;
        Scanner stdIn = new Scanner(System.in);
        String linea;
        WorkerJuego w = new WorkerJuego();

        try {
            socketCliente = new Socket("localhost", PORT);
            entrada = new BufferedReader(
                    new InputStreamReader(
                            socketCliente.getInputStream()));
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println(
                    "No se puede establecer canales de E/S para la conexión");
            System.exit(-1);
        }

        try {

            linea = entrada.readLine();
            System.out.println(linea);

            linea = stdIn.nextLine();
            salida.println(linea);

            linea = entrada.readLine();
            System.out.println(linea);

            while (true) {

                linea = stdIn.nextLine();
                salida.println(linea);

                String pista = entrada.readLine();
                switch (pista) {
                    case "+":
                        pista = "El número es mayor";
                        break;
                    case "-":
                        pista = "El número es menor";
                        break;
                    case "=":
                        pista = "El número es correcto";
                        break;
                    case "EXIT":
                        break;
                }

                System.out.println(pista);
                
                if(pista.equals("El número es correcto"))
                {
                    break;
                }

                if (!pista.equals("EXIT")) {
                    String intentosRestantes = entrada.readLine();
                    System.out.println(intentosRestantes);               
                } else {
                    salida.close();
                    entrada.close();
                    socketCliente.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        }

    }

}
