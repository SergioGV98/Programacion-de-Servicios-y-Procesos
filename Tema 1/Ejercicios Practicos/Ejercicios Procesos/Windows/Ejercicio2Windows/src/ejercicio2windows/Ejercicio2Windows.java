
package ejercicio2windows;

import java.io.IOException;

public class Ejercicio2Windows {

    public static void main(String[] args) {
        //A) Crea un programa que lance un proceso con ProcessBuilder que se encargue de
        // ejecutar un comando sin argumentos.
        
        String comando = "dir";
        
        //B) Crea un programa que lance un proceso con ProcessBuilder que se
        // encargue de ejecutar un comando con un argumento.
        String argumento = "/s";
        
        //C) Crea un programa que lance un proceso con ProcessBuilder que se encargue
        // de ejecutar un comando con dos argumentos
        
        String argumento2 = "/b";
        
        ProcessBuilder procesoSinArgumento = new ProcessBuilder("cmd.exe", comando);
        procesoSinArgumento.inheritIO();
        
        ProcessBuilder procesoConArgumentos = new ProcessBuilder(comando, argumento);
        procesoConArgumentos.inheritIO();
        
        ProcessBuilder procesoConVariosArgumentos = new ProcessBuilder(comando, argumento, argumento2);
        procesoConVariosArgumentos.inheritIO();
        
        
        Process p;
        try {
            //A)
            System.out.println("COMANDO SIN ARGUMENTOS");
            p = procesoSinArgumento.start();
            System.out.println();      
            
            //B)
            System.out.println("COMANDO CON UN ARGUMENTO");
            p = procesoConArgumentos.start();
            System.out.println();            
            
            //C)
            System.out.println("COMANDO CON VARIOS ARGUMENTOS");
            p = procesoConVariosArgumentos.start();
            
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
}
