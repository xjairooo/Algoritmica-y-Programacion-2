/**
 * 14. Escribir el metodo factorial y un programa que lee un entero n no negativo
 * y calcula su factorial del mismo.
 */

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int valor = scanner.nextInt();

        // Llama al metodo que calcula el factorial
        System.out.println("El factorial de " + valor + " es: " + factorial(valor));
    }
    // Metodo para calcular el factorial
    public static int factorial(int n) {
        if ( n == 0 || n == 1 )
            return 1;
        else {
            return n * factorial(n - 1);
        }
    }
}
