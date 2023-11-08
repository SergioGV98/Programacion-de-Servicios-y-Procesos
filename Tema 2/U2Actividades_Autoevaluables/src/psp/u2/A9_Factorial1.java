package psp.u2;

public class A9_Factorial1 implements Runnable {
    
    private int numero;
    
    public A9_Factorial1(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        long factorial = calculateFactorial(numero);
        System.out.println(numero + "! = " + factorial);
    }
    
    private long calculateFactorial(int n) {
        if (n < 0) {
            return -1; 
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

}
