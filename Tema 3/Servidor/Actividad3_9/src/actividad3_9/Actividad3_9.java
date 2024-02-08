package actividad3_9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Actividad3_9 {

    public static void main(String[] args) {
        
         try (ServerSocket socketServidor = new ServerSocket(4404)) {
            System.out.println("Escuchando: " + socketServidor);
            while (true) {
                try (Socket socketCliente = socketServidor.accept(); BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

                    System.out.println("Conexión aceptada: " + socketCliente);

                    String str;
                    while ((str = entrada.readLine()) != null) {
                        try {
                           
                            
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(str);
                            LocalDateTime dateTime = LocalDateTime.now();
                            String formattedDate = dateTime.format(formatter);
                            salida.printf("Respuesta servidor: %s\n", formattedDate);
                        } catch (Exception e) {
                            salida.println("Error en el formato: " + e.getMessage());
                            System.out.println("Error en el formato: " + e.getMessage());
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al tratar con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + 4404);
            System.exit(-1);
        }
        
    }
    
}
