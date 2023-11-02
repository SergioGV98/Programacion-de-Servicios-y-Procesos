
package hilos_extends_thread;

import hilos_implements_runnable.*;

public class Hilo extends Thread{
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Hilo hijo");
        }
    }
    
}
