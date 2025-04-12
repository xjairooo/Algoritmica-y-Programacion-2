package lista;
public class Lista<E> {

	private E lista[];
	private int indice;
	private final int MAXELEM;

	public Lista(int n) {
		lista = (E[]) new Object[n];
		MAXELEM = n;
		indice = 0;
	}

	/* Agrega un elemento al final de la lista */
	public void add(E e) throws IndexOutOfBoundsException {
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		
		lista[indice++] = e;
	}

	/** 
	 * Los elementos existentes desde la posicion indicada se desplazan hacia la derecha
 	 * para hacer espacio para el nuevo elemento.
 	 *
 	 * @param p La posicion en la que se desea insertar el elemento. Debe estar entre 0 y el tamaño actual de la lista (inclusive)
 	 * @param e El elemento que se desea agregar a la lista.
 	 * @throws IndexOutOfBoundsException Si la posicion especificada esta fuera del rango valido (0 <= p <= tamaño de la lista)
 	 *                                   o si la lista ya esta llena.
 	*/
	public void add(int p, E e) throws IndexOutOfBoundsException {
		// Verifica si p esta dentro del rango valido entre (0, indice)
		if (p < 0 || p > indice) 
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		// Verifica si la lista no esta llena
		if (indice == MAXELEM) 	
			throw new IndexOutOfBoundsException("Lista llena");
		// Recorre los elementos a la derecha ->, para hacer espacio e inserte el nuevo elemento
		for (int i = indice; i > p; i--) {
			lista[i] = lista[i - 1];
		}
		// Inserta el elemento en la posicion deseada
		lista[p] = e;
		// Incrementa el indice para saber cuantos elementos hay en la lista
		indice++;
	}

	/* Retorna el elemento que se encuentra en p */
	public E get(int p) throws IndexOutOfBoundsException {		
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice inválido: " + p);
		return lista[p];
	}

	/* Remueve el elemento E de la lista. Retorna null sino se encuentra */
	public E remove(E e) {
		boolean encontrado = false;
		int i;
		for (i = 0; i < indice && !encontrado; i++)
			if (lista[i].equals(e))
				encontrado = true;
		if (!encontrado)
			return null;
		return remove(i);
	}

	/** 
	 * Remueve el elemento que se encuentra en la posicion p 
	 * @param p Ingresa el indice del elemento a remover
	 * @return El elemento eliminado
	 * @throws IndexOutOfBoundsException Si la posicion especificada esta fuera 
	 * 									 del rango valido (0 <= p <= tamaño de la lista)
	*/
	public E remove(int p) throws IndexOutOfBoundsException {
		// Verificar si la posicion esta dentro del rango valido
		if (p < 0 || p >= indice) 
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		// Guarda el elemento que sera eliminado para retornarlo
		E eliminado = lista[p];
		// Desplazar los elementos hacia la izquierda <-, para llenar el espacio vacio
		for(int i = p; i < indice - 1; i++){
			lista[i] = lista[i + 1];	// Deszplaza e elimina el espacio vacio
		}

		// Limpia el ultimo elemento (ya que fue dezplazado)
		lista[indice - 1] = null;
		// Decrementa el indice para reflejar lo eleminado
		indice--;
		return eliminado;
	}

	/**
	 * Se agrego porque 'Assert.assertEquals' lo requiere para comparar listas,
	 * osea su contenido de las listas, no solo sus referencias. 
	 * Por esta razon se implemento el metodo equals de manera de sobreescribir el de la clase Object.
	 * 
	 * Conclusion: Con el metodo equals sobrescrito, ahora las pruebas pueden verificar correctamente
	 * si dos listas son equivalentes en su contenido. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Lista<?> otraLista = (Lista<?>) obj;

		if (this.indice != otraLista.indice) return false;

		for (int i = 0; i < this.indice; i++) {
			if (!this.lista[i].equals(otraLista.lista[i])) {
				return false;
			}
		}
		return true;
	}
	public String toString(){
		String s = "";
		for(int i=0; i<indice; i++)
			s +=lista[i]+"\n";
		return s;
		 
	}
}
