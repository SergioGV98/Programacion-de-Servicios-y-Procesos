package act1punto3ordenarfichero;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Act1punto3OrdenarFichero {

    public static void main(String[] args) {

         if (args.length != 1) {
            System.err.println("No se encuentra el nombre del archivo");
            System.exit(1);
        }

        Scanner sc = new Scanner(System.in);

        String nombreArchivoEntrada = args[0];

        System.out.println("Dime el nombre del fichero de salida");
        String ficheroSalida = sc.nextLine();

        String[] comando = { "bash", "-c", "sort " + nombreArchivoEntrada + " > " + ficheroSalida };

        ProcessBuilder pb = new ProcessBuilder(comando);

        try {
            Process p = pb.start();
            System.out.println("Archivo ordenado correctamente.");
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        } 
    }

}
