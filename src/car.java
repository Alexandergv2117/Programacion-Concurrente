import java.util.Random;

public class car extends Thread {
  String model;
  String color;
  String placa;

  int carPark;

  boolean finished = false;
  boolean parking = true;
  boolean exited = false;
  boolean print = false;

  parking Car_park;
  Random rand = new Random();

  public car(String model, String color, String placa, parking Park) {
    this.model = model;
    this.color = color;
    this.placa = placa;
    this.Car_park = Park;
  }

  public void run() {
    while (parking) {
      carPark = Car_park.parkingEntrance(model, color, placa);
      if (carPark != 0) {
        parking = false;
        exited = true;
        try {
          sleep(rand.nextInt(3000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      if (carPark == 0 && print == false) {
        try {
          print = true;
          System.out.println(model + " " + color + " " + placa + " esta esperando lugar");
          wait();
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }

    if (exited) {
      Car_park.parkingExit(model, color, placa, carPark);
      exited = false;
      finished = true;
      try {
        notifyAll();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
