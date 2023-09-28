package ejercicio3windows;

import java.io.IOException;

public class Ejercicio3Windows {

    public static void main(String[] args) {
        
         //A) Ejecucion de programa que no existe.
        ProcessBuilder programaNoExiste = new ProcessBuilder("Comando_que_no_existe");
        programaNoExiste.inheritIO();
        
        ProcessBuilder comandoFallo = new ProcessBuilder("dir");
        comandoFallo.inheritIO();
        
        
        Process p;
        
        try {
            p = programaNoExiste.start();
            p = comandoFallo.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
