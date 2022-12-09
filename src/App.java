public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello, World!");

    parking Park = new parking(6, 2);

    car car1 = new car("Challenger Demon", "Rojo", "1234", Park);
    car car2 = new car("Charger hellcat", "Azul", "5678", Park);
    car car3 = new car("Lancer Evolution", "Blanco", "9101", Park);
    car car4 = new car("RAM TRX", "Roja", "1121", Park);
    car car5 = new car("FORD Raptor R", "Azul", "3141", Park);
    car car6 = new car("Ferrari 458", "Rojo", "5161", Park);
    car car7 = new car("Lamborghini Aventador", "Blanco", "7181", Park);
    car car8 = new car("Porsche 911", "Rojo", "9201", Park);
    car car9 = new car("BMW M3", "Azul", "1221", Park);
    car car10 = new car("Audi R8", "Blanco", "3241", Park);

    car1.start();
    car2.start();
    car3.start();
    car4.start();
    car5.start();
    car6.start();
    car7.start();
    car8.start();
    car9.start();
    car10.start();
  }
}
