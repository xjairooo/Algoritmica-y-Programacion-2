package ej1.test;

import ej1.Position; // Importa la interfaz Position desde el paquete ej1

import ej1.LinkedBinaryTree;

public class TestTree {
    public static void main(String[] args) {

        Position<String> p, q, r, s;
        // create instances of
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();

        p = t.addRoot("A");
        q = t.addLeft(p, "B");
        r = t.addRight(p, "C");

        t.addLeft(q, "D");
        t.addRight(q, "E");

        t.addLeft(r, "F");
        t.addRight(r, "G");

        /*
         * Ordenes de recorridos
         * RID - preorder
         * IRD - inorder
         * IDR - posorden
         */
        System.out.println("Recorrido por nivel (breadhtfirst)");
        for (Position<String> pos : t.breadthfirst()) {
            System.out.print(pos.getElement() + " ");
        }
        System.out.println();

        System.out.println("Recorrido por preorden (preorder)");
        for (Position<String> pos : t.preorder()) {
            System.out.print(pos.getElement() + " ");
        }
        System.out.println();

        System.out.println("Recorrido por inorden (inorder)");
        for (Position<String> pos : t.inorder()) {
            System.out.print(pos.getElement() + " ");
        }
        System.out.println();

        System.out.println("Recorrido por post orden (posorden)");
        for (Position<String> pos : t.postorder()) {
            System.out.print(pos.getElement() + " ");
        }
        System.out.println();

        System.out.println("Hijos de B (children)");
        for (Position<String> child : t.children(q)) {
            System.out.print(child.getElement() + " ");
        }
        System.out.println();

        System.out.println("Altura del arbol (height): " + t.height(p));
        System.out.println("Hermano de C (sibling): " + t.sibling(r).getElement());
        System.out.println("Pronfundidad de F (depth): " + t.depth(t.left(r)));

    }
}
