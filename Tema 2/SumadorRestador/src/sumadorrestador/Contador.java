
package sumadorrestador;

public class Contador {
    
    private int c = 0;
    
    public Contador(int c){
        this.c = c;
    }
    
    public synchronized void sumarSync() throws InterruptedException {
        while (c % 2 != 0) {
            wait();
        }
        c++;
        System.out.printf("%sSumador %d\n", "\u001B[31m", c);
        notify();
    }

    public synchronized void restarSync() throws InterruptedException {
        while (c % 2 == 0) {
            wait();
        }
        c--;
        System.out.printf("%sRestador %d\n", "\u001B[32m", c);
        notify();
    }
    
    public int valor(){
        return c;
    }

}
