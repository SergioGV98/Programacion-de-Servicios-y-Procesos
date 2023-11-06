
package psp.u2;

public class A3_Inversa {

    public static void main(String[] args) {
        
        
        A3_Inversa1 a1 = new A3_Inversa1();
        Thread hilo = new Thread(a1);
        hilo.start();
    }
    
}
