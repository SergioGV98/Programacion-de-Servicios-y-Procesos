/*
 * Ejemplo de ejecución paralela. 
 * Los empleados ahora sí actúan de forma concurrente
 */
package psp.u3;

public class A20_Banco {
    final static int SALDO_INICIAL = 500;
    
    public static void main(String[] args) {
        final A20_Cuenta cuenta = new A20_Cuenta(SALDO_INICIAL);
        String color_rojo="\u001B[31m";
        String color_verde="\u001B[32m";
        
        A20_Empleado emp1 = new A20_Empleado("Luis", 5, cuenta,color_rojo);
        A20_Empleado emp2 = new A20_Empleado("Manuel", 5, cuenta,color_verde);
        
        // Es lo único que cambia respecto al secuencial
        Thread t1 = new Thread(emp1);
        Thread t2 = new Thread(emp2);
        t1.start();
        t2.start();
        
        try {
            // Debemos esperar a que los hilos acaben para mostrar los resultados finales
            t1.join();
            t2.join();
        } catch (InterruptedException ex) { }
        
        
        System.out.println(color_rojo + emp1.getNombre() + " ha retirado " + emp1.getTotalRetirado() + " Euros de la cuenta");
        System.out.println(color_rojo + emp1.getNombre() + " ha ingresado " + emp1.getTotalIngresado() + " Euros de la cuenta");
        System.out.println(color_verde + emp2.getNombre() + " ha retirado " + emp2.getTotalRetirado() + " Euros de la cuenta");
        System.out.println(color_verde + emp2.getNombre() + " ha ingresado " + emp2.getTotalIngresado() + " Euros de la cuenta");
        System.out.println("En la cuenta quedan " + cuenta.getSaldo() + " Euros");        
        
    }
    
}
