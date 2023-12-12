
package ejercicio3holamundo;

public class Mensaje extends Thread{
    
    private String mensaje = "";

    public String getMensaje() {
        return mensaje;
    }

    public synchronized void imprimirHola() throws InterruptedException{ 
         while (!mensaje.contains("")) {            
            wait();
        }
        notifyAll();
        mensaje = "Hola";
    }
    
    public synchronized void imprimirMundo() throws InterruptedException{
        while (mensaje.contains("Hola")) {            
            wait();
        }
        notifyAll();
        mensaje = "Hola Mundo";
    }
    
    public synchronized void imprimirJava() throws InterruptedException{
        while (mensaje.contains("Hola Mundo")) {            
            wait();
        }
        notifyAll();
        mensaje = "Hola Mundo Java";
    }

    @Override
    public void run() {
        try {
            imprimirHola();
            imprimirJava();
            imprimirMundo();
        } catch (InterruptedException ex) {
            
        }
    }
}
