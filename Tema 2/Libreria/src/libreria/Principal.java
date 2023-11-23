package libreria;

public class Principal {

    public static void main(String[] args) {
        Book book = new Book("Mistborn: El Imperio Final");
        
        BookReader sergio = new BookReader("Sergio", book);
        BookReader cacahuete = new BookReader("Cacahuete", book);
        
        sergio.start();
        cacahuete.start();
        
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
        
        BookWriter brandom = new BookWriter("Brandom Sanderson", book);
        brandom.start();
    }
    
}
