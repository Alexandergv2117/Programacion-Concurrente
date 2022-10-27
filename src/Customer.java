import java.util.concurrent.Semaphore;

public class Customer extends Thread {
  String name;
  String[] products;
  double[] quantityToBuy;
  boolean isFullShoppingList = false;
  int productsLength;

  Store store;
  Semaphore semaphore;

  public Customer(String name, String[] products, double[] quantityToBuy, Store store, Semaphore semaphore) {
    this.name = name;
    this.products = products;
    this.quantityToBuy = quantityToBuy;
    this.productsLength = products.length;
    this.store = store;
    this.semaphore = semaphore;
  }

  public void run() {
    while (!isFullShoppingList) {
      try {
      semaphore.acquire();
      if (store.isFullContainers) {
        System.out.println("\n#########################  CLIENTE  #########################");
        System.out.println("\nEl cliente " + name + " ha entrado a la tienda");
        isFullShoppingList = store.buyProducts(name, products, quantityToBuy);
        System.out.println("\nEl cliente " + name + " ha salido de la tienda");
      }
      semaphore.release();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
