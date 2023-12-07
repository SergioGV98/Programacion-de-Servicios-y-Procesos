package psp.actividades;

import java.util.concurrent.ThreadLocalRandom;

public class U3A36_Coche implements Runnable {

    private final U3A36_ControlPlazas plazasParking;
    private String matricula;
    private final int tiempoEsperaMin;
    private final int tiempoEsperaMax;
    

    U3A36_Coche(int tiempoEsperaMin, int tiempoEsperaMax, U3A36_ControlPlazas plazasParking) {
        this.plazasParking = plazasParking;
        this.matricula = "";
        this.tiempoEsperaMin = tiempoEsperaMin;
        this.tiempoEsperaMax = tiempoEsperaMax;
    }

    @Override
    public void run() {

        // Le asignamos una matricula al coche
        setMatricula();
        
        // El coche intenta conseguir una plaza libre
        plazasParking.entraCoche(this.matricula);
        
        // Hacemos una espera para simular el tiempo que el coche pasa en el parking
        try {
            Thread.sleep((long) (ThreadLocalRandom.current().nextDouble() * (tiempoEsperaMax - tiempoEsperaMin) + tiempoEsperaMin));
        } catch (InterruptedException ex) {
                System.err.println("Problema mientras el coche (" + matricula + ") está en el parking: " + ex.getLocalizedMessage());
                ex.printStackTrace();            
        }

        // El coche libera la plaza que ocupaba
        plazasParking.saleCoche(this.matricula);
    }

    private void setMatricula() {
        // La matrícula está formada por 3 letras y cuatro dígitos
        
        // Generamos un número entre 0 y 9999 formateado completando con 0 por delante
        matricula = String.format("%04d", (int) (Math.random() * 9999));
        
        // Cogemos las tres letras
        matricula += " ";        
        for (int i = 0; i < 3; i++) {
            matricula += String.valueOf((char) (Math.random() * 26 + 65));
            // Valor aleatorio entre 0 y 26 -> Le sumo el valor de A y obtengo entre A y Z
        }
    }
}
