package parking;

public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking();

        for (byte i = 0; i < 50; i++) {
            if (i % 13 < 10) {
                new Thread(new Coche(parking)).start();
            } else {
                new Thread(new Camion(parking)).start();
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

    }

}
