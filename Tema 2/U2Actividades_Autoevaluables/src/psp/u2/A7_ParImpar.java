package psp.u2;

public class A7_ParImpar {

    public static void main(String[] args) {

        A7_ParImpar1 hilo = new A7_ParImpar1();
        Thread hilo2 = new Thread(new A7_ParImpar2());
        
        hilo.start();
        hilo2.start();
        
    }

}
