package position.test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;
import net.datastructures.PositionalList;

public class Prueba {
    public static void main(String[] args) {

        PositionalList<String> pl = new LinkedPositionalList<>();

        Position<String> p1;
        Position<String> p2;

        p1 = pl.addLast("Ana");
        p2 = pl.addLast("Juan");

        p1.addAfter(p1, "Maria");

        p1.addBefore(p2, "Pablo");

        for (Position<String> p = pl.first(); p != null; p = pl.after(p)) {
            System.out.println(p.getElement());
        }
    }
}
