// Ejercicio 13 - Dados
// Escribir un programa para simular el lanzamiento de dos dados. El 
// programa debe pedir el número de veces que se tiran los dados y mostrar una 
// tabla indicando cuantas veces aparece cada suma.

import java.util.Random;
import java.util.Scanner;

public class Dados {
    public static void main(String[] args) {
        // Creación de un objeto Scanner y un objeto Random
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Pide al usuario que ingrese la cantidad de veces que se tirarán los dados
        System.out.print("Ingrese la cantidad de tiradas: ");
        int cantidadTiradas = input.nextInt();

        int[] sumas = new int[13]; // Array para almacenar las sumas de los dados

        // Realiza las tiradas de los dados y sumas
        for (int i = 0; i < cantidadTiradas; i++) {
            int dado1 = random.nextInt(6) + 1;
            int dado2 = random.nextInt(6) + 1;
            int suma = dado1 + dado2;
            sumas[suma]++; // Incrementa la cantidad de veces que se obtiene la suma
        }

        System.out.println("Cantidad de tiradas = " + cantidadTiradas);

        // Imprime la cantidad de veces que se obtiene cada suma
        for (int i = 2; i <= 12; i++) {
            System.out.println("Suma " + i + " = " + sumas[i]);
        }

        // Cierra el objeto Scanner
        input.close();
    }
}
