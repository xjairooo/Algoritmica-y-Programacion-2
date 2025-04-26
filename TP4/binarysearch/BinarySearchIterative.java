public class BinarySearchIterative {
    /**
   * Implementación iterativa de la búsqueda binaria.
   * Devuelve true si el valor objetivo se encuentra en el arreglo de datos.
   */
  public static boolean binarySearchIterative(int[] data, int target) {
    int low = 0;
    int high = data.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      System.out.println("Buscando " + target + " en el rango [" + low + ", " + high + "], punto medio: " + mid);
      if (target == data[mid]) { // se encontró una coincidencia
        System.out.println("¡Valor encontrado en la posición " + mid + "!");
        return true;
      } else if (target < data[mid]) {
        high = mid - 1; // considerar solo los valores a la izquierda del medio
      } else {
        low = mid + 1; // considerar solo los valores a la derecha del medio
      }
    }
    System.out.println("No se encontró el valor.");
    return false; // el bucle terminó sin éxito
  }
}
