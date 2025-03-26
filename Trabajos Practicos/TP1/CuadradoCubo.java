// Ejercicio 07 - Cuadrado y cubo
// Escribir un programa que imprima una tabla de los cuadrados y los cubos de 
// los números del 0 al 10.

public class CuadradoCubo {
    public static void main(String[] args) {
        
        // Declaro las variables
        double cuadrado, cubo;
        
        // Imprimo la cabecera de la tabla
        System.out.println("Numero\tCuadrado\tCubo");

        for (int i = 0; i <= 10; i++){
            // Calculo el cuadrado y el cubo de i
            cuadrado = Math.pow(i, 2);
            cubo = Math.pow (i,3);
            
            // Imprimo los resultados
            System.out.println(i + "\t" + cuadrado + "\t" + cubo);
        }
    }
}
