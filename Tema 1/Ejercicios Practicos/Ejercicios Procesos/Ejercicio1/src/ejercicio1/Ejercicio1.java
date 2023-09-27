package ejercicio1;

import java.io.IOException;


public class Ejercicio1 {

    public static void main(String[] args) {
        
        //A) Crear un proceso con ProcessBuilder
        ProcessBuilder proceso = new ProcessBuilder("bash", "-c", "ps aux | grep 'Z'");
        proceso.inheritIO();
        
        try {
            Process p = proceso.start();
            p.waitFor();
            
            //B) Muestra informacion del proceso
            System.out.println("Informacion del proceso " + p.info());
            
            //C) Muestra si el proceso esta Activo
            System.out.println("¿Esta vivo el proceso? " + p.isAlive());
            
            //D) Muestra el PID del proceso.
            System.out.println("PID del proceos:  " + p.pid());
            
            //E) Muestra el codigo de retorno del proceso
            System.out.println("Codigo del retorno:  " + p.exitValue());
            
            //F) Espera 5 segundos y mata al proceso
            Thread.sleep(5000);
            p.destroy();
            
            //G) Muestra de nuevo si el proceso esta activo.
            System.out.println("¿Esta vivo el proceso? " + p.isAlive());
            
            //H) Muestra el codigo de retorno del proceso
            System.out.println("Codigo del retorno:  " + p.exitValue());
            
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
