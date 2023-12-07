class Comprador extends Thread {
    private final Concierto concierto;

    public Comprador(Concierto concierto, String nombre) {
        super(nombre);
        this.concierto = concierto;
    }

    @Override
    public void run() 
    {
        int cantidadComprar = (int) (Math.random() * 4) + 1; // Compra entre 1 y 4 entradas
        concierto.comprarEntrada(getName(), cantidadComprar);
        }
    }

