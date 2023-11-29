
package sumadorrestador;

public class Restador implements Runnable {
    
    private final Contador c;

    public Restador(Contador c) {
        this.c = c;
    }

    @Override
    public void run() {
        
        for(int i = 0; i < 300; i++){
            try{
                c.restarSync();
                Thread.sleep((long) (Math.random() * 100 +50));
            } catch(InterruptedException ex){
                System.out.println("ERROR");
            }
        }
    }
    
}
