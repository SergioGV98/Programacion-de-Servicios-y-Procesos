package clienteservidortcpmultihilolibreria;

import java.util.HashMap;
import java.util.Map;


public class Libreria {

    private final String nombre;
    private Map<String, Integer> libros = new HashMap<>();

    public Libreria(String nombre, Map<String, Integer> libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized String comprar(String nombreLibro, int cantidad) {
        if (libros.containsKey(nombreLibro)) {
            int cantidadActual = libros.get(nombreLibro);
            if (cantidadActual >= cantidad) {
                libros.put(nombreLibro, cantidadActual - cantidad);
                int cantidadRestante = cantidadActual - cantidad;
                return "Compra exitosa de " + cantidad + " ejemplar(es) de " + nombreLibro + ". Quedan " + cantidadRestante + " ejemplares.";
            } else {
                return "No hay suficientes ejemplares de " + nombreLibro + " disponibles.";
            }
        } else {
            return "No tenemos ese libro.";
        }
    }

}
