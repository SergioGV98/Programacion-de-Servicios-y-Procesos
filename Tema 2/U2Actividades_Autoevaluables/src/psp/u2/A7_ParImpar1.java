package psp.u2;

public class A7_ParImpar1 extends Thread {
    
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.printf("%sImpar: %d\n", "\033[33m", i);
        }
    }
}
