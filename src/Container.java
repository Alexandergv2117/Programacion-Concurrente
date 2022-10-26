public class Container {
  String storedProduct;
  double maximunContainerCapacity;
  double currentCapacity = 0;
  double spare = 0;
  boolean isFull = false;

  public Container(String product, double capacities) {
    this.storedProduct = product;
    this.maximunContainerCapacity = capacities;
  }

  public boolean retireProduct(double quantity, String name) {
    if (quantity > currentCapacity) {
      System.out.println("No hay suficiente producto en el contenedor para " + name);
      return false;
    } 
    if (quantity >= currentCapacity) {
      currentCapacity -= quantity;
      System.out.println(name + " ha retirado " + quantity + " de " + storedProduct);
      if (currentCapacity == 0) {
        System.out.println("El contenedor de " + storedProduct + " está vacío");
        isFull = false;
      }
      return true;
    }
    return false;
  }

  public double addProduct(double quatity) {
    if (getIsFull()) {
      System.out.println("El contenedor de " + getProduct() + " esta lleno");
      System.out.println("El producto " + getProduct() + " se ha regresado");
      return quatity;
    }

    if (currentCapacity + quatity > maximunContainerCapacity && !getIsFull()) {
      spare = (currentCapacity + quatity) - maximunContainerCapacity;
      currentCapacity = maximunContainerCapacity;
      System.out.println("Se ha ingresado al contenedor de " + getProduct() + " " + (quatity - spare) + " unidades");
      System.out.println("Se ha llenado el contenedor de " + getProduct() + " y ha sobrado " + spare + " unidades");
      setIsFull(true);
      return spare;
    }

    if (currentCapacity + quatity <= maximunContainerCapacity) {
      currentCapacity += quatity;
      System.out.println("Se ha ingresado al contenedor de " + getProduct() + " " + quatity + " unidades");
      if (currentCapacity == maximunContainerCapacity) {
        System.out.println("Se ha llenado el contenedor de " + getProduct());
        setIsFull(true);
      }
      return 0;
    }
    
    return 0;
  }

  public String getProduct() {
    return this.storedProduct;
  }

  public double getMaximunContainerCapacity() {
    return this.maximunContainerCapacity;
  }

  public void setCurrentCapacity(Float capacity) {
    this.currentCapacity = capacity;
  }

  public double getCurrentCapacity() {
    return this.currentCapacity;
  }

  public void setSpare(Float spare) {
    this.spare = spare;
  }

  public double getSpare() {
    return this.spare;
  }

  public void setIsFull(boolean isFull) {
    this.isFull = isFull;
  }

  public boolean getIsFull() {
    return this.isFull;
  }
}
