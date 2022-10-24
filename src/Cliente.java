import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente extends Thread {
  Mesa mesa;
  ReentrantLock lock;
  Random random;

  String nombre;
  int lugar;
  int cubiertoAdicional;
  
  boolean sentado = false;

  public Cliente(Mesa mesa, String nombre, ReentrantLock lock, Random random) {
    this.mesa = mesa;
    this.lock = lock;
    this.random = random;
    this.nombre = nombre;
  }

  public void run() {
    boolean termino = false;
    while (!termino) {
      if (!sentado) {
        lock.lock();
        lugar = sentarse();
        cubiertoAdicional = lugar + 1;
        sentado = true;
        System.out.println(nombre + " se sienta en el lugar " + (lugar + 1)+ "\n");
        lock.unlock();
      }
      lock.lock();
      if (mesa.comidaServida[lugar] && mesa.getCubierto(lugar) && mesa.getCubierto(cubiertoAdicional)) {
        mesa.setCubierto(lugar, false);
        mesa.setCubierto(cubiertoAdicional, false);
        System.out.println("\n" + nombre + " come en el lugar " + (lugar + 1));
        System.out.println("Con el cubierto del lugar " + (lugar + 1) + " y el cubierto del lugar " + (ajustarCubierto(cubiertoAdicional) + 1));
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
        System.out.println("deja los cubiertos en el lugar " + (lugar + 1) + " y el lugar " + (ajustarCubierto(cubiertoAdicional) + 1));
        System.out.println("se levanta del lugar " + (lugar + 1) + "\ny se va.");

      }
      lock.unlock();
    }
  }

  public synchronized int sentarse() {
    int lugar = 0;
    for (int i = 0; i < mesa.sillas.length; i++) {
      if (!mesa.sillas[i]) {
        mesa.sillas[i] = true;
        lugar = i;
        break;
      }
    }
    return lugar;
  }

  public int ajustarCubierto(int i) {
    if (i == mesa.cubiertos.length) {
      i = 0;
    }
    return i;
  }
}
