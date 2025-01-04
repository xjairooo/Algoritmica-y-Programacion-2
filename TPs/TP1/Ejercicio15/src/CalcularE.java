/**
 * 15. Escribir un programa que calcula el valor de e a partir de la serie infinita:
 * e = 1 + 1/1! + 1/2! + 1/3! + …
 */

import java.util.Scanner;

public class CalcularE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de términos para la aproximación de e: ");
        int numAproximado = scanner.nextInt();

        double e = 1.0; // Primer término de la serie

        // Cálculo de e utilizando la serie infinita hasta el número de términos indicado
        for (int i = 1; i <= numAproximado; i++) {
            e += 1.0 / factorial(i);
        }

        System.out.println("El valor aproximado de e con " + numAproximado + " términos es: " + e);
    }

    // Metodo para calcular el factorial
    public static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
