package preparacionpintura;

public class DepositoPintura {

    boolean cian = true;
    boolean magenta = true;
    boolean amarillo = true;

    public DepositoPintura() {
    }

    public synchronized void usarCian() throws InterruptedException {
        while (cian) {
            System.out.println("El bote de pintura cian esta en uso");
            wait();
        }
    }

    public synchronized void usarMagenta() throws InterruptedException {
        while (magenta) {
            System.out.println("El bote de pintura magenta esta en uso");
            wait();
        }
    }

    public synchronized void usarAmarillo() throws InterruptedException {
        while (amarillo) {
            System.out.println("El bote de pintura amarillo esta en uso");
            wait();
        }
    }

}
