public class BinarySearchRecursive {

  /**
   * Devuelve true si el valor objetivo se encuentra en la porción indicada del arreglo de datos.
   * Esta búsqueda solo considera la porción del arreglo desde data[low] hasta data[high] inclusive.
   */
  public static boolean binarySearch(int[] data, int target, int low, int high) {
    System.out.println("Buscando " + target + " en el rango [" + low + ", " + high + "]");
    if (low > high) {
      System.out.println("Intervalo vacío, no se encontró el valor.");
      return false; // intervalo vacío; no hay coincidencia
    } else {
      int mid = (low + high) / 2;
      System.out.println("Punto medio: " + mid + " (valor: " + data[mid] + ")");
      if (target == data[mid]) {
        System.out.println("¡Valor encontrado en la posición " + mid + "!");
        return true; // se encontró una coincidencia
      } else if (target < data[mid]) {
        return binarySearch(data, target, low, mid - 1); // buscar a la izquierda del medio
      } else {
        return binarySearch(data, target, mid + 1, high); // buscar a la derecha del medio
      }
    }
  }

  /**
   * Función de envoltura para realizar la búsqueda binaria recursiva con una firma más limpia.
   * Devuelve true si el valor objetivo se encuentra en el arreglo de datos.
   */
  public static boolean binarySearch(int[] data, int target) {
    return binarySearch(data, target, 0, data.length - 1); // llama a la versión parametrizada
  }

  
}