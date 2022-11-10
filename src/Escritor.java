public class Escritor extends Thread {
  int palabrasEscritas;
  int limitePalabras;
  String nombre;
  Libro libro;

  public Escritor(int lim, String nombre, Libro libro) {
    this.limitePalabras = lim;
    this.palabrasEscritas = 0;
    this.nombre = nombre;
    this.libro = libro;

  }

  public void run() {
    while (!libro.libroEscrito) {
      int random = (int) (Math.random() * (limitePalabras - 1)) + 1;
      libro.escribirPalabra(random, nombre);
    }
  }
}
