package ejerciciosaldosincronizado;

public class EjercicioSaldoSincronizado {

    public static void main(String[] args) {
       
        Cuenta general = new Cuenta(500);
        Usuario manuel = new Usuario(general, "Manuel", "\u001B[32m");
        Usuario luis = new Usuario(general, "Luis", "\u001B[33m");
        
        manuel.start();
        luis.start();

        try{
            manuel.join();
            luis.join();
        } catch(InterruptedException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
        }
    }
    
}
