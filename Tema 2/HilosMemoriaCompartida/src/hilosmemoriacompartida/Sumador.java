
package hilosmemoriacompartida;

public class Sumador extends Thread{
    
    private final Contador c;
    
    public Sumador(String name, Contador c){
        super(name);
        this.c=c;
    }
    
    @Override
    public void run(){
        String rojo = "\u001B[31m";
        for(int i = 0; i < 300; i++){
            try{
                c.incrementar();
                System.out.println(rojo + Thread.currentThread().getName() + " " + c.valor());
                Thread.sleep((long) (Math.random() * 100 +50));
            } catch(InterruptedException ex){
                System.out.println("ERROR");
            }
        }
    }

}
