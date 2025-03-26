// Ejercicio 15 - CalculoEuler
// Escribir un programa que calcula el valor de e a partir de la serie infinita: 
// e = 1 + 1/1! + 1/2! + 1/3! + ... 

import java.util.Scanner;

public class CalculoEuler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double e = 1.0; // Inicializa e a 1

        // Pide la cantidad de terminos
        System.out.print("Ingrese la cantidad de terminos: ");
        int cantidadTerminos = input.nextInt();

        // Calcula el valor de e
        for (int i = 1; i <= cantidadTerminos; i++) {
            e += 1.0 / factorial(i); // comienza en 1.0 (que representa *1/0!+*).
        }

        // Imprime el valor de e
        System.out.println("Cantidad terminos: " + cantidadTerminos);
        System.out.println("e = " + e);
        input.close();
    }

    // Metodo para calcular el factorial de un numero de forma recursiva
    public static long factorial(int n) {
        return n == 0 ? 1 : n * factorial((n - 1));
    }
}
