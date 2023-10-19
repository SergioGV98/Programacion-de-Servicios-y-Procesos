package act1punto5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Act1punto5 {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Faltan argumentos.");
            return;
        }
        
        ProcessBuilder pb = new ProcessBuilder("md5sum", args[1]);

        if (args[0].contains("-l")) {
            try {
                Process p = pb.start();
                try (var br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                }
            } catch (IOException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

        if (args[0].contains("-c")) {
            try{
                Process p = pb.start();
                try(var br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                    String linea;
                    String ret = "";
                    
                    while ((linea = br.readLine()) != null) {
                        ret += linea;
                    }
                    
                    try(var fw = new FileWriter(args[1]+".md5")){
                        fw.write(ret);
                    }
                }
            }catch(IOException ex){
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

    }

}
