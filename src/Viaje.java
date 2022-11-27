public class Viaje extends Thread {
  String nombreViaje;
  String[] nombres;
  int[] pisoOrigen;
  int[] pisoDestino;
  int totalPersonas;
  boolean[] llegoAlDestino;
  boolean[] enElAscensor;
  boolean[] sentido; // false = sube, true = baja
  boolean terminoViaje = false;

  Hotel hotel;
  Elevador elevador;

  public Viaje(Hotel hotel, String nombreViaje, Elevador elevador) {
    this.hotel = hotel;
    this.nombreViaje = nombreViaje;
    this.elevador = elevador;
    this.totalPersonas = (int) (Math.random() * hotel.getTotalPisos()) + 1;

    this.nombres = new String[totalPersonas];
    this.pisoOrigen = new int[totalPersonas];
    this.pisoDestino = new int[totalPersonas];
    this.llegoAlDestino = new boolean[totalPersonas];
    this.enElAscensor = new boolean[totalPersonas];
    this.sentido = new boolean[totalPersonas];

    for (int i = 0; i < totalPersonas; i++) {
      this.nombres[i] = nombreViaje + ": Persona " + i;
      this.pisoOrigen[i] = (int) (Math.random() * hotel.getTotalPisos()) + 1;
      
      this.pisoDestino[i] = (int) (Math.random() * hotel.getTotalPisos());
      this.llegoAlDestino[i] = false;
      this.enElAscensor[i] = false;
      this.sentido[i] = this.pisoOrigen[i] < this.pisoDestino[i] ? false : true;
      System.out.println(this.nombres[i] + " va del piso " + this.pisoOrigen[i] + " al piso " + this.pisoDestino[i] + " y su sentido es " + (this.sentido[i] ? "bajar" : "subir"));
    }
  }

  public void run() {
    while (!terminoViaje) {
      
      elevador.subirBajarPersonas(sentido, enElAscensor, pisoOrigen, pisoDestino, llegoAlDestino, nombres);

      elevador.llamarElevadorDesdePiso(llegoAlDestino, pisoOrigen);

      this.terminoViaje = elevador.validarPersonasEnDestino(llegoAlDestino);
    }
  }
}
