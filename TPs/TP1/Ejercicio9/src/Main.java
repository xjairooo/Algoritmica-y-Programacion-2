/**
 * 9. Escribir un programa que lee diez números e imprima el número más grande
 * y el número más pequeño.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese un numero: ");
            int num = scanner.nextInt();

            max = (num > max) ? num : max;
            min = (num < min) ? num : min;
        }

        System.out.println("Número más grande: " + max);
        System.out.println("Número más pequeño: " + min);
    }

}