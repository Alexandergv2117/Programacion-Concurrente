import java.util.concurrent.Semaphore;

public class Customer extends Thread {
  String name;
  String[] products;
  double[] quantityToBuy;
  boolean isFullShoppingList = false;
  int productsLength;

  Store store;
  Semaphore semaphore;
  season season;

  public Customer(String name, String[] products, double[] quantityToBuy, Store store, season season,
      Semaphore semaphore) {
    this.name = name;
    this.products = products;
    this.quantityToBuy = quantityToBuy;
    this.productsLength = products.length;
    this.store = store;
    this.semaphore = semaphore;
    this.season = season;
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
        if (store.getBuyers() == 4) {
          season.setChangeSeason();
          store.setBuyers(0);
        }
        semaphore.release();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
