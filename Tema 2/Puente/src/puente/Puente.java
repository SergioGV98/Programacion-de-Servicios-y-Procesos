package puente;

public class Puente {

    private int cantidadPersonas = 0;
    private int cantidadPesoActual = 0;

    public Puente() {
    }

    public synchronized void cruzarPuenteDerecha(Persona p) throws InterruptedException {
        while (cantidadPersonas >= 4 || cantidadPesoActual + p.getPeso() > 250) {
            System.out.printf("[%s] con peso %skg. Espera a cruzar el puente.\n", p.getNombre(), p.getPeso());
            wait();
        }

        cantidadPersonas++;
        cantidadPesoActual += p.getPeso();

        System.out.printf("[%s] cruza el puente desde la derecha.\n", p.getNombre());
        System.out.printf("Personas en el puente: %d - Peso en el puente: %d\n", cantidadPersonas, cantidadPesoActual);
    }
    
    public synchronized void cruzarPuenteIzquierda(Persona p) throws InterruptedException {
        while (cantidadPersonas >= 4 || cantidadPesoActual + p.getPeso() > 250) {
            System.out.printf("[%s] con peso %skg. Espera a cruzar el puente.\n", p.getNombre(), p.getPeso());
            wait();
        }

        cantidadPersonas++;
        cantidadPesoActual += p.getPeso();

        System.out.printf("[%s] cruza el puente desde la izquierda.\n", p.getNombre());
        System.out.printf("Personas en el puente: %d - Peso en el puente: %d\n", cantidadPersonas, cantidadPesoActual);
    }

    public synchronized void terminarCruzarPuente(Persona p) {
        cantidadPersonas--;
        cantidadPesoActual -= p.getPeso();
        System.out.printf("[%s] con peso %skg. Termino de cruzar el puente.\n", p.getNombre(), p.getPeso());
        System.out.printf("Personas en el puente: %d - Peso en el puente: %d\n", cantidadPersonas, cantidadPesoActual);
        notifyAll();
    }

}
