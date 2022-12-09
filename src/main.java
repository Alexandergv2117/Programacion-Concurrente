public class main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        reloj reloj = new reloj(7, 0, 0);
        checador checador = new checador(10, reloj);

        reloj.start();
        checador.start();
    }
}
