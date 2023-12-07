/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.u3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vmartinez
 */
public class U3S3_SharedMemory {

    public static void main(String[] args){
        // Inicializar el objeto Contador
        Contador c = new Contador(100);
        
        // Crear y lanzar 2 hilos (Sumador + Restador)
        Sumador s1 = new Sumador("Sumador1", c);
        Restador r1 = new Restador("Restador1", c);
        Thread h1 = new Thread(r1);
        
        s1.start();
        h1.start();
        
        try {
            s1.join();
            h1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(U3S3_SharedMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("El valor final de c es " + c.valor());
        
    }
    
}
