public class Mesa {
  String Mesa;
  boolean[] cubiertos;
  boolean[] comidaServida;

  public Mesa(String nombreMesa, int cantidad) {
    cubiertos = new boolean[cantidad];
    comidaServida = new boolean[cantidad];
    for (int i = 0; i < cantidad; i++) {
      cubiertos[i] = true;
      comidaServida[i] = false;
    }
  }

  public synchronized void setCubierto(int i, boolean status) {
    if (i == cubiertos.length) {
      i = 0;
    }
    cubiertos[i] = status;
  }

  public synchronized boolean getCubierto(int i) {
    if (i == cubiertos.length) {
      i = 0;
    }
    return cubiertos[i];
  }

  public synchronized void servir(int i) {
    if (getCubierto(i)) {
      System.out.println("El mesero sirve la comida al lugar " + (i + 1));
      comidaServida[i] = true;
    }
  }
}
