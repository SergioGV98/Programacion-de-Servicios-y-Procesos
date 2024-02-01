package actividad_3_3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad_3 {

    public static void main(String[] args) {
        try {
            System.out.println("Scanning...");
            System.out.println("Checking network 192.168.1.0...");
            System.out.println("Reachable IPs:");
            for (int i = 1; i <= 255; i++) {
                if (InetAddress.getByName("192.168.1." + i).isReachable(1000)) {
                    System.out.printf("--> %s%d\n", "192.168.1.", i);
                }
            }
            System.out.println("Scanning finished");
        } catch (UnknownHostException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
    
}
