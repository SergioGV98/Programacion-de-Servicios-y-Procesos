package libreria;

import java.util.Random;

public class Lector extends Thread{
    
    private final Libreria libreria;
    private final Escritor autorFavorito;

    public Lector(Libreria libreria, Escritor autorFavorito) {
        this.libreria = libreria;
        this.autorFavorito = autorFavorito;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            libreria.autorFimarLibros(autorFavorito, this);
            Thread.sleep(r.nextInt(5000, 10001));
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
    }

}
