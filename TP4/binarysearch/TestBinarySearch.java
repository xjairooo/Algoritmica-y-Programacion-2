
public class TestBinarySearch {
    public static void main(String[] args) {
        final int N = 100;
        int[] data = new int[N];
        for (int j = 0; j < N; j++)
            data[j] = 1 + 2 * j; // llena el arreglo con números impares

        if (args.length > 0) {
            try {
                int target = Integer.parseInt(args[0]); // Convierte el argumento a un entero
                System.out.println("Buscando el valor " + target + " en el arreglo...");

                // Realiza la búsqueda binaria recursiva
                if (BinarySearchRecursive.binarySearch(data, target)) {
                    System.out.println("El valor " + target + " fue encontrado (recursivo).");
                } else {
                    System.out.println("El valor " + target + " no fue encontrado (recursivo).");
                }

                // Realiza la búsqueda binaria iterativa
                if (BinarySearchIterative.binarySearchIterative(data, target)) {
                    System.out.println("El valor " + target + " fue encontrado (iterativo).");
                } else {
                    System.out.println("El valor " + target + " no fue encontrado (iterativo).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El argumento debe ser un número entero.");
            }
        } else {
            System.out.println("Por favor, proporciona un número como argumento para buscar en el arreglo.");
        }
    }
}