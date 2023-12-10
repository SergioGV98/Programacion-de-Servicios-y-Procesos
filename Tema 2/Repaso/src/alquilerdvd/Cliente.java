package alquilerdvd;

import java.util.Random;

public class Cliente extends Thread {

    private final Tienda tienda;
    private final String pelicula;
    private final String identificador;

    public Cliente(String pelicula, Tienda tienda) {
        this.pelicula = pelicula;
        this.tienda = tienda;
        this.identificador = crearIdentificador();
    }

    public String getIdentificador() {
        return identificador;
    }

    private String crearIdentificador() {
        Random r = new Random();

        String numIdentificador = String.format("%03d", r.nextInt(999));
        String letrasIdentificador = "";
        for (byte i = 0; i < 5; i++) {
            letrasIdentificador += (char) r.nextInt(65, 122);
        }
        return "[" + numIdentificador + "]" + " " + letrasIdentificador;

    }

    @Override
    public void run() {
        Random r = new Random();

        try {
            tienda.alquilar(this, pelicula);
            long t = r.nextInt(10000, 50001);

            while (t > 100) {
                Thread.sleep(10000);
                System.err.printf("Cliente con Identificador %s le quedan %d para devolver la pelicula.\n", identificador, t/1000);
                t -= 10000;
            }
            tienda.devolver(this, pelicula);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
