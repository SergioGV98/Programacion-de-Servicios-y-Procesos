package hilos_extends_thread;

public class Principal {

    public static void main(String[] args) {
        Hilo h = new Hilo();
        h.start();
        
        for(int i = 0; i < 10; i++){
             System.out.println("Hilo padre");
        }
        
        
    }
    
}
