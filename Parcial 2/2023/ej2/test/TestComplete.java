package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestComplete {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<>();

        Position<Integer> n1 = t1.addRoot(1);
        Position<Integer> n2 = t1.addLeft(n1, 2);
        Position<Integer> n3 = t1.addRight(n1, 3);
        Position<Integer> n4 = t1.addLeft(n2, 4);
        Position<Integer> n5 = t1.addRight(n2, 5);
        Position<Integer> n6 = t1.addLeft(n3, 6);
        Position<Integer> n7 = t1.addRight(n3, 7);

        System.out.println("Arbol 1 completo: " + t1.complete()); // true

        // Árbol completo: 1 2 3 4 5 6 null
        LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<>();
        Position<Integer> m1 = t2.addRoot(1);
        Position<Integer> m2 = t2.addLeft(m1, 2);
        Position<Integer> m3 = t2.addRight(m1, 3);
        Position<Integer> m4 = t2.addLeft(m2, 4);
        Position<Integer> m5 = t2.addRight(m2, 5);
        Position<Integer> m6 = t2.addLeft(m3, 6);
        // No agregamos el hijo derecho m3 (quedo null)
        System.out.println("Arbol 2 completo: " + t2.complete()); // true

        // Árbol NO completo: 1 2 3 4 5 null 7
        LinkedBinaryTree<Integer> t3 = new LinkedBinaryTree<>();
        Position<Integer> p1 = t3.addRoot(1);
        Position<Integer> p2 = t3.addLeft(p1, 2);
        Position<Integer> p3 = t3.addRight(p1, 3);
        Position<Integer> p4 = t3.addLeft(p2, 4);
        Position<Integer> p5 = t3.addRight(p2, 5);
        // No agregamos hijo izquierdo de p3 (queda null)
        Position<Integer> p7 = t3.addRight(p3, 7);
        System.out.println("Arbol 3 completo: " + t3.complete());
    }
}
