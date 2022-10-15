public class Proveedor extends Thread {
  String PRODUCTO_SURTIDO;
  int CAPACIDAD_DE_SURTIDO;

  Tienda tienda;

  public Proveedor(String producto_surtido, int capacidad_de_surtido, Tienda tienda) {
    this.PRODUCTO_SURTIDO = producto_surtido;
    this.CAPACIDAD_DE_SURTIDO = capacidad_de_surtido;
    this.tienda = tienda;
  }

  public void run() {
    while (true) {
      if (!(tienda.getContenedoresLlenos()) && !(tienda.getContenedorLleno(PRODUCTO_SURTIDO))) {
        tienda.rellenarContenedor(PRODUCTO_SURTIDO, CAPACIDAD_DE_SURTIDO);
        System.out.println("El proveedor ha surtido " + PRODUCTO_SURTIDO  + " en la tienda\n");
      }
      try {
        wait();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
 