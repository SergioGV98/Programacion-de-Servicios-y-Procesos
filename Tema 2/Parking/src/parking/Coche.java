package parking;

import java.util.Random;

public class Coche extends Thread {

    private final String matricula;
    private final Parking parking;
    private int posicionParking;

    public Coche(Parking parking) {
        this.parking = parking;
        this.matricula = asignarMatricula();
        this.posicionParking = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPosicionParking() {
        return posicionParking;
    }
    
    public void setPosicionParking(int posicionParking) {
        this.posicionParking = posicionParking;
    }
    
    private String asignarMatricula() {

        Random r = new Random();
        String ret = "[";
        ret += String.format("%04d", r.nextInt(10000));
        ret += " ";

        for (byte i = 0; i < 3; i++) {
            char c = (char) ('A' + r.nextInt(26));
            ret += c;
        }
        ret += "]";
        return ret;
    }

    @Override
    public void run() {
        try {
            Random r = new Random();
            Thread.sleep((long) (r.nextInt(100, 5001)));
            parking.accederParking(this);
            Thread.sleep((long) (r.nextInt(100, 10001)));
            parking.salirParking(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }

}
