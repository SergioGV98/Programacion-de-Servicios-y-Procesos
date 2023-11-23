
package libreria;

public class BookWriter extends Thread{
    
    Book book;

    public BookWriter(String name, Book book) {
        super(name);
        this.book = book;
    }

    @Override
    public void run() {
        book.escribir();
    }
    
}
