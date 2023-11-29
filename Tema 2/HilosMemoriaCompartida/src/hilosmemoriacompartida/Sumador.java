
package hilosmemoriacompartida;

public class Sumador extends Thread{
    
    private final Contador c;
    
    public Sumador(Contador c){
        this.c=c;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 300; i++){
            try{
                c.sumarSync();
                Thread.sleep((long) (Math.random() * 100 +50));
            } catch(InterruptedException ex){
                System.out.println("ERROR");
            }
        }
    }

}
