/**
 * 2. Escribir un programa que reciba el radio de un círculo e imprima el diámetro
 * (2r), la circunferencia (2πr) y el área (πr2) de este círculo. Utilizar el valor
 * constante 3.14159 para π
 */
import java.util.Scanner;
public class Circulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el radio de un circulo: ");
        double radio = scanner.nextDouble();

        //Imprime los datos del circulo
        System.out.printf("Diametro: %.2f%n", (2 * radio));
        System.out.printf("Circunferencia: %.2f%n", (2 * Math.PI * radio));
        System.out.printf("Area: %.2f%n", (Math.PI * Math.pow(radio, 2)));
    }
}