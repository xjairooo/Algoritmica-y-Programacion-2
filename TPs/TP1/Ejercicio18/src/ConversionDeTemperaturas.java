import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionDeTemperaturas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú para elegir la conversión
        System.out.println("Seleccione la conversión que desea realizar:");
        System.out.println("1. Fahrenheit a Centígrados");
        System.out.println("2. Centígrados a Fahrenheit");

        try {
            int opcion = scanner.nextInt();
            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
                return;
            }

            // Solicitar la temperatura
            System.out.println("Ingrese la temperatura:");
            double temperatura = scanner.nextDouble();

            // Ejecutar la conversión dependiendo de la opción seleccionada
            if (opcion == 1) {
                double resultado = fahrenheitToCelsius(temperatura);
                System.out.printf("La temperatura %.2f °F en grados Centígrados es: %.2f °C\n", temperatura, resultado);
            } else {
                double resultado = celsiusToFahrenheit(temperatura);
                System.out.printf("La temperatura %.2f °C en grados Fahrenheit es: %.2f °F\n", temperatura, resultado);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: por favor ingrese un valor numérico válido.");
        }
    }

    // Metodo que convierte de Fahrenheit a Centígrados
    public static double fahrenheitToCelsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    // Metodo que convierte de Centígrados a Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }
}
