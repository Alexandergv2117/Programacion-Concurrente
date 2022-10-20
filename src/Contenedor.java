public class Contenedor {
  String PRODUCTO;
  int CAPACIDAD_MAX;
  int cantidad_actual = 0;
  boolean lleno = false;

  int sobrante = 0;

  public Contenedor(String producto, int capacidad_max) {
    this.PRODUCTO = producto;
    this.CAPACIDAD_MAX = capacidad_max;
  }

  public void setCantidadActual(int cantidad_actual) {
    this.cantidad_actual = cantidad_actual;
  }

  public int getCantidadActual() {
    return cantidad_actual;
  }

  public void setLleno(boolean lleno) {
    this.lleno = lleno;
  }

  public boolean getLleno() {
    return lleno;
  }

  public void rellenar(int cantidad) {
    if (!lleno) {
      if (cantidad_actual + cantidad > CAPACIDAD_MAX) {
        sobrante = (cantidad_actual + cantidad) - CAPACIDAD_MAX;
        cantidad_actual = CAPACIDAD_MAX;
        System.out.println("Se ha ingresado al contenedor de " + PRODUCTO + " " + cantidad + " unidades");
        System.out.println("Se ha llenado el contenedor de " + PRODUCTO + " y ha sobrado " + sobrante + " unidades");
        lleno = true;
        return;
      } else if (cantidad_actual + cantidad <= CAPACIDAD_MAX) {
        cantidad_actual += cantidad;
        System.out.println("Llenando contenedor de " + PRODUCTO + " ...");
        System.out.println("Se ha ingresado al contenedor de " + PRODUCTO + " " + cantidad + " unidades");
        if (cantidad_actual == CAPACIDAD_MAX) {
          System.out.println("El contenedor de " + PRODUCTO + " ya está lleno");
          lleno = true;
          return;
        }
      }
    } else {
      System.out.println("El contenedor de " + PRODUCTO + " ya está lleno");
    }
  }

  public synchronized boolean retirarProductoDelContenedor(int cantidad__retirar, String nombreComprador) {
    int cantidad_actual_temp = cantidad_actual - cantidad__retirar;

    if (cantidad_actual_temp < 0) {
      System.out.println("No hay suficiente producto en el contenedor de " + PRODUCTO + " para " + nombreComprador + "\n");
      return false;
    } else if (cantidad_actual_temp >= 0) {
      cantidad_actual -= cantidad__retirar;
      System.out.println(nombreComprador + " ha retirado " + cantidad__retirar + " unidades del contenedor de " + PRODUCTO);
      if (cantidad_actual == 0) {
        System.out.println("El contenedor de " + PRODUCTO + " está vacío");
        lleno = false;
      }
      return true;
    }
    return false;
  } 
}
