public class Elevador extends Thread {
  int capacidadMaxima;
  int capacidadActual = 0;
  int pisoActual = 0;
  int pisoDestino;

  boolean puertaAbierta = false;
  boolean enReposo = true;
  boolean sentidoElevador = false; // false = sube, true = baja

  Hotel hotel;

  public Elevador(int capacidadMaxima, Hotel hotel) {
    this.capacidadMaxima = capacidadMaxima;
    this.hotel = hotel;
  }

  public void run() {
    while (true) {
      if (getPisoActual() == hotel.getTotalPisos()) setSentidoElevador(true);

      if (getPisoActual() == 0 && getSentidoElevador()) setEnReposo(true);

      if (!isEnReposo()) {
        if (getSentidoElevador()) {
          bajarElevador();
        } else {
          subirElevador();
        }
        delay(500);
        cerrarPuertaDelElevador();
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
    this.pisoActual++;
    System.out.println("\nEl elevador esta subiendo");
    System.out.println("El elevador esta en el piso: " + getPisoActual());
    System.out.println("Capacidad actual: " + getCapacidadActual());
    abrirPuertaDelElevador();

    if (hotel.getTotalPisos() == getPisoActual()) {
      System.out.println("\nEl elevador llego al ultimo piso del hotel");
    }
  }

  public synchronized void bajarElevador() {
    this.pisoActual--;
    System.out.println("\nEl elevador esta bajando");
    System.out.println("El elevador esta en el piso: " + getPisoActual());
    System.out.println("Capacidad actual: " + getCapacidadActual());
    abrirPuertaDelElevador();

    if (pisoActual == 0) {
      System.out.println("\nEl elevador llego al primer piso del hotel: " + getPisoActual());
    }
  }

  public synchronized void abrirPuertaDelElevador() {
    setPuertaAbierta(true);
    System.out.println("\n---------- PUERTA ABRIERTA ---------\n");
  }

  public synchronized void cerrarPuertaDelElevador() {
    setPuertaAbierta(false);
    System.out.println("\n---------- PUERTA CERRADA ----------\n");
    System.out.println("\n############################################################\n");
  }

  public synchronized void subirPersona() {
    if (getCapacidadActual() <= getCapacidadMaxima()) {
      this.capacidadActual++;
      System.out.println("\nPersona entrando al elevador");
    }
  }

  public synchronized void bajarPersona() {
    if (getCapacidadActual() > 0) {
      this.capacidadActual--;
      System.out.println("\nPersona saliendo del elevador");
    }
  }

  public synchronized void llamarElevador(int pisoDestino) {
    if (!isEnReposo()) return;

    setPisoDestino(pisoDestino);
    if (getPisoDestino() > getPisoActual()) {
      setSentidoElevador(false);
      setEnReposo(false);

      System.out.println("Llamando al elevador para subir al piso: " + pisoDestino);
      return;
    }

    if (getPisoDestino() < getPisoActual()) {
      setSentidoElevador(true);
      setEnReposo(false);

      System.out.println("Llamando al elevador para bajar al piso: " + pisoDestino);
      return;
    }
  }

  public synchronized boolean validarPersonasEnDestino(Persona[] personas) {
    for (int i = 0; i < personas.length; i++ ) {
      if (!personas[i].llegoAlDestino) return false;
    }

    return true;
  }

  public synchronized void llamarElevadorDesdePiso(Persona[] personas) {
    if (!isEnReposo()) return;

    for (int i = 0; i < personas.length; i++) {
      if (!personas[i].llegoAlDestino) {
        llamarElevador(personas[i].pisoOrigen);
        return;
      }
    }
  }

  public synchronized void subirBajarPersonas(Persona[] personas)  {
    for (int i = 0; i < personas.length; i++) {
      if (personas[i].sentido == sentidoElevador && getPisoActual() == personas[i].pisoOrigen && !personas[i].llegoAlDestino && !personas[i].enElAscensor && capacidadActual < capacidadMaxima) {
        personas[i].enElAscensor = true;
        subirPersona();
        System.out.println("\n" + personas[i].nombre + " sube al elevador en el piso " + personas[i].pisoOrigen + " y va al piso " + personas[i].pisoDestino + " en el sentido " + (personas[i].sentido ? "bajando" : "subiendo"));
      }

      if (getPisoActual() == 15 && getPisoActual() == personas[i].pisoOrigen && !personas[i].llegoAlDestino && !personas[i].enElAscensor && capacidadActual < capacidadMaxima) {
        personas[i].enElAscensor = true;
        subirPersona();
        System.out.println("\n" + personas[i].nombre + " sube al elevador en el piso " + personas[i].pisoOrigen + " y va al piso " + personas[i].pisoDestino + " en el sentido " + (personas[i].sentido ? "bajando" : "subiendo"));
      }

      if (getPisoActual() == personas[i].pisoDestino && !personas[i].llegoAlDestino && personas[i].enElAscensor) {
        bajarPersona();
        System.out.println("\n" + personas[i].nombre + " baja del elevador en el piso " + personas[i].pisoDestino);
        personas[i].llegoAlDestino = true;
      }
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

  public boolean isEnReposo() {
    return this.enReposo;
  }

  public void setPuertaAbierta(boolean puertaAbierta) {
    this.puertaAbierta = puertaAbierta;
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

  public void setSentidoElevador(boolean sentido) {
    this.sentidoElevador = sentido;
  }

  public boolean getSentidoElevador() {
    return this.sentidoElevador;
  }
}
