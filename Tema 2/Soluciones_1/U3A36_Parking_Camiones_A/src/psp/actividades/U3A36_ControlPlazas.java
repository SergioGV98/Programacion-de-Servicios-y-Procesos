package psp.actividades;

import java.util.Arrays;

/**
 *
 * @author VicenteMartínez
 */
class U3A36_ControlPlazas {

    private final int numPlazas;
    private int plazasLibres;
    private String[] parking;
    
    U3A36_ControlPlazas(int numPlazas) {
        this.numPlazas = numPlazas-1;
        this.plazasLibres = numPlazas-1;
        parking = new String[numPlazas];
    }

    // En este método no estamos controlando que los coches ocupen una plaza en el orden en el que se 
    // han quedado esperando. Para gestionar los turnos, podemos ir apilándolos en una lista e ir comprobando
    // si el que quiere aparcar es el primero de la lista.
    public synchronized void entraCoche(String matricula) {
        while (plazasLibres == 0) {
            System.out.println("Coche: [" + matricula + "] espera a que queden plazas libres");
            try {
                wait();
            } catch (InterruptedException ex) { 
                System.err.println("Problema mientras (" + matricula + ") espera a conseguir una plaza libre: " + ex.getLocalizedMessage());
            }
        }
        
        // Busco una plaza libre en el parking
        // Con este algoritmo se escoge la primera (número más bajo) que esté libre
        int plaza;
        for(plaza = 1; plaza < numPlazas; plaza++)
            if (parking[plaza]==null) break;
        
        // Asigno la plaza al coche
        parking[plaza] = matricula;
        plazasLibres--;
        System.out.println("Coche: [" + matricula + "] aparca en la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        
        // No es necesario hacer un notify porque si algún coche estaba esperando porque no había suficientes plazas, 
        // en esta acción sólo hemos reducido las plazas disponibles, por lo que seguirá sin poder prepararlo        
        
    }
    
        public synchronized void entraCamion(String matricula) {
        
        int plaza,plaza1;        
        while ((plaza = plazasDoblesLibres())==-1) {
            System.out.println("Camion: [" + matricula + "] espera a que queden plazas libres");
            try {
                wait();
            } catch (InterruptedException ex) { 
                System.err.println("Problema mientras (" + matricula + ") espera a conseguir una plaza libre: " + ex.getLocalizedMessage());
            }
        }
        
        
        // Asigno la plaza al camion
        parking[plaza]=matricula;
        parking[plaza+1]=matricula;
        plaza1=plaza + 1;
        plazasLibres=plazasLibres - 2;
        System.out.println("Camion: [" + matricula + "] aparca en la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        System.out.println("Camion: [" + matricula + "] aparca en la plaza " + plaza1 + " -> Quedan " + plazasLibres + " plazas libres");
        
        // No es necesario hacer un notify porque si algún coche estaba esperando porque no había suficientes plazas, 
        // en esta acción sólo hemos reducido las plazas disponibles, por lo que seguirá sin poder prepararlo        
        
    }
        
    private int plazasDoblesLibres()
    {
        int plaza;
        for (plaza=1;plaza<numPlazas-2;plaza=plaza+2)
            if (!(parking[plaza]!=null || parking[plaza+1]!=null))
            {
                return plaza;
            }
        return -1;
    }

    public synchronized void saleCoche(String matricula) {        
        int plaza;
        plaza = Arrays.asList(parking).indexOf(matricula);
        
        // Desasigna la plaza en el parking
        parking[plaza]=null;
        plazasLibres++;
        System.out.println("Coche: [" + matricula + "] deja la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        
        // Hacemos notifyAll porque puede haber coches esperando que puedan ocupar la plaza que dejamos libre
        notifyAll();
    } 
    
        public synchronized void saleCamion(String matricula) {        
        int plaza;
        plaza = Arrays.asList(parking).indexOf(matricula);
       
        // Desasigna las plazas en el parking
        parking[plaza]=null;
        parking[plaza+1]=null;
        
        plazasLibres=plazasLibres+2;
        System.out.println("Camion [" + matricula + "] deja la plaza " + plaza + " -> Quedan " + plazasLibres + " plazas libres");
        
        // Hacemos notifyAll porque puede haber coches esperando que puedan ocupar la plaza que dejamos libre
        notifyAll();
    } 
}
