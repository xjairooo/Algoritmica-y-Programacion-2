package adivinanza;

import java.util.Scanner;

public class TestAdivinaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Declara boolean jugarDeNuevo para controlar el bucle del juego
        boolean jugarDeNuevo = true;

        // Bucle principal del juego
        while (jugarDeNuevo) {
            // Genera un número aleatorio con el método generarNumeroAleatorio
            int numeroAleatorio = AdivinaNumero.generarNumeroAleatorio();
            int intentos = 0;
            boolean adivinado = false;

            // Muestra el mensaje de bienvenida
            System.out.println("Estoy pensando en un numero entre 1 y " + AdivinaNumero.RANGO_MAXIMO + ".");
            System.out.println("¿Puedes adivinar cual es?");

            // Bucle para adivinar el número
            while (!adivinado) {
                System.out.print("Por favor, ingrese un numero: ");

                // Si la entrada no es un número, muestra un mensaje de error y continúa con el
                // bucle
                if (!AdivinaNumero.esNumeroValido(scanner)) {
                    continue;
                }

                // Lee el número elegido por el jugador
                int numeroElegido = scanner.nextInt();
                intentos++;
                // Compara el número elegido con el número aleatorio y muestra un mensaje
                String resultado = AdivinaNumero.compararNumeros(numeroElegido, numeroAleatorio);

                // Si el número es igual, muestra el mensaje de felicitaciones y el número de
                // intentos
                if (resultado.equals("igual")) {
                    AdivinaNumero.mostrarResultado(intentos); // Muestra el mensaje de felicitaciones
                    adivinado = true; // Cambia el valor de adivinado a true para salir del bucle
                } else {
                    System.out.println("El número que buscas es " + resultado + ". Inténtalo de nuevo.");
                }
            }

            // Pregunta al jugador si quiere jugar de nuevo
            System.out.print("¿Quieres jugar de nuevo? (s/n): ");
            jugarDeNuevo = scanner.next().trim().equalsIgnoreCase("s");
        }
        scanner.close();
    }
}