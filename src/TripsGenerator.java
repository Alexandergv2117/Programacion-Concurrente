import java.util.ArrayList;
class TripsGenerator {
    int trips;
    int totalFloors;
    int totalCapacity;
    ArrayList<Object> tripsList = new ArrayList<Object>();
    
    TripsGenerator(int trips, int totalFloors, int totalCapacity) {
        this.trips = trips;
        this.totalFloors = totalFloors;
        this.totalCapacity = totalCapacity;
        generateTrips();
    }

    public void generateTrips() {
        for (int i = 0; i < trips; i++) {
            int origin = (int) (Math.random() * totalFloors);
            int destination = (int) (Math.random() * totalFloors);
            int people = (int) (Math.random() * totalCapacity);
            while (origin == destination) {
                destination = (int) (Math.random() * totalFloors);
            }
            Trip trip = new Trip(origin, destination, people, i == 0 ? true: false);
            tripsList.add(trip); // no jalo xd
        }
      }
    }