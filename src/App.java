public class App {
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();

        Proveedor proveedor1 = new Proveedor("Frijol", 5, tienda);
        Proveedor proveedor2 = new Proveedor("Arroz", 5, tienda);
        Proveedor proveedor3 = new Proveedor("Maiz", 5, tienda);

        String[] productos1 = {"Frijol", "Arroz", "Maiz"};
        int[] cantidades1 = {5, 5, 5};
        Compradores comprador1 = new Compradores("Comprador 1", productos1, cantidades1, tienda);
        Compradores comprador2 = new Compradores("Comprador 2", productos1, cantidades1, tienda);
        Compradores comprador3 = new Compradores("Comprador 3", productos1, cantidades1, tienda);
        Compradores comprador4 = new Compradores("Comprador 4", productos1, cantidades1, tienda);
        Compradores comprador5 = new Compradores("Comprador 5", productos1, cantidades1, tienda);
        Compradores comprador6 = new Compradores("Comprador 6", productos1, cantidades1, tienda);

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
