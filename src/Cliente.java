import java.util.concurrent.locks.ReentrantLock;

public class Cliente extends Thread {
  Mesa mesa;
  ReentrantLock lock;

  String nombre;
  int lugar;
  int cubiertoAdicional;


  public Cliente(Mesa mesa, String nombre, int lugar, ReentrantLock lock) {
    this.mesa = mesa;
    this.lock = lock;
    this.nombre = nombre;
    this.lugar = lugar;
    this.cubiertoAdicional = lugar + 1;
  }

  public void run() {
    boolean termino = false;
    while (!termino) {
      lock.lock();
      if (mesa.comidaServida[lugar]) {
        mesa.setCubierto(lugar, false);
        mesa.setCubierto(cubiertoAdicional, false);
        System.out.println(nombre + " come en el lugar " + cubiertoAdicional);
        try {
          sleep(1000); // Simula el tiempo que tarda en comer
        } catch (Exception e) {
          // TODO: handle exception
        }
        mesa.setCubierto(lugar, true);
        mesa.setCubierto(cubiertoAdicional, true);
        termino = true;
        System.out.println(nombre + " termino de comer");
      }
      lock.unlock();
    }
  }
}
