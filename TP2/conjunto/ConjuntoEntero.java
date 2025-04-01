package conjunto;

import java.util.Arrays;

/**
 * La clase que representa un conjunto de numeros enteros en el rango 0-100.
 * Implementa operaciones basicas de conjuntos usando un arreglo tipo boolean.
 * 
 * @author Jairo, Alexis y Jose
 */
public class ConjuntoEntero {

	/**
	 * Tamaño MAX del conjunto (101 elementos para cubrir 0-100 inclusive)
	 */
	private static final int MAX = 101;

	/**
	 * Arreglo que almacena los elementos del conjunto.
	 */
	private boolean conjunto[];

	/**
	 * Constructor que inicializa un conjunto vacio.
	 * Todos los valores se establecen a false inicialmente.
	 */
	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
		for (int i = 0; i < conjunto.length; i++) {
			conjunto[i] = false;
		}
	}

	/**
	 * Inserta un numero en el conjunto marcando su posicion como true.
	 * 
	 * @param k El numero a insertar (debe estar en el rango[0, 100])
	 */
	public void insertarElemento(int k) {
		if (k >= 0 && k < MAX) {
			conjunto[k] = true;
		} else {
			System.out.println("Error: " + k + " esta fuera del rango [0, 100].");
		}
	}

	/**
	 * Elimina un numero del conjunto marcando su posicion como false.
	 * 
	 * @param k El numero a eliminar (debe estar en el rango[0, 100])
	 */
	public void eliminarElemento(int k) {
		if (k >= 0 && k < MAX) {
			conjunto[k] = false;
		} else {
			System.out.println("Error: " + k + " esta fuera del rango [0, 100].");
		}
	}

	/**
	 * Union (A ∪ B).
	 * Realiza la union entre este conjunto y otro.
	 * 
	 * @param otro El conjunto con el que se realizara la union
	 * @return Nuevo conjunto con la unión de ambos
	 */
	public ConjuntoEntero union(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] || otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Interseccion (A ∩ B)
	 * Realiza la interseccion entre este conjunto y otro.
	 * 
	 * @param otro El conjunto con el que se realizara la interseccion
	 * @return Nuevo conjunto con los elementos comunes
	 */
	public ConjuntoEntero interseccion(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] && otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Diferencia (A - B) o (B - A)
	 * Realiza la diferencia entre este conjunto y otro.
	 * 
	 * @param otro El conjunto que se restara
	 * @return Nuevo conjunto con los elementos de este que no estan en el otro
	 */
	public ConjuntoEntero diferencia(ConjuntoEntero otro) {
		ConjuntoEntero resultado = new ConjuntoEntero();
		for (int i = 0; i < MAX; i++) {
			resultado.conjunto[i] = this.conjunto[i] && !otro.conjunto[i];
		}
		return resultado;
	}

	/**
	 * Genera una representacion en String del conjunto.
	 * 
	 * @return String con los numeros del conjunto separados por espacios
	 */
	public String aStringConjunto() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MAX; i++) {
			if (conjunto[i]) {
				// Agrega el elemento al StringBuilder si es parte del conjunto
				// Se agrega un espacio entre los elementos
				sb.append(i).append(" ");
			}
		}
		// Convierte el StringBuilder a String y elimina el espacio final
		return sb.toString().trim();
	}

	/**
	 * Calcula el codigo hash para el conjunto.
	 * 
	 * @return Codigo hash basado en los elementos del conjunto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conjunto);
		return result;
	}

	/**
	 * Compara este conjunto con otro objeto para determinar igualdad.
	 * 
	 * @param obj El objeto a comparar
	 * @return true si son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		ConjuntoEntero other = (ConjuntoEntero) obj;
		return Arrays.equals(conjunto, other.conjunto);
	}
}