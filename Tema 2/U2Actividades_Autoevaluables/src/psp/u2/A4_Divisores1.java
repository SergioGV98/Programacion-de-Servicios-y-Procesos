
package psp.u2;

public class A4_Divisores1 extends Thread{
    
    public static final String ANSI_YELLOW = "\033[33m";

    @Override
    public void run() {
        for(int i = 1; i <= 200; i++){
            if(i % 4 == 0){
                System.out.printf("%sEl numero %d es divisible entre 4\n", ANSI_YELLOW, i);
            }
        }
    }

}
