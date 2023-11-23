
package libreria;

public class Book {
    
    String title;
    boolean isCompleted;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
    public synchronized void escribir(){
        System.out.printf("Autor esta escribiendo el libro: %s\n", getTitle());
        
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
        setIsCompleted(true);
        System.out.println("El libro ha sido escrito.");
        
        notifyAll();
        System.out.println("Se comunica a un lector.");
    }
    
    public synchronized void leer(){
        System.out.printf("%s esta esperando a que el libro se escriba: %s\n", Thread.currentThread().getName(), getTitle());
        
        try{
            if(!isCompleted){
                wait();
            }
        } catch (InterruptedException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
        System.out.printf("%s: El libro ha sido terminado: Ahora lo puedo leer.\n", Thread.currentThread().getName());
    }

}
