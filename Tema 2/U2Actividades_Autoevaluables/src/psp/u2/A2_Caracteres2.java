package psp.u2;

import java.util.Scanner;

public class A2_Caracteres2 extends Thread {

    public static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribeme una cadena de texto");
        String cadena = sc.nextLine();

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') {
                System.out.print(ANSI_GREEN + cadena.charAt(i));
            }
        }
        System.out.println();

    }

}
