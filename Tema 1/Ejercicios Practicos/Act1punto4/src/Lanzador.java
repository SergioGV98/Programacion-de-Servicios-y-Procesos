

import java.io.File;
import java.io.IOException;

public class Lanzador {

    public static void main(String[] args) {
        
        if(args.length < 1){
            System.out.println("Falta parametros.");
            return;
        }
        
        ProcessBuilder pb;
        
        try {
            pb = new ProcessBuilder("java", "-cp", "build/classes/","Cifrado", args[0], args[1]);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File("cifrado.txt"));
            pb.start();
        } catch (IOException e){
            System.out.println("Error acceso fichero");
        }
    }
    
}
