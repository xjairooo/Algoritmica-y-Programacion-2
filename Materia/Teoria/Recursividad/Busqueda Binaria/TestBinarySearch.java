public class TestBinarySearch {
    public static void main(String[] args) {
        int[] data = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 1048576, 2097152};
        int target = 32;
        
        // Warm-up: Ejecutar antes de medir para que la JVM optimice
        for (int i = 0; i < 1000; i++) {
            BinarySearch.binarySearch(data, target, 0, data.length - 1);
        }
        
        // Registrar tiempo de inicio en nanosegundos
        long startTime = System.nanoTime();
        
        // Ejecutar la búsqueda binaria
        boolean result = BinarySearch.binarySearch(data, target, 0, data.length - 1);
        
        // Registrar tiempo de finalización
        long endTime = System.nanoTime();
        
        // Calcular tiempo transcurrido en nanosegundos
        long elapsedTime = endTime - startTime;
        
        // Mostrar resultados
        System.out.println("Target " + target + " found: " + result);
        System.out.println("Execution time: " + elapsedTime + " nanoseconds");
        System.out.println("Which is " + (elapsedTime / 1_000_000.0) + " milliseconds");
    }
}