package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame un dividendo");
        short dividendo = Short.parseShort(sc.nextLine());
        
        System.out.println("Dame el divisor");
        short divisor = Short.parseShort(sc.nextLine());
        
        if(dividendo%divisor == 0){
            System.out.println("El resto es 0");
        } else {
            System.out.println("El resto no es 0");
        }
        
    }
    
}
