package clienteservidortcpmultihilolibreria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Comprador extends Thread {

    private final Socket socketCliente;
    private final Libreria libreria;

    public Comprador(Socket socketCliente, Libreria libreria) {
        this.socketCliente = socketCliente;
        this.libreria = libreria;
    }

    @Override
    public void run() {

        try (var entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

            String linea;

            while (true) {
                salida.printf("Bienvenido a %s. ¿Que quieres hacer?.\n", libreria.getNombre());
                salida.println("1.- Comprar un libro\n2.- Borrar un libro");

                linea = entrada.readLine();
                System.out.println(linea);

                int opcion = Integer.parseInt(linea);

                switch (opcion) {
                    case 1 -> {
                        salida.println("Introduce el libro que quieres comprar.");
                        String libro = entrada.readLine();
                        salida.println("Introduce la cantidad que vas a comprar.");
                        int cantidad = Integer.parseInt(entrada.readLine());
                        String informacion = libreria.comprar(libro, cantidad);
                        salida.println(informacion);
                    }
                }

            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

    }
}
