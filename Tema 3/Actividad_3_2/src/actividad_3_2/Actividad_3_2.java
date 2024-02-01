
package actividad_3_2;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Actividad_3_2 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netIf : Collections.list(nets)) {
                if (netIf.getName().equals("eth5")) {
                    for (InterfaceAddress interfaceAddress : netIf.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet4Address) {
                            System.out.printf("Nombre de la interfaz: %s\n", netIf.getDisplayName());
                            System.out.printf("Dirección de red: %s\n", address.getHostAddress());
                            System.out.printf("Dirección de broadcast: %s\n", interfaceAddress.getBroadcast().getHostAddress());
                            System.out.printf("Máscara de subred: %s\n", interfaceAddress.getNetworkPrefixLength());
                            System.out.printf("Hashcode: %d\n",interfaceAddress.hashCode());
                            System.out.printf("Formato extendido: %s/%s [/%s]\n", interfaceAddress.getAddress(), interfaceAddress.getNetworkPrefixLength(), interfaceAddress.getBroadcast().getHostAddress());
                            break;  
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}