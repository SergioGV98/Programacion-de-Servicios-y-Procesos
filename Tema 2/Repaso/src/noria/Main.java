package noria;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    Noria noria = new Noria();
    ArrayList<Cliente> arr = new ArrayList<>();

    for (byte i = 0; i < 15; i++) {
        arr.add(new Cliente("Persona " + i, noria));
    }

    for (byte i = 0; i < arr.size(); i++) {
        Thread clienteThread = new Thread(arr.get(i));
        clienteThread.start();

        try {
            clienteThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


}
