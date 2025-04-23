public class BinarySearch {

    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false; // Base case: target not found
        } else {
            int mid = (low + high) / 2; // Calculate the middle index
            if (data[mid] == target) {
                return true; // Target found at mid index
            } else if (data[mid] < target) {
                return binarySearch(data, target, mid + 1, high); // Search in the right half
            } else {
                return binarySearch(data, target, low, mid - 1); // Search in the left half
            }
        }
    }
}