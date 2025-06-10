package test;

import net.datastructures.LinkedPositionalList;

public class TestReverse {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        list.addLast("H");
        list.addLast("O");
        list.addLast("L");
        list.addLast("A");

        System.out.println("Lista original: " + list);

        list.reverse();
        System.out.println("Lista reversa: " + list);
    }
}
