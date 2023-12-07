package psp.proyectos;
public class AdivinaNumero {
        
    final static int JUGADORES = 5;
    final static int NUMERO_MAXIMO = 50;
    
    public static void main(String[] args) {
        // Objeto compartido (Partida) + MAX_JUGADORES * Consumidor (Jugador)
        int numeroAdivinar = (int) (Math.random() * (NUMERO_MAXIMO - 1) + 1);
        System.out.println("-------------------------------------");
        System.out.println("Numero de jugadores: " + JUGADORES);
        System.out.println("Rango de numeros: " + "Entre 1 y " + NUMERO_MAXIMO);
        System.out.println("Numero a adivinar: " + numeroAdivinar);
        System.out.println("-------------------------------------");

        Partida part = new Partida(JUGADORES, NUMERO_MAXIMO,numeroAdivinar);
        
         for (int i = 0; i < JUGADORES; i++) {
            // Creamos los hilos a partir de los Runnables y los lanzamos
            Jugador ju = new Jugador("Jugador " + (i+1), part);
            Thread j = new Thread(ju);
            j.start();
        }
    }
    
}
