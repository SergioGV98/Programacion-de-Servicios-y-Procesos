
package psp.u2;

public class A1_Numeros1 extends Thread{
    
    public static final String ANSI_AZUL = "\033[34m";
    
    @Override
    public void run() {
        int suma = 0;
        
        for(int i = 100; i < 1000; i++){
            if(i%5 == 0){
                suma += i;
            }
        }
        System.out.printf("%sLa suma de los numeros divisibles entre 100 y 1000 es: %d\n", ANSI_AZUL,suma);
        
    }
    

}
