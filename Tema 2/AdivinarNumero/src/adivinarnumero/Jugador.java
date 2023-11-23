
package adivinarnumero;

import java.util.Random;

public class Jugador extends Thread{
    
    private final int numero;
    private final Juego juego;
    private final String color;
    private boolean acertado;

    public Jugador(int numero, Juego juego, String color) {
        this.numero = numero;
        this.juego = juego;
        this.color = color;
    }

    public boolean isAcertado() {
        return acertado;
    }
    
    @Override
    public void run() {
          try {
            Random r = new Random();
            acertado = juego.adivinarNumero(color, numero, r.nextInt(1,juego.getNumeroMaximo()+1));
            Thread.sleep((long) (r.nextInt(100, 501)));
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
    
}
