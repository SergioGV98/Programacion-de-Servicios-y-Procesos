package clienteservidortcpmultihilolibreria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

    public static final int PORT = 5656;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Socket cliente = new Socket("localhost", PORT); var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true)) {

            String response;
            String linea;

            while (true) {

                response = entrada.readLine();
                System.out.println(response);
                response = entrada.readLine();
                System.out.println(response);
                response = entrada.readLine();
                System.out.println(response);

                linea = sc.nextLine();
                salida.println(linea);
                if (linea.equals("1")) {
                    response = entrada.readLine();
                    System.out.println(response);
                    linea = sc.nextLine();
                    salida.println(linea);
                    response = entrada.readLine();
                    System.out.println(response);
                    linea = sc.nextLine();
                    salida.println(linea);
                    response = entrada.readLine();
                    System.out.println(response);
                }
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
            System.exit(-1);
        }
    }
}
