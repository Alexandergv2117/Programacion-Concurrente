public class Elevador extends Thread {
  int capacidadMaxima;
  int capacidadActual;
  int pisoActual;
  int pisoDestino;

  boolean puertaAbierta;
  boolean subiendo;
  boolean bajando;
  boolean enReposo;
  boolean sentidoElevador = false; // false = sube, true = baja

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
      if (getPisoActual() == hotel.getTotalPisos()) {
        setBajando(true);
        setSubiendo(false);
        setSentido(true);
      }

      if (getPisoActual() == 0 && isBajando()) {
        setBajando(false);
        setEnReposo(true);
        setSentido(false);
      }

      if (isSubiendo()) {
        subirElevador();
        delay(1000);
        cerrarPuertaDelElevador();
      }

      if (isBajando()) {
        bajarElevador();
        delay(1000);
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
      System.out.println("Persona entrando al elevador");
    } else {
      System.out.println("No hay espacio en el elevador");
    }
  }

  public synchronized void bajarPersona() {
    if (getCapacidadActual() > 0) {
      this.capacidadActual--;
      System.out.println("Persona saliendo del elevador");
    } else {
      System.out.println("No hay personas en el elevador");
    }
  }

  public synchronized void llamarElevador(int pisoDestino) {
    if (!isEnReposo()) return;

    if (pisoDestino == getPisoActual()) {
      System.out.println("El elevador ya esta en el piso destino");
      return;
    }

    setPisoDestino(pisoDestino);
    if (getPisoDestino() > getPisoActual()) {
      setSubiendo(true);
      setBajando(false);
      setEnReposo(false);

      System.out.println("Llamando al elevador para subir al piso: " + pisoDestino);
      return;
    }

    if (getPisoDestino() < getPisoActual()) {
      setBajando(true);
      setSubiendo(false);
      setEnReposo(false);

      System.out.println("Llamando al elevador para bajar al piso: " + pisoDestino);
      return;
    }
  }

  public synchronized boolean validarPersonasEnDestino(boolean[] llegoAlDestino) {
    boolean terminoViaje = false;
    for (int i = 0; i < llegoAlDestino.length; i++ ) {
      if (llegoAlDestino[i]) {
        terminoViaje = true;
      } else {
        terminoViaje = false;
        break;
      }
    }

    return terminoViaje;
  }

  public synchronized void llamarElevadorDesdePiso(boolean[] llegoAlDestino, int[] pisoOrigen) {
    for (int i = 0; i < llegoAlDestino.length; i++) {
      if (!llegoAlDestino[i] && isEnReposo()) {
        llamarElevador(pisoOrigen[i]);
        return;
      }
    }
  }

  public synchronized void subirBajarPersonas(boolean[] sentido, boolean[] enElAscensor, int[] pisoOrigen, int[] pisoDestino , boolean[] llegoAlDestino, String[] nombres)  {
    for (int i = 0; i < nombres.length; i++) {
      if (sentido[i] == sentidoElevador && getPisoActual() == pisoOrigen[i] && !llegoAlDestino[i] && !enElAscensor[i] && capacidadActual < capacidadMaxima) {
        enElAscensor[i] = true;
        subirPersona();
        System.out.println("\n" + nombres[i] + " sube al elevador en el piso " + pisoOrigen[i] + " y va al piso " + pisoDestino[i] + " en el sentido " + (sentido[i] ? "bajando" : "subiendo"));
      }

      if (getPisoActual() == 15 && getPisoActual() == pisoOrigen[i] && !llegoAlDestino[i] && !enElAscensor[i] && capacidadActual < capacidadMaxima) {
        enElAscensor[i] = true;
        subirPersona();
        System.out.println("\n" + nombres[i] + " sube al elevador en el piso " + pisoOrigen[i] + " y va al piso " + pisoDestino[i] + " en el sentido " + (sentido[i] ? "bajando" : "subiendo"));
      }

      if (getPisoActual() == pisoDestino[i] && !llegoAlDestino[i] && enElAscensor[i]) {
        System.out.println("\n" + nombres[i] + " baja del elevador en el piso " + pisoDestino[i]);
        bajarPersona();
        llegoAlDestino[i] = true;
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

  public void setSentido(boolean sentido) {
    this.sentidoElevador = sentido;
  }

  public boolean getSentido() {
    return this.sentidoElevador;
  }
}
