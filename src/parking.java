public class parking extends Thread {
  boolean[] parkingLot;
  boolean[] parkinglotTickets;
  boolean isEmptyParkinglotTickets = true;

  int entrada;
  int PARKING_LOT_LENGTH;

  public parking(int size, int tickets) {
    this.parkingLot = new boolean[size];
    this.parkinglotTickets = new boolean[tickets];
    this.PARKING_LOT_LENGTH = size;

    for (int i = 0; i < size; i++) {
      parkingLot[i] = false;
    }
    for (int i = 0; i < tickets; i++) {
      parkinglotTickets[i] = false;
    }
  }

  public synchronized int parkingEntrance(String model, String color, String placa) {
    int i;
    
    resetParkingtickets();

    if (!isFull()) {
      for (i = 0; i < PARKING_LOT_LENGTH; i++) {
        if (!parkingLot[i]) {
          parkingLot[i] = true;
          System.out.println("\n" + model + " " + color + " " + placa + " ha entrado por la entrada " + entrada);
          System.out.println(model + " " + color + " " + placa + " se ha estacionado en el lugar: " + (i + 1));
          return i + 1;
        }
      }
    }
    return 0;
  }

  public synchronized void parkingExit(String model, String color, String placa, int lugar) {
    int lugarParking = lugar - 1;
    if (parkingLot[lugarParking]) {
      parkingLot[lugarParking] = false;
      System.out.println("\n" + model + " " + color + " " + placa + " saliendo del lugar " + lugar);
    }
  }

  private boolean isFull() {
    int ticket = 0;

    if(isEmptyParkinglotTickets) {
      for (ticket = 0; ticket < parkinglotTickets.length; ticket++) {
        if (parkinglotTickets[ticket] == false) {
          parkinglotTickets[ticket] = true;
          entrada = ticket + 1;
          return false;
        }
      }
    }
    isEmptyParkinglotTickets = false;
    return true;
  }

  private void resetParkingtickets() {
    if(!isEmptyParkinglotTickets) {
      for (int i = 0; i < parkinglotTickets.length; i++) {
        parkinglotTickets[i] = false;
      }
      isEmptyParkinglotTickets = true;
    }
  }
}
