package conjunto;

public class PruebaConjunto {

	public static void main(String[] args) {
		// Creación de conjuntos
		ConjuntoEntero conjuntoA = new ConjuntoEntero();
		ConjuntoEntero conjuntoB = new ConjuntoEntero();

		// Agregar elementos al conjunto A
		conjuntoA.insertarElemento(5);
		conjuntoA.insertarElemento(10);
		conjuntoA.insertarElemento(15);
		conjuntoA.insertarElemento(20);

		// Agregar elementos al conjunto B
		conjuntoB.insertarElemento(10);
		conjuntoB.insertarElemento(20);
		conjuntoB.insertarElemento(25);
		conjuntoB.insertarElemento(30);

		// Pruebas básicas
		System.out.println("=== CONJUNTOS INICIALES ===");
		System.out.println("Conjunto A: " + conjuntoA.aStringConjunto());
		System.out.println("Conjunto B: " + conjuntoB.aStringConjunto());
		System.out.println();

		// Pruebas de operaciones
		System.out.println("=== OPERACIONES ENTRE CONJUNTOS ===");
		System.out.println("Unión (A ∪ B):        " + conjuntoA.union(conjuntoB).aStringConjunto());
		System.out.println("Intersección (A ∩ B): " + conjuntoA.interseccion(conjuntoB).aStringConjunto());
		System.out.println("Diferencia (A - B):   " + conjuntoA.diferencia(conjuntoB).aStringConjunto());
		System.out.println("Diferencia (B - A):   " + conjuntoB.diferencia(conjuntoA).aStringConjunto());
		System.out.println();

		// Pruebas de igualdad
		System.out.println("=== PRUEBAS DE IGUALDAD ===");
		System.out.println("¿A es igual a B? " + conjuntoA.equals(conjuntoB));

		ConjuntoEntero conjuntoC = new ConjuntoEntero();
		conjuntoC.insertarElemento(10);
		conjuntoC.insertarElemento(20);
		System.out.println("Conjunto C: " + conjuntoC.aStringConjunto());
		System.out.println("¿B es igual a C? " + conjuntoB.equals(conjuntoC));

		// Eliminar elemento y volver a comparar
		conjuntoB.eliminarElemento(25);
		conjuntoB.eliminarElemento(30);
		System.out.println("\nConjunto B actualizado: " + conjuntoB.aStringConjunto());
		System.out.println("¿B es igual a C ahora? " + conjuntoB.equals(conjuntoC));

		// Pruebas con conjunto vacío
		ConjuntoEntero conjuntoVacio = new ConjuntoEntero();
		System.out.println("\n=== PRUEBAS CON CONJUNTO VACÍO ===");
		System.out.println("Conjunto vacío: " + conjuntoVacio.aStringConjunto());
		System.out.println("Unión con vacío: " + conjuntoA.union(conjuntoVacio).aStringConjunto());
		System.out.println("Intersección con vacío: " + conjuntoA.interseccion(conjuntoVacio).aStringConjunto());

		// Prueba con elementos fuera de rango
		System.out.println("\n=== PRUEBAS CON ELEMENTOS INVÁLIDOS ===");
		conjuntoA.insertarElemento(-5); // Debe mostrar error
		conjuntoA.insertarElemento(150); // Debe mostrar error
	}
}