import java.util.concurrent.Semaphore;

public class Customer extends Thread{
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
        if (store.getIsFullContainers()) {
          semaphore.acquire();
          System.out.println("####################################################################");
          System.out.println("\nEl cliente " + name + " ha entrado a la tienda");
          isFullShoppingList = store.buyProducts(name, products, quantityToBuy);
          System.out.println("\nEl cliente " + name + " ha salido de la tienda");
          semaphore.release();
        }
        sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
