/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.u3;


/**
 *
 * @author vmartinez
 */
public class Contador {

    private int c = 0;
    boolean ahoraSumador;

    public Contador(int c) {
        this.c = c;
        ahoraSumador = true;
    }

    public synchronized void incrementa() {
        while (!ahoraSumador) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }

        // El hilo hace su tarea
        c++;
        System.out.println(Thread.currentThread().getName() + " " +  valor());
        
        // Cambia el estado y avisa al resto de hilos por si alguno puede seguir
        ahoraSumador = false;
        notifyAll();

    }

    public synchronized void decrementa() {
        while (ahoraSumador) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }

        // El hilo hace su tarea
        c--;
        System.out.println(Thread.currentThread().getName() + " " +  valor());
        
        // Cambia el estado y avisa al resto de hilos por si alguno puede seguir
        ahoraSumador = true;
        notifyAll();
    }

    public int valor() {
        return c;
    }
}
