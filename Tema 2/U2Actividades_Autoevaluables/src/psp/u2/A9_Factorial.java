
package psp.u2;

public class A9_Factorial {
    
    public static void main(String[] args) {
       
        for(int i = 0; i < args.length; i++){
            try {
                int number = Integer.parseInt(args[i]);
                Thread thread = new Thread(new A9_Factorial1(number));
                thread.start();
            } catch (NumberFormatException e) {
                System.out.println("Error: " + args[i] + " no es un número válido.");
            }
        }
        
    }
    
}
