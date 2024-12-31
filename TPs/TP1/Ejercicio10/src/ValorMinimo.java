/**
 * 10. Escribir una aplicación que encuentre el menor de varios enteros. El primer
 * valor leído especifica el número de valores que el usuario va a introducir.
 */

import java.util.Scanner;

public class ValorMinimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numeroRepeticiones = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numeroRepeticiones; i++) {
            System.out.println("Ingrese un numero: ");
            int num = scanner.nextInt();

            min = (num < min) ? num : min;
        }
        System.out.println("El numero menor es: " + min);
    }
}