
package psp.u2;

public class A6_Sumatorio1 implements Runnable{

    @Override
    public void run() {
        int suma = 0;
        for(int i = 100; i <= 1000; i++){
            if(i % 2 == 0){
                suma += i;
            }
        }
        System.out.printf("%sLa suma es %d\n", "\u001B[32m", suma);
    }
    
}
