package puente;

import java.util.Random;

public class Persona extends Thread {

    private final String nombre;
    private final Puente puente;
    private final int peso;

    public Persona(String nombre, Puente puente) {
        this.nombre = nombre;
        this.puente = puente;
        this.peso = generarPeso();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    private int generarPeso() {
        Random r = new Random();
        return r.nextInt(40, 121);
    }

    @Override
    public void run() {

        Random r = new Random();

        try {
            if (r.nextBoolean()) {
                puente.cruzarPuenteDerecha(this);
            } else {
                puente.cruzarPuenteIzquierda(this);
            }

            long t = r.nextInt(10000, 50001);

            while (t > 100) {
                Thread.sleep(10000);
                System.err.println(getNombre() + " me quedan " + t / 1000 + " segundos minutos para terminar de cruzar");
                t -= 10000;
            }
            puente.terminarCruzarPuente(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }

    }

}
