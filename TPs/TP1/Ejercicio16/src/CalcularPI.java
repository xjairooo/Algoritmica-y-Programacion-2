/**
 * 16. Escribir un programa que calcula el valor de π a partir de la serie infinita:
 * π = 4 – 4/3 + 4/5 – 4/7 + 4/9 – 4/11 + …
 */

import java.util.Scanner;

public class CalcularPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el número de términos para aproximar π
        System.out.println("Ingrese un número aproximado:");
        int numAprox = scanner.nextInt();  // Asegúrate de que esta línea tiene los paréntesis correctos

        // Llamar al metodo para calcular π
        double pi = calculoPi(numAprox);

        // Mostrar el resultado
        System.out.println("El valor aproximado de π con " + numAprox + " términos es: " + pi);
    }

    // Metodo que calcula π basado en la serie infinita, utilizando operadores ternarios
    public static double calculoPi(int numAprox) {
        double pi = 0.0;
        for (int i = 0; i < numAprox; i++) {
            // Alternar sumando y restando términos en la serie con operador ternario
            pi += (i % 2 == 0) ? 4.0 / (2 * i + 1) : -4.0 / (2 * i + 1);
        }
        return pi;  // Devolver el valor aproximado de π
    }
}
