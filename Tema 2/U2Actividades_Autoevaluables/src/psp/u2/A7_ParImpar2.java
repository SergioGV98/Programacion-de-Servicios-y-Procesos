
package psp.u2;

public class A7_ParImpar2 implements Runnable{
    
    @Override
     public void run() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.printf("%sPar: %d\n", "\u001B[32m", i);
        }
    }
    
}
