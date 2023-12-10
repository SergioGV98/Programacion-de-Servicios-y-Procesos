
package libreria;

import java.util.HashMap;
import java.util.Random;

public class Libreria {
    
    private final HashMap<Escritor, String []> escritores;
    private double dineroGenerado;
    private boolean firma;

    public Libreria(HashMap<Escritor, String[]> escritores) {
        this.escritores = escritores;
        this.dineroGenerado = 0;
        this.firma = false;
    }

    public void setFirma(boolean firma) {
        this.firma = firma;
    }

    public boolean isFirma() {
        return firma;
    }
    
    public synchronized void venderLibro(Escritor autor, double precio){
        Random r = new Random();
        String[] libros = escritores.get(autor);
        System.out.printf("El autor %s, ha vendido el libro %s por %.2f euros.\n", autor.getNombre(), libros[r.nextInt(libros.length)], precio);
        dineroGenerado += precio;
        autor.setDineroIngresado(autor.getDineroIngresado() + dineroGenerado);
        autor.setLibrosVendidos(autor.getLibrosVendidos() + 1);
        System.out.printf("La libreria ha ganado un total de %.2f Euros.\n", dineroGenerado);
    }
    
    public synchronized void autorFimarLibros(Escritor autor, Lector lector) throws InterruptedException{
        while (!firma) {            
            System.out.println("No se ha organizado una firma de libros.");
            wait();
        }
        
        System.out.printf("El autor %s ha firmado un libro.\n", autor.getNombre());
    }
    
    public synchronized void libreriaOrganizaFirmas(){
        System.out.printf("%sLa libreria ha organizado una firma de libros.\n", "\u001B[33m");
        notifyAll();
    }
    
    
    
}
