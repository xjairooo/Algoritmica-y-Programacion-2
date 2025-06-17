package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;
import net.datastructures.PositionalList;

class TestReplaceAll1 {

    PositionalList<String> lp1;
    Position<String> p;

    @BeforeEach
    void setUp() throws Exception {
        lp1 = new LinkedPositionalList<String>();
        p = lp1.addFirst("N");
        p = lp1.addAfter(p, "E");
        p = lp1.addAfter(p, "U");
        p = lp1.addAfter(p, "Q");
        p = lp1.addAfter(p, "U");
        p = lp1.addAfter(p, "E");
        p = lp1.addAfter(p, "N");
    }

    @Test
    void test1() {
        assertEquals(lp1.replaceAll("E", "Z"), 2);

        PositionalList<String> lp = new LinkedPositionalList<String>();
        p = lp.addFirst("N");
        p = lp.addAfter(p, "Z");
        p = lp.addAfter(p, "U");
        p = lp.addAfter(p, "Q");
        p = lp.addAfter(p, "U");
        p = lp.addAfter(p, "Z");
        p = lp.addAfter(p, "N");
        assertIterableEquals(lp1, lp);

        System.out.println(lp1);
    }

    @Test
    void test2() {
        assertEquals(lp1.replaceAll("X", "Z"), 0);

        PositionalList<String> lp = new LinkedPositionalList<String>();
        p = lp.addFirst("N");
        p = lp.addAfter(p, "E");
        p = lp.addAfter(p, "U");
        p = lp.addAfter(p, "Q");
        p = lp.addAfter(p, "U");
        p = lp.addAfter(p, "E");
        p = lp.addAfter(p, "N");
        assertIterableEquals(lp1, lp);

        System.out.println(lp1);
    }

}
