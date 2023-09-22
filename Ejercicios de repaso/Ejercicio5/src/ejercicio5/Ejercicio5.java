package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame N1");
        int n1 = Integer.parseInt(sc.nextLine());

        System.out.println("Dame N2");
        int n2 = Integer.parseInt(sc.nextLine());

        int factorialN1 = factorial(n1);
        int factorialN2 = factorial(n2);

        int resultado = factorialN1 + factorialN2;

        System.out.println("Resultado = " + resultado);
        
    }
    
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
