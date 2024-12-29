/**
 * 5. Escribir un programa que lee dos números e imprima si el primero es
 * múltiplo del segundo.
 */

import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese 2 numeros: ");
        int num1 = scanner.nextInt(), num2 = scanner.nextInt();
        System.out.println(num1 % num2 == 0? "El primero es multiplo del segundo" : "El primero no es multiplo del segundo");
    }
}