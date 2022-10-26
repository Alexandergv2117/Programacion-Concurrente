import java.util.concurrent.Semaphore;

public class Providers extends Thread {
  String name;
  String[] products;
  double[] assortmentCapacity;
  int productsLength;

  Store store;
  season season;
  Semaphore semaphore;

  public Providers(String name, String[] products, double[] assortmentCapacity, Store store, season season,
      Semaphore semaphore) {
    this.name = name;
    this.products = products;
    this.assortmentCapacity = assortmentCapacity;
    this.productsLength = products.length;
    this.store = store;
    this.season = season;
    this.semaphore = semaphore;
  }

  public void run() {
    while (true) {
      try {
        semaphore.acquire();
        if (store.isFullEntryProviders && !store.isFullContainers) {
          System.out.println("\nEl proveedor " + name + " ha entrado a la tienda");
          for (int i = 0; i < productsLength; i++) {
            store.addProductToContainer(products[i], (assortmentCapacity[i] * season.getCurrentMultiplier()), name);
          }
          System.out.println("\nEl proveedor " + name + " ha salido de la tienda");
          System.out.println("-------------------------------------------------------------");
          store.isFullEntryProviders = true;
        }
        semaphore.release();
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
