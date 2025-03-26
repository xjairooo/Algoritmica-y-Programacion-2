// Ejecicio 11 - Histograma
// Escribir un programa que lee cinco números entre 1 y 30 y dibuje un 
// histograma horizontal usando * 

import java.util.Scanner;

public class Histograma {
    public static void main (String[] args) {
        // Crea un objeto Scanner
        Scanner input = new Scanner(System.in);

        // Crea un arreglo de 5 elementos
        int [] arreglo = new int[5];
        int numero;     // Almacena el numero ingresado por el usuario

        // Pide al usuario que ingrese 5 números
        System.out.println("Ingrese cinco numeros entre 1 y 30");

        // Lee los 5 numeros
        for(int i = 0; i < 5; i++){
            System.out.print("Numero " + (i + 1)+ ": ");
            numero = input.nextInt();   // Lee el numero ingresado por el usuario

            // Verificar si el numero esta entre el 1 y 30
            if (numero < 1 || numero > 30){
                System.out.println("El numero debe estar entre 1 y 30");
                i--;        // Decrementa el contador para que el usuario ingrese el numero nuevamente
                continue;   // Continua con la siguiente iteración
            }
            // Almacena el numero en el arreglo
            arreglo[i] = numero;
        }
        // Imprime el histograma
        System.out.println("Histograma");
        for (int i = 0; i < 5; i++){
            System.out.print("Numero " + (i + 1) + ": ");
            // Imprime asteriscos
            for (int j = 0; j < arreglo[i]; j++){
                System.out.print("*");
            }
            System.out.println();   // Salto de linea para el siguiente numero
        }
    //Cierra el objeto Scanner
    input.close();
    }
}
