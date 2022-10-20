import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();
        ReentrantLock lock = new ReentrantLock();

        Proveedor proveedor1 = new Proveedor("Carlos",new String[] { "Frijol", "Arroz" }, new int[] { 4, 6 }, tienda, lock);
        Proveedor proveedor2 = new Proveedor("Hector", new String[] { "Frijol", "Maiz" }, new int[] { 4, 3 }, tienda, lock);
        Proveedor proveedor3 = new Proveedor("Beto", new String[] { "Maiz", "Arroz" }, new int[] { 6, 5 }, tienda, lock);
        Proveedor proveedor4 = new Proveedor("Joe", new String[] { "Frijol", "Arroz" }, new int[] { 2, 1 }, tienda, lock);

        String[] productosAlex = {"Frijol"};
        int[] cantidadesAlex = {1};

        String[] productosPikabu = {"Frijol", "Arroz", "Maiz"};
        int[] cantidadesPikabu = {4, 3, 6};

        String[] productosJuanito = {"Frijol"};
        int[] cantidadesJuanito = {7};
        
        String[] productosPepe = {"Frijol", "Arroz"};
        int[] cantidadesPepe = {1, 3};

        String[] productosTommys = {"Frijol", "Arroz"};
        int[] cantidadesTommys = {1, 2};

        String[] productosOjito = {"Frijol", "Arroz", "Maiz"};
        int[] cantidadesOjito = {1, 3, 6};

        
        Compradores comprador1 = new Compradores("Alex", productosAlex, cantidadesAlex, tienda);
        Compradores comprador2 = new Compradores("Pikabu", productosPikabu, cantidadesPikabu, tienda);
        Compradores comprador3 = new Compradores("Juanito", productosJuanito, cantidadesJuanito, tienda);
        Compradores comprador4 = new Compradores("Pepe", productosPepe, cantidadesPepe, tienda);
        Compradores comprador5 = new Compradores("Tommys", productosTommys, cantidadesTommys, tienda);
        Compradores comprador6 = new Compradores("Ojito", productosOjito, cantidadesOjito, tienda);

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
