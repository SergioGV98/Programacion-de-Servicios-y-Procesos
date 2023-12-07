package parking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parking {

    private final Map<Integer, Vehiculo> aparcamientos = new HashMap<>(10);
    private final LinkedList<Integer> posicionesLiberadas = new LinkedList<>();
    private int plazasLibres;

    public Parking() {
        plazasLibres = 10;
    }

    public Map<Integer, Vehiculo> getMap() {
        return aparcamientos;
    }

    public synchronized void accederParking(Vehiculo v) throws InterruptedException {
        while (plazasLibres == 0) {
            System.out.printf("%s con matricula%s espera a que queden plazas libres\n", TipoVehiculo(v), v.getMatricula());
            wait();
        }

        if (v.getClass().equals(Coche.class) && plazasLibres > 1) {
            aparcarCoche(v);
        } else if (v.getClass().equals(Camion.class) && plazasLibres > 2) {
            aparcarCamion(v);
        }

    }

    public synchronized void salirParking(Vehiculo v) throws InterruptedException {
        int posicion = v.getPosicionParking();
        this.aparcamientos.remove(posicion);
        System.out.printf("%s con matricula %s deja la plaza %d \n", TipoVehiculo(v), v.getMatricula(), posicion + 1);
        plazasLibres++;
        posicionesLiberadas.offer(posicion);
        notifyAll();

    }

    public synchronized void aparcarCoche(Vehiculo v) {
        int posicion;
        if (!posicionesLiberadas.isEmpty()) {
            posicion = posicionesLiberadas.poll();
        } else {
            posicion = aparcamientos.size();
        }

        while (aparcamientos.containsKey(posicion) && posicion < 10) {
            posicion++;
        }

        if (posicion < 10) {
            this.aparcamientos.put(posicion, v);
            v.setPosicionParking(posicion);
            plazasLibres--;

            System.out.printf("%s con matricula %s aparca en la plaza %d -> Quedan %d plazas libres\n", TipoVehiculo(v), v.getMatricula(), posicion + 1,
                    plazasLibres);
        } else {
            System.out.printf("%s con matricula %s no pudo aparcar, no hay plazas disponibles\n", TipoVehiculo(v), v.getMatricula());
        }
    }

    public synchronized void aparcarCamion(Vehiculo v) {
        int posicionPar;
        int posicionImpar;

        if (!posicionesLiberadas.isEmpty()) {
            posicionPar = posicionesLiberadas.poll();
            posicionImpar = posicionesLiberadas.poll();
        } else {
            posicionPar = aparcamientos.size();
            posicionImpar = posicionPar + 1;
        }

        while ((aparcamientos.containsKey(posicionPar) || aparcamientos.containsKey(posicionImpar)
                || aparcamientos.containsKey(posicionPar + 1) || aparcamientos.containsKey(posicionImpar + 1))
                && (posicionPar < 10 && posicionImpar < 10)) {
            posicionPar += 2;
            posicionImpar += 2;
        }

        if ((posicionPar < 10 && posicionImpar < 10)) {
            this.aparcamientos.put(posicionPar, v);
            this.aparcamientos.put(posicionPar + 1, v);
            v.setPosicionParking(posicionPar);

            plazasLibres -= 2;

            System.out.printf("%s con matricula %s aparca en las plazas %d y %d -> Quedan %d plazas libres\n", TipoVehiculo(v),
                    v.getMatricula(), posicionPar + 1, posicionPar + 2, plazasLibres);
        } else {
            System.out.printf("%s con matricula %s no pudo aparcar, no hay plazas disponibles\n", TipoVehiculo(v), v.getMatricula());
        }
    }

    public synchronized String TipoVehiculo(Vehiculo v) {
        if (v.getClass().equals(Coche.class)) {
            return "Coche";
        } else {
            return "Camion";
        }
    }
}
