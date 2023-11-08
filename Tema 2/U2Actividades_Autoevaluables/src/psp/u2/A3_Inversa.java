
package psp.u2;

public class A3_Inversa {

    public static void main(String[] args) {
        
        
        A3_Inversa1 a1 = new A3_Inversa1();
        Thread hilo = new Thread(a1);
        hilo.start();
        
        A3_Inversa2 a2 = new A3_Inversa2();
        Thread hilo2 = new Thread(a2);
        hilo2.start();
    }
    
}
