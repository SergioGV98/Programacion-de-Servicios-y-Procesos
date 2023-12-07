package sumadorrestador;

public class Main {

    public static void main(String[] args) {
        
        Contador c = new Contador(100);
        
        Sumador suma = new Sumador(c);  
        Thread resta = new Thread(new Restador(c));
        
        suma.start();
        resta.start();
        
        try{
            suma.join();
            resta.join();
        } catch(InterruptedException ex){
            System.out.println("Error Hilos");
        }
        
        System.out.println("El valor final de c es " + c.valor());
    }
    
}
