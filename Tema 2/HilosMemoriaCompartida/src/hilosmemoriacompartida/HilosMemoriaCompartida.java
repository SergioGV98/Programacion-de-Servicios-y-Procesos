package hilosmemoriacompartida;

public class HilosMemoriaCompartida {

    public static void main(String[] args) {
        
        Contador c = new Contador(100);
        
        Sumador suma = new Sumador("Sumador", c);  
        Thread resta = new Thread(new Restador("Resta", c));
        
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