public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel(15);
        Elevador elevador = new Elevador(8, hotel);
        
        Viaje viaje = new Viaje(hotel, "Viaje 1", elevador);
        Viaje viaje2 = new Viaje(hotel, "Viaje 2", elevador);
        Viaje viaje3 = new Viaje(hotel, "Viaje 3", elevador);
        Viaje viaje4 = new Viaje(hotel, "Viaje 4", elevador);
        Viaje viaje5 = new Viaje(hotel, "Viaje 5", elevador);
        Viaje viaje6 = new Viaje(hotel, "Viaje 6", elevador);
        Viaje viaje7 = new Viaje(hotel, "Viaje 7", elevador);
        Viaje viaje8 = new Viaje(hotel, "Viaje 8", elevador);
        Viaje viaje9 = new Viaje(hotel, "Viaje 9", elevador);
        Viaje viaje10 = new Viaje(hotel, "Viaje 10", elevador);

        elevador.start();
        viaje.start();
        viaje2.start();
        viaje3.start();
        viaje4.start();
        viaje5.start();
        viaje6.start();
        viaje7.start();
        viaje8.start();
        viaje9.start();
        viaje10.start();
    }
}
