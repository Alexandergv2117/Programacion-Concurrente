import java.util.concurrent.locks.ReentrantLock;

public class Mesero extends Thread {
  Mesa mesa;
  ReentrantLock lock;

  public Mesero(Mesa mesa, ReentrantLock lock) {
    this.mesa = mesa;
    this.lock = lock;
  }

  public void run() {
    lock.lock();
    for (int i = 0; i < mesa.cubiertos.length; i++) {
      mesa.servir(i);
    }
    lock.unlock();
  }
}
