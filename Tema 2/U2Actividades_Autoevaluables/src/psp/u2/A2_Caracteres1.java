
package psp.u2;

import java.util.Random;

public class A2_Caracteres1 extends Thread {
    
    public static final String ANSI_TELLOW = "\033[33m";
    Random r = new Random();
     
    @Override
    public void run() {
      for(byte i = 0; i < 5; i++){
          System.out.printf("%sCaracter (%c)\n",ANSI_TELLOW, (char) r.nextInt(97,123));
      }
    }


}
