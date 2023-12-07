
package parking;

import java.util.Random;

class Camion extends Vehiculo implements Runnable {
    private Parking parking;

    public Camion(Parking parking) {
        super();
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            Random r = new Random();
            parking.accederParking(this);
            Thread.sleep(r.nextInt(20000, 30001));
            parking.salirParking(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
}