public class Persona {
  String nombre;
  int pisoOrigen;
  int pisoDestino;
  boolean llegoAlDestino;
  boolean enElAscensor;
  boolean sentido; // false = sube, true = baja
  boolean terminoViaje = false;

  public Persona(String nombre, int pisos) {
    this.nombre = nombre;
    this.pisoOrigen = (int) (Math.random() * pisos) + 1;
    this.pisoDestino = (int) (Math.random() * pisos);
    this.llegoAlDestino = false;
    this.enElAscensor = false;
    this.sentido = this.pisoOrigen < this.pisoDestino ? false : true;
  }
}
