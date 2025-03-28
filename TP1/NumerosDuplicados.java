// Ejercio 12 - Numeros duplicados
// Escribir un programa que lee 20 números y al final imprime los mismos 
// descartando los duplicados. 

import java.util.HashSet;
import java.util.Scanner;

public class NumerosDuplicados {
    public static void main(String[] args) {
        // Crea un objeto Scanner
        Scanner input = new Scanner(System.in);

        // Crea un conjunto para almacenar los números
        HashSet<Integer> numerosUnicos = new HashSet<>(); // HashSet no permite duplicados

        // Pide al usuario que ingrese 20 números
        System.out.println("Ingrese 20 números");
        for (int i = 0; i < 20; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            int numero = input.nextInt();

            numerosUnicos.add(numero); // Agrega el número al conjunto
        }

        // Imprime los números únicos
        System.out.println("Numeros únicos: ");

        // Se usa un for-each para recorrer el conjunto
        for (int numero : numerosUnicos) { // Recorre el conjunto
            System.out.print(numero + " ");
        }
        // Cierra el objeto Scanner
        input.close();
    }
}
