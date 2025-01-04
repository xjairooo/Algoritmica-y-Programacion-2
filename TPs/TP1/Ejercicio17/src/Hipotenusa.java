import java.util.Scanner;

public class Hipotenusa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicita los catetos del triangulo
        System.out.println("Ingrese el cateto opuesto: ");
        double catetoOpuesto = scanner.nextDouble();
        System.out.println("Ingrese el cateto adyacente: ");
        double catetoAdyacente = scanner.nextDouble();

        //Recibe el valor de la hipotenusa
        double Hipotenusa = calcularHipotenusa(catetoAdyacente, catetoOpuesto);

        System.out.println("La longitud de la hipotenusa es: " + Hipotenusa);
    }

    // Metodo que calcula la longitud de la hipotenusa
    public static int calcularHipotenusa(double catetoAdyacente, double catetoOpuesto) {
        //Calcula y devuelve la hipotenusa
        return (int) Math.sqrt(Math.pow(catetoAdyacente, 2) + Math.pow(catetoOpuesto, 2));
    }
}