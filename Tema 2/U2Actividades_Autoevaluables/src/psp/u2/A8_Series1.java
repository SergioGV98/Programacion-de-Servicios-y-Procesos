
package psp.u2;

import java.util.Scanner;

public class A8_Series1 extends Thread{

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero para la serie: ");
        int n = scanner.nextInt();

        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += 2 * i;
        }

        System.out.printf("%sLa suma de la serie para n=%d es: %d\n", "\u001B[32m",  n, suma);
    }
}
