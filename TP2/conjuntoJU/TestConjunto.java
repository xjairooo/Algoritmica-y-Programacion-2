
public class TestConjunto {

	public static void main(String[] args) {

		// Creamos dos conjuntos de enteros con capacidad 3
		Conjunto<Integer> c1 = new Conjunto<Integer>(3);
		Conjunto<Integer> c2 = new Conjunto<Integer>(3);

		// ingreso de los elementos al 1°conjunto
		c1.insertarElemento(10);
		c1.insertarElemento(20);
		c1.insertarElemento(30);

		// ingreso de los elementos al 2°conjunto
		c2.insertarElemento(20);
		c2.insertarElemento(30);
		c2.insertarElemento(120);

		// imprimo ambos conjuntos y verificar que esten los elementos ingresados que
		// fueron dados por el usuario
		System.out.println("1° Conjunto: " + c1.toString() + "\t2°Segundo: " + c2.toString());
		System.out.println("\nUNION: " + c1.union(c2));
		System.out.println("INTESECCION: " + c1.interseccion(c2));
		System.out.println("¿AMBOS CONJUNTOS SON IGUALES?: " + c1.iguales(c2));
	}
}