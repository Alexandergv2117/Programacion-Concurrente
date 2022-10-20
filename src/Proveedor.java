import java.util.concurrent.locks.ReentrantLock;

public class Proveedor extends Thread {
  String NOMBRE;
  String[] PRODUCTO_SURTIDO;
  int[] CAPACIDAD_DE_SURTIDO;
  int PRODUCTO_SURTIDO_LENGTH;

  boolean isRunning = false;

  Tienda tienda;
  ReentrantLock lock;

  public Proveedor(String nombre, String[] producto_surtido, int[] capacidad_de_surtido, Tienda tienda, ReentrantLock lock) {
    this.NOMBRE = nombre;
    this.PRODUCTO_SURTIDO = producto_surtido;
    this.CAPACIDAD_DE_SURTIDO = capacidad_de_surtido;
    this.tienda = tienda;
    this.PRODUCTO_SURTIDO_LENGTH = producto_surtido.length;
    this.lock = lock;
  }

  public void run() {
    while (true) {
      lock.lock();
      if (!tienda.getContenedoresLlenos() && tienda.entradaProveedores) {
        for (int i = 0; i < PRODUCTO_SURTIDO_LENGTH; i++) {
          if (!tienda.getContenedorLleno(PRODUCTO_SURTIDO[i])) {
            tienda.rellenarContenedor(PRODUCTO_SURTIDO[i], CAPACIDAD_DE_SURTIDO[i]);
            System.out.println("El "+ this.NOMBRE + " ha surtido " + PRODUCTO_SURTIDO[i]  + " en la tienda\n");
          }
        }
        isRunning = tienda.getContenedoresLlenos();
      } 
      lock.unlock();
      if (isRunning) {
        isRunning = !isRunning;
        System.out.println("La tienda esta llena, el " + this.NOMBRE + " no puede surtir mas productos\n");
        try {
          wait();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
  }
}
 