package _01_ejercicio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

    public static final int PORT = 12345;

    public static void main(String[] args) {

        Map<String, String> cuentas = new HashMap<>();
        cuentas.put("usuario1", "clave1");
        cuentas.put("usuario2", "clave2");
        cuentas.put("usuario3", "clave3");

        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.err.println("No puede escucharse el puerto " + PORT);
            System.exit(-1);
        }

        System.out.println("Escuchando: " + socketServidor);

        try {

            while (true) {
                socketCliente = socketServidor.accept();
                System.out.println("Conexión aceptada " + socketCliente);
                Usuario usuario = new Usuario(socketCliente, cuentas);
                usuario.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}


