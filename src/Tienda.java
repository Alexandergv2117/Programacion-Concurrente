public class Tienda {
  Contenedor contenedor_frijol = new Contenedor("Frijol", 10);
  Contenedor contenedor_arroz = new Contenedor("Arroz", 10);
  Contenedor contenedor_maiz = new Contenedor("Maiz", 10);

  public boolean contenedores_llenos = false;
  public boolean entradaProveedores = true;

  public void rellenarContenedor(String producto, int cantidad) {
    if (producto.equals("Frijol")) {
      contenedor_frijol.rellenar(cantidad);
    } else if (producto.equals("Arroz")) {
      contenedor_arroz.rellenar(cantidad);
    } else if (producto.equals("Maiz")) {
      contenedor_maiz.rellenar(cantidad);
    }

    if (contenedor_frijol.lleno && contenedor_arroz.lleno && contenedor_maiz.lleno) {
      contenedores_llenos = true;
      notifyAllCompradores();
    }
  }

  public synchronized boolean comprarProducto(String[] producto, int[] cantidad, String nombreComprador) {
    int i;
    int PRODUCTO_LENGTH = producto.length;
    boolean lista_de_compra_completa = true;
    for (i = 0; i < PRODUCTO_LENGTH; i++) {
      if(producto[i] == "Frijol"){
        if(!contenedor_frijol.retirarProductoDelContenedor(cantidad[i], nombreComprador)){
          lista_de_compra_completa = false;
          contenedores_llenos = false;
          contenedor_frijol.lleno = false;
        }
      } else if(producto[i] == "Arroz"){
        if(!contenedor_arroz.retirarProductoDelContenedor(cantidad[i], nombreComprador)){
          lista_de_compra_completa = false;
          contenedores_llenos = false;
          contenedor_arroz.lleno = false;
        }
      } else if(producto[i] == "Maiz"){
        if(!contenedor_maiz.retirarProductoDelContenedor(cantidad[i], nombreComprador)){
          lista_de_compra_completa = false;
          contenedores_llenos = false;
          contenedor_maiz.lleno = false;
        }
      }
    }
    if (!lista_de_compra_completa) {
      System.out.println(nombreComprador + " no ha podido comprar todos los productos");
      contenedores_llenos = false;
      //notifyAll();
      return false;
    } else {
      System.out.println(nombreComprador + " ha comprado todos los productos\n");
    }

    if(contenedor_frijol.cantidad_actual == 0 && contenedor_arroz.cantidad_actual == 0 && contenedor_maiz.cantidad_actual == 0){
      contenedores_llenos = false;
      //notifyAll();
    }

    return lista_de_compra_completa;
  }

  public synchronized void setContenedoresLlenos(boolean contenedores_llenos) {
    this.contenedores_llenos = contenedores_llenos;
  }

  public synchronized boolean getContenedoresLlenos() {
    return contenedores_llenos;
  }

  public synchronized boolean getContenedorLleno(String producto) {
    if (producto.equals("Frijol")) {
      return contenedor_frijol.lleno;
    } else if (producto.equals("Arroz")) {
      return contenedor_arroz.lleno;
    } else if (producto.equals("Maiz")) {
      return contenedor_maiz.lleno;
    }
    return false;
  }

  public synchronized void notifyAllCompradores() {
    notifyAll();
  }
}
