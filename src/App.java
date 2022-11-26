// Elevador con monitores en Java
// Programacion concurrente

public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel(15);
        Elevador elevador = new Elevador(10, hotel);

        elevador.start();
    }
}
