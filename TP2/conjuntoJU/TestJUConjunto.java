
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;  

class TestJUConjunto {

    private Conjunto<Integer> c1;
    private Conjunto<Integer> c2;

    /**
     * @BeforeEach es una anotación que indica que el metodo setUp() se ejecutara antes de cada metodo de prueba.
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        // Inicializamos los conjuntos c1 y c2 antes de cada prueba
        c1 = new Conjunto<Integer>(10);
        c1.insertarElemento(10);
        c1.insertarElemento(20);
        c1.insertarElemento(30);
        
        c2 = new Conjunto<Integer>(10);
        c2.insertarElemento(20);
        c2.insertarElemento(30);
        c2.insertarElemento(40);
    }

    @Test
    void testInserta1(){
        /*
         * Se elemino un elemento porque estaba dentro del conjunto 10,
         * ya qye compara solo 3 elementos
         */
        Assert.assertEquals(3, c1.cardinalidad());
    }
    
    @Test
    void testInsertar2(){
        /*
         * Se corrigio la capacidad de elementos del conjunto c3 a 2 elementos, para que la comparacion
         * Equals que compara 2 con la cantidad de elemento del conjunto c3
         */
        Conjunto<Integer> c3 = new Conjunto<Integer>(2);
        c3.insertarElemento(40);
        c3.insertarElemento(30);

        Assert.assertEquals(2, c3.cardinalidad());
    }

    @Test
    void testIguales(){
        Assert.assertFalse(c1.iguales(c2));
        Assert.assertFalse(c2.iguales(c1));

        Conjunto<Integer> c3 = new Conjunto<Integer>(10);
        Assert.assertFalse(c1.iguales(c3));
        Assert.assertFalse(c3.iguales(c1));

        c3.insertarElemento(30);
        c3.insertarElemento(20);
        c3.insertarElemento(10);

        Assert.assertTrue(c1.iguales(c3));
        Assert.assertTrue(c1.iguales(c1));
    }

    @Test
    void testUnion(){
        Conjunto<Integer> c3 = new Conjunto<Integer>(10);
        Conjunto<Integer> c4 = c1.union(c3);

        Assert.assertTrue(c1.iguales(c4));

        c4 = c3.union(c1);
        Assert.assertTrue(c1.iguales(c4));
    }

    @Test
    void testUnion2(){
        Conjunto<Integer> c3 = new Conjunto<Integer>(10);
        c3.insertarElemento(40);
        c3.insertarElemento(30);
        c3.insertarElemento(20);
        c3.insertarElemento(10);

        Conjunto<Integer> c4 = c1.union(c2);
        Assert.assertTrue(c3.iguales(c4));

        c4 = c2.union(c1);
        Assert.assertTrue(c4.iguales(c3));
    }

    @Test
    void testInterseccion1(){
        Conjunto<Integer> c3 = new Conjunto<Integer>(10);
        Conjunto<Integer> c4 = c1.interseccion(c3);

        Assert.assertTrue(c3.iguales(c4));

        c4 = c3.interseccion(c1);
        Assert.assertTrue(c3.iguales(c4));
    }

    @Test
    void testInterseccion2(){
        Conjunto<Integer> c3 = new Conjunto<Integer>(10);
        c3.insertarElemento(30);
        c3.insertarElemento(20);
        
        Conjunto<Integer> c4 = c1.interseccion(c2);
        Assert.assertTrue(c3.iguales(c4));

        c4 = c2.interseccion(c1);
        Assert.assertTrue(c4.iguales(c3));
    }
}