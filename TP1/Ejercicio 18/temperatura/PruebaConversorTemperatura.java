package temperatura;

import java.util.Scanner;

public class PruebaConversorTemperatura {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menu de opciones para el usuario seleccionar el tipo de conversion
        System.out.println("CONVERSOR DE TEMPERATURA");
        System.out.println("------------------------");
        System.out.println("1. Fahrenheit a Celsius");
        System.out.println("2. Celsius a Fahrenheit");
        System.out.print("Seleccione el tipo de conversion (1-2): ");
        int opcion = input.nextInt();

        // Validar que la opcion seleccionada sea 1 o 2
        if (opcion < 1 || opcion > 2) {
            System.out.println("Opción invalida. Seleccionar 1 o 2.");
        }

        // Solicitar al usuario la temperatura a convertir
        System.out.print(opcion == 1 ? "Ingrese los grados Fahrenheit: "
                : "Ingrese los grados Celsius: ");
        double temperatura = input.nextDouble();

        // Realizar la conversion de temperatura segun la opcion seleccionada
        double resultado = opcion == 1 ? ConversorTemperatura.fahrToCent(temperatura)
                : ConversorTemperatura.centToFahr(temperatura);

        // Mostrar el resultado de la conversion
        String desde = opcion == 1 ? "ºF" : "ºC";
        String hacia = opcion == 1 ? "ºC" : "ºF";

        System.out.printf("%.2f%s = %.2f%s%n", temperatura, desde, resultado, hacia);

        input.close();
    }
}
