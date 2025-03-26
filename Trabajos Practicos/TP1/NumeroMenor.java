// Ejercicio 10 - NumeroMenor   
//  Escribir una aplicación que encuentre el menor de varios enteros. El primer 
// valor leído especifica el número de valores que el usuario va a introducir.

import java.util.Scanner;

public class NumeroMenor {
    public static void main(String[] args){
        //Creacion del objeto Scanner para leer datos
        Scanner input = new Scanner(System.in);
        
        // Declara las variables
        int contador, numero; 
        int menor = Integer.MAX_VALUE;

        // Solicitar la cantidad de repeticiones
        System.out.print("Ingrese la cantidad de repeticiones: ");
        contador = input.nextInt();

        // Solicitar los numeros y verificar cual es el menor
        for (int i = 1; i <= contador; i++){
            System.out.print("Ingrese un numero: ");
            numero = input.nextInt();

            menor = (numero < menor) ? numero : menor;
        }

        // Imprimir el resultado
        System.out.println("El numero menor es: " + menor);

        // Cierra el objeto Scanner
        input.close();
    }        
}

