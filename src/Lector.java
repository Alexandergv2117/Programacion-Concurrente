public class Lector extends Thread {
    int palabrasLeidas;
    int limitePalabras;
    String nombre;

    Libro libro;

    public Lector(String nombre, Libro libro) {
        this.nombre = nombre;
        this.limitePalabras = libro.palabrasTotales;
        palabrasLeidas = 0;
        this.libro = libro;
    }

    public void run() {
        while (palabrasLeidas < libro.palabrasEscritas) {
            palabrasLeidas = libro.leerPalabras(palabrasLeidas, nombre);
        }
    }

}
