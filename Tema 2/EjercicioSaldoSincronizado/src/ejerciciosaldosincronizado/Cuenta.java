
package ejerciciosaldosincronizado;

public class Cuenta {
    
    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public synchronized void reintegro(String cliente, String color, int retiro){      
        if(dineroDisponible(retiro)){
            System.out.printf("%s%s ha realizado un reintegro de %d Euros\n",color, cliente, retiro);
            saldo -= retiro;
        } else {
            System.out.printf("%s%s no ha podido realizar un reintegro de %d Euros\n", color, cliente, retiro);
        }
    }
    
    public synchronized boolean dineroDisponible(int retiro){
        if(this.saldo >= retiro){
            return true;
        } 
        return false;
    }

}
