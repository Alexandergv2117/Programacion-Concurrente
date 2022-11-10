import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro(100);

        Escritor escritor1 = new Escritor(4, "Jose", libro);
        Escritor escritor2 = new Escritor(4, "Maria", libro);
        Escritor escritor3 = new Escritor(4, "Pedro", libro);

        // Lector lector1 = new Lector("Timis", libro);
        // Lector lector2 = new Lector("Luis", libro);
        // Lector lector3 = new Lector("Juan", libro);

        escritor1.start();
        escritor2.start();
        escritor3.start();

        // lector1.start();
        // lector2.start();
        // lector3.start();
    }
}
