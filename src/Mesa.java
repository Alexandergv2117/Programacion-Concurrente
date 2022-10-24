public class Mesa {
  String Mesa;
  boolean[] cubiertos;
  boolean[] comidaServida;
  boolean[] sillas;

  public Mesa(String nombreMesa, int cantidad) {
    cubiertos = new boolean[cantidad];
    comidaServida = new boolean[cantidad];
    sillas = new boolean[cantidad];
    for (int i = 0; i < cantidad; i++) {
      cubiertos[i] = true;
      comidaServida[i] = false;
      sillas[i] = false;
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

  public void servir(int i) {
    System.out.println("El mesero sirve la comida al lugar " + (i + 1));
    comidaServida[i] = true;
  }

  public boolean mesaLlena() {
    boolean llena = true;
    for (int i = 0; i < sillas.length; i++) {
      if (!sillas[i]) {
        llena = false;
        break;
      }
    }
    return llena;
  }

  public boolean comidaServida() {
    boolean servida = true;
    for (int i = 0; i < comidaServida.length; i++) {
      if (!comidaServida[i]) {
        servida = false;
        break;
      }
    }
    return servida;
  }
}
