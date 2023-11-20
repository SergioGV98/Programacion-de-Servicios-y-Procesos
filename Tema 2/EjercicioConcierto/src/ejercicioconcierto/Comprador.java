
package ejercicioconcierto;

import java.util.Random;

public class Comprador extends Thread {
    
    private final int idComprador;
    private final String color;
    private final Concierto concierto;

    public Comprador(int idComprador, String color, Concierto concierto) {
        this.idComprador = idComprador;
        this.color = color;
        this.concierto = concierto;
    }
    
    @Override
    public void run() {
        try {
            Random r = new Random();
            concierto.comprarEntrada(color, idComprador, r.nextInt(1,5));
            Thread.sleep((long) (r.nextInt(100, 501)));
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
