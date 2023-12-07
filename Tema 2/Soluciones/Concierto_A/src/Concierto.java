public class Concierto {
    private int entradasDisponibles;
    
    public Concierto(int entradas)
    {
        this.entradasDisponibles=entradas;
    }

    public synchronized void comprarEntrada(String comprador, int cantidad) {
        if (getEntradasDisponibles() >= cantidad) {
            entradasDisponibles -= cantidad;
            System.out.println(comprador + " compra " + cantidad + " entradas. Entradas restantes: " + getEntradasDisponibles());
        } else {
            System.out.println(comprador + " intento comprar " + cantidad + " entradas, pero no hay suficientes disponibles.");
        }
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }   
}