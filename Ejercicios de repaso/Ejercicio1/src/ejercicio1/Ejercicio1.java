package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime la Base del rectangulo");
        double base = Double.parseDouble(sc.nextLine());
        
        System.out.println("Dime la Altura del rectangulo");
        double altura = Double.parseDouble(sc.nextLine());
        
        System.out.println("El Perimetro del rectangulo es " + (2*base) + (2*altura));
        System.out.println("La Superficie del rectangulo es " + base * altura);
        
    }
    
}
