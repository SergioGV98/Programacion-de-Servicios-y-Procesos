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
                    informacion += linea + "\n";
                }
            }

            if (informacion.contains("enp4s0:")) {
                ret += "enp4s0 [activa]\n";
            } else {
                ret += "enp4s0 [no activa]\n";
            }

            if (informacion.contains("enp0s3")) {
                if (informacion.contains("enp0s3:")) {
                    String enp0s3 = informacion.substring(informacion.indexOf("enp0s3: "), informacion.length());
                    String inet = enp0s3.substring(enp0s3.indexOf("inet"), enp0s3.indexOf("netmask"));
                    String netmask = enp0s3.substring(enp0s3.indexOf("netmask"), enp0s3.indexOf("broadcast"));
                    ret += "enp0s3 [" + inet.substring(inet.indexOf(" ")).trim() + "/" + netmask.substring(netmask.indexOf(" ")).trim() + "]\n";
                }
            }

            if (informacion.contains("lo: flags")) {
                String lo = informacion.substring(informacion.indexOf("lo:"), informacion.length());
                String inet = lo.substring(lo.indexOf("inet"), lo.indexOf("netmask"));
                String netmask = lo.substring(lo.indexOf("netmask"), lo.indexOf("inet6"));
                ret += "lo [" + inet.substring(inet.indexOf(" ")).trim() + "/" + netmask.substring(netmask.indexOf(" ")).trim() + "]\n";
            }

            if (informacion.contains("wlp3s0:")) {
                String wlp3s0 = informacion.substring(informacion.indexOf("wlp3s0:"), informacion.length());
                String inet = wlp3s0.substring(wlp3s0.indexOf("inet"), wlp3s0.indexOf("netmask"));
                String netmask = wlp3s0.substring(wlp3s0.indexOf("netmask"), wlp3s0.indexOf("broadcast"));
                ret += "wlp3s0 [" + inet.substring(inet.indexOf(" ")).trim() + "/" + netmask.substring(netmask.indexOf(" ")).trim() + "]";
            } else {
                ret += "wlp3s0 [no activa]";
            }

            p.waitFor();

            System.out.println(ret);

        } catch (IOException | InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

    }

}
