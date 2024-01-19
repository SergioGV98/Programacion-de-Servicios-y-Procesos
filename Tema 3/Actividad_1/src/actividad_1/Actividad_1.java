package actividad_1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Actividad_1 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netIf : Collections.list(nets)) {
                if (netIf.getDisplayName().equals("Realtek PCIe GbE Family Controller")) {
                    byte[] mac = netIf.getHardwareAddress();
                    System.out.printf("Interface Name: %s\n", netIf.getName());
                    System.out.printf("Interface display name: %s\n", netIf.getDisplayName());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.printf("Hardware Adress: %s\n", sb.toString());
                    Enumeration<InetAddress> prueba = netIf.getInetAddresses();
                    String inet = "";
                    for(InetAddress ip : Collections.list(prueba)){
                        if(!ip.isLinkLocalAddress()){
                            inet = ip.toString();
                        }           
                    }
                    System.out.printf("Index: %d\n\tInetAdresses associated with this interface: %s\n", netIf.getIndex(), inet);
                    System.out.printf("\tMTU: %d\n", netIf.getMTU());
                    System.out.printf("\tis loopback: %s\n", netIf.isLoopback());
                    System.out.printf("\tis virtual: %s\n", netIf.isVirtual());
                    System.out.printf("Support Multicast: %s\n", netIf.supportsMulticast());
                }
            }
        } catch (SocketException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
