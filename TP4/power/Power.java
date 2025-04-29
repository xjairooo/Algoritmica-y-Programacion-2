package power;

/**
 * Demostración de dos métodos recursivos para calcular la potencia de un número.
 */
class PowerSlow {
  /** Calcula el valor de x elevado a la potencia n, para n entero no negativo. */
  public static double power(double x, int n) {
    System.out.println("PowerSlow: Calculando " + x + "^" + n);
    if (n == 0)
      return 1;
    else
      return x * power(x, n - 1);
  }
}

/** Demostración del método más eficiente para calcular la función de potencia. */
public class Power {

  /** Calcula el valor de x elevado a la potencia n, para n entero no negativo. */
  public static double power(double x, int n) {
    System.out.println("Power: Calculando " + x + "^" + n);
    if (n == 0)
      return 1;
    else {
      double partial = power(x, n / 2);          // se basa en la división truncada de n
      double result = partial * partial;
      if (n % 2 == 1)                            // si n es impar, incluye un factor adicional de x
        result *= x;
      return result;
    }
  }

  public static void main(String[] args) {
    final double EPSILON = 0.0000000001; // margen de error permitido
    final int BASE = 3; // base para las potencias
    final int EXPONENT = 3; // exponente para probar

    // Medir tiempo para PowerSlow
    long startSlow = System.nanoTime();
    double resultSlow = PowerSlow.power(BASE, EXPONENT);
    long endSlow = System.nanoTime();
    System.out.println("Resultado método lento: " + resultSlow);
    System.out.println("Tiempo método lento: " + (endSlow - startSlow) + " nanosegundos");

    // Medir tiempo para Power
    long startFast = System.nanoTime();
    double resultFast = Power.power(BASE, EXPONENT);
    long endFast = System.nanoTime();
    System.out.println("Resultado método rápido: " + resultFast);
    System.out.println("Tiempo método rápido: " + (endFast - startFast) + " nanosegundos");

    // Comparar resultados con margen de error
    if (Math.abs(resultSlow - resultFast) > EPSILON) {
      System.out.println("Los resultados no coinciden.");
    } else {
      System.out.println("Los resultados coinciden.");
    }
  }
}