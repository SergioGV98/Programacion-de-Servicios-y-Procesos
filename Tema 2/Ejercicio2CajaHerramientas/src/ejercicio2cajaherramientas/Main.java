package ejercicio2cajaherramientas;


public class Main {

    public static void main(String[] args) {
        
        Herramienta herramientas = new Herramienta(4, 2);
        int idTrabajador = 1;
        
        while (true) {            
            try {
                new Thread(new Trabajador("Trabajador " + idTrabajador, herramientas)).start();
                idTrabajador++;
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }
        
    }
    
}