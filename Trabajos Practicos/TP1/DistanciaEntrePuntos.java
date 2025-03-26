import java.util.Scanner;

public class DistanciaEntrePuntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculo de distancia");
        System.out.println("Ingrese los puntos x1, y1, x2, y2 (separados por espacios): ");
        double x1 = scanner.nextDouble(), y1 = scanner.nextDouble(), x2 = scanner.nextDouble(), y2 = scanner.nextDouble();

        double distancia = calcularDistancia(x1, y1, x2, y2);
        System.out.printf("La distancia entre los puntos (%.2f, %.2f) y (%.2f, %.2f) es: %.2f%n", x1, y1, x2, y2, distancia);
    }

    public static double calcularDistancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
