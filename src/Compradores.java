public class Compradores extends Thread {
  String nombre;
  String[] productos;
  int[] cantidades;
  boolean lista_de_compra_completa = false;

  Tienda tienda;

  public Compradores(String nombre, String[] productos, int[] cantidades, Tienda tienda) {
    this.nombre = nombre;
    this.productos = productos;
    this.cantidades = cantidades;
    this.tienda = tienda;
  }

  public void run() {
    while (!lista_de_compra_completa) {
      if (tienda.getContenedoresLlenos()) {
        lista_de_compra_completa = tienda.comprarProducto(productos, cantidades);
        if (lista_de_compra_completa) {
          System.out.println(nombre + " ha comprado todos los productos");
        } else {
          System.out.println(nombre + " no ha podido comprar todos los productos");
        }
      } else {
        try {
          wait();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
  }
}
