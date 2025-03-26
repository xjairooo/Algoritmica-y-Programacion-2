// Ejercicio 02 - Circulo
// Escribir un programa que lea el radio de un círculo y que imprima el diámetro,
// la circunferencia y el área del círculo. Utilice el valor constante 3.14159 para PI.

import java.util.Scanner;

public class Circulo {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);

        // Declaración de variables
        double radio;

        // Pedir que ingrese el radio del círculo
        System.out.print("Ingrese el radio del círculo: ");
        radio = input.nextDouble();

        // Calcular y mostrar resultados formateados con dos decimales
        System.out.printf("Diámetro: %.2f%n", (2 * radio));
        System.out.printf("Circunferencia: %.2f%n", (2 * Math.PI * radio));
        System.out.printf("Área: %.2f%n", (Math.PI * radio * radio));

        // Cerrar el objeto Scanner
        input.close();
    }
}