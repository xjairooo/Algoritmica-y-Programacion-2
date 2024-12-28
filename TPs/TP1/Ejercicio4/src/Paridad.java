/**
 * 4. Escribir un programa que lee un número e imprima si es par o impar
 * utilizando el operador módulo.
 */

import java.util.Scanner;

public class Paridad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        int num1 = scanner.nextInt();
        // Verifica si es par o impar
        System.out.println(num1 % 2 == 0 ? "Es par" : "Es impar");
    }
}