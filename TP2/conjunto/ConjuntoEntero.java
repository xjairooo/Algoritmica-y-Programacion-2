package conjunto;

import java.util.Arrays;

public class ConjuntoEntero {

	// final = significa q esa constate no va a cambiar
	private static final int MAX = 101;

	// Declara un array boolean
	private boolean conjunto[];

	// Inicializa el arreglo boolean
	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
	}

	// Implementar
	public void insertarElemento(int i) {
		conjunto[i] = true;
	}

	// Implementar
	public void eliminarElemento(int i) {

	}

	// Implementar
	public ConjuntoEntero union(ConjuntoEntero c) {
		return null;
	}

	// Implementar
	public ConjuntoEntero interseccion(ConjuntoEntero c) {
		return null;
	}

	// Implementar
	public ConjuntoEntero diferencia(ConjuntoEntero c) {
		return null;
	}

	// Implementar
	/*
	 * public String toString() {
	 * // String s = "";
	 * for (int i = 0; i < MAX;i++)
	 * if (conjunto[i])
	 * // s+= i + " ";
	 * return null;
	 * }
	 */

	// Generado con Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conjunto);
		return result;
	}

	// Generado con Eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjuntoEntero other = (ConjuntoEntero) obj;
		if (!Arrays.equals(conjunto, other.conjunto))
			return false;
		return true;
	}

}
