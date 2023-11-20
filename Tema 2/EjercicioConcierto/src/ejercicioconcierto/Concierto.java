package ejercicioconcierto;

public class Concierto {

    private int entradas;

    public Concierto(int entradas) {
        this.entradas = entradas;
    }

    public int getEntradas() {
        return entradas;
    }

    public synchronized boolean comprarEntrada(String color, int idCliente, int numerosEntradas) {

        if (entradasDisponibles(numerosEntradas)) {
            entradas -= numerosEntradas;
            System.out.printf("%sCliente %d compra %d entradas. Entradas restantes: %d\n", color, idCliente, numerosEntradas, entradas);
            return true;
        } else {
            System.out.printf("%sCliente %d intento comprar %d entradas, pero no hay suficientes disponibles.\n", color, idCliente, numerosEntradas);
            return false;
        }
    }

    public synchronized boolean entradasDisponibles(int numerosEntradasCompradas) {
        return this.entradas >= numerosEntradasCompradas;
    }

}
