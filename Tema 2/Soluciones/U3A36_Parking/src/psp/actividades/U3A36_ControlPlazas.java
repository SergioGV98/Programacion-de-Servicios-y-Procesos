package psp.actividades;

import java.util.HashMap;

/**
 *
 * @author VicenteMartínez
 */
class U3A36_ControlPlazas {

    private final int numPlazas;
    private int plazasLibres;
    private final HashMap<String, Integer> parking;
    
    U3A36_ControlPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
        this.plazasLibres = numPlazas;
        parking = new HashMap<>();
    }

    // En este método no estamos controlando que los coches ocupen una plaza en el orden en el que se 
    // han quedado esperando. Para gestionar los turnos, podemos ir apilándolos en una lista e ir comprobando
    // si el que quiere aparcar es el primero de la lista.
    public synchronized void entraCoche(String matricula) {
        while (plazasLibres == 0) {
            System.out.println("[" + matricula + "] espera a que queden plazas libres");
            try {
                wait();
            } catch (InterruptedException ex) { 
                System.err.println("Problema mientras (" + matricula + ") espera a conseguir una plaza libre: " + ex.getLocalizedMessage());
            }
        }
        
        // Busco una plaza libre en el parking
        // Con este algoritmo se escoge la primera (número más bajo) que esté libre
        int plaza;
        for(plaza = 0; plaza < numPlazas; plaza++)
            if(!parking.containsValue(plaza)) break;
        
        // Asigno la plaza al coche
        parking.put(matricula, plaza);
        plazasLibres--;
        System.out.println("[" + matricula + "] aparca en la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        
        // No es necesario hacer un notify porque si algún coche estaba esperando porque no había suficientes plazas, 
        // en esta acción sólo hemos reducido las plazas disponibles, por lo que seguirá sin poder prepararlo        
        
    }

    public synchronized void saleCoche(String matricula) {        
        int plaza;
        plaza = parking.get(matricula);
        
        // Desasigna la plaza en el parking
        parking.remove(matricula);
        plazasLibres++;
        System.out.println("[" + matricula + "] deja la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        
        // Hacemos notifyAll porque puede haber coches esperando que puedan ocupar la plaza que dejamos libre
        notifyAll();
    }    
}
