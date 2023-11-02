
package hilos_implements_runnable;

public class Hilo implements Runnable{
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Hilo hijo");
        }
    }
    
}
