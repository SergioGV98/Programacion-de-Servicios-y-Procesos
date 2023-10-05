package procredirfichafich;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProcRedirFichAFich {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("ERROR: indicar: fichero_entrada fichero_salida patron");
            return;
        }

        String nomFichEntrada = args[0];
        String nomFichSalida = args[1];
        String patron = args[2];
        File error = new File("error.txt");

        System.out.printf("Buscando patrón \"%s\" en fichero %s, salida a fichero %s\n", patron, nomFichEntrada, nomFichSalida);

        ProcessBuilder pb = new ProcessBuilder("grep", patron);
        pb.redirectInput(new File(nomFichEntrada));
        pb.redirectOutput(new File(nomFichSalida));

        try {
            Process p = pb.start();
        } catch (IOException e) {
            String errorOut = e.getMessage();
            try (FileOutputStream f = new FileOutputStream(error)) {
                byte[] bytes = errorOut.getBytes();
                for (byte b : bytes) {
                    f.write(b);
                }
            } catch (IOException ex) {
                System.out.printf("ERROR: %s", ex.getMessage());
            }

        }
    }
}
