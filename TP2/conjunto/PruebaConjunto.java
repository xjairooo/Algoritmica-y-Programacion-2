package conjunto;
public class PruebaConjunto {

	public static void main(String[] args) {
		// PRUEBA 1: Creacion basica de conjuntos
		System.out.println("=== CONJUNTOS INICIALES ===");
		ConjuntoEntero conjuntoA = new ConjuntoEntero();
		ConjuntoEntero conjuntoB = new ConjuntoEntero();

		System.out.println("Hola mundo");
		// Agregamos elementos al conjunto A
		conjuntoA.insertarElemento(5); 
		conjuntoA.insertarElemento(10); 
		conjuntoA.insertarElemento(15); 
		conjuntoA.insertarElemento(20); 

		// Agregamos elementos al conjunto B
		conjuntoB.insertarElemento(10); // Presente en ambos conjuntos
		conjuntoB.insertarElemento(20); // Presente en ambos conjuntos
		conjuntoB.insertarElemento(25); // Exclusivo de B
		conjuntoB.insertarElemento(30); // Exclusivo de B

		// Resultado esperado:
		// Conjunto A: 5 10 15 20
		// Conjunto B: 10 20 25 30
		System.out.println("Conjunto A: " + conjuntoA.aStringConjunto());
		System.out.println("Conjunto B: " + conjuntoB.aStringConjunto());
		System.out.println();

		// PRUEBA 2: Operaciones entre conjuntos
		System.out.println("=== OPERACIONES ENTRE CONJUNTOS ===");

		// Union: Todos los elementos de A y B
		// Esperado: 5 10 15 20 25 30
		System.out.println("Union (A U B): " + conjuntoA.union(conjuntoB).aStringConjunto());

		// Interseccion: Solo elementos comunes
		// Esperado: 10 20
		System.out.println("Interseccion (A ∩ B): " + conjuntoA.interseccion(conjuntoB).aStringConjunto());

		// Diferencia A-B: Elementos en A que no estan en B
		// Esperado: 5 15
		System.out.println("Diferencia (A - B): " + conjuntoA.diferencia(conjuntoB).aStringConjunto());

		// Diferencia B-A: Elementos en B que no estan en A
		// Conjunto A: 5 10 15 20
		// Conjunto B: 10 20 25 30
		// Esperado: 25 30
		System.out.println("Diferencia (B - A): " + conjuntoB.diferencia(conjuntoA).aStringConjunto());
		System.out.println();

		// PRUEBA 3: Comparacion de conjuntos
		System.out.println("=== PRUEBAS DE IGUALDAD ===");

		// A y B son diferentes
		// Esperado: false
		System.out.println("¿A es igual a B? " + conjuntoA.equals(conjuntoB));

		// Creamos un conjunto C con algunos elementos de A y B
		ConjuntoEntero conjuntoC = new ConjuntoEntero();
		conjuntoC.insertarElemento(10);
		conjuntoC.insertarElemento(20);

		// Mostramos C
		// Esperado: 10 20
		System.out.println("Conjunto C: " + conjuntoC.aStringConjunto());

		// B y C son diferentes
		// Esperado: false
		System.out.println("¿B es igual a C? " + conjuntoB.equals(conjuntoC));

		// PRUEBA 4: Modificacion y nueva comparacion
		// Eliminamos elementos unicos de B para hacerlo igual a C
		conjuntoB.eliminarElemento(25);
		conjuntoB.eliminarElemento(30);

		// Mostramos B actualizado
		// Esperado: 10 20 (igual que C)
		System.out.println("\nConjunto B actualizado: " + conjuntoB.aStringConjunto());

		// Ahora B y C deberian ser iguales
		// Esperado: true
		System.out.println("¿B es igual a C ahora? " + conjuntoB.equals(conjuntoC));

		// PRUEBA 5: Conjunto vacio
		System.out.println("\n=== PRUEBAS CON CONJUNTO VACIO ===");
		ConjuntoEntero conjuntoVacio = new ConjuntoEntero();

		// Mostrar conjunto vacio
		// Esperado: (cadena vacia)
		System.out.println("Conjunto vacio: " + conjuntoVacio.aStringConjunto());

		// Union con vacio: debe dar el mismo conjunto
		// Esperado: 5 10 15 20 (igual que A)
		System.out.println("Union con vacio: " + conjuntoA.union(conjuntoVacio).aStringConjunto());

		// Interseccion con vacio: debe dar vacio
		// Esperado: (cadena vacia)
		System.out.println("Interseccion con vacio: " + conjuntoA.interseccion(conjuntoVacio).aStringConjunto());

		// PRUEBA 6: Manejo de errores
		System.out.println("\n=== PRUEBAS CON ELEMENTOS INVALIDOS ===");
		// Intentamos insertar numeros fuera de rango
		// Esperado: Mensajes de error para ambos casos
		conjuntoA.insertarElemento(-5); // Numero negativo -> Error
		conjuntoA.insertarElemento(150); // Numero mayor a 100 -> Error
	}
}