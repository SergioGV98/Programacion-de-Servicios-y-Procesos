package psp.actividades;

import java.util.concurrent.ThreadLocalRandom;

public class U3A38_Persona implements Runnable {

    private final U3A38_ControlPuente puente;
    private final String nombre;
    private final int peso;
    private final int tiempoPasoMin;
    private final int tiempoPasoMax;
    

    U3A38_Persona(int tiempoPasoMin, int tiempoPasoMax, int pesoMin, int pesoMax, int id, U3A38_ControlPuente puente) {
        
        this.nombre = "Persona " + id;
        this.peso = ThreadLocalRandom.current().nextInt(pesoMin, pesoMax+1);
        this.puente = puente;
        this.tiempoPasoMin = tiempoPasoMin;
        this.tiempoPasoMax = tiempoPasoMax;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getPeso() {
        return peso;
    }
    
    @Override
    public void run() {

        // Asignamos nombre al hilo
        Thread.currentThread().setName(nombre);
         
        // La persona intenta pasar el puente
        puente.entrar(this);
        
        // Hacemos una espera para simular el tiempo que la persona tarda en cruzar el puente
        try {
            long t = (long) (ThreadLocalRandom.current().nextDouble() * (tiempoPasoMax - tiempoPasoMin) + tiempoPasoMin);
            while (t > 0) {
                // Hemos tomado como unidad 10ms = 1 min
                // Esperan entre 10 y 50 minutos
                // Actualizamos la info cada 10min --> 100ms
                Thread.sleep(100);
                System.err.println(getNombre() + " me quedan " + t/10 + " minutos para terminar de cruzar");
                t-=100;
                
            }
        } catch (InterruptedException ex) {
                System.err.println("Problema mientras (" + nombre + ") cruza el puente: " + ex.getLocalizedMessage());
        }

        // La persona sale del puente
        puente.salir(this);
    }

}
