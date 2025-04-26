package lista;

public class TestRight {
    public static void main(String[] args) {
        
        // Caso 1: Lista {A, B, C, D}, n = 4
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.addLast("A");
        list1.addLast("B");
        list1.addLast("C");
        list1.addLast("D");
        System.out.println("Original: " + list1); // Original: (A, B, C, D)
        SinglyLinkedList<String> result1 = list1.right(4);
        System.out.println("Right(4): " + result1); // Right(4): (A, B, C, D)

        // Caso 2: Lista {A, B, C, D}, n = 3
        SinglyLinkedList<String> result2 = list1.right(3);
        System.out.println("Right(3): " + result2); // Right(3): (B, C, D)

        // Caso 3: Lista {A, B, C, D}, n = 2
        SinglyLinkedList<String> result3 = list1.right(2);
        System.out.println("Right(2): " + result3); // Right(2): (C, D)

        // Caso 4: Lista {A, B, C, D}, n = 1
        SinglyLinkedList<String> result4 = list1.right(1);
        System.out.println("Right(1): " + result4); // Right(1): (D)

        // Caso 5: Lista {A, B, C, D}, n = 0
        SinglyLinkedList<String> result5 = list1.right(0);
        System.out.println("Right(0): " + result5); // Right(0): ()

        // Caso 6: Lista {A, B, C, D}, n = 5 (excepcion)
        try {
            SinglyLinkedList<String> result6 = list1.right(5);
            System.out.println("Right(5): " + result6);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Right(5): " + e.getMessage()); // Right(5): n: 5 no es valido
        }

        // Caso 7: Lista {A, B, C, D}, n = -1 (excepcion)
        try {
            SinglyLinkedList<String> result7 = list1.right(-1);
            System.out.println("Right(-1): " + result7);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Right(-1): " + e.getMessage()); // Right(-1): n: -1 no es valido
        }

        // Caso 8: Lista vacia {}, n = 0
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        System.out.println("\nOriginal: " + list2); // Original: ()
        SinglyLinkedList<String> result8 = list2.right(0);
        System.out.println("Right(0): " + result8); // Right(0): ()

        // Caso 9: Lista vacia {}, n = 1 (excepcion)
        try {
            SinglyLinkedList<String> result9 = list2.right(1);
            System.out.println("Right(1): " + result9);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Right(1): " + e.getMessage()); // Right(1): n: 1 no es valido
        }
    }
}