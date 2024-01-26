package actividad_3_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad_3_4 {

    public static void main(String[] args) {
        
       if (args.length != 1) {
            System.out.println("Por favor, proporciona un nombre de dominio como argumento.");
            return;
        }
        String nombreDominio = args[0];
        try {
            InetAddress direccionIP = InetAddress.getByName(nombreDominio);
            System.out.printf("La dirección IP asociada al dominio %s es: %s\n", nombreDominio, direccionIP.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.printf("No se pudo resolver la dirección IP para el dominio: %s\n",nombreDominio);
        }
    }
    
}
