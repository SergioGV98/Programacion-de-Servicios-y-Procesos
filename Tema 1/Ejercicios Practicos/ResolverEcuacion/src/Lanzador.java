
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Lanzador {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a;
        String b;
        String c;

        System.out.println("Dime el valor de A");
        a = sc.nextLine();
        args[0] = a;

        System.out.println("Dime el valor de B");
        b = sc.nextLine();
        args[1] = b;

        System.out.println("Dime el valor de C");
        c = sc.nextLine();
        args[2] = c;

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "build/classes/", "Ecuacion", args[0], args[1], args[2]);

        try {
            pb.redirectError(new File("error.txt"));
            Process p = pb.start();
            try (var bf = new BufferedReader(new InputStreamReader(p.getInputStream())); var sal = new FileWriter(new File("salida.txt"))) {
                String linea;

                while ((linea = bf.readLine()) != null) {
                    sal.write(linea + "\n");
                }

            }

        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
