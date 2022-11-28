class Hotel {
  int totalPisos;
  int elevatorCapacity;
  int trips;
  TripsGenerator tripsGenerator;
  

  public Hotel(int totalPisos, int elevatorCapacity, int trips) {
    this.totalPisos = totalPisos;
    this.elevatorCapacity = elevatorCapacity;
    this.trips = trips;
    this.tripsGenerator = new TripsGenerator(trips, totalPisos, elevatorCapacity);
  }

  public int getTotalPisos() {
    return this.totalPisos;
  }
  public int getElevatorCapacity() {
    return this.elevatorCapacity;
  }
}