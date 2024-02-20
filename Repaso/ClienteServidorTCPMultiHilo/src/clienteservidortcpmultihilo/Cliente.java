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
        Contador contador = new Contador();
        
        try (Socket cliente = new Socket("localhost", PORT);
             var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
             var entradaUsuario = new BufferedReader(new InputStreamReader(System.in))) {

            String linea;
            while (true) {

                linea = entrada.readLine();
                System.out.println(linea);
                
                linea = entrada.readLine();
                System.out.println(linea);
                
                linea = entrada.readLine();
                System.out.println(linea);
                
                linea = entrada.readLine();
                System.out.println(linea);

                String opcionUsuario = entradaUsuario.readLine();
                salida.println(opcionUsuario);
                
                opcionUsuario = entradaUsuario.readLine();
                salida.println(opcionUsuario);

                // Procesar la respuesta del servidor
                linea = entrada.readLine();
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
            System.exit(-1);
        }
    }
}

