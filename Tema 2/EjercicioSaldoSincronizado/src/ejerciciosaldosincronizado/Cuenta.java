package ejerciciosaldosincronizado;

public class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void ingreso(String cliente, String color, int ingreso) {
        System.out.printf("%s%s ha realizado un ingreso de %d Euros\n", color, cliente, ingreso);
        saldo += ingreso;
    }

    public synchronized boolean reintegro(String cliente, String color, int retiro) {
        if (dineroDisponible(retiro)) {
            System.out.printf("%s%s ha realizado un reintegro de %d Euros\n", color, cliente, retiro);
            saldo -= retiro;
            return true;
        } else {
            System.out.printf("%s%s no ha podido realizar un reintegro de %d Euros\n", color, cliente, retiro);
            return false;
        }
    }

    public synchronized boolean dineroDisponible(int retiro) {
        return this.saldo >= retiro;
    }

}
