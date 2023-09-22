package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Short> arr = new ArrayList<Short>();
        short numero;
        
        do{
            System.out.println("Dame numeros hasta que quieras parar en ese caso pon un 0");
            numero = Short.parseShort(sc.nextLine());
            arr.add(numero);
        }while(numero != 0);
        
        for(short i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
    
}
