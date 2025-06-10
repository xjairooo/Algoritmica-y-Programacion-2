package test;

import net.datastructures.Position;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.List;
import net.datastructures.TreeMap;
import net.datastructures.Entry;

public class TestMapDepth {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("F");
        Position<String> b = tree.addLeft(root, "B");
        Position<String> g = tree.addRight(root, "G");
        Position<String> a = tree.addLeft(b, "A");
        Position<String> d = tree.addRight(b, "D");
        Position<String> c = tree.addLeft(d, "C");
        Position<String> f2 = tree.addRight(d, "F");
        Position<String> f3 = tree.addLeft(g, "F");
        Position<String> h = tree.addRight(f3, "H");

        TreeMap<Integer, List<String>> resultado = tree.mapDepth();
        for (Entry<Integer, List<String>> entry : resultado.entrySet()) {
            System.out.println("Profundidad " + entry.getKey() + " Letra: " + entry.getValue());
        }
    }
}