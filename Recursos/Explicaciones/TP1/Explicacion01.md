# Explicación de Ejercicios TP1 de Algorítmica y Programación 2 📝

Este archivo contiene las explicaciones de los ejercicios realizados del TP1 de **Algorítmica y Programación 2**.

## Ejercicio 1: Cálculo de la Hipotenusa 📐

### Descripción:
1. Escribir un programa que lee dos números e imprima la suma, producto, diferencia y cociente de los números.

### Código:
```java
public static double calcularHipotenusa(double cateto1, double cateto2) {
    return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
}


/**
 * 1. Escribir un programa que lee dos números e imprima la suma, producto,
 * diferencia y cociente de los números.
 */
import java.util.Scanner;
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
