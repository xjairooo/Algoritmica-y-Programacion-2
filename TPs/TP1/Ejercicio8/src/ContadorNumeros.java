/**
 * 8. Escribir un programa que lee diez números e imprima la cantidad de
 * números negativos, positivos y ceros.
 */

import java.util.Scanner;

public class ContadorNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese un numero: ");
            int num = scanner.nextInt();

            ceros += (num == 0) ? 1 : 0;
            positivos += (num > 0) ? 1 : 0;
            negativos += (num < 0) ? 1 : 0;
        }
        System.out.println("Ceros: " + ceros);
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
    }
}