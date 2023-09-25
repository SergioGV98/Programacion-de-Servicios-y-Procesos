package ejercicio6;

import ejercicio6.Clases.Empleado;
import ejercicio6.Clases.Persona;

public class Ejercicio6 {


    public static void main(String[] args) {
        
        Persona p1 = new Persona("Paco", (byte) 44);
        Empleado e1 = new Empleado("Juan", (byte) 65, 1023.44);

        System.out.println(p1);
        System.out.println(e1);
        
        System.out.println(e1.getNombre() + " ¿Esta jubilado? " + e1.estaJubilado(e1.getEdad()));
    }
    
}
