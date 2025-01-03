/**
 * 10. Escribir una aplicación que encuentre el menor de varios enteros. El primer
 * valor leído especifica el número de valores que el usuario va a introducir.
 */

import java.util.Scanner;

public class ValorMinimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario la cantidad de numeros a comparar
        System.out.println("Introduce la cantidad de numeros a introducir: ");
        int numeroRepeticiones = scanner.nextInt();

        int min = Integer.MAX_VALUE;

        //Compara y actualiza el menor
        for (int i = 0; i < numeroRepeticiones; i++) {
            System.out.println("Ingrese un numero: ");
            int num = scanner.nextInt();

            min = (num < min) ? num : min;
        }
        System.out.println("El numero menor es: " + min);
    }
}