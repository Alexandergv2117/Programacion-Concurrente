
public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel(15, 8, 10);

        System.out.println(hotel.tripsGenerator.tripsList.get(1));

        Elevator elevator = new Elevator(hotel);

        elevator.start();
    }
}
