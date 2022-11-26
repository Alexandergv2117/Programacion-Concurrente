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
      if (this.enReposo) {
        this.pisoDestino = (int) (Math.random() * this.hotel.totalPisos);
        System.out.println("Elevador en reposo, destino: " + this.pisoDestino);
        llamarElevador(pisoDestino);
      }

      if (this.pisoActual == hotel.totalPisos) {
        this.pisoDestino = 0;
      }

      if (this.pisoActual < this.pisoDestino) {
        subirElevador();
        delay(500);
      }

      if (this.pisoActual > this.pisoDestino) {
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
    if (hotel.totalPisos <= pisoActual) {
      System.out.println("El elevador llego al ultimo piso del hotel");
      subiendo = false;
      bajando = true;
      System.out.println("El elevador esta bajando");
      return;
    }

    this.pisoActual++;
    System.out.println("\nEl elevador esta en el piso: " + this.pisoActual);
    System.out.println("El elevador esta subiendo");
  }

  public synchronized void bajarElevador() {
    if (pisoActual <= 0) {
      System.out.println("El elevador llego al primer piso del hotel: " + this.pisoActual);
      bajando = false;
      subiendo = false;
      enReposo = true;
      return;
    }

    this.pisoActual--;
    System.out.println("\nEl elevador esta en el piso: " + this.pisoActual);
    System.out.println("El elevador esta bajando");
  }

  public synchronized void abrirPuertaDelElevador() {
    this.puertaAbierta = true;
    System.out.println("Puerta abierta");
  }

  public synchronized void cerrarPuertaDelElevador() {
    this.puertaAbierta = false;
    System.out.println("Puerta cerrada");
  }

  public synchronized void entrarPersona() {
    if (this.capacidadActual <= this.capacidadMaxima) {
      this.capacidadActual++;
      System.out.println("Persona entrando al elevador");
    } else {
      System.out.println("No hay espacio en el elevador");
      return;
    }
  }

  public synchronized void salirPersona() {
    if (this.capacidadActual > 0) {
      this.capacidadActual--;
      System.out.println("Persona saliendo del elevador");
    } else {
      System.out.println("No hay personas en el elevador");
      return;
    }
  }

  public synchronized void llamarElevador(int pisoDestino) {
    this.pisoDestino = pisoDestino;
    if (this.pisoDestino > this.pisoActual) {
      subiendo = true;
      bajando = false;
      enReposo = false;
      this.pisoDestino = hotel.totalPisos;

      System.out.println("Llamando al elevador para subir al piso: " + pisoDestino);
    }

    if (this.pisoDestino < this.pisoActual) {
      subiendo = false;
      bajando = true;
      enReposo = false;
      this.pisoDestino = 0;

      System.out.println("Llamando al elevador para bajar al piso: " + pisoDestino);
    }
  }
}
