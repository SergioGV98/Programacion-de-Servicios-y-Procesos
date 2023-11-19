
package psp.u2;

public class A3_Inversa2 implements Runnable {
    
    public static final String ANSI_YELLOW = "\033[33m";

    @Override
    public void run() {
        int suma = 0;
        for(int i = 500; i <= 1000; i++){
            if(i%2 != 0){
                suma += i;
            }
        }
         System.out.printf("%sLa suma de todos los numeros impares es: %d\n", ANSI_YELLOW, suma);
    }

}
