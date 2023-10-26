package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el fichero de entrada");
        String ficheroEntrada = sc.nextLine();
        System.out.println("Dime el fichero de salida");
        String ficheroSalida = sc.nextLine();

        try {
            ProcessBuilder pb = new ProcessBuilder("rev", ficheroEntrada);
            Process p = pb.start();
            try (var br = new BufferedReader(new InputStreamReader(p.getInputStream())); var fw = new FileWriter(new File("intermedio.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    fw.write(linea + "\n");
                }
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
        try {
            ProcessBuilder pb = new ProcessBuilder("nl", "intermedio.txt");
            Process p = pb.start();
            try (var br = new BufferedReader(new InputStreamReader(p.getInputStream())); var fw = new FileWriter(new File(ficheroSalida))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    fw.write(linea + "\n");
                }
            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

    }

}
