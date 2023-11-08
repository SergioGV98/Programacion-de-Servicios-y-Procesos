package psp.u2;

public class A5_Argumentos {

    public static void main(String[] args) {


        for (int i = 0; i < args.length; i++) {
            Thread hilo = new Thread(new A5_Argumentos1(args[i]));
            hilo.start();
        }

    }

}
