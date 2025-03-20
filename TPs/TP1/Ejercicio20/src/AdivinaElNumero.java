import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo;

        do {
            jugarDeNuevo = jugarJuego(scanner);
        } while (jugarDeNuevo);

        System.out.println("¡Gracias por jugar! Hasta la próxima.");
    }

    // Metodo que maneja una partida del juego
    public static boolean jugarJuego(Scanner scanner) {
        int intentos = 0;
        int numAleatorio = (int) (Math.random() * 1000) + 1;
        int num;

        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("He elegido un número entre 1 y 1000. ¡Intenta adivinarlo!");

        do {
            System.out.print("Ingresa un número: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Descartamos la entrada inválida
                System.out.print("Ingresa un número: ");
            }
            num = scanner.nextInt();
            intentos++;

            if (num < numAleatorio) {
                System.out.println("Demasiado bajo. Intenta nuevamente.");
            } else if (num > numAleatorio) {
                System.out.println("Demasiado alto. Intenta nuevamente.");
            }
        } while (num != numAleatorio);

        System.out.println("¡Adivinaste el número en " + intentos + " intentos!");

        // Preguntar si desea jugar de nuevo
        System.out.print("¿Deseas jugar de nuevo? (sí/no): ");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("sí") || respuesta.equals("si");

    }
}
