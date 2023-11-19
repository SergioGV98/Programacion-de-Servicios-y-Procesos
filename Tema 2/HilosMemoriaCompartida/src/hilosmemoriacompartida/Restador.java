
package hilosmemoriacompartida;

public class Restador implements Runnable {
    
    private final String name;
    private final Contador c;

    public Restador(String name, Contador c) {
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        String verde = "\u001B[32m";
        
        for(int i = 0; i < 300; i++){
            try{
                c.decrementar();
                System.out.println(verde + Thread.currentThread().getName() + " " + c.valor());
                Thread.sleep((long) (Math.random() * 100 +50));
            } catch(InterruptedException ex){
                System.out.println("ERROR");
            }
        }
    }
    
}
