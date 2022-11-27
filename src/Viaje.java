public class Viaje extends Thread {
  Hotel hotel;
  Elevador elevador;
  Persona[] personas;

  int totalPersonas;
  boolean terminoViaje = false;

  public Viaje(Hotel hotel, String nombreViaje, Elevador elevador) {
    this.hotel = hotel;
    this.elevador = elevador;
    this.totalPersonas = (int) (Math.random() * hotel.getTotalPisos()) + 1;
    this.personas = new Persona[totalPersonas];

    for (int i = 0; i < totalPersonas; i++) {
      personas[i] = new Persona(nombreViaje + " - Persona " + i, hotel.getTotalPisos());
    }
  }

  public void run() {
    while (!terminoViaje) {
      
      elevador.subirBajarPersonas(personas);

      elevador.llamarElevadorDesdePiso(personas);

      this.terminoViaje = elevador.validarPersonasEnDestino(personas);
    }
  }
}
