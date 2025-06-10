package test;

import net.datastructures.LinkedPositionalList;

public class TestRemoveAll {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        // agregar los elemento [A, B, C, D, E]
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");

        System.out.println("Lista original: " + list);

        // Caso fromIndex == toIndex: no cambia la lista
        try {
            list.removeAll(1, 1);
            System.out.println("Después de removeAll(1,1): " + list);
        } catch (Exception e) {
            System.out.println("Excepción en removeAll(1,1): " + e.getMessage());
        }

        // Caso fromIndex > toIndex: debe lanzar IllegalArgumentException
        try {
            list.removeAll(3, 2);
        } catch (Exception e) {
            System.out.println("Excepción en removeAll(3,2): " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Caso fromIndex < 0: debe lanzar IndexOutOfBoundsException
        try {
            list.removeAll(-1, 2);
        } catch (Exception e) {
            System.out
                    .println("Excepción en removeAll(-1,2): " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Caso toIndex > size: debe lanzar IndexOutOfBoundsException
        try {
            list.removeAll(0, 10);
        } catch (Exception e) {
            System.out
                    .println("Excepción en removeAll(0,10): " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
