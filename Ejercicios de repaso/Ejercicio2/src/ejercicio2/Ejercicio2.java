package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Dime tu apellido");
        String apellido = sc.nextLine();
        System.out.println("Dime tu edad");
        byte edad = Byte.parseByte(sc.nextLine());
        System.out.println("Dime tu nota media");
        float nota = Float.parseFloat(sc.nextLine());
        
        System.out.println("El alumno " + nombre + " " + apellido + ", de edad " + edad + " años, tiene uan nota media de " + nota);
        
    }
    
}
