// Ejercicio 06 - Concatenar dos cadenas de texto
// Escribir un programa que lee un nombre y un apellido por separado y lo 
// muestre concatenado y separado por un espacio.

import java.util.Scanner;

public class Concatenado {
    public static void main(String[] args) {
        //Creacion del objeto Scanner para leer datos
        Scanner input = new Scanner(System.in);

        //Declaracion de variables
        String nombre, apellido, nombreCompleto;
        
        //Solicitar al usuario que ingrese su nombre
        System.out.print("Ingrese su nombre: ");
        nombre = input.nextLine();

        System.out.print("Ingrese su apellido: ");
        apellido = input.nextLine();
        
        // Concatenar las variables nombre y apellido
        nombreCompleto = nombre + " " + apellido;

        //Imprimir el resultado
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre completo: " + nombreCompleto);

        //Cierra el objeto Scanner
        input.close();
    }
}
