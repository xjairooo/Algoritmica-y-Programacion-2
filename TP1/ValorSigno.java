// Ejercicio 08 - ValorSigno
// Crear un programa que lea 10 números enteros por teclado y que cuente cuántos son positivos, cuántos negativos y cuántos ceros.

import java.util.Scanner;

public class ValorSigno {
    public static void main(String[] args) {
        // Creacion del objeto Scanner para leer datos
        Scanner input = new Scanner(System.in);
        
        // Declaro las variables
        int numero;
        int negativo = 0;
        int positivo = 0;
        int ceros = 0;
        
        // Solicitar al usuario que ingrese los numeros
        for (int i = 1; i <= 10; i++ ){
            System.out.print("Ingrese un numero: ");
            numero = input.nextInt();

            // Verificar si el numero es positivo, negativo o cero
            if (numero < 0){
                negativo++;    
            } else if (numero > 0){
                positivo++;
            } else {
                ceros++;
            }
        }
        
        // Imprimir los resultados
        System.out.println("Numeros positivos: " + positivo);
        System.out.println("Numeros negativos: " + negativo);
        System.out.println("Ceros: " + ceros);

        // Cierro el objeto
        input.close();
}
}