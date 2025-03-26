// Ejercicio 01 - Operaciones
// Escribir un programa que lee dos números e imprima la suma, producto, 
// diferencia y cociente de los números.

import java.util.Scanner;

public class Operaciones {
    public static void main(String[] args) {
        // Creación de objeto Scanner para leer datos
        Scanner input = new Scanner(System.in);
        
        // Declaración de variables 
        int num1, num2;

        // Ingreso de datos
        System.out.println("Ingrese el primer número: ");
        num1 = input.nextInt();
        System.out.println("Ingrese el segundo número: ");
        num2 = input.nextInt();
        
        // Operaciones 
        System.out.println("La suma de los números es: " + (num1 + num2));
        System.out.println("El producto de los números es: " + (num1 * num2));  
        System.out.println("La diferencia de los números es: " + (num1 - num2));
        System.out.println("El cociente de los números es: " + (num1 / num2));

        input.close();
    }
} 