// Elevador con monitores en Java
// Programacion concurrente

public class App {
    public static void main(String[] args) throws Exception {
        Elevador elevador = new Elevador(10);

        elevador.start();

        elevador.pisoDestino = 5;

        Thread.sleep(5000);

        elevador.pisoDestino = 3;
    }
}
