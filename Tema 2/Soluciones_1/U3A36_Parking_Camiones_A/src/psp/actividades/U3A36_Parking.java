/*
 * Ejemplo de ejecución paralela. 
 * Vamos a programar la clase ControlPlazas como una clase Thread-safe, por lo 
 * que el resto de clases no se tienen que preocupar de la sincronización
 */
package psp.actividades;
import java.util.Random;

public class U3A36_Parking {

    private final static int MAX_PLAZAS = 51;
    private final static int TIEMPO_MIN_LLEGADA = 5;
    private final static int TIEMPO_MAX_LLEGADA = 15;
    private final static int TIEMPO_MIN_ESTANCIA = 300;
    private final static int TIEMPO_MAX_ESTANCIA = 900;

    public static void main(String[] args) {

        // Objeto compartido (ControlPlazas) + Coches generados aleatoriamente
        U3A36_ControlPlazas plazasParking = new U3A36_ControlPlazas(MAX_PLAZAS);

        // Creamos y lanzamos los coches
        while (true) {
            // Dejamos pasar el tiempo entre coche y coche
            try {
                Thread.sleep((long) (Math.random() * (TIEMPO_MAX_LLEGADA - TIEMPO_MIN_LLEGADA) + TIEMPO_MIN_LLEGADA));
            } catch (InterruptedException ex) {
            }

            
            Random r=new Random();
            int valor=r.nextInt();
            
            if (valor>0.3) 
                // Simulamos la llegada de un coche al parking
                new Thread(new U3A36_Coche(TIEMPO_MIN_ESTANCIA, TIEMPO_MAX_ESTANCIA, plazasParking)).start();
                else
                // Simulamos la llegada de un camion al parking
                new Thread(new U3A36_Camion(TIEMPO_MIN_ESTANCIA, TIEMPO_MAX_ESTANCIA, plazasParking)).start();
        }

        // Como el programa se está ejecutando indefinidamente, no es necesario 
        // que el hilo prinicipal espere a ningún otro hilo
    }

}
