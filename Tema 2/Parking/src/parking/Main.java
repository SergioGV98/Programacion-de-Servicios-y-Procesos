package parking;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Coche> arr = new ArrayList<>();
        Parking parking = new Parking();

        for (byte i = 0; i < 50; i++) {
            Coche c = new Coche(parking);
            arr.add(c);
            c.start();
        }
        
        for(byte i = 0; i< 50; i++){
            try {
                arr.get(i).join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
