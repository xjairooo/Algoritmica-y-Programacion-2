public class Conjunto<T> {
	private T[] data;
	private int p;

	public Conjunto(int capacity) {
		data = (T[]) new Object[capacity]; // legal, but compiler warning
		p = 0;
	}

	/**
     * Inserta un elemento al conjunto si el mismo no esta.
     * Si se supera la capacidad del conjunto o el elemento ya existe, lanza una excepción.
     * 
     * @param d elemento a insertar
     * @throws IllegalStateException si el conjunto esta lleno
     * @throws IllegalArgumentException si el elemento ya existe en el conjunto
     */
    public void insertarElemento(T d) {
        if (p >= data.length) {
            throw new IllegalStateException("No se puede insertar el elemento " + d + " porque el conjunto esta lleno.");
        }
        if (find(d)) {
            throw new IllegalArgumentException("El elemento " + d + " ya existe en el conjunto.");
        }
        data[p] = d; // Inserta el elemento en la posicion p
        p++; // Aumenta el contador de elementos
    }

	/**
	 * Retorna la cantidad de elementos de un conjunto
	 * 
     * @return p cantidad de elementos en el conjunto
	 */
	public int cardinalidad() {
		return p; // Retorna la cantidad de elementos en el conjunto
	}

	/**
	 * Retorna un nuevo conjunto con la union del conjunto actual con el conjunto c
	 * 
     * @param c conjunto a unir
     * @throws IllegalArgumentException si el conjunto c es null
     * @return un nuevo conjunto con la union de ambos conjuntos
	 */
	public Conjunto<T> union(Conjunto<T> c) {
        if (c == null) throw new IllegalArgumentException("El conjunto no puede ser null.");
    
        Conjunto<T> unionConjunto = new Conjunto<>(this.cardinalidad() + c.cardinalidad());
    
        // Agregar los elementos del conjunto actual
        for (int i = 0; i < this.p; i++) {
            unionConjunto.insertarElemento(this.data[i]);
        }
    
        // Agregar los elementos del conjunto c, verificando duplicados
        for (int i = 0; i < c.p; i++) {
            if (!unionConjunto.find(c.data[i])) { // Verifica si el elemento ya esta en el conjunto resultante
                unionConjunto.insertarElemento(c.data[i]);
            }
        }
    
        return unionConjunto;
    }

	/**
	 * Retorna un nuevo conjunto con la interseccion del conjunto actual con el
	 * conjunto c
	 * 
     * @param c conjunto a intersectar
     * @throws IllegalArgumentException si el conjunto c es null
     * @return un nuevo conjunto con la interseccion de ambos conjuntos
	 */
	public Conjunto<T> interseccion(Conjunto<T> c) {
        // No se puede intersectar con un conjunto nulo
        if (c == null) throw new IllegalArgumentException("El conjunto c no puede ser null", null);
        // Compara la cardinalidad de ambos conjuntos y crea un nuevo conjunto con la menor capacidad (Math.min)
        Conjunto<T> interseccionConjunto = new Conjunto<>(Math.min(this.cardinalidad(), c.cardinalidad())); // Crear un nuevo conjunto con la capacidad minima de ambos conjuntos
        /*
         * Recorre el conjunto actual y verifica si los elementos estan en el conjunto c
         * Si el elemento se encuentra en el conjunto c, se agrega al nuevo conjunto 'interseccionConjunto'
         */
        for (int i = 0; i < this.cardinalidad(); i++) {
            if (c.find(this.data[i])) {
                interseccionConjunto.insertarElemento(this.data[i]); // Agregar el elemento al nuevo conjunto si se encuentra en el conjunto c
            }
        }
        return interseccionConjunto;
	}

	/**
	 * Retorna si dos conjuntos tienen los mismos elementos
	 * 
     * @param c conjunto a comparar
     * @return true si los conjuntos son iguales, false si no son iguales
	 */
	public boolean iguales(Conjunto<T> c) {
		/*
         * Verifica si:
         *  - Si el conjunto c es null 
         *  - La cardinalidad de ambos conjuntos no es la misma
         */
        if (c == null || this.cardinalidad() != c.cardinalidad()) {
			return false;
		}
        /*
         * Verifica si:
         *   - Si los elementos del conjunto actual no se encuentran en el conjunto c
         */
		for (int i = 0; i < p; i++) {
			if (!c.find(data[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Retorna si un elemento esta en el conjunto
	 * Osea si el conjunto contiene al elemento retorna true, en caso contrario false 
     * @param find elemento a buscar
     * @throws IllegalArgumentException si el elemento a buscar es null
     * @return true si el elemento se encuentra en el conjunto, false en caso contrario
	 */
	private boolean find(T find) {
         // No se puede buscar un elemento nulo
        if (find == null) throw new IllegalArgumentException("El elemento que se busca no puede ser null", null);
        /* Recorre el conjunto y busca el elemento
         * Verifica si:
         * - Si el elemento se encuentra en el conjunto, retorna true
         * - Si no se encuentra, retorna false
         */
        for (int i = 0; i < p; i++) {
            if (data[i].equals(find)) {
                return true; // El elemento se encuentra en el conjunto
            }
        }
        return false;
	}

    /**
     * StringBuilder para crear una cadena con los elementos del conjunto
     * Ejemplo de imprimecion: { 1, 2, 3, 4, 5 }
     * @return cadena con los elementos del conjunto
    */
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder("{ "); 
        for (int i = 0; i < p; i++) {
            sb.append(data[i]);
            // Verifica si no es el ultimo elemento para agregar una coma
            if (i < p - 1) {
                sb.append(", "); // Agrega una coma entre los elementos
            }
        }
        sb.append(" }"); // Cierra el conjunto
		return sb.toString(); // Retorna el conjunto como una cadena
	}

}
