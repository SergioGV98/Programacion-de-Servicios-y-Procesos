package repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
 /*
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
         */
 /*
 
        ArrayList<String> comandos = new ArrayList<String>();
        try (var br = new BufferedReader(new FileReader("comandos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                comandos.add(linea);
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

        for (int i = 0; i < comandos.size(); i++) {
            if(comandos.get(i).equals("sort")){
                ProcessBuilder pb = new ProcessBuilder(comandos.get(i), "prueba.txt");
                try{
                    Process p = pb.start();
                    try(var br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
                            var salida = new FileWriter(new File("salida.txt"))){
                        String linea;
                        while((linea = br.readLine()) != null){
                            salida.write(linea + "\n");
                            System.out.println(linea);
                        }
                    }
                } catch(IOException ex){
                    System.out.printf("ERROR: %s\n", ex.getMessage());
                }
            }
        }
         */
        //ArrayList<String> comandos = new ArrayList<String>();
        /* Comandos hacia abajo
        try (var br = new BufferedReader(new FileReader("comandos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                comandos.add(linea);
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } */
        // Comandos en fila
        /*
        try (var br = new BufferedReader(new FileReader("comandos.txt"))) {
            String linea;
            String[] comandosSinEspacios = null;
            while ((linea = br.readLine()) != null) {
                comandosSinEspacios = linea.split(" ");
            }
            for (String comando : comandosSinEspacios) {
                comandos.add(comando);
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

        ProcessBuilder pb = new ProcessBuilder();

        try {
            for (byte i = 0; i < comandos.size(); i++) {
                pb = new ProcessBuilder(comandos.get(i));
                Process p = pb.start();
                try (var br = new BufferedReader(new InputStreamReader(p.getInputStream())); var fw = new FileWriter(new File("salida.txt"), true)) {
                    fw.write("Comando> " + comandos.get(i) + "\n");
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        fw.write(linea + "\n");
                    }

                }
            }
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }*/
 /*
        
        String comando = "";
        
        do{
            System.out.println("Escribe el comando");
            comando = sc.nextLine();
            String comandos [] = comando.split(" ");
            
            if(!comando.equals("exit") && !comando.equals("quit")){
                ProcessBuilder pb = new ProcessBuilder(comandos);
                try{
                    Process p = pb.start();
                    pb.redirectErrorStream(true); // Redirige los errores tambien a la salida
                    
                    try(var br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
                            var fw = new FileWriter("salida.txt", true)){
                        String linea;
                        while((linea = br.readLine()) !=  null){
                            fw.write(linea + "\n");
                        }
                    } 
                    
                } catch(IOException ex){
                    System.out.printf("ERROR: %s\n", ex.getMessage());
                }
            }
            
        }while(!comando.equals("exit") && !comando.equals("quit"));
         */
    }

}
