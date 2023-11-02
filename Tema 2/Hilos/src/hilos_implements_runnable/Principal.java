package hilos_implements_runnable;

public class Principal {

    public static void main(String[] args) {
        Hilo h = new Hilo();
        Thread hilo = new Thread(h);
        hilo.start();
        
        for(int i = 0; i < 10; i++){
             System.out.println("Hilo padre");
        }
        
        
    }
    
}
