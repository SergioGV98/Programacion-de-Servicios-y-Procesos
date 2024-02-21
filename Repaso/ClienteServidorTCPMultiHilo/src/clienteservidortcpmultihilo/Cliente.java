package clienteservidortcpmultihilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static final int PORT = 5656;

    public static void main(String[] args) {
        try (Socket cliente = new Socket("localhost", PORT); var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true); var entradaUsuario = new BufferedReader(new InputStreamReader(System.in))) {

            String send;
            String response;

            while (true) {

                while ((response = entrada.readLine()) != null) {
                    System.out.println(response);
                }

                send = entradaUsuario.readLine();
                salida.println(send);
                
                 while ((response = entrada.readLine()) != null) {
                    System.out.println(response);
                }
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
            System.exit(-1);
        }
    }
}
