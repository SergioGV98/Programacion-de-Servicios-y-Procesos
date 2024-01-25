package actividad_5;

import java.net.URL;

public class Actividad_5 {

    public static void main(String[] args) {
        try{
            URL url = new URL("http://www.example.com/inicio.htm?nombre=Fede");
            System.out.printf("Protocolo: %s\n", url.getProtocol());
            System.out.printf("Nombre del Host: %s\n", url.getHost());
            System.out.printf("Nombre del recurso: %s\n", url.getFile());
            System.out.printf("Parte de la consulta: %s\n", url.getQuery());
            System.out.printf("Puerto por defecto: %d\n", url.getDefaultPort());
        }catch(Exception e){
            System.out.printf("ERROR: /s\n", e.getMessage());
        }
        
    }
    
}
