import java.util.Arrays;

public class ArregloMetodos {
    public static void main(String[] args) {
        // Crear arreglos para los ejemplos
        int[] arreglo1 = { 5, 2, 9, 1, 7, 3, 8, 4, 6 };
        int[] arreglo2 = { 5, 2, 9, 1, 7, 3, 8, 4, 6 };
        int[] arreglo3 = { 1, 2, 3, 4, 5 };

        // 1. equals(A, B) - Compara si dos arreglos son iguales
        System.out.println("--- Método equals(A, B) ---");
        System.out.println("¿arreglo1 es igual a arreglo2? " + Arrays.equals(arreglo1, arreglo2));
        System.out.println("¿arreglo1 es igual a arreglo3? " + Arrays.equals(arreglo1, arreglo3));

        // 2. fill(A,x) - Llena el arreglo A con el valor x, sobreescribe los elementos
        System.out.println("\n--- Método fill(A, x) ---");
        Arrays.fill(arreglo3, 10);
        System.out.println("Arreglo después de fill(arreglo3, 10): " + Arrays.toString(arreglo3));

        // 3. copyOf(A, n) - Crea una copia del arreglo A con longitud n
        System.out.println("\n--- Método copyOf(A, n) ---");
        int[] copiaMayor = Arrays.copyOf(arreglo1, 12); // Copia con longitud mayor
        int[] copiaMenor = Arrays.copyOf(arreglo1, 5); // Copia con longitud menor
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Copia con longitud 12: " + Arrays.toString(copiaMayor));
        System.out.println("Copia con longitud 5: " + Arrays.toString(copiaMenor));

        // 4. copyOfRange(A, s, t) - Copia un rango del arreglo desde índice s hasta t-1
        System.out.println("\n--- Método copyOfRange(A, s, t) ---");
        int[] rangoCopiado = Arrays.copyOfRange(arreglo1, 2, 6);
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Rango copiado (índices 2 a 5): " + Arrays.toString(rangoCopiado));

        // 5. toString(A) - Devuelve una representación en cadena del arreglo
        System.out.println("\n--- Método toString(A) ---");
        String representacion = Arrays.toString(arreglo1);
        System.out.println("Representación del arreglo como cadena: " + representacion);

        // 6. sort(A) - Ordena los elementos del arreglo
        System.out.println("\n--- Método sort(A) ---");
        System.out.println("Arreglo antes de ordenar: " + Arrays.toString(arreglo1));
        Arrays.sort(arreglo1);
        System.out.println("Arreglo después de ordenar: " + Arrays.toString(arreglo1));

        // 7. binarySearch(A, x) - Busca el elemento x en el arreglo usando búsqueda
        // binaria
        System.out.println("\n--- Método binarySearch(A, x) ---");
        // Nota: El arreglo debe estar ordenado para usar binarySearch correctamente
        int indice7 = Arrays.binarySearch(arreglo1, 7);
        int indice10 = Arrays.binarySearch(arreglo1, 10);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo1));
        System.out.println("Índice del número 7: " + indice7);
        System.out.println("Índice del número 10: " + indice10 + " (negativo porque no existe en el arreglo)");
    }
}