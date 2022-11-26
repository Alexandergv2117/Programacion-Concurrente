public class Elevador extends Thread {
  int capacidadMaxima;
  int capacidadActual;
  int pisoActual;
  int pisoDestino;

  boolean puertaAbierta;
  boolean subiendo;
  boolean bajando;
  boolean enReposo;

  Hotel hotel;

  public Elevador(int capacidadMaxima, Hotel hotel) {
    this.capacidadMaxima = capacidadMaxima;
    this.capacidadActual = 0;
    this.pisoActual = 0;
    this.puertaAbierta = false;
    this.subiendo = false;
    this.bajando = false;
    this.enReposo = true;
    this.hotel = hotel;
  }

  public void run() {
    while (true) {
      if (isEnReposo()) {
        setPisoDestino((int) (Math.random() * hotel.getTotalPisos()));
        System.out.println("Elevador en reposo, destino: " + getPisoDestino());
        llamarElevador(pisoDestino);
      }

      if (getPisoActual() == hotel.getTotalPisos()) {
        setPisoDestino(0);
      }

      if (getPisoActual() < getPisoDestino()) {
        subirElevador();
        delay(500);
      }

      if (getPisoActual() > getPisoDestino()) {
        bajarElevador();
        delay(500);
      }
    }
  }

  private void delay(int i) {
    try {
      sleep(i);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void subirElevador() {
    if (hotel.getTotalPisos() <= getPisoActual()) {
      System.out.println("El elevador llego al ultimo piso del hotel");
      setSubiendo(false);
      setBajando(true);
      System.out.println("El elevador esta bajando");
      return;
    }

    this.pisoActual++;
    System.out.println("\nEl elevador esta en el piso: " + getPisoActual());
    System.out.println("El elevador esta subiendo");
  }

  public synchronized void bajarElevador() {
    if (pisoActual <= 0) {
      System.out.println("El elevador llego al primer piso del hotel: " + getPisoActual());
      setBajando(false);
      setSubiendo(false);
      setEnReposo(true);
      return;
    }

    this.pisoActual--;
    System.out.println("\nEl elevador esta en el piso: " + getPisoActual());
    System.out.println("El elevador esta bajando");
  }

  public synchronized void abrirPuertaDelElevador() {
    setPuertaAbierta(true);
    System.out.println("Puerta abierta");
  }

  public synchronized void cerrarPuertaDelElevador() {
    setPuertaAbierta(false);
    System.out.println("Puerta cerrada");
  }

  public synchronized void entrarPersona() {
    if (getCapacidadActual() <= getCapacidadMaxima()) {
      this.capacidadActual++;
      System.out.println("Persona entrando al elevador");
    } else {
      System.out.println("No hay espacio en el elevador");
      return;
    }
  }

  public synchronized void salirPersona() {
    if (getCapacidadActual() > 0) {
      this.capacidadActual--;
      System.out.println("Persona saliendo del elevador");
    } else {
      System.out.println("No hay personas en el elevador");
      return;
    }
  }

  public synchronized void llamarElevador(int pisoDestino) {
    setPisoDestino(pisoDestino);
    if (getPisoDestino() > getPisoActual()) {
      setSubiendo(true);
      setBajando(false);
      setEnReposo(false);
      setPisoDestino(hotel.getTotalPisos());

      System.out.println("Llamando al elevador para subir al piso: " + pisoDestino);
    }

    if (getPisoDestino() < getPisoActual()) {
      setBajando(true);
      setSubiendo(false);
      setEnReposo(false);
      setPisoDestino(0);

      System.out.println("Llamando al elevador para bajar al piso: " + pisoDestino);
    }
  }

  public void setPisoDestino(int pisoDestino) {
    this.pisoDestino = pisoDestino;
  }

  public int getPisoDestino() {
    return this.pisoDestino;
  }

  public int getPisoActual() {
    return this.pisoActual;
  }

  public int getCapacidadActual() {
    return this.capacidadActual;
  }

  public int getCapacidadMaxima() {
    return this.capacidadMaxima;
  }

  public boolean isPuertaAbierta() {
    return this.puertaAbierta;
  }

  public boolean isSubiendo() {
    return this.subiendo;
  }

  public boolean isBajando() {
    return this.bajando;
  }

  public boolean isEnReposo() {
    return this.enReposo;
  }

  public void setPuertaAbierta(boolean puertaAbierta) {
    this.puertaAbierta = puertaAbierta;
  }

  public void setSubiendo(boolean subiendo) {
    this.subiendo = subiendo;
  }

  public void setBajando(boolean bajando) {
    this.bajando = bajando;
  }

  public void setEnReposo(boolean enReposo) {
    this.enReposo = enReposo;
  }

  public void setCapacidadActual(int capacidadActual) {
    this.capacidadActual = capacidadActual;
  }

  public void setCapacidadMaxima(int capacidadMaxima) {
    this.capacidadMaxima = capacidadMaxima;
  }

  public void setPisoActual(int pisoActual) {
    this.pisoActual = pisoActual;
  }
}
