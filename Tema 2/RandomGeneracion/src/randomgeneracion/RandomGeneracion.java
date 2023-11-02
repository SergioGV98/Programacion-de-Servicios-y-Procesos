package randomgeneracion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneracion {

    public static void main(String[] args) {
        
        Random r = new Random();

        System.out.printf("Numero random usando (Random): %d\n", r.nextInt(0, 10));
        System.out.printf("Numero random usando (Math.Random): %d\n", (int) (Math.random()*9));
        System.out.printf("Numero random usando (ThreadLocalRandom): %d\n", ThreadLocalRandom.current().nextInt(0, 10));
        
    }
    
}
