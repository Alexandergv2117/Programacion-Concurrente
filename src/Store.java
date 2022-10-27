public class Store {
  Container[] containers = new Container[3];
  String[] products = {"Frijol", "Arroz", "Maiz"};
  double capacities = 10.0;

  int buyers = 0;

  boolean isFullContainers = false;
  boolean isFullEntryProviders = true;

  season Season;

  public Store(season Season) {
    this.Season = Season;
    for (int i = 0; i < containers.length; i++) {
      containers[i] = new Container(products[i], capacities);
    }
  }

  public void addProductToContainer(String product, double quantity, String provider) {
    for (int i = 0; i < containers.length; i++) {
      if ((containers[i].getProduct().equals(product)) && (!containers[i].getIsFull())) {
        System.out.println("\nEl proveedor " + provider + " esta ingresando " + product + " al contenedor, cantidad: "
            + quantity);
        quantity = containers[i].addProduct(quantity);
      } else if (containers[i].getProduct().equals(product) && containers[i].getIsFull()) {
        System.out.println("El contenedor de " + product + " está lleno");
      }
    }
    setIsFullContainers(ContainersAreFull());
  }

  public boolean buyProducts(String name, String[] products, double[] quantity) {
    int productsLength = products.length;
    int containersLength = containers.length;
    boolean fullShoppingList = true;

    for (int i = 0; i < productsLength; i++) {
      for (int j = 0; j < containersLength; j++) {
        if (containers[j].getProduct().equals(products[i])) {
          if (!containers[j].retireProduct(quantity[i], name)){
            fullShoppingList = false;
            containers[j].setIsFull(false);
            setIsFullContainers(false);
          }
        }
      }
    }

    if (!fullShoppingList){
      setIsFullContainers(false);
      System.out.println("No se pudo completar la compra de " + name);
      return false;
    }
    buyers++;

    System.out.println("Se ha completado la compra de " + name + " con éxito" + "\n" + "Cantidad de compradores: " + buyers);

    return fullShoppingList;
  }

  private boolean ContainersAreFull() {
    for (int i = 0; i < containers.length; i++) {
      if (!containers[i].getIsFull()) {
        return false;
      }
    }
    return true;
  }

  public void setIsFullContainers(boolean isFullContainers) {
    this.isFullContainers = isFullContainers;
  }

  public boolean getIsFullContainers() {
    return isFullContainers;
  }

  public void setIsFullEntryProviders(boolean isFullEntryProviders) {
    this.isFullEntryProviders = isFullEntryProviders;
  }

  public boolean getIsFullEntryProviders() {
    return isFullEntryProviders;
  }

  public boolean isFullContainers(String[] Products){
    boolean puedeEntrar = true;
    for (int i = 0; i < containers.length; i++) {
      for (int j = 0; j < Products.length; j++) {
        if (containers[i].getProduct().equals(Products[j]) && !containers[i].getIsFull()) {
          puedeEntrar = false;
        }
      }
    }
    return puedeEntrar;
  }

  public int getBuyers() {
    return buyers;
  }

  public void setBuyers(int resetBuyers) {
    this.buyers = resetBuyers;
  }
}
