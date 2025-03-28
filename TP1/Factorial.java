// Ejercicio 14 - Factorial
// Escribir un programa que calcule el factorial de un número entero no negativo.

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pido que ingrese un numero
        System.out.print("Ingrese un número: ");
        int numero = input.nextInt();

        // Verifico si el numero es negativo, para realizar el factorial
        if (numero < 0) {
            System.out.println("Numero negativo, no se puede calcular el factorial");
        } else {
            // Calculo el factorial del numero ingresado
            int factorial = calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es " + factorial);
        }
        // Cierra el objeto Scanner
        input.close();
    }

    // Metodo para calcular el factorial de un numero
    // Calcula n! = n * (n-1) * (n-2) * ... * 1
    // de manera recursiva
    public static int calcularFactorial(int n) {
        return n == 0 ? 1 : n * calcularFactorial(n - 1);
    }

}