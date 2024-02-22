package _02_ejercicio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(12345)) {
            byte[] enviados;
            byte[] recibidos = new byte[1024];
            System.out.println("Servidor encendido...");

            while (true) {

                DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
                serverSocket.receive(paqRecibido);
                InetAddress clienteAddress = paqRecibido.getAddress();
                int clientePort = paqRecibido.getPort();

                enviados = "Ingrese el nombre de la ciudad y el tipo de dato: ".getBytes();
                DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
                serverSocket.send(paqEnviado);

                serverSocket.receive(paqRecibido);
                String respuestaCliente = new String(paqRecibido.getData(), 0, paqRecibido.getLength());

                String mensaje = "";
                String[] mensajeRecibido = respuestaCliente.split(",");

                if (mensajeRecibido.length != 2) {
                    mensaje = "Respuesta del servidor: Faltan datos\n";
                } else if (!mensajeRecibido[0].equals("Nueva York") && !mensajeRecibido[0].equals("Londres") && !mensajeRecibido[0].equals("Tokio")) {
                    mensaje = "Respuesta del servidor: Ciudad incorrecta.\n";
                } else if (!mensajeRecibido[1].equals("Temperatura") && !mensajeRecibido[1].equals("Humedad") && !mensajeRecibido[1].equals("Viento")) {
                    mensaje = "Respuesta del servidor: Dato incorrecto.\n";
                } else if (mensajeRecibido[0].equals("Nueva York")) {
                    switch (mensajeRecibido[1]) {
                        case "Temperatura" -> {
                            mensaje = "Respuesta del servidor: Temperatura: 25";
                        }
                        case "Humedad" -> {
                            mensaje = "Respuesta del servidor: Humedad: 65%";
                        }
                        case "Viento" -> {
                            mensaje = "Respuesta del servidor: Viento: 10 km/h";
                        }
                    }
                } else if (mensajeRecibido[0].equals("Londres")) {
                    switch (mensajeRecibido[1]) {
                        case "Temperatura" -> {
                            mensaje = "Respuesta del servidor: Temperatura: 20";
                        }
                        case "Humedad" -> {
                            mensaje = "Respuesta del servidor: Humedad: 70%";
                        }
                        case "Viento" -> {
                            mensaje = "Respuesta del servidor: Viento: 15 km/h";
                        }
                    }
                } else if (mensajeRecibido[0].equals("Tokio")) {
                    switch (mensajeRecibido[1]) {
                        case "Temperatura" -> {
                            mensaje = "Respuesta del servidor: Temperatura: 30";
                        }
                        case "Humedad" -> {
                            mensaje = "Respuesta del servidor: Humedad: 80%";
                        }
                        case "Viento" -> {
                            mensaje = "Respuesta del servidor: Viento: 5 km/h";
                        }
                    }
                } 

                enviados = mensaje.getBytes();
                paqEnviado = new DatagramPacket(enviados, enviados.length, clienteAddress, clientePort);
                serverSocket.send(paqEnviado);
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}
