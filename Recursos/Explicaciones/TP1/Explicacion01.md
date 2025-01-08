# Explicación del Ejercicio TP1 - 01 de AyP 2 📝

Este archivo contiene la explicación del ejercicio 1 del TP1 de **Algorítmica y Programación 2**.

---

## Ejercicio 1: Cálculo de Suma, Producto, Diferencia y Cociente 🔢


### Descripción:
Escribir un programa que lea dos números e imprima su suma, producto, diferencia y cociente.

- Este ejercicio tiene como objetivo practicar el uso de operadores aritméticos básicos en Java. También introduce el uso de la clase `Scanner` para la entrada de datos por parte del usuario.

### Código:
```java
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
```
### Explicación del Código:
**1. Importación de la clase Scanner:** El código importa la clase Scanner del paquete java.util, la cual permite la entrada de datos por parte del usuario desde la consola.

java
Copiar código
import java.util.Scanner;
Creación del objeto Scanner:
El programa utiliza el objeto scanner para capturar los valores ingresados por el usuario. Cada vez que se usa scanner.nextInt(), se espera que el usuario ingrese un número entero.

java
Copiar código
Scanner scanner = new Scanner(System.in);
Operaciones Aritméticas:

Suma: Se suman los dos números ingresados.
java
Copiar código
System.out.println("Suma: " + (num1 + num2));
Producto: Se multiplican los dos números.
java
Copiar código
System.out.println("Producto: " + (num1 * num2));
Diferencia: Se resta el segundo número del primero.
java
Copiar código
System.out.println("Diferencia: " + (num1 - num2));
Cociente: Se divide el primer número entre el segundo. Nota importante: Aquí se asume que el segundo número no es 0.
java
Copiar código
System.out.println("Cociente: " + (num1 / num2));
Posibles Mejoras:

Validar que el segundo número no sea cero antes de realizar la división, ya que la división por cero lanzará una excepción (ArithmeticException).
java
Copiar código
if (num2 != 0) {
System.out.println("Cociente: " + (num1 / num2));
} else {
System.out.println("Error: División por cero.");
}
