/**
 * 12. Escribir un programa que lee 20 números y al final imprime los mismos
 * descartando los duplicados
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DescartarDuplicados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>(); // Añadir todos los números a la lista original
        HashSet<Integer> unicos = new HashSet<>();      // Añadir solo números únicos al conjunto (Set)


        // Leer y añadir los 20 números al ArrayList y al HashSet
        System.out.println("Introduce 20 numeros");
        for (int i = 0; i < 20; i++) {
            System.out.println("Numero " + (i + 1) + ":");
            int num = scanner.nextInt();
            numeros.add(num);
            unicos.add(num);
        }

        // Imprimir los números originales y sin duplicados
        System.out.println("\nNumeros originales");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println("\n\nNumeros sin duplicados");
        for (int numero : unicos) {
            System.out.print(numero + " ");
        }
    }
}