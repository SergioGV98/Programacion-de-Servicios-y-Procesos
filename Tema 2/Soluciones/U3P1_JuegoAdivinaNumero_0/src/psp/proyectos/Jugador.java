package psp.proyectos;

import java.util.concurrent.ThreadLocalRandom;

public class Jugador implements Runnable {


    final private int MAX_DELAY = 5000;
    final private int MIN_DELAY = 1000;

    private final Partida partida;
    private final String nombre;

    Jugador(String nombre, Partida partida) {
        this.partida = partida;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        // Asignamos nombre al hilo
        Thread.currentThread().setName(nombre);
        
        while (!partida.haTerminado()) {
            // La elección de número la paso al interior de jugador
            // si la hago aquí, aunque compruebe que no está dicho el número
            // puede que otro jugador lo diga mientras espera a que le toque
            partida.juega();           
            try {
                Thread.sleep((long)(ThreadLocalRandom.current().nextDouble()*(MAX_DELAY-MIN_DELAY)+MIN_DELAY));
            } catch (InterruptedException ex) { }
        }
    }
}
