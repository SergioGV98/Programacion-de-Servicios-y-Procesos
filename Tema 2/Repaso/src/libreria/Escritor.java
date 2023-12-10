package libreria;

import java.util.Random;

public class Escritor extends Thread {

    private final Libreria libreria;
    private final String nombre;
    private double dineroIngresado;
    private int librosVendidos;

    public Escritor(Libreria libreria, String nombre) {
        this.libreria = libreria;
        this.nombre = nombre;
        this.dineroIngresado = 0;
        this.librosVendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDineroIngresado(double dineroIngresado) {
        this.dineroIngresado = dineroIngresado;
    }

    public double getDineroIngresado() {
        return dineroIngresado;
    }

    public int getLibrosVendidos() {
        return librosVendidos;
    }

    public void setLibrosVendidos(int librosVendidos) {
        this.librosVendidos = librosVendidos;
    }

    @Override
    public void run() {
        Random r = new Random();
        if (r.nextBoolean()) {
            libreria.venderLibro(this, r.nextDouble(9.98, 31));
            System.out.printf("%s ha vendido %d libros.\n", nombre, librosVendidos);
        } 
        
        if(librosVendidos % 10 == 0 && librosVendidos != 0){
            libreria.setFirma(true);
            libreria.libreriaOrganizaFirmas();
            try {
                Thread.sleep(40000);
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
            libreria.setFirma(false);
        } 
    }

}
