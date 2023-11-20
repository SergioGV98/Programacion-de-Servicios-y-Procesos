package ejercicioconcierto;

import java.util.Random;

public class EjercicioConcierto {

    public static void main(String[] args) {

        Concierto concierto = new Concierto(50);

        Random r = new Random();

        int nCompradores = r.nextInt(1, 51);
        //Meter un arrayList de comprador

        for (byte i = 1; i < nCompradores; i++) {
            Comprador comprador = new Comprador(i, "\u001B[32m", concierto);
            //añadir comprador al arraylist
            comprador.start();
        }
        
        //Bucle for que recorra el arraylist y haga un join en cada uno.

        System.out.printf("Entradas restantes despues de las compras: %d\n", concierto.getEntradas());
    }

}
