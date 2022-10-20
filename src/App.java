import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();
        ReentrantLock lock = new ReentrantLock();

        Proveedor proveedor1 = new Proveedor("Manuelin", new String[] { "Frijol", "Arroz" }, new int[] { 4, 6 }, tienda, lock);
        Proveedor proveedor2 = new Proveedor("Diler", new String[] { "Maiz", "Arroz" }, new int[] { 4, 6 }, tienda, lock);
        Proveedor proveedor3 = new Proveedor("Karla", new String[] { "Frijol", "Maiz" }, new int[] { 4, 6 }, tienda, lock);
        Proveedor proveedor4 = new Proveedor("Moi", new String[] { "Frijol", "Arroz" }, new int[] { 4, 6 }, tienda, lock);

        Compradores comprador1 = new Compradores("Alex", new String[] {"Frijol"} , new int[] { 1 }, tienda);
        Compradores comprador2 = new Compradores("Pikabu", new String[] {"Frijol", "Arroz", "Maiz"}, new int[] {4, 3, 6}, tienda);
        Compradores comprador3 = new Compradores("Juanito", new String[] {"Frijol"}, new int[] {7}, tienda);
        Compradores comprador4 = new Compradores("Pepe", new String[] {"Frijol", "Arroz"}, new int[] {4, 3, 6}, tienda);
        Compradores comprador5 = new Compradores("Tommys", new String[] {"Frijol", "Arroz"}, new int[] {7}, tienda);
        Compradores comprador6 = new Compradores("Ojito", new String[] {"Frijol", "Arroz", "Maiz"}, new int[] {1, 3, 6}, tienda);

        proveedor1.start();
        proveedor2.start();
        proveedor3.start();
        proveedor4.start();

        comprador1.start();
        comprador2.start();
        comprador3.start();
        comprador4.start();
        comprador5.start();
        comprador6.start();
    }
}
