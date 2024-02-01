package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Cliente {

    public static void main(String[] args) {
        try (Socket socketCliente = new Socket("192.168.97.163", 4444);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
             PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

            Scanner sc = new Scanner(System.in);
            String linea;

            while (true) {
                System.out.print("Cliente: ");
                linea = sc.nextLine();

                salida.println(linea);

                linea = entrada.readLine();
                System.out.println("Respuesta del servidor: " + linea);
                if (linea.equalsIgnoreCase("Adios")) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
            System.exit(-1);
        }
    }
}