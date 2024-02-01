package actividad_3_1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import java.net.*;

public class Actividad_3_1 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            System.out.println("INFORMACION SOBRE MI TARJETA DE RED");
            for (NetworkInterface netIf : Collections.list(nets)) {
                if (netIf.getName().equals("eth5")) {
                    byte[] mac = netIf.getHardwareAddress();
                    System.out.printf("Interface Name: %s\n", netIf.getName());
                    System.out.printf("Interface display name: %s\n", netIf.getDisplayName());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.printf("Hardware Address: %s\n", sb.toString());
                    Enumeration<InetAddress> addresses = netIf.getInetAddresses();
                    String ipv4 = "";
                    while (addresses.hasMoreElements()) {
                        InetAddress addr = addresses.nextElement();
                        if (addr instanceof Inet4Address && !addr.isLinkLocalAddress()) {
                            ipv4 = addr.getHostAddress();
                        }
                    }
                    System.out.printf("Index: %d\n\tInetAddresses associated with this interface: %s\n", netIf.getIndex(), ipv4);
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
