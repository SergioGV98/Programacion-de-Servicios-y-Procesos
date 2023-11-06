package psp.u2;

public class A3_Inversa1 implements Runnable{
    
    public static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void run() {
        String cadena = "hilo";
        String ret = "";
        
        for(int i = cadena.length()-1; i >= 0; i--){
            ret += cadena.charAt(i);
            System.out.println(ANSI_GREEN + ret);
        }
        
    }

}
