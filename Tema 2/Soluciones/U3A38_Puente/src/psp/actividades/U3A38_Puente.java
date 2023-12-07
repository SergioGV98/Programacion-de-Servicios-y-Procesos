/*
 * Ejemplo de ejecución paralela. 
 * Vamos a programar la clase ControlPuente como una clase Thread-safe, por lo 
 * que el resto de clases no se tienen que preocupar de la sincronización
 */
package psp.actividades;

public class U3A38_Puente {

    private final static int MAX_PERSONAS = 3;
    private final static int PESO_MAX_PUENTE = 200;
    private final static int TIEMPO_MIN_LLEGADA = 10;
    private final static int TIEMPO_MAX_LLEGADA = 30;
    private final static int TIEMPO_MIN_PASO = 100;
    private final static int TIEMPO_MAX_PASO = 500;
    private final static int PESO_MIN_PERSONA = 40;
    private final static int PESO_MAX_PERSONA = 120;
    

    public static void main(String[] args) {

        // Objeto compartido (ControlPlazas) + Coches generados aleatoriamente
        U3A38_ControlPuente puente = new U3A38_ControlPuente(MAX_PERSONAS, PESO_MAX_PUENTE);

        // Creamos y lanzamos las personas
        int id = 0;
        while (true) {
            // Dejamos pasar el tiempo entre persona y persona
            try {
                Thread.sleep((long) (Math.random() * (TIEMPO_MAX_LLEGADA - TIEMPO_MIN_LLEGADA) + TIEMPO_MIN_LLEGADA));
            } catch (InterruptedException ex) {
            }

            // Simulamos la llegada de una persona al puente
            new Thread(new U3A38_Persona(TIEMPO_MIN_PASO, TIEMPO_MAX_PASO, PESO_MIN_PERSONA, PESO_MAX_PERSONA, id++, puente)).start();
        }

        // Como el programa se está ejecutando indefinidamente, no es necesario 
        // que el hilo principal espere a ningún otro hilo
    }

}
