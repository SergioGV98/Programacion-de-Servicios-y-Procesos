package parking;

import java.util.HashMap;
import java.util.Map;

public class Parking {

    private final Map<Integer, Coche> aparcamientos = new HashMap<>(10);
    private int plazasLibres;

    public Parking() {
        plazasLibres = 10;
    }

    public Map<Integer, Coche> getMap() {
        return aparcamientos;
    }

    public synchronized void accederParking(Coche c) throws InterruptedException {
        if (plazasLibres != 0) {
            this.aparcamientos.put(aparcamientos.size(), c);
            c.setPosicionParking(aparcamientos.size());
            plazasLibres--;
            System.out.printf("%s aparca en la plaza %d -> Quedan %d plazas libres\n", c.getMatricula(), aparcamientos.size(), plazasLibres);
        } else {
            System.out.printf("%s espera a que queden plazas libres\n", c.getMatricula());
            wait();
        } 
    }

    public synchronized void salirParking(Coche c) throws InterruptedException {
        if (plazasLibres == 0) {
            this.aparcamientos.remove(c.getPosicionParking());
            System.out.printf("%s deja la plaza %d \n", c.getMatricula(), c.getPosicionParking());
            plazasLibres++;
            notifyAll();
        } 
    }
}
