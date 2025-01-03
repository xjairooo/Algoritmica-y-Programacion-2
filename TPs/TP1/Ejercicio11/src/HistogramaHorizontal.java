/**
 * 11. Escribir un programa que lee cinco números entre 1 y 30 y dibuje un
 * histograma horizontal usando *
 */

import java.util.Scanner;

public class HistogramaHorizontal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Leer cinco números entre 1 y 30
        System.out.println("Introduce 5 numeros entre 1 y 30");
        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Numero " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
                if (numbers[i] < 1 || numbers[i] > 30) {
                    System.out.println("Por favor, ingrese un número entre 1 y 30.");
                }
            } while (numbers[i] < 1 || numbers[i] > 30);
        }

        // Dibujar histograma horinzontal
        System.out.println("\nHistograma:");
        for (int num : numbers) {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();  // Nueva línea para el siguiente número
        }
    }
}
