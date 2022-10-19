public class App {
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();

        Proveedor proveedor1 = new Proveedor("Frijol", 1, tienda);
        Proveedor proveedor2 = new Proveedor("Arroz", 5, tienda);
        Proveedor proveedor3 = new Proveedor("Maiz", 10, tienda);

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

        comprador1.start();
        comprador2.start();
        comprador3.start();
        comprador4.start();
        comprador5.start();
        comprador6.start();
    }
}
