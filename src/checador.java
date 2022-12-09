import java.util.ArrayList;
import java.util.Scanner;

public class checador extends Thread {
    int[] registrados;
    int poscion = 0;
    int numeroEmpleado;
    boolean registrar = true;
    boolean registrado = false;
    reloj reloj;
    Scanner sc = new Scanner(System.in);

    public checador(int registros, reloj reloj) {
        registrados = new int[registros];
        this.reloj = reloj;
    }

    public void run() {
        while (true) {
            sc.nextLine();
            reloj.mostrar = false;
            System.out.print("\rIngrese su número de empleado: ");
            numeroEmpleado = sc.nextInt();
            if (buscar(numeroEmpleado)) {
                System.out.println("Se ha registrado su salida: " + reloj.getHora());
                eliminar(numeroEmpleado);
                registrar = false;
            } else {
                registrar(numeroEmpleado);
                System.out.println("Se ha registrado su entrada: " + reloj.getHora());
                registrar = false;
            }
            reloj.mostrar = true;
            sc.nextLine();
        }
    }

    public void registrar(int numeoEmpleado) {
        if (poscion < registrados.length) {
            registrados[poscion] = numeoEmpleado;
            poscion++;
        } else {
            System.out.println("No hay mas espacio");
        }
    }

    public void eliminar(int numeoEmpleado) {
        for (int i = 0; i < registrados.length; i++) {
            if (registrados[i] == numeoEmpleado) {
                registrados[i] = 0;
                poscion--;
            }
        }
    }

    public boolean buscar(int numeroEmpleado) {
        for (int i = 0; i < registrados.length; i++) {
            if (registrados[i] == numeroEmpleado) {
                return true;
            }
        }
        return false;
    }
}
