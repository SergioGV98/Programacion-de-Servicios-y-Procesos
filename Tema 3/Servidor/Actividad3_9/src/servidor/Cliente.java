package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente extends Thread {

    private final Socket socketCliente;

    public Cliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {

        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); 
                PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

            String str;
            while ((str = entrada.readLine()) != null) {
                try {
                    if (str.equalsIgnoreCase("CERRAR")) {
                        break;
                    }
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(str);
                    LocalDateTime dateTime = LocalDateTime.now();
                    String formattedDate = dateTime.format(formatter);
                    salida.printf("Respuesta servidor: %s\n", formattedDate);
                } catch (Exception e) {
                    salida.println("Error en el formato: " + e.getMessage());
                    System.out.println("Error en el formato: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.printf("ERROR %s\n", e.getMessage());
        }

    }

}
