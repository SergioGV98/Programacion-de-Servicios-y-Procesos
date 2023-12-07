import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        int num_compradores = (int) (Math.random() * 50) + 1;
        Concierto concierto = new Concierto(50);

        List<Comprador> compradores = new ArrayList<>();
        for (int i = 1; i <= num_compradores; i++) {
            compradores.add(new Comprador(concierto, "Comprador " + i));
        }

        for (Comprador comprador : compradores) {
            comprador.start();
        }

        for (Comprador comprador : compradores) {
            try {
                comprador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Entradas restantes despues de las compras: " + concierto.getEntradasDisponibles());
    }
}

