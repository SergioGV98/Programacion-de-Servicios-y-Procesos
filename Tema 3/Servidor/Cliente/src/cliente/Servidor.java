
package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 4444;

    public static void main(String[] args) {
        try (ServerSocket socketServidor = new ServerSocket(PORT)) {
            System.out.println("Escuchando: " + socketServidor);

            while (true) { 
                try (Socket socketCliente = socketServidor.accept();
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                     PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

                    System.out.println("Conexión aceptada: " + socketCliente);

                    String str;
                    while ((str = entrada.readLine()) != null) { 
                        System.out.println("Cliente: " + str);
                        salida.println(str);
                        if ("Adios".equals(str)) {
                            break; 
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al tratar con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }
    }
}
