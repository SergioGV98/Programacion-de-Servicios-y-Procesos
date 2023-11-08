
package psp.u2;

public class A4_Divisores2 extends Thread{

    public static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void run() {
        for(int i = 1; i <= 200; i++){
            if(i % 4 == 0){
                System.out.printf("%sEl numero %d es divisible entre 4\n", ANSI_GREEN, i);
            }
        }
    }
    
}
