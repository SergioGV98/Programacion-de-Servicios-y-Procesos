package ejercicio3;

import java.io.IOException;

public class Ejercicio3 {


    public static void main(String[] args) {
        
        //A) Ejecucion de programa que no existe.
        ProcessBuilder programaNoExiste = new ProcessBuilder("Comando_que_no_existe");
        programaNoExiste.inheritIO();
        
        ProcessBuilder comandoFallo = new ProcessBuilder("ls /et");
        comandoFallo.inheritIO();
        
        
        Process p;
        
        try {
            p = programaNoExiste.start();
            p.waitFor();
                
            p = comandoFallo.start();
            p.waitFor();
        } catch (IOException |  InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
