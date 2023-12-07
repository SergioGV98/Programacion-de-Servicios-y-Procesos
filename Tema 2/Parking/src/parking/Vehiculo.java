
package parking;

import java.util.Random;

class Vehiculo {

    protected final String matricula;
    private int posicionParking;

    public Vehiculo() {
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
}
