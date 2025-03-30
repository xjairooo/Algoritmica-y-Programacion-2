package conjunto;

import java.util.Arrays;

public class ConjuntoEntero {

	/**
	 * final = significa q esa constate no va a cambiar
	 * El arreglo conjunto tiene 101 elementos (índices de 0 a 100)
	 * para cubrir el rango de 0 a 100
	 */
	private static final int MAX = 101;

	// Declara un array boolean
	private boolean conjunto[];

	// Inicializa el arreglo boolean para armar un conjunto vacio
	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
		for (int i = 0; i < conjunto.length; i++) {
			conjunto[i] = false; // Inicializa todos los elementos en falso (no está en el conjunto) }
		}
	}

	/**
	 * Inserta un entero k en el conjunto (lo marca como "true").
	 * 
	 * @param k El número a insertar (debe estar entre 0 y 100).
	 */
	public void insertarElemento(int k) {
		if (k >= 0 && k < MAX) { // Verifica que k esté en el rango válido.
			conjunto[k] = true; // Marca el número como presente.
		} else {
			System.out.println("Error: " + k + " está fuera del rango [0, 100].");
		}
	}

	/**
	 * Similar al anterior metodo solo que ahora devuelve false en ves de true
	 * Elimina un entero k del conjunto (lo marca como "false").
	 * 
	 * @param k El número a eliminar (debe estar entre 0 y 100).
	 */
	public void eliminarElemento(int k) {
		if (k >= 0 && k < MAX) { // Verifica que k esté en el rango válido.
			conjunto[k] = false; // Marca el número como ausente.
		} else {
			System.out.println("Error: " + k + " está fuera del rango [0, 100].");
		}
	}

	// Implementar
	public ConjuntoEntero union(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero(); // Crea un nuevo conjunto
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] || otro.conjunto[i];
		}
		return resultado;
	}

	// Implementar
	public ConjuntoEntero interseccion(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = conjunto[i] && otro.conjunto[i];
		}

		return resultado;
	}

	// Implementar
	public ConjuntoEntero diferencia(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] && !otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Devuelve los numeros del conjunto como texto separado osea por espacios.
	 * Ejemplo: "3 7 10" para un conjunto con {3, 7, 10}.
	 */
	public String aStringConjunto() {
		// "constructorTexto" es nuestro StringBuilder (construye texto eficientemente)
		// StringBuilder es un objeto que pertenece dentro de la clase de String
		StringBuilder constructorTexto = new StringBuilder();

		// Itera sobre cada número del rango [0, 100] y si estA en el conjunto, añade el
		// numero al StringBuilder.
		for (int numero = 0; numero < MAX; numero++) {
			if (conjunto[numero]) { // Si el número está en el conjunto
				constructorTexto.append(numero).append(" "); // Añade el número + espacio
			}
		}

		// Convierte a String y elimina el espacio final sobrante
		return constructorTexto.toString().trim();
	}

	/**
	 * Calcula un valor hash (código numérico único) para este conjunto.
	 * Este valor se basa en los números contenidos en el conjunto.
	 * 
	 * Reglas importantes:
	 * - Si dos conjuntos son iguales según equals(), deben tener el mismo hashCode
	 * - Conjuntos diferentes pueden tener el mismo hashCode (aunque es raro)
	 * 
	 * Ejemplo:
	 * Si tienes los números {3, 5} en el conjunto, hashCode generará un número
	 * como 32768 (el valor exacto depende de la fórmula). Otro conjunto con {3, 5}
	 * tendrá EL MISMO código.
	 * 
	 * @return Un código numérico que representa este conjunto
	 */
	@Override
	public int hashCode() {
		// Usamos el número primo 31 para calcular el hash porque:
		// 1. Es un número impar primo
		// 2. La multiplicación por 31 puede optimizarse en la JVM
		// 3. Reduce colisiones de hash
		final int prime = 31;

		// Valor inicial del hash (puede ser cualquier número, 1 es común)
		int result = 1;

		// Calcula el hash del arreglo 'conjunto' y lo combina con el resultado:
		// 1. Arrays.hashCode() genera un hash basado en los elementos del arreglo
		// 2. Se multiplica por 'prime' y se suma para mezclar mejor los bits
		result = prime * result + Arrays.hashCode(conjunto);

		// Retorna el código hash final
		return result;
	}

	/**
	 * Compara este conjunto con otro objeto para ver si son iguales.
	 * Dos conjuntos son iguales si contienen exactamente los mismos números.
	 * 
	 * @param obj El objeto a comparar (puede ser cualquier objeto)
	 * @return true si son iguales, false si son diferentes
	 * @throws ClassCastException si el objeto no es un ConjuntoEntero
	 */
	@Override
	public boolean equals(Object obj) {
		// Caso 1: ¿Es exactamente el mismo objeto en memoria?
		if (this == obj) {
			return true;
		}

		// Caso 2: ¿El objeto es null?
		if (obj == null) {
			return false;
		}

		// Caso 3: ¿Es de la misma clase exacta?
		if (getClass() != obj.getClass()) {
			return false;
		}

		// Ahora podemos hacer la conversión segura a ConjuntoEntero
		ConjuntoEntero other = (ConjuntoEntero) obj;

		// Comparación real: ¿Tienen los mismos números?
		// Arrays.equals() compara elemento por elemento en los arreglos
		return Arrays.equals(conjunto, other.conjunto);
	}

}
