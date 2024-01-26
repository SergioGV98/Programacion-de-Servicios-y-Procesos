package actividad_3_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Actividad_3_7 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com/");
            try (InputStream is = url.openStream(); var br = new BufferedReader(new InputStreamReader(is))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains("https")) {
                        System.out.println(linea.trim().subSequence(3, linea.length() - 8));
                    }
                }
            }
        } catch (IOException e) {
            System.out.printf("ERROR: %s\n", e.getMessage());
        }
    }
}
