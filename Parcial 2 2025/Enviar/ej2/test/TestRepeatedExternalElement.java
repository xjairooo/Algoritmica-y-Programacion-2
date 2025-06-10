package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestRepeatedExternalElement {
    public static void main(String[] args) {

        LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<>();

        Position<String> root1 = tree1.addRoot("F");

        Position<String> b1 = tree1.addLeft(root1, "B");
        Position<String> c1 = tree1.addRight(root1, "C");

        Position<String> a1 = tree1.addLeft(b1, "A");
        Position<String> d1 = tree1.addRight(b1, "D");

        tree1.addLeft(d1, "C");
        tree1.addRight(d1, "F");

        Position<String> a2 = tree1.addRight(c1, "A");
        tree1.addRight(a2, "A");

        System.out.println("Arbol con elementos externos repetidos:");
        System.out.println("RETORNA: " + tree1.repeatedExternalElement());

        // --------------------------------------------------------------

        LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<>();

        Position<String> root2 = tree2.addRoot("M");

        Position<String> n1 = tree2.addLeft(root2, "N");
        Position<String> p1 = tree2.addRight(root2, "P");

        tree2.addLeft(n1, "X");
        tree2.addRight(n1, "Y");

        tree2.addLeft(p1, "Z");
        tree2.addRight(p1, "W");

        System.out.println("\nArbol sin elementos externos repetidos:");
        System.out.println("RETORNA: " + tree2.repeatedExternalElement());
    }
}