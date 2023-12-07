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
public class Sumador  extends Thread {
    private final Contador c;
    public Sumador(String name, Contador c) {
        super(name);
        this.c = c;
        
    }
    
    @Override
    public void run() {
        // Ejecutar 300 veces con espera entre 50ms y 150ms
        for (int i = 0; i < 100; i++) {
            try {
                c.incrementa();
                Thread.sleep((long) (Math.random() * 100 + 50));
            } catch (InterruptedException ex) {
                // Nothing
            }            
        }
    }
}
