package act1punto6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Act1punto6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String comando = "";
        ProcessBuilder pb;
        do {
            System.out.println("Escribe el comando");
            comando = sc.nextLine();
            String[] parts = comando.split(" ");

            pb = new ProcessBuilder(parts);

            if (!comando.contains("exit") && !comando.contains("quit")) {
                try {
                    Process p = pb.start();
                    try (var br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    }
                    try (var br = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    }
                    p.waitFor();
                } catch (IOException | InterruptedException ex) {
                    System.out.printf("ERROR: %s\n", ex.getMessage());
                }
            }

        } while (!comando.contains("quit") && !comando.contains("exit"));

    }

}
