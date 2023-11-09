package ejerciciosaldosincronizado;

import java.util.Random;

public class Usuario extends Thread {

    private final Cuenta cuenta;
    private final String nombre;
    private final String color;

    public Usuario(Cuenta cuenta, String nombre, String color) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.color = color;
    }

    @Override
    public void run() {
        Random r = new Random();
        int dineroRetirado = 0;
        int dinero = 0;

        for (int i = 0; i < 5; i++) {
            try {
                dinero = r.nextInt(50,201);
                if(cuenta.dineroDisponible(dinero)){
                    dineroRetirado += dinero;
                }
                cuenta.reintegro(nombre, color, dinero);
                Thread.sleep((long) (r.nextInt(100, 501)));
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }
        System.out.printf("%s%s ha retirado %d Euros de la cuenta\n", color,nombre, dineroRetirado);
    }

}
