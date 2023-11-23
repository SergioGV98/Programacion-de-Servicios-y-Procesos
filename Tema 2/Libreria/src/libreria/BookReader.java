
package libreria;

public class BookReader extends Thread{

    Book book;

    public BookReader(String name, Book book) {
        super(name);
        this.book = book;
    }

    @Override
    public void run() {
        book.leer();
    }
}
