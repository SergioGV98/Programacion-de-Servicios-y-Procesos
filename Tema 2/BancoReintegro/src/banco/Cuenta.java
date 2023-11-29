package banco;

public class Cuenta {

    private int saldo;
    private boolean haySaldoSuficiente = true;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public synchronized void ingreso(String cliente, String color, int ingreso) {
        System.out.printf("%s%s ha realizado un ingreso de %d Euros\n", color, cliente, ingreso);
        saldo += ingreso;
        haySaldoSuficiente = true;
        notify();
    }

    public synchronized boolean reintegro(String cliente, String color, int retiro) {
        while (!dineroDisponible(retiro)) {
            try {
                System.out.printf("%s%s espera a que haya saldo suficiente para retirar %d Euros\n", color, cliente, retiro);
                wait();
            } catch (InterruptedException ex) {
                System.out.printf("ERROR: %s\n", ex.getMessage());
            }
        }

        System.out.printf("%s%s ha realizado un reintegro de %d Euros\n", color, cliente, retiro);
        saldo -= retiro;
        return true;

    }

    public boolean dineroDisponible(int retiro) {
        return this.saldo >= retiro;
    }
}
