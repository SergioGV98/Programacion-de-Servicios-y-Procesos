package actividad_3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad_3 {

    public static void main(String[] args) {
        try {
            //192.168.96.0
            System.out.println("Scanning...");
            System.out.println("Checking network 192.168.1.0");
            for(int i = 0; i < 200; i++){
                if(InetAddress.getByName("192.168.96." + i).isReachable(100)){
                    System.out.println("192.168.96." + i);
                }
            }
            System.out.println("Scanning finish");
        } catch (UnknownHostException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
    
}
