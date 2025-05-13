package position;

import java.util.Iterator;

public class Prueba {
    public static void main(String[] args) {
        // TIPOS DE RECORRIDOS
        /*
         * PositionalList<String> pl = new LinkedPositionalList<String>();
         * 
         * Position<String> p1;
         * Position<String> p2;
         * 
         * p1 = pl.addLast("Ana");
         * p2 = pl.addLast("Juan");
         * 
         * p1.addAfter(p1, "Maria");
         * 
         * p1.addBefore(p2, "Pablo");
         * 
         * for (Position<String> p = pl.first(); p != null; p = pl.after(p)) {
         * System.out.println(p.getElement());
         * }
         */

        List<String> pl = new ArrayList<String>();
        pl.add(0, "Ana");
        pl.add(1, "Carlos");
        pl.add(2, "Juan");
        pl.add(3, "Pablo");

        for (int i = 0; i < pl.size(); i++) {
            System.out.println(pl.get(i));
        }

        System.out.println("------------");
        // Este tipo de recorrido no nos dejar utilizar el remove
        for (String s : pl) {
            System.out.println(s);
        }

        System.out.println("------Remueve Juan------");
        Iterator<String> it = pl.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("Juan")) {
                it.remove();
            }
            System.out.println(it.next());
        }

    }
}
