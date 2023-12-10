
package noria;

public class Cliente implements Runnable{
    
    private String nombre;
    private Noria noria;

    public Cliente(String nombre, Noria noria) {
        this.nombre = nombre;
        this.noria = noria;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public void run() {
        
        try {
            noria.subirseNoria(this);
            Thread.sleep(10000);
            noria.bajarseNoria(this);
        } catch (InterruptedException ex) {
            System.out.printf("ERROR: %s.\n");
        }
    }
}
