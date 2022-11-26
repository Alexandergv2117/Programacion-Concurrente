public class Viaje extends Thread {
  String nombreViaje;
  String[] nombres;
  int[] pisoOrigen;
  int[] pisoDestino;
  int totalPersonas;
  boolean[] llegoAlDestino;
  boolean[] enElAscensor;
  boolean[] sube;
  boolean[] baja;
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
    this.sube = new boolean[totalPersonas];
    this.baja = new boolean[totalPersonas];

    for (int i = 0; i < totalPersonas; i++) {
      this.nombres[i] = nombreViaje + ": Persona " + i;
      this.pisoOrigen[i] = (int) (Math.random() * hotel.getTotalPisos());
      this.pisoDestino[i] = (int) (Math.random() * hotel.getTotalPisos());
      this.llegoAlDestino[i] = false;
      this.enElAscensor[i] = false;

      if (this.pisoOrigen[i] < this.pisoDestino[i]) {
        this.sube[i] = true;
        this.baja[i] = false;
      } else {
        this.sube[i] = false;
        this.baja[i] = true;
      }
    }
  }

  public void run() {
    while (!terminoViaje) {
      for (int i = 0; i < totalPersonas; i++) {
        if (elevador.getPisoActual() == pisoOrigen[i] && !llegoAlDestino[i] && !enElAscensor[i] && elevador.capacidadActual < elevador.capacidadMaxima) {
          this.enElAscensor[i] = true;
          elevador.subirPersona();
          System.out.println("\n" + nombres[i] + " sube al elevador en el piso " + pisoOrigen[i] + " y va al piso " + pisoDestino[i]);
        }

        if (elevador.getPisoActual() == pisoDestino[i] && !llegoAlDestino[i] && enElAscensor[i]) {
          System.out.println("\n" + nombres[i] + " baja del elevador en el piso " + pisoDestino[i]);
          elevador.bajarPersona();
          llegoAlDestino[i] = true;
        }
      }

      for (int i = 0; i < totalPersonas; i++) {
        if (!llegoAlDestino[i]) {
          elevador.llamarElevador(pisoOrigen[i]);
          break;
        }
      }

      for (int i = 0; i < totalPersonas; i++ ) {
        if (llegoAlDestino[i]) {
          terminoViaje = true;
        } else {
          terminoViaje = false;
          break;
        }
      }
    }
  }
}
