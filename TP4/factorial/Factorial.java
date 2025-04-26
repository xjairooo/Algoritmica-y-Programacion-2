import java.util.Scanner;

/**
 * Demonstration of recursive factorial function.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Factorial {

  /** Computes the factorial of the given (nonnegative) integer) */
  public static int factorial(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException();     // argument must be nonnegative
    else if (n == 0)
      return 1;                                 // base case
    else
      System.out.println("factorial(" + n + ") = " + n + " * factorial(" + (n-1) + ")");
      return n * factorial(n-1);                // recursive case
  }

  public static int factorialIterative(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException();     // argument must be nonnegative
    int result = 1;
    for (int i = 1; i <= n; i++)
      result *= i;
    return result;
  }

  /** Simple test, assuming valid integer given as command-line argument */
  public static void main(String[] args) {
    int n = 0;
    try (Scanner scanner = new Scanner(System.in)) { // try-with-resources para cerrar automáticamente el Scanner
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.print("Ingrese un número para calcular el factorial: ");
            n = scanner.nextInt();
        }

        if (n < 0)
            throw new IllegalArgumentException("El número no puede ser negativo.");

        System.out.println("Factorial recursivo de " + n + ": " + factorial(n));
        System.out.println("Factorial iterativo de " + n + ": " + factorialIterative(n));
    } catch (IllegalArgumentException e) {
        System.out.println("Error: el factorial no está definido para números negativos.");
    } catch (Exception e) {
        System.out.println("Error: debe ingresar un número entero válido.");
    }
  }
}
