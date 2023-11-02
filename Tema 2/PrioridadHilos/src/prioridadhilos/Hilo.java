package prioridadhilos;

public class Hilo extends Thread{
    
    private int c = 0;
    
    public int getContador(){
        return c;
    }
    
    public void pararHilo(){
        interrupt();
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) c++;
    }
    
    
}
