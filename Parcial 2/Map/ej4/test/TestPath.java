package test;

import net.datastructures.List;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestPath {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> f = tree.addRoot("F");
        Position<String> b = tree.addLeft(f, "B");
        Position<String> g = tree.addRight(f, "G");
        Position<String> a = tree.addLeft(b, "A");
        Position<String> d = tree.addRight(b, "D");
        Position<String> c = tree.addLeft(d, "C");
        Position<String> e = tree.addRight(d, "E");
        Position<String> h = tree.addLeft(g, "H");
        Position<String> i = tree.addRight(g, "I");

        // a) path (A, I) = [ A, B, F, G, I ]
        printPath("A", "I", tree.path(a, i));

        // b) path (E, A) = [ E, D, B, A ]
        printPath("E", "A", tree.path(e, a));

        // c) path (B, B) = [ B ]
        printPath("B", "B", tree.path(b, b));

        // d) path (D, B) = [ D, B ]
        printPath("D", "B", tree.path(d, b));

    }

    private static void printPath(String from, String to, net.datastructures.List<Position<String>> path) {
        System.out.print("path(" + from + ", " + to + ") = [");
        boolean first = true;
        for (Position<String> p : path) {
            if (!first)
                System.out.print(", ");
            System.out.print(p.getElement());
            first = false;
        }
        System.out.println("]");
    }
}
