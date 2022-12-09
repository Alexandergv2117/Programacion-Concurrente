import java.util.Random;

public class main  {
    public static void main(String[] args) throws Exception {
        ranking ranki = new ranking();
        Random rand = new Random();

        corredores corredor1 = new corredores("Juan", 1, 0, ranki, rand);
        corredores corredor2 = new corredores("Pedro", 2, 1, ranki, rand);
        corredores corredor3 = new corredores("Luis", 3, 2, ranki, rand);
        corredores corredor4 = new corredores("Jose", 4, 3, ranki, rand);
        corredores corredor5 = new corredores("Maria", 5, 0, ranki, rand);
        corredores corredor6 = new corredores("Ana", 6, 1, ranki, rand);
        corredores corredor7 = new corredores("Luisa", 7, 2, ranki, rand);
        corredores corredor8 = new corredores("Josefa", 8, 3, ranki, rand);
        corredores corredor9 = new corredores("Carlos", 9, 0, ranki, rand);
        corredores corredor10 = new corredores("Raul", 10, 1, ranki, rand);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();
        corredor10.start();

        corredor1.join();
        corredor2.join();
        corredor3.join();
        corredor4.join();
        corredor5.join();
        corredor6.join();
        corredor7.join();
        corredor8.join();
        corredor9.join();
        corredor10.join();

        System.out.println("\nTodos los corredores han terminado");
		System.out.println("\nEl resultado de la carrera es: \n");

        for (int i = 0; i < ranki.rankiList.size(); i++) {
            System.out.println(i + 1 + "-- " + ranki.rankiList.get(i));
        }

        System.out.println("\nLos corredores fracturados son: \n");

        for (int i = 0; i < ranki.rankiLesionados.size(); i++) {
            System.out.println(i + 1 + "-- " + ranki.rankiLesionados.get(i));
        }
    }
}
