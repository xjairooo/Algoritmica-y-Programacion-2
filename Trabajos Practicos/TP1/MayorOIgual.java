// Ejercicio 03 - Mayor o igual
// Escribir un programa que lee dos números e imprima el número más grande 
// seguido de las palabras es más grande. Si son iguales, imprimir el mensaje los números son iguales.

import java.util.Scanner;

public class MayorOIgual {

    public static void main(String[] args) {
        //Crear un objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);

        // Declaración de variables
        int num1, num2;

        // Solicitar los números al usuario
        System.out.print("Ingrese el primer número: ");        
        num1 = input.nextInt();
        System.out.print("Ingrese el segundo número: ");
        num2 = input.nextInt(); 

        // Comparar si los números son iguales
        System.out.println(num1 == num2 ? "Los números son iguales" : // Operador ternario para simplificar el if
            (num1 > num2 ? num1 : num2) + " es mas grande");          // Si n1 es mas grande que n2, imprime n1, sino n2

        // Cerrar el objeto Scanner
        input.close();            
    }
}