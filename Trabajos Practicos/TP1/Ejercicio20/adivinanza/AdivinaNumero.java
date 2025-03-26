package adivinanza;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene la logica principal del juego de adivinanza de numeros.
 * Proporciona lso metodos para generar numeros aleatorios, validar entradas,
 * comparar numeros y mostrar resultados.
 */
public class AdivinaNumero {

    // El valor maximo del rango para el número aleatorio (inclusive).
    static final int RANGO_MAXIMO = 1000;

    /**
     * Genera un número aleatorio dentro del rango definido.
     * 
     * @return Numero entero aleatorio entre 1 y RANGO_MAXIMO
     */
    public static int generarNumeroAleatorio() {
        return new Random().nextInt(RANGO_MAXIMO) + 1;
    }

    /**
     * Valida si la entrada del usuario es un número entero válido.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @return true si la entrada es un numero entero valido, false en caso
     *         contrario
     */
    public static boolean esNumeroValido(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
            scanner.next();
            return false;
        }
        return true;
    }

    /**
     * Compara el número ingresado por el usuario con el numero objetivo.
     * 
     * @param numeroElegido   Numero ingresado por el usuario
     * @param numeroAleatorio Numero objetivo generado aleatoriamente
     * @return "igual" si los números coinciden, "mayor" si el numero objetivo es
     *         mayor, o "menor" si el numero objetivo es menor
     */
    public static String compararNumeros(int numeroElegido, int numeroAleatorio) {
        if (numeroElegido == numeroAleatorio) {
            return "igual";
        }
        return numeroElegido < numeroAleatorio ? "mayor" : "menor";
    }

    /**
     * Muestra el mensaje de felicitaciones cuando el usuario adivina el numero.
     * 
     * @param intentos Cantidad de intentos que tomó adivinar el numero
     */
    public static void mostrarResultado(int intentos) {
        System.out.println("¡Felicidades! Adivinaste el numero.");
        System.out.println("Lo lograste en " + intentos + " intentos.");
    }
}