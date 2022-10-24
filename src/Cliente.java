import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente extends Thread {
  Mesa mesa;
  ReentrantLock lock;
  Random random;

  String nombre;
  int lugar;
  int cubiertoAdicional;

  public Cliente(Mesa mesa, String nombre, int lugar, ReentrantLock lock, Random random) {
    this.mesa = mesa;
    this.lock = lock;
    this.random = random;
    this.nombre = nombre;
    this.lugar = lugar;
    this.cubiertoAdicional = lugar + 1;
  }

  public void run() {
    boolean termino = false;
    while (!termino) {
      lock.lock();
      if (mesa.comidaServida[lugar] && mesa.getCubierto(lugar) && mesa.getCubierto(cubiertoAdicional)) {
        mesa.setCubierto(lugar, false);
        mesa.setCubierto(cubiertoAdicional, false);
        System.out.println("\n" + nombre + " come en el lugar " + lugar);
        System.out.println("Con el cubierto del lugar " + lugar + " y el cubierto del lugar " + cubiertoAdicional);
        lock.unlock();
        try {
          sleep(random.nextInt(2000, 10000)); // Simula el tiempo que tarda en comer
        } catch (Exception e) {
          // TODO: handle exception
        }
        lock.lock();
        mesa.setCubierto(lugar, true);
        mesa.setCubierto(cubiertoAdicional, true);
        termino = true;
        System.out.println("\n" + nombre + " termino de comer");
      }
      lock.unlock();
    }
  }
}
