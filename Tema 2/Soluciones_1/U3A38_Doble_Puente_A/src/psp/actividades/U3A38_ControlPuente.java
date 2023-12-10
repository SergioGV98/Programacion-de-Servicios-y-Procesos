package psp.actividades;

/**
 *
 * @author VicenteMartínez
 */
class U3A38_ControlPuente {

    private final int maxPersonas;
    private final int maxPeso;
    private int numPersonasCruzando;
    private int pesoPersonasCruzando;
    
    
    U3A38_ControlPuente(int maxPersonas, int pesoMaxPuente) {
        this.maxPersonas = maxPersonas;
        this.maxPeso = pesoMaxPuente;
        this.numPersonasCruzando = 0;
        this.pesoPersonasCruzando = 0;
    }

    // En este método no estamos controlando que las personas pasen por el puente en el orden en que han llegado
    // y se han quedado esperando. Para gestionar los turnos, podemos ir apilándolos en una lista e ir comprobando
    // si el que quiere pasar es el primero de la lista, y además puede pasar
    public synchronized void entrar(U3A38_Persona p) {
        
        while (numPersonasCruzando >= maxPersonas || pesoPersonasCruzando +  p.getPeso() > maxPeso) {
            System.out.println("[" + p.getNombre() + "] con peso " + p.getPeso() + "kg. espera a cruzar el puente");
            System.out.println("Personas en el puente: " + numPersonasCruzando + " - Peso en el puente: " + pesoPersonasCruzando);
            try {
                wait();
            } catch (InterruptedException ex) { 
                System.err.println("Problema mientras (" + p.getNombre() + ") espera a cruzar el puente: " + ex.getLocalizedMessage());
            }
        }
        
        // Actualizo la información de las personas sobre el puente
        pesoPersonasCruzando += p.getPeso();
        numPersonasCruzando++;
        System.out.println("[" + p.getNombre() + "] cruza el puente");
        System.out.println("Personas en el puente: " + numPersonasCruzando + " - Peso en el puente: " + pesoPersonasCruzando);
        
        // No es necesario hacer un notify porque si algún coche estaba esperando porque no había suficientes plazas, 
        // en esta acción sólo hemos reducido las plazas disponibles, por lo que seguirá sin poder prepararlo        
        
    }

    public synchronized void salir(U3A38_Persona p) {        
        
        // Actualizo la información de las personas sobre el puente
        pesoPersonasCruzando -= p.getPeso();
        numPersonasCruzando--;
        System.out.println("[" + p.getNombre() + "] sale del puente");
        System.out.println("Personas en el puente: " + numPersonasCruzando + " - Peso en el puente: " + pesoPersonasCruzando);
        
        // Hacemos notifyAll porque puede haber personas esperando que puedan cruzar el puente
        notifyAll();
    }    
}
