import java.util.Scanner;

public class CalculoPi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pide la cantidad de terminos
        System.out.print("Ingrese la cantidad de terminos: ");
        int cantidadTerminos = input.nextInt();

        double pi = 0.0;
        int denominador = 1;
        int signo = 1;

        // Calcula el valor de pi
        for (int i = 1; i <= cantidadTerminos; i++) {
            pi += signo * 4.0 / denominador;
            signo *= -1; // Cambia el signo 1 -> -1 -> 1 -> -1 -> ...
            denominador += 2; // Incrementa el denominador en 2 para q sea impar
        }

        // Imprime el valor de pi
        System.out.println("Cantidad terminos: " + cantidadTerminos);
        System.out.println("PI = " + pi);
        input.close();
    }
}
