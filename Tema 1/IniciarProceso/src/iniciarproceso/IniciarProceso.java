package iniciarproceso;

import java.io.IOException;

public class IniciarProceso {

    public static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder("C:/Windows/System32/calc.exe");
        //ProcessBuilder proceso2 = new ProcessBuilder("ls","-l"); linux
        //proceso2.inheritIO();
        
        try {
            proceso.start();
            System.out.println("Proceso lanzado con éxito.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
