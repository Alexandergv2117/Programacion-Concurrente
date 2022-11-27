public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel(15);
        Elevador elevador = new Elevador(2, hotel);
        Viaje viaje = new Viaje(hotel, "Viaje 1", elevador);
        Viaje viaje2 = new Viaje(hotel, "Viaje 2", elevador);

        elevador.start();
        viaje.start();
        viaje2.start();
    }
}
