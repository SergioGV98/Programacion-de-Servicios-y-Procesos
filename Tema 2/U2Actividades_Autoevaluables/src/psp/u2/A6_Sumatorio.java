package psp.u2;

public class A6_Sumatorio {
    
    public static void main(String[] args) {
        
        Thread hilo = new Thread(new A6_Sumatorio1());
        hilo.start();
        
    }
}
