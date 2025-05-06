package quicksort;

import java.util.Arrays;

public class Quicksort {
        private int[] numbers;
        private int number;

        public void sort(int[] values) {
                // check for empty or null array
                if (values == null || values.length == 0) {
                        return;
                }
                this.numbers = values;
                number = values.length;
                quicksort(0, number - 1);
        }

        private void quicksort(int low, int high) {
                System.out.println("Llamada a quicksort(low=" + low + ", high=" + high + ")");
                System.out.println("Estado actual del arreglo: " + Arrays.toString(numbers));

                int i = low, j = high;
                int pivot = numbers[low + (high - low) / 2];
                System.out.println("Pivot seleccionado: " + pivot);

                while (i <= j) {
                        while (numbers[i] < pivot) {
                                i++;
                        }
                        while (numbers[j] > pivot) {
                                j--;
                        }
                        if (i <= j) {
                                System.out.println("Intercambiando números[" + i + "]=" + numbers[i] + " con números["
                                                + j + "]=" + numbers[j]);
                                exchange(i, j);
                                i++;
                                j--;
                        }
                }

                System.out.println("Estado del arreglo después de partición: " + Arrays.toString(numbers));

                if (low < j) {
                        quicksort(low, j);
                }
                if (i < high) {
                        quicksort(i, high);
                }
        }

        private void exchange(int i, int j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
        }
}