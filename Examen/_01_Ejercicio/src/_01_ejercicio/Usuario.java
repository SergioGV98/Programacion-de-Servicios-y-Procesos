package _01_ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class Usuario extends Thread {

    private final Socket socketCliente;
    private final Map<String, String> cuentas;

    public Usuario(Socket socketCliente, Map<String, String> cuentas) {
        this.socketCliente = socketCliente;
        this.cuentas = cuentas;
    }

    public String Login(String usuario, String password) {
        if (cuentas.containsKey(usuario)) {
            String passwordActual = cuentas.get(usuario);
            if (passwordActual.equals(password)) {
                return "LOGIN_CORRECTO";
            } else {
                return "PASSWORD_INVALIDA";
            }
        } else {
            return "USUARIO_INVALIDO";
        }
    }

    @Override
    public void run() {

        try (var entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true)) {

            String usuario;
            String password;
            String mensaje;

            while (true) {
                salida.println("Usuario: ");
                usuario = entrada.readLine();
                System.out.println(usuario);
                salida.println("Password: ");
                password = entrada.readLine();
                System.out.println(password);
                
                mensaje = Login(usuario, password);
                salida.println(mensaje);
                
                if(mensaje.equalsIgnoreCase("LOGIN_CORRECTO")){
                    return;
                }
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

    }

}
