package temperatura;

/*
 * Clase que contiene metodos estaticos para convertir temperaturas entre grados Celsius y Fahrenheit.
 */
public class ConversorTemperatura {
    /**
     * Convierte la temperatura en grados Celsius a grados Fahrenheit y viceversa.
     * 
     * @param fahrenheit temperatura en grados Fahrenheit a convertir
     * @return equivalente en grados Celsius
     */
    public static double fahrToCent(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    /**
     * Convierte la temperatura en grados Fahrenheit a grados Celsius.
     * 
     * @param celsius temperatura en grados Celsius a convertir
     * @return equivalente en grados Fahrenheit
     */
    public static double centToFahr(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }
}
