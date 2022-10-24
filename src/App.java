import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();

        Mesa mesa = new Mesa("Mesa 1", 7);

        Mesero mesero = new Mesero(mesa, lock);

        Cliente cliente1 = new Cliente(mesa, "Cliente 1", 0, lock);
        Cliente cliente2 = new Cliente(mesa, "Cliente 2", 1, lock);
        Cliente cliente3 = new Cliente(mesa, "Cliente 3", 2, lock);
        Cliente cliente4 = new Cliente(mesa, "Cliente 4", 3, lock);
        Cliente cliente5 = new Cliente(mesa, "Cliente 5", 4, lock);
        Cliente cliente6 = new Cliente(mesa, "Cliente 6", 5, lock);
        Cliente cliente7 = new Cliente(mesa, "Cliente 7", 6, lock);

        mesero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
    }
}
