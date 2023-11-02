
package psp.u2;

public class A1_Numeros2 extends Thread{
    
    public static final String ANSI_GREEN = "\u001B[32m";
    
    @Override
    public void run() {
       for(byte i = 1; i <= 10; i++){
           System.out.printf("%sMultiplos de 10: %d\n", ANSI_GREEN, (10 * i));
       }
    }

}
