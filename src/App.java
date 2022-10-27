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

        Customer customer1 = new Customer("Carlos", new String[] { "Frijol", "Arroz", "Maiz" }, new double[] { 3, 2, 5 }, store, season,  semaphore);
        Customer customer2 = new Customer("Luis", new String[] { "Frijol" }, new double[] { 3 }, store, season,  semaphore);
        Customer customer3 = new Customer("Ana", new String[] { "Arroz" }, new double[] { 2 }, store, season,  semaphore);
        Customer customer4 = new Customer("Peekaboo", new String[] { "Maiz" },new double[] { 6 }, store, season,  semaphore);
        Customer customer5 = new Customer("Ojito", new String[] { "Frijol", "Arroz", "Maiz" },new double[] { 2, 4, 3 }, store, season,  semaphore);
        Customer customer6 = new Customer("Pedro", new String[] { "Maiz", "Arroz" }, new double[] { 3, 5 }, store, season,  semaphore);
        Customer customer7 = new Customer("Juan", new String[] { "Maiz", "Arroz" }, new double[] { 5, 6 }, store, season,  semaphore);
        Customer customer8 = new Customer("Manuel", new String[] { "Frijol", "Arroz" }, new double[] { 2, 1 }, store, season,  semaphore);
        Customer customer9 = new Customer("Jose", new String[] { "Frijol", "Arroz" }, new double[] { 3, 2 }, store, season,  semaphore);
        Customer customer10 = new Customer("Charlitos", new String[] { "Frijol", "Arroz", "Maiz" }, new double[] { 3, 2, 5 }, store, season,  semaphore);
        Customer customer11 = new Customer("Xool", new String[] { "Frijol" }, new double[] { 3 }, store, season,  semaphore);
        Customer customer12 = new Customer("Anita", new String[] { "Arroz" }, new double[] { 2 }, store, season,  semaphore);
        Customer customer13 = new Customer("Sofi", new String[] { "Maiz" },new double[] { 6 }, store, season,  semaphore);
        Customer customer14 = new Customer("Juanitoo", new String[] { "Frijol", "Arroz", "Maiz" },new double[] { 2, 4, 3 }, store, season,  semaphore);
        Customer customer15 = new Customer("Pedro Parker", new String[] { "Maiz", "Arroz" }, new double[] { 3, 5 }, store, season,  semaphore);
        Customer customer16 = new Customer("Jose Luis", new String[] { "Maiz", "Arroz" }, new double[] { 5, 6 }, store, season,  semaphore);
        Customer customer17 = new Customer("Maria", new String[] { "Frijol", "Arroz" }, new double[] { 2, 1 }, store, season,  semaphore);
        Customer customer18 = new Customer("Benito", new String[] { "Frijol", "Arroz" }, new double[] { 3, 2 }, store, season,  semaphore);
        Customer customer19 = new Customer("Alex", new String[] { "Frijol", "Arroz", "Maiz" }, new double[] { 3, 2, 5 }, store, season,  semaphore);
        Customer customer20 = new Customer("Gohan", new String[] { "Frijol" }, new double[] { 3 }, store, season,  semaphore);
        
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
        customer8.start();
        customer9.start();
        customer10.start();
        customer11.start();
        customer12.start();
        customer13.start();
        customer14.start();
        customer15.start();
        customer16.start();
        customer17.start();
        customer18.start();
        customer19.start();
        customer20.start();
    }
}
