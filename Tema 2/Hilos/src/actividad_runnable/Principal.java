package actividad_runnable;

import actividad_thread.*;

public class Principal {

    public static void main(String[] args) {
       
        LanzaHilo launch = new LanzaHilo(5);
        Thread hilo = new Thread(launch);
        LanzaHilo launch1 = new LanzaHilo(3);
        Thread hilo2 = new Thread(launch1);
        LanzaHilo launch2 = new LanzaHilo(10);
        Thread hilo3 = new Thread(launch2);
        hilo.start();
        hilo2.start();
        hilo3.start();
        System.out.println("Comienza la cuenta atras!");
        
        
    }
    
}
