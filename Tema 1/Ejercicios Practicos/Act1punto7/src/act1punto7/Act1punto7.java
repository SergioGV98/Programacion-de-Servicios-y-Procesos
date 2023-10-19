package act1punto7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Act1punto7 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ifconfig", "-a");
        String informacion = "";
        String ret = "";

        try {
            Process p = pb.start();
            try (var br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    informacion += linea;
                }
            }
            p.waitFor();

            if (informacion.substring(informacion.indexOf("lo: flags")).contains("lo: flags")) {
                String t = informacion.substring(informacion.indexOf("lo"), informacion.length());
                String inet = t.substring(t.indexOf("inet"), t.indexOf("netmask"));
                String netmask = t.substring(t.indexOf("netmask"), t.indexOf("inet6"));
                ret += "lo[" + inet.substring(inet.indexOf(" ")).trim() + "/" + netmask.substring(netmask.indexOf(" ")).trim() + "]";
            }
            
            
            System.out.println(informacion);


            System.out.println(ret);

        } catch (IOException | InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

        System.out.println(ret);

    }

}
