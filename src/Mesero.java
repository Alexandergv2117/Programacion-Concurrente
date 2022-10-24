import java.util.concurrent.locks.ReentrantLock;

public class Mesero extends Thread {
  Mesa mesa;
  ReentrantLock lock;
  boolean termino = false;

  public Mesero(Mesa mesa, ReentrantLock lock) {
    this.mesa = mesa;
    this.lock = lock;
  }

  public void run() {
    while (!termino) {
      if (mesa.mesaLlena()) {
        lock.lock();
        for (int i = 0; i < mesa.sillas.length; i++) {
          if (mesa.sillas[i] && !mesa.comidaServida[i]) {
            mesa.servir(i);
          }
          termino = mesa.comidaServida();
        }
        lock.unlock();
      }
    }
  }
}
