package quicksort;

public class QuicksortPrueba {

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 8, 7, 1, 9, 5 };

        System.out.println("Arreglo original: " + java.util.Arrays.toString(numbers));

        Quicksort sorter = new Quicksort();
        System.out.println();
        sorter.sort(numbers);
        System.out.println("\nArreglo ordenado: " + java.util.Arrays.toString(numbers));
    }
}