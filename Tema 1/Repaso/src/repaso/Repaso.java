package repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Repaso {

    public static void main(String[] args) {

        /**
         * ACT 1.2 | 1 ProcessBuilder pb = new
         * ProcessBuilder("gnome-system-monitor");
         *
         * try{ Process p = pb.start(); System.out.printf("Informacion del
         * proceso: %s\n", p.info()); System.out.printf("¿Proceso activo?:
         * %s\n", p.isAlive()); System.out.printf("PID del proceso %s\n",
         * p.pid()); try{ System.out.printf("Codigo del retorno: %s\n",
         * p.exitValue()); } catch (IllegalThreadStateException ex){
         * System.out.printf("ERROR: %s\n", ex.getMessage()); }
         * Thread.sleep(5000); p.destroy(); System.out.printf("¿Proceso activo?:
         * %s\n", p.isAlive()); System.out.printf("Codigo del retorno: %s\n",
         * p.exitValue()); } catch(IOException | InterruptedException ex){
         * System.out.printf("ERROR: %s\n", ex.getMessage()); }
         */
        /*
        ProcessBuilder pb = new ProcessBuilder("ls", "-l", "-a");
        pb.inheritIO();
        try {
            Process p = pb.start();
        } catch (IOException ex) {
           System.out.printf("ERROR: %s\n", ex.getMessage());
        }
         */
        Scanner sc = new Scanner(System.in);

        /*
        String ficheroEn = "";
        String ficheroSal = "";

        ProcessBuilder pb = new ProcessBuilder("wc");
        pb.inheritIO();

        do {
            System.out.println("Nombre para el fichero de entrada");
            ficheroEn = sc.nextLine();

            if (!ficheroEn.contains("exit")) {
                System.out.println("Nombre para el fichero de salida");
                ficheroSal = sc.nextLine();

                pb.redirectInput(new File(ficheroEn));
                pb.redirectOutput(new File(ficheroSal));

                try {
                    Process p = pb.start();
                } catch (IOException ex) {
                    System.out.printf("ERROR: %s\n", ex.getMessage());
                }

            }

        } while (!ficheroEn.contains("exit"));
         */
        
        
        ProcessBuilder pb = new ProcessBuilder("sort");

        if (args.length < 1) {
            System.out.println("Faltan argumentos");
            return;
        }

        System.out.println("Dime el nombre del fichero de salida");
        String ficheroSalida = sc.nextLine();

        pb.redirectInput(new File(args[0]));
        
        try {
            Process p = pb.start();
            try(var br = new BufferedReader(new InputStreamReader(p.getInputStream())); var salida = new FileWriter(new File(ficheroSalida))){
                String linea;
                while ((linea = br.readLine()) != null){
                    salida.write(linea + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
