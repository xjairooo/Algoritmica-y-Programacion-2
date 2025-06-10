package test;

import net.datastructures.LinkedPositionalList;

class TestReplaceAll {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<String>();

        list.addLast("N");
        list.addLast("E");
        list.addLast("U");
        list.addLast("Q");
        list.addLast("U");
        list.addLast("E");
        list.addLast("N");

        System.out.println("Lista original: " + list);
        /*
         * * Ejemplo 1:
         *
         * {N, E, U, Q, U, E, N}
         *
         * replace(E,Z) > {N, Z, U, Q, U, Z, N} (retorna 2)
         */
        int reemplazos1 = list.replaceAll("E", "Z");
        System.out.println("replaceAll(E, Z) -> " + list + " (retorna " + reemplazos1 + ")");

        list = new LinkedPositionalList<String>();
        list.addLast("N");
        list.addLast("E");
        list.addLast("U");
        list.addLast("Q");
        list.addLast("U");
        list.addLast("E");
        list.addLast("N");

        /*
         * * Ejemplo 2:
         * Elemento que no existe
         * {N, E, U, Q, U, E, N}
         *
         * replace(X,Z) > {N, E, U, Q, U, E, N} (retorna 0)
         */

        int reemplazos2 = list.replaceAll("X", "Z");
        System.out.println("replaceAll(X, Z) -> " + list + " (retorna " + reemplazos2 + ")");

    }

}
