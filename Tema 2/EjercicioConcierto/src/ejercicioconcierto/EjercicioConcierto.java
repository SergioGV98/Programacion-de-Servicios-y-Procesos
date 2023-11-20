package ejercicioconcierto;

import java.util.ArrayList;
import java.util.Random;

public class EjercicioConcierto {

    public static void main(String[] args) {

        Concierto concierto = new Concierto(50);

        Random r = new Random();

        int nCompradores = r.nextInt(1, 51);
        ArrayList<Comprador> arr = new ArrayList<Comprador>();

        for (byte i = 1; i < nCompradores; i++) {
            Comprador comprador = new Comprador(i, "\u001B[32m", concierto);
            arr.add(comprador);
            comprador.start();
        }
        
        for(byte i = 0; i < arr.size(); i++){
            Comprador comprador = arr.get(i);
            try {
                comprador.join();
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

        System.out.printf("Entradas restantes despues de las compras: %d\n", concierto.getEntradas());
    }

}
