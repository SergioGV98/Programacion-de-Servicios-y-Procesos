
package psp.u2;

public class A9_Factorial {
    
    public static void main(String[] args) {
        args[0] = "10";
        
        if (args.length == 0) {
            System.out.println("Debes proporcionar al menos un número como argumento.");
            return;
        }
        
        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                Thread thread = new Thread(new A9_Factorial1(number));
                thread.start();
            } catch (NumberFormatException e) {
                System.out.println("Error: " + arg + " no es un número válido.");
            }
        }
        
    }
    
}
