import java.util.concurrent.locks.ReentrantLock;

public class Proveedor extends Thread {
  String[] PRODUCTO_SURTIDO; // nombre del producto que surte
  int[] CAPACIDAD_DE_TRANSPORTE; // capacidad de transporte
  String NOMBRE;

  Tienda tienda;
  ReentrantLock lock;

  public Proveedor(String nombre, String[] producto_surtido, int[] capacidad_de_transporte, Tienda tienda, ReentrantLock lock) {
    this.NOMBRE = nombre;
    this.PRODUCTO_SURTIDO = producto_surtido;
    this.CAPACIDAD_DE_TRANSPORTE = capacidad_de_transporte;
    this.tienda = tienda;
    this.lock = lock;
  }

  public void run() {
    while (true) {
      lock.lock();
      for (int i = 0; i < PRODUCTO_SURTIDO.length; i++) {
        if (!(tienda.getContenedoresLlenos()) && !(tienda.getContenedorLleno(PRODUCTO_SURTIDO[i]))) {
          
          tienda.rellenarContenedor(NOMBRE, PRODUCTO_SURTIDO[i], CAPACIDAD_DE_TRANSPORTE[i]);
          
        }
      }
      lock.unlock();
    }
  }
}
