package puente;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Puente puente = new Puente();
        Random r = new Random();

        Persona[] personas = new Persona[15];
        for (byte i = 0; i < 15; i++) {
            personas[i] = new Persona("Persona " + i, puente);
        }

        for (Persona persona : personas) {
            try {
                int tiempoLlegada = r.nextInt(1000,30001);
                System.out.printf("%sTiempo de llegada de una nueva persona es %d segundos\n","\u001B[31m", tiempoLlegada/1000);
                Thread.sleep(tiempoLlegada);
                persona.start();
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }
        
    }

}
