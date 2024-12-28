import java.util.Scanner;

/**
 * 1. Escribir un programa que lee dos números e imprima la suma, producto,
 * diferencia y cociente de los números.
 */

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer valor: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor: ");
        int num2 = scanner.nextInt();

        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Producto: " + (num1 * num2));
        System.out.println("Diferencia: " + (num1 - num2));
        System.out.println("Cociente: " + (num1 / num2));

    }
}