
package psp.u2;

public class A5_Argumentos1 implements Runnable{
    
    private String palabra;

    public A5_Argumentos1(String palabra) {
        this.palabra = palabra;
    }
    
    @Override
    public void run() {
         for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e' || palabra.charAt(i) == 'i' || palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u') {
                System.out.printf("%s%s ","\u001B[32m",palabra.charAt(i));
            }
        }
    }

}
