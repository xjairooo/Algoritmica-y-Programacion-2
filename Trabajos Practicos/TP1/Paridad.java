// Ejercicio 04 - Paridad
// Programa que solicita un número al usuario e imprime si es par o impar
import java.util.Scanner;

public class Paridad {
    public static void main(String[] args) {
        // Creacion de un objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);     
        
        // Declara una variable tipo entero 
        int num;

        // Solicita un número al usuario
        System.out.printf("Ingrese un número: ");
        num = input.nextInt();

        // Imprime si el número es par o impar
        System.out.println(num % 2 == 0 ? "El numero es par" : "El numero es impar");
        // Cierra el objeto Scanner
        input.close();
    }
}
