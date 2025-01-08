# Explicación de Ejercicios TP1 de Algorítmica y Programación 2 📝

Este archivo contiene las explicaciones de los ejercicios realizados del TP1 de **Algorítmica y Programación 2**.

## Ejercicio 1: Cálculo de la Hipotenusa 📐

### Descripción:
Este programa calcula la hipotenusa de un triángulo rectángulo utilizando el Teorema de Pitágoras.

### Código:
```java
public static double calcularHipotenusa(double cateto1, double cateto2) {
    return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
}
