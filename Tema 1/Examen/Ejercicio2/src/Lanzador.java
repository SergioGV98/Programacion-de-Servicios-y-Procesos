import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {

    public static void main(String[] args) {

        String frase = "";
        
        for(int i = 0; i < args.length; i++){
            frase += args[i] + " ";
        }
        args[0] = frase;
        
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "build/classes/", "ConvertidorMayus", args[0]);

        try{
            Process p = pb.start();
            
            try(var br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    var fw = new FileWriter(new File("mayusculas.txt"))){
                String linea;
                while((linea = br.readLine()) != null){
                    fw.write(linea);
                }
            }
            
        } catch(IOException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
    }

}
