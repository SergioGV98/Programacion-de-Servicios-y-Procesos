package adivinarnumero;

import java.util.Random;

public class Juego {

    private final int numeroAdivinar;
    private final int numeroMaximo;

    public Juego(int numeroMaximo) {
        Random r = new Random();
        this.numeroAdivinar = r.nextInt(1, numeroMaximo + 1);
        this.numeroMaximo = numeroMaximo;
    }

    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public synchronized boolean adivinarNumero(String color, int idJugador, int numero) {

        if (this.numeroAdivinar != numero) {
            System.out.printf("%sJugador %d dice: %d\n", color, idJugador, numero);
        } else {
            System.out.printf("%sJugador %d dice: %d\n", color, idJugador, numero);
            System.out.printf("%sJugador %d gana!!!\n", color, idJugador);
            return true;
        }
        return false;
    }

}
