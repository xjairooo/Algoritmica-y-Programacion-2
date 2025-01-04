import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recursivo recursivo = new Recursivo();
        System.out.println("Ingrese un numero: ");
        int valor = scanner.nextInt();

        // Llama al metodo que calcula el factorial
        System.out.println("El factorial de " + valor + " es: " + Recursivo.factorial(valor));
    }
}