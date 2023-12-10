package libreria;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        HashMap<Escritor, String[]> escritores = new HashMap<>();
        Libreria libreria = new Libreria(escritores);

        // Autor 1
        Escritor brandom = new Escritor(libreria, "Brandom Sanderson");
        String[] librosBrandom = {"Nacidos de la bruma: Imperio final", "Nacidos de la bruma: El pozo de la ascensión", "Nacidos de la bruma: El héroe de las eras"};
        escritores.put(brandom, librosBrandom);

        // Autor 2
        Escritor rowling = new Escritor(libreria, "J.K. Rowling");
        String[] librosRowling = {"Harry Potter y la piedra filosofal", "Harry Potter y la cámara secreta", "Harry Potter y el prisionero de Azkaban"};
        escritores.put(rowling, librosRowling);

        // Autor 3
        Escritor lewis = new Escritor(libreria, "C.S. Lewis");
        String[] librosLewis = {"El león, la bruja y el armario", "El príncipe Caspian", "La travesía del Viajero del Alba"};
        escritores.put(lewis, librosLewis);

        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Random r = new Random();
                int autorVendido = r.nextInt(1, 4);
                switch (autorVendido) {
                    case 1 ->
                        new Thread(brandom).start();
                    case 2 ->
                        new Thread(rowling).start();
                    default ->
                        new Thread(lewis).start();
                }
                if (libreria.isFirma()) {
                    int autorFavorito = r.nextInt(1, 4);
                    switch (autorFavorito) {
                        case 1 ->
                            new Thread(new Lector(libreria, brandom)).start();
                        case 2 ->
                            new Thread(new Lector(libreria, rowling)).start();
                        default ->
                            new Thread(new Lector(libreria, lewis)).start();
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

        System.out.printf("Brandom Sanderson ha vendido un total de %d y ha ingresado un total de %.2f\n", brandom.getLibrosVendidos(), brandom.getDineroIngresado());
        System.out.printf("J.K. Rowling ha vendido un total de %d y ha ingresado un total de %.2f\n", rowling.getLibrosVendidos(), rowling.getDineroIngresado());
        System.out.printf("C.S. Lewis ha vendido un total de %d y ha ingresado un total de %.2f\n", lewis.getLibrosVendidos(), lewis.getDineroIngresado());
    }

}
