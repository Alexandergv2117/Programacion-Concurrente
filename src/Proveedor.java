public class Proveedor extends Thread {
  String NOMBRE;
  String[] PRODUCTO_SURTIDO;
  int[] CAPACIDAD_DE_SURTIDO;
  int PRODUCTO_SURTIDO_LENGTH;

  boolean isRunning = false;

  Tienda tienda;

  public Proveedor(String nombre, String[] producto_surtido, int[] capacidad_de_surtido, Tienda tienda) {
    this.NOMBRE = nombre;
    this.PRODUCTO_SURTIDO = producto_surtido;
    this.CAPACIDAD_DE_SURTIDO = capacidad_de_surtido;
    this.tienda = tienda;
    this.PRODUCTO_SURTIDO_LENGTH = producto_surtido.length;
  }

  public void run() {
    while (true) {
      if (!tienda.getContenedoresLlenos()) {
        for (int i = 0; i < PRODUCTO_SURTIDO_LENGTH; i++) {
          if (!tienda.getContenedorLleno(PRODUCTO_SURTIDO[i])) {
            tienda.rellenarContenedor(PRODUCTO_SURTIDO[i], CAPACIDAD_DE_SURTIDO[i]);
            System.out.println("El "+ this.NOMBRE + " ha surtido " + PRODUCTO_SURTIDO[i]  + " en la tienda\n");
          }
        }
        isRunning = tienda.getContenedoresLlenos();
      } 
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
 