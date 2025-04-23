public class BinarySearchIterative {
    
    public static boolean binarySearchIterative(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
    
        while (low <= high) {
            int mid = (low + high) / 2;
    
            if (data[mid] == target) {
                return true; // Elemento encontrado
            } else if (data[mid] < target) {
                low = mid + 1; // Buscar en la mitad derecha
            } else {
                high = mid - 1; // Buscar en la mitad izquierda
            }
        }
    
        return false; // Elemento no encontrado
    }
}