package act1punto3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Act1punto3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        ProcessBuilder pb = new ProcessBuilder("wc");
        
        String ficheroEntrada;
        String ficheroSalida;
        boolean exit = true;
        
        do{
            System.out.println("Dime el nombre del fichero de Entrada");
            ficheroEntrada = sc.nextLine();
            pb.redirectInput(new File(ficheroEntrada));
            
            if(!ficheroEntrada.equals("exit")){
                System.out.println("Dime el nombre del fichero de Salida");
                ficheroSalida = sc.nextLine();
                pb.redirectInput(new File(ficheroSalida));
            } else {
                exit = false;
            }
            
            try {
                Process p = pb.start();
            } catch (IOException ex) {
                System.out.printf("ERROR: %s", ex.getMessage());
            }
            
        } while(exit);
      
    }
    
}
