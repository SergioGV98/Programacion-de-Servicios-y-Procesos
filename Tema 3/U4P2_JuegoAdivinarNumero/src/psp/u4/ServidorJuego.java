/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psp.u4;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJuego {

    public static final int PORT = 1234;

    public static void main(String[] args) {
        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        int intentosMaximos = 3;
        int numeroMaximo = 30;

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
                WorkerJuego worker = new WorkerJuego(
                        socketCliente,
                        intentosMaximos,
                        numeroMaximo);
                worker.start();         
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}

