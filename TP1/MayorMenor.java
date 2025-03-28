// Ejericio 09 - MayorMenor
// Escribir un programa que lee diez números e imprima el número más grande 
// y el número más pequeño

import java.util.Scanner;

public class MayorMenor {
    public static void main(String[] args) {
        // Creacion del objeto Scanner para leer datos
        Scanner input = new Scanner(System.in);
        
        // Declara las variables
        int numero;
        int mayor = Integer.MIN_VALUE;  // El valor minimo de un entero
        int menor = Integer.MAX_VALUE;  // El valor maximo de un entero 

        // Pide y verifica cual numero es mayor o menor
        for (int i = 0; i <= 10; i++){
            System.out.print("Ingrese un numero: ");
            numero = input.nextInt();
            
            mayor = (numero > mayor) ? numero : mayor;  // Si numero es mayor que mayor, entonces mayor es igual a numero
            menor = (numero < menor) ? numero : menor;  // Si numero es menor que menor o igual a 0, entonces menor es igual a numero
        }
        
        // Imprime el resultado
        System.out.println("Numero mayor: " + mayor);
        System.out.println("Numero menor: " + menor);

        // Cierra el objeto Scanner
        input.close();
    }
}
