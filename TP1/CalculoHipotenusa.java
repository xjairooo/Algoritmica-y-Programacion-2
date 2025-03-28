import java.util.Scanner;

public class CalculoHipotenusa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pide los catetos
        System.out.print("Ingrese el primer cateto: ");
        double cateto1 = input.nextDouble();

        System.out.print("Ingrese el segundo cateto: ");
        double cateto2 = input.nextDouble();

        // Llamo al metodo hipotenusa y le paso los catetos
        double hipotenusa = hipotenusa(cateto1, cateto2);

        // Imprime la longitud de la hipotenusa
        System.out.println("La longitud de la hipotenusa es: " + hipotenusa);
        input.close();
    }

    // Metodo para calcular la hipotenusa de un triangulo rectangulo
    // usando el teorema de pitagoras
    public static double hipotenusa(double cateto1, double cateto2) {
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }
}
