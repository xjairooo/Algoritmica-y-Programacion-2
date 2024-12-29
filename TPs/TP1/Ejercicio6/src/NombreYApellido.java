/**
 *6. Escribir un programa que lee un nombre y un apellido por separado y lo
 * muestre concatenado y separado por un espacio.
 */

import java.util.Scanner;

public class NombreYApellido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Recibe e imprime el nombre y apellido
        System.out.println("Ingrese nombre y apellido: ");
        String nombre = scanner.next(), apellido = scanner.next();
        System.out.println(nombre + " " + apellido);
    }
}
