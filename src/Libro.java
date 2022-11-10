public class Libro {
  int palabrasTotales;
  int palabrasEscritas;

  boolean libroEscrito = false;

  public Libro(int paginasTotales) {
    this.palabrasTotales = paginasTotales;
    this.palabrasEscritas = 0;
  }

  public synchronized boolean escribirPalabra(int palabras_a_escribir, String nombreEscritor) {
    if (libroEscrito) {
      return false;
    }
    System.out.println("#########################  ESCRITOR  #########################");
    System.out
        .println("\n" + nombreEscritor + " está escribiendo de la palabra " + palabrasEscritas + "/" + palabrasTotales
            + " a la palabra "
            + (palabrasEscritas + palabras_a_escribir > palabrasTotales ? 100 : palabrasEscritas + palabras_a_escribir)
            + "/" + palabrasTotales + "\n");

    palabrasEscritas += palabras_a_escribir;

    if (palabrasEscritas >= palabrasTotales) {
      palabrasEscritas = palabrasTotales;
      libroEscrito = true;
      System.out.println("El libro se ha termiando de escribir por " + nombreEscritor + "\n\n");
      return true;
    } else {
      System.out.println(nombreEscritor + " ha escrito " + palabras_a_escribir + " palabras\n\n");
    }

    notify();
    return false;
  }

  public synchronized int leerPalabras(int palabrasLeidas, String nombreLector) {
    while (palabrasLeidas >= palabrasEscritas) {
      try {
        notify();
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("#########################  LECTOR  #########################");
    System.out.println(nombreLector + " está leyendo...");
    System.out.println("El lector ha leido de la palabra" + palabrasLeidas + "/" + palabrasTotales + " a la palabra "
        + (palabrasLeidas + palabrasEscritas) + "/" + palabrasTotales + "\n\n");

    if (palabrasLeidas >= palabrasTotales) {
      System.out.println(nombreLector + " ha termiando de leer el libro\n\n");
    }

    notify();
    return palabrasEscritas;
  }
}
