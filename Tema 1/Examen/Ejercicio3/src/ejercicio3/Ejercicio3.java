package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el fichero de entrada");
        String ficheroEntrada = sc.nextLine();
        int i = 0;

        try {
            ProcessBuilder pb = new ProcessBuilder("rev", ficheroEntrada);
            Process p = pb.start();
            
            try(var br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                String linea;
                while((linea = br.readLine()) != null){
                    i++;
                    System.out.printf("%d.- %s\n", i, linea.toUpperCase());
                }
            }
            
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
    
}
