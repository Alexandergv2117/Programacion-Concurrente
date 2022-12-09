import java.util.Random;

public class corredores extends Thread{
    String _nombre;
    int _numParticipante;
    _niveles _nivel;
    int _posicion;
    ranking rank;
    Random rand;

    public enum _niveles {
        Principiante(90),
        Experto(63),
        Maestro(20),
        Profesional(10);

        private int velocidad;

        _niveles(int s) {
            velocidad = s;
        }

        int getVelocidad() {
            return ( velocidad * 1);
        }

        void AjustarVelocidad() {
            int decimalVelocidad = velocidad % 1;
            double enteroVelocidad = (velocidad * 0.5) - decimalVelocidad; 
            velocidad += (int) enteroVelocidad;
        }

        void recuperar(int descansado){
            double enteroDescansado = descansado * 0.01;
            double decimalDescansado = enteroDescansado % 1;
            enteroDescansado -= decimalDescansado;
            velocidad -= (int) enteroDescansado;
            if (velocidad <= 0) {
                velocidad = 0;
            }
            System.out.println( "Se ha recuperado: " + enteroDescansado);
        }
    }

    public corredores(String nombre, int numParticipante, int nivel, ranking rank, Random rand) {
        this._nombre = nombre;
        this._numParticipante = numParticipante;
        this._nivel = _niveles.values()[nivel];
        this.rank = rank;
        this.rand = rand;

        System.out.println("El corredor " + _nombre + " ha iniciado");        
    }

    public void run() {
        int aleatorio;

        for (int i = 0; i < 10; i++) {
            aleatorio = rand.nextInt(2000);

            if (i == 9) {
                //System.out.println(_nombre + " ya recorrio " + (i + 1) + " km");
                System.out.println("El corredor " + _nombre + " ha terminado");
                rank.rankiList.add(_nombre + " #" + _numParticipante + " " + _nivel);
            } else if(i < 9) {
                System.out.println(_nombre + " ya recorrio " + (i + 1) + " km");
            }

            try {
                if (i == 2 || i == 5 || i == 8) {
                    _nivel.recuperar(aleatorio);
                    sleep(aleatorio);
                } else {
                    if (aleatorio > 1000 && aleatorio <= 1600) {
                        System.out.println("El corredor " + _nombre + " se ha lesionado");
                        _nivel.AjustarVelocidad();
                    }
                    if (aleatorio > 1600 && aleatorio <= 1900) {
                        System.out.println("El corredor " + _nombre + " esta cansado");
                        _nivel.velocidad += 100;
                    }
                    if (aleatorio > 1950 && aleatorio <= 2000) {
                        System.out.println("El corredor " + _nombre + " esta fracturado");
                        rank.rankiLesionados.add(_nombre + " #" + _numParticipante + " " + _nivel + " fracturado");
                        i = 11;
                        break;
                    }
                    sleep(_nivel.getVelocidad());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
