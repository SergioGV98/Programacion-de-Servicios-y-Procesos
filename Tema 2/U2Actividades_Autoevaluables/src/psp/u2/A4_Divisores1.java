
package psp.u2;

public class A4_Divisores1 extends Thread{
    
    public static final String ANSI_AZUL = "\033[34m";

    @Override
    public void run() {
        for(int i = 1; i <= 200; i++){
            if(i % 4 == 0){
                System.out.printf("%sEl numero %d es divisible entre 4\n", ANSI_AZUL, i);
            }
        }
    }

}
