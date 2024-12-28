/**
 * 3. Escribir un programa que lee dos números e imprima el número más grande
 * seguido de las palabras es más grande. Si son iguales, imprimir el mensaje
 * los números son iguales
 */

import java.util.Scanner;

public class IgualOMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dos numeros: ");
        int num1 = scanner.nextInt(), num2 = scanner.nextInt();
        System.out.println(num1 == num2 ? "Los números son iguales" :
                (num1 > num2 ? num1 : num2) + " es más grande");
    }
}
