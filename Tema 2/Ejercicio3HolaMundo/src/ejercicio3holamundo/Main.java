package ejercicio3holamundo;

public class Main {

    public static void main(String[] args) { 
        int repeticiones = 1;
        while (repeticiones != 6) {
            Mensaje mensaje = new Mensaje();
            Thread hola = new Thread(mensaje);
            hola.start();
            Thread mundo = new Thread(mensaje);
            mundo.start();
            Thread java = new Thread(mensaje);
            java.start();
            if(mensaje.getMensaje().contains("Hola Mundo Java")){
                System.out.printf("Mensaje%d: %s\n", repeticiones,mensaje.getMensaje());
                repeticiones++;
                if(repeticiones == 6){
                    System.exit(0);
                }
            } 
        }

    }

}