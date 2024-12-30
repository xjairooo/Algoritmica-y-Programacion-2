/**
 * 7. Escribir un programa que imprima una tabla de los cuadrados y los cubos de
 * los números del 0 al 10
 */
    public class CuadradoCubo {
    public static void main(String[] args) {
        System.out.println("Nro.\t Cuadrado\t Cubo");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t\t%d\t\t%d%n", i, i * i, i * i * i);
        }
    }
}