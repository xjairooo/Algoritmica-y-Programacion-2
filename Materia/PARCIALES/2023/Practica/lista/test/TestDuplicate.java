package test;

import net.datastructures.SinglyLinkedList;

public class TestDuplicate {

    public static void main(String[] args) {

        SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
        l1.addFirst("Juan");
        l1.addLast("Pedro");
        l1.addLast("Ana");
        // Salida esperada: [Juan, Pedro, Ana]
        System.out.println();
        System.out.println(l1);
        System.out.println(l1.duplicate());
        // Salida esperada: ()
        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
        System.out.println(l2);
        System.out.println(l2.duplicate());

    }
}
