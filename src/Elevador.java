public class Elevador extends Thread{
  int capacidadMaxima;
  int capacidadActual;
  int pisoActual;
  int pisoDestino;

  boolean puertaAbierta;
  boolean subiendo;
  boolean bajando;
  boolean enReposo;

  public Elevador(int capacidadMaxima) {
    this.capacidadMaxima = capacidadMaxima;
    this.capacidadActual = 0;
    this.pisoActual = 0;
    this.puertaAbierta = false;
    this.subiendo = false;
    this.bajando = false;
    this.enReposo = true;
  }

  public void run() {
    while (true) {
      if (this.pisoDestino > this.pisoActual) {
        subirElevador(pisoDestino);
        abrirPuertaDelElevador();
        delay(1000);
        cerrarPuertaDelElevador();
      }
      if (this.pisoDestino < this.pisoActual) {
        bajarElevador(pisoDestino);
        abrirPuertaDelElevador();
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

  public synchronized void subirElevador( int pisoDestino) {
    if (pisoDestino > this.pisoActual) {
      System.out.println("\nSubiendo al piso: " + (this.pisoActual + 1));
      this.subiendo = true;
      this.bajando = false;
      this.enReposo = false;
      this.pisoActual++;
      System.out.println("El elevador esta en el piso: " + this.pisoActual);
    }
  }

  public synchronized void bajarElevador(int pisoDestino) {
    if (this.pisoActual > pisoDestino) {
      System.out.println("\nBajando al piso: " + (this.pisoActual - 1));
      this.subiendo = false;
      this.bajando = true;
      this.enReposo = false;
      this.pisoActual--;
      System.out.println("El elevador esta en el piso: " + this.pisoActual);
    }
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
  }
}
