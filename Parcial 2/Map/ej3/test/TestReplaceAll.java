package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import net.datastructures.Map;
import net.datastructures.TreeMap;

public class TestReplaceAll {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        // nodos
        Position<String> root = tree.addRoot("F");
        Position<String> b = tree.addLeft(root, "B");
        Position<String> g = tree.addRight(root, "G");
        Position<String> a = tree.addLeft(b, "A");
        Position<String> d = tree.addRight(b, "D");
        Position<String> c = tree.addLeft(d, "C");
        Position<String> f2 = tree.addRight(d, "F");
        Position<String> f3 = tree.addLeft(g, "F");
        Position<String> h = tree.addRight(f3, "H");

        // Mostrar árbol por niveles antes del reemplazo
        for (Position<String> p : tree.breadthfirst()) {
            System.out.print(p.getElement());
        }
        System.out.println();

        // Crea un mapa de reemplazos usando tu TreeMap
        Map<String, String> replace = new TreeMap<>();
        replace.put("F", "Z");
        replace.put("C", "W");

        // Reemplazar y mostrar cantidad de reemplazos
        int cantidad = tree.replaceAll(replace);
        System.out.println("Cantidad de reemplazos: " + cantidad);

        // Mostrar árbol por niveles después del reemplazo
        for (Position<String> p : tree.breadthfirst()) {
            System.out.print(p.getElement());
        }
        System.out.println();
    }
}