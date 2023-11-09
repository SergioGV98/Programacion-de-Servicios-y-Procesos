
package hilosmemoriacompartida;

public class Contador {
    
    private int c = 0;
    
    public Contador(int c){
        this.c = c;
    }
    
    public void incrementar(){
        c++;
    }
    
    public void decrementar(){
        c--;
    }
    
    public int valor(){
        return c;
    }

}
