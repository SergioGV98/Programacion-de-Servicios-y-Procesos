package adivinarnumero;

import java.util.ArrayList;

public class AdivinarNumero {

    public static void main(String[] args) {
        Juego juego = new Juego(51);
        ArrayList<Jugador> arr = new ArrayList<Jugador>();

        System.out.printf("Numero de jugadores 5\nRango de numeros: Entre 1 y 50\nNumero a adivinar: %d\n", juego.getNumeroAdivinar());

        byte i = 1;
        boolean juegoTerminado = false;

        do {
            Jugador j = new Jugador(i, juego, "\u001B[3" + i + "m");
            arr.add(j);
            j.start();

            try {
                j.join();
                if (j.isAcertado()) {
                    juegoTerminado = true;
                }
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }

            if (i == 5) {
                i = 1;
            } else {
                i++;
            }
        } while (!juegoTerminado && i <= 5);
    }

}
