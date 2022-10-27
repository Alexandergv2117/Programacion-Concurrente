import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(1);
        season season = new season(0);
        Store store = new Store(season);

        Providers provider1 = new Providers("Juan", new String[] { "Frijol", "Arroz" }, new double[] { 4, 6 }, store, season, semaphore);
        Providers provider2 = new Providers("Pedro", new String[] { "Frijol", "Maiz" }, new double[] { 4, 3 }, store, season, semaphore);
        Providers provider3 = new Providers("Maria", new String[] { "Maiz", "Arroz" }, new double[] { 6, 5 }, store, season, semaphore);
        Providers provider4 = new Providers("Jose", new String[] { "Frijol", "Arroz" },new double[] { 2, 1 }, store, season, semaphore);

        Customer customer1 = new Customer("Carlos", new String[] { "Frijol", "Arroz", "Maiz" }, new double[] { 3, 2, 5 }, store, semaphore);
        Customer customer2 = new Customer("Luis", new String[] { "Frijol" }, new double[] { 3 }, store, semaphore);
        Customer customer3 = new Customer("Ana", new String[] { "Arroz" }, new double[] { 2 }, store, semaphore);
        Customer customer4 = new Customer("Peekaboo", new String[] { "Maiz" },new double[] { 6 }, store, semaphore);
        Customer customer5 = new Customer("Ojito", new String[] { "Frijol", "Arroz", "Maiz" },new double[] { 2, 4, 3 }, store, semaphore);
        Customer customer6 = new Customer("Pedro", new String[] { "Maiz", "Arroz" }, new double[] { 3, 5 }, store, semaphore);
        Customer customer7 = new Customer("Juan", new String[] { "Maiz", "Arroz" }, new double[] { 5, 6 }, store, semaphore);
        
        provider1.start();
        provider2.start();
        provider3.start();
        provider4.start();

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();
        customer7.start();
    }
}
