/**
 * 13. Escribir un programa para simular el lanzamiento de dos dados. El
 * programa debe pedir el número de veces que se tiran los dados y mostrar una
 * tabla indicando cuantas veces aparece cada suma.
 */

import java.util.Scanner;

public class Dados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de tiradas:");
        int numTiradas = scanner.nextInt();

        // Array para contar cuántas veces aparece cada suma (de 2 a 12)
        int[] contarSumas = new int[11];  // Índices 0-10 corresponden a sumas 2-12

        // Realizar las tiradas
        for (int i = 0; i < numTiradas; i++) {
            int dado1 = (int) (Math.random() * 6) + 1; // Lanza el primer dado (1-6)
            int dado2 = (int) (Math.random() * 6) + 1; // Lanza el segundo dado (1-6)
            int suma = dado1 + dado2;

            // Comprobar si la suma está dentro del rango válido
            if (suma >= 2 && suma <= 12) {
                // Imprimir el resultado de la tirada
                System.out.printf("Tirada %d: Dado 1 = %d, Dado 2 = %d, Suma = %d%n", i + 1, dado1, dado2, suma);

                // Contar cuántas veces aparece cada suma
                contarSumas[suma - 2]++;  // Restamos 2 porque la suma mínima es 2
            } else {
                System.out.println("Suma fuera de rango: " + suma);  // Esto no debería ocurrir nunca
            }
        }

        // Imprimir la tabla de frecuencias de las sumas
        System.out.println("\nFrecuencia de las sumas:");
        for (int i = 0; i < contarSumas.length; i++) {
            System.out.printf("Suma %d: %d veces%n", i + 2, contarSumas[i]); // +2 para mostrar la suma real
        }

        scanner.close();
    }
}
