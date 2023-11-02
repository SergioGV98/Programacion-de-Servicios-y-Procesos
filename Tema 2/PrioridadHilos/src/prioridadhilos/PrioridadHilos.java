package prioridadhilos;

public class PrioridadHilos {

    public static void main(String[] args) {
        
        Hilo h1 = new Hilo();
        Hilo h2 = new Hilo();
        Hilo h3 = new Hilo();
        
        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        
        h1.start();
        h2.start();
        h3.start();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Error en el hilo.");
        }
        
        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();
        
        System.out.println("H2 (Prio. Max): " + h2.getContador());
        System.out.println("H1 (Prio. Normal): " + h1.getContador());
        System.out.println("H3 (Prio. Min): " + h3.getContador());
        
    }
    
}
