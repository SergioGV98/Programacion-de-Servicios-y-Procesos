package actividad_thread;

public class Principal {

    public static void main(String[] args) {
       
        LanzaHilo launch = new LanzaHilo(5);
        LanzaHilo launch1 = new LanzaHilo(3);
        LanzaHilo launch2 = new LanzaHilo(10);
        launch.start();
        launch1.start();
        launch2.start();
        System.out.println("Comienza la cuenta atras!");
        
        
    }
    
}
