public class Lector extends Thread {
  int palabrasLeidas;
  int limitePalabras;
  boolean libroLeido = false;
  String nombre;

  Libro libro;

  public Lector(String nombre, Libro libro) {
    this.nombre = nombre;
    this.limitePalabras = libro.palabrasTotales;
    this.palabrasLeidas = 0;
    this.libro = libro;
  }

  public void run() {
    while (!libroLeido) {
      palabrasLeidas = libro.leerPalabras(palabrasLeidas, nombre);

      if (palabrasLeidas >= libro.palabrasTotales) {
        libroLeido = true;
      }
    }
  }
}
