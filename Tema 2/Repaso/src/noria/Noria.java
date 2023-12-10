package noria;

public class Noria {

    public Noria() {
    }
    
    public synchronized void subirseNoria(Cliente cliente){
        System.out.printf("%s ha subido a la noria.\n", cliente.getNombre());
    }
    
    public synchronized void bajarseNoria(Cliente cliente){
        System.out.printf("%s ha bajado de la noria.\n", cliente.getNombre());
    }
}
