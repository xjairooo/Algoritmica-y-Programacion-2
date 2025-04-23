public class TestBinarySearchIterative {
    public static void main(String[] args) {
        int[] data = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 1048576, 2097152};
        int target = 32;

        // Warm-up para que la JVM haga optimización (JIT)
        for (int i = 0; i < 1000; i++) {
            BinarySearchIterative.binarySearchIterative(data, target);
        }

        // Medir tiempo de ejecución
        long startTime = System.nanoTime();
        boolean result = BinarySearchIterative.binarySearchIterative(data, target);
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        // Imprimir resultados
        System.out.println("Target " + target + " found: " + result);
        System.out.println("Execution time: " + elapsedTime + " nanoseconds");
        System.out.println("Which is " + (elapsedTime / 1_000_000.0) + " milliseconds");
    }
}