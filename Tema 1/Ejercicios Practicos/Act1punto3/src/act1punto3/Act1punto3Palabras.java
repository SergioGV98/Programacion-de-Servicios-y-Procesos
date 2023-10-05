package act1punto3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Act1punto3Palabras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProcessBuilder pb = new ProcessBuilder("wc");

        String ficheroEntrada = "";
        String ficheroSalida;
        boolean exit = true;

        do {
            System.out.println("Dime el nombre del fichero de Entrada");
            ficheroEntrada = sc.nextLine();
            if (!ficheroEntrada.equals("exit")) {
                pb.redirectInput(new File(ficheroEntrada));
                if (!ficheroEntrada.equals("exit")) {
                    System.out.println("Dime el nombre del fichero de Salida");
                    ficheroSalida = sc.nextLine();
                    pb.redirectOutput(new File(ficheroSalida));
                }
            } else {
                exit = false;
            }

            try {
                Process p = pb.start();
            } catch (IOException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }

        } while (exit);

    }

}
