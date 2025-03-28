// Ejercicio 05 - Multiplo
// Escribir un programa que lee dos números e imprime si el primer número es múltiplo del segundo.

import java.util.Scanner;

public class Multiplo {
    public static void main(String[] args) {
    
        // Creacion del objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);
        
        // Declaracion de variables
        int num1, num2;

        // Se pide al usuario que ingrese dos numeros
        System.out.print("Ingrese el primer numero: ");
        num1 = input.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        num2 = input.nextInt();

        // Se verifica si el primer numero es multiplo del segundo
        if (num2 != 0 && num1 % num2 == 0) {
            System.out.println(num1 + " es multiplo de " + num2);
        } else {
            System.out.println(num1 + " no es multiplo de " + num2);
        }

        // Cierra el objeto Scanner
        input.close();        
    }
}

