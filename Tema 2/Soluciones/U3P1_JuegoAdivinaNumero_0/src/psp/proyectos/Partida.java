/**
 * El juego se gestiona a partir del turno, que nos servirá para ejecutar los
 * diferentes hilos lanzados en orden.
 */
package psp.proyectos;

public class Partida {

    
    // Número máximo hasta el que se puede decir
    int numeroMaximo;
    // Estado de finalización 
    boolean terminado;
    // Número a acertar por los nJugadores
    int numeroPensado;

    Partida(int nJugadores, int numeroMaximo, int adivinar) {
        this.terminado = false;
        this.numeroMaximo = numeroMaximo;
        this.numeroPensado = adivinar;
    }

    public synchronized void juega() {
        if (!terminado) {
            int numero = escogeNumero();
            System.out.println("\u001B[1m" + Thread.currentThread().getName() + " dice: " + numero);

            if (numero == numeroPensado) {
                terminado = true;
                System.out.println(Thread.currentThread().getName() + " gana!!!");
            }
        }
    }

    public boolean haTerminado() {
        return terminado;
    }

    private int escogeNumero() {
        int numeroEscogido;
        numeroEscogido = (int) (Math.random() * (numeroMaximo - 1) + 1);
        return numeroEscogido;
    }
}


