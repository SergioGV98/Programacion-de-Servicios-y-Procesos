package actividad_7;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Pattern;

public class Actividad_7 {

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
        } catch (Exception e) {
            System.out.printf("ERROR: %s\n", e.getMessage());
        }
    }
}
