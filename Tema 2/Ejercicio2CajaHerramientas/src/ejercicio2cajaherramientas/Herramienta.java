package ejercicio2cajaherramientas;

public class Herramienta {

    private int martillos;
    private int guantes;

    public Herramienta(int martillos, int guantes) {
        this.martillos = martillos;
        this.guantes = guantes;
    }

    public synchronized void tomarMartillo(Trabajador trabajador) throws InterruptedException {
        while (martillos == 0) {
            System.out.printf("%s%s esta esperando por un martillo...\n", "\u001B[31m", trabajador.getNombre());
            wait();
        }
        martillos -= 1;
        System.out.printf("%s%s tomo un martillo. Martillos disponibles: %d\n", "\u001B[32m", trabajador.getNombre(), martillos);
    }

    public synchronized void tomarGuante(Trabajador trabajador) throws InterruptedException {
        while (guantes == 0) {
            System.out.printf("%s%s esta esperando por un guante...\n", "\u001B[31m", trabajador.getNombre());
            wait();
        }
        guantes -= 1;
        System.out.printf("%s%s tomo un guante y puede trabajar. Guantes disponibles: %d\n", "\u001B[32m", trabajador.getNombre(), guantes);
    }

    public synchronized void devolver(Trabajador trabajador) {
        martillos += 1;
        System.out.printf("%s devolvio un martillo. Martillos disponibles: %d\n", trabajador.getNombre(), martillos);
        guantes += 1;
        System.out.printf("%s devolvio un guante. Guantes disponibles: %d\n", trabajador.getNombre(), guantes);
        notifyAll();
    }

}
