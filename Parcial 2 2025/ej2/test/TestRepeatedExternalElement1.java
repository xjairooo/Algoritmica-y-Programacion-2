package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestRepeatedExternalElement1<E> {

    public static void main(String[] args) {

        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p, q, s, u;

        p = t.addRoot("F");
        q = t.addLeft(p, "B");
        t.addLeft(q, "A");
        s = t.addRight(q, "D");
        t.addLeft(s, "C");
        t.addRight(s, "F");

        s = t.addRight(p, "C");
        u = t.addRight(s, "A");
        t.addLeft(u, "A");

        System.out.println(t.repeatedExternalElement());

    }
}
