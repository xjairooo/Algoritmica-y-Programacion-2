package lista;
public class TestRemoveOdd {
    public static void main(String[] args) {
        // Caso 1: Lista {A, B, C, D}
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.addLast("A");
        list1.addLast("B");
        list1.addLast("C");
        list1.addLast("D");
        System.out.println("Original: " + list1); // Original: (A, B, C, D)
        SinglyLinkedList<String> removed1 = list1.removeOdd();
        System.out.println("Modificada: " + list1); // Modificada: (A, C)
        System.out.println("Eliminados: " + removed1); // Eliminados: (B, D)

        // Caso 2: Lista {A, B, C}
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.addLast("A");
        list2.addLast("B");
        list2.addLast("C");
        System.out.println("\nOriginal: " + list2); // Original: (A, B, C)
        SinglyLinkedList<String> removed2 = list2.removeOdd();
        System.out.println("Modificada: " + list2); // Modificada: (A, C)
        System.out.println("Eliminados: " + removed2); // Eliminados: (B)

        // Caso 3: Lista {A, B}
        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.addLast("A");
        list3.addLast("B");
        System.out.println("\nOriginal: " + list3); // Original: (A, B)
        SinglyLinkedList<String> removed3 = list3.removeOdd();
        System.out.println("Modificada: " + list3); // Modificada: (A)
        System.out.println("Eliminados: " + removed3); // Eliminados: (B)

        // Caso 4: Lista {A}
        SinglyLinkedList<String> list4 = new SinglyLinkedList<>();
        list4.addLast("A");
        System.out.println("\nOriginal: " + list4); // Original: (A)
        SinglyLinkedList<String> removed4 = list4.removeOdd();
        System.out.println("Modificada: " + list4); // Modificada: (A)
        System.out.println("Eliminados: " + removed4); // Eliminados: ()

        // Caso 5: Lista vacía {}
        SinglyLinkedList<String> list5 = new SinglyLinkedList<>();
        System.out.println("\nOriginal: " + list5); // Original: ()
        SinglyLinkedList<String> removed5 = list5.removeOdd();
        System.out.println("Modificada: " + list5); // Modificada: ()
        System.out.println("Eliminados: " + removed5); // Eliminados: ()
    }
}
