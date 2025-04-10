/**
 * Clase Lista
 * 
 * @author Jairo, Alexis y Juan
 */
package TP3.lista.src;
public class Lista<E> {
	private E lista[];
	private int indice;
	private final int MAXELEM;	// no puede cambiar de valor

	public Lista(int n) {
		lista = (E[]) new Object[n];
		MAXELEM = n;
		indice = 0;
		System.out.println("Lista creada con capacidad para " + n + " elementos.");
	}
	public Lista() {
		this(10); // por defecto, la lista tiene capacidad para 10 elementos
	}

	/** Agrega un elemento al final de la lista 
	 * @param e el elemento a agregar
	*/
	public void add(E e) throws IndexOutOfBoundsException {
		// Si la lista esta llena, lanza una IndexOutOfBoundsException
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		// Si la lista esta vacia, agrega el elemento en la posicion 0
			lista[indice++] = e;
	}
	
	/** Agrega un elemento a la lista en la posición p 
	 * @param p la posición donde se quiere agregar el elemento
	 * @param e el elemento a agregar
	*/
	public void add(int p, E e) throws IndexOutOfBoundsException {
		// Si la posición es inválida, lanza una IndexOutOfBoundsException
		if (p < 0 || p > indice)
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		// Si la lista esta llena, lanza una IndexOutOfBoundsException
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		// Desplaza los elementos a la derecha para hacer espacio al nuevo elemento
		for (int i = indice; i > p; i--)
			lista[i] = lista[i - 1];
		lista[p] = e;
		indice++;
	}

	/** Retorna el elemento que se encuentra en p 
	 * 
	 * @throws IndexOutOfBoundsException si p es menor a 0 o mayor o igual a indice
	 */
	
	public E get(int p) throws IndexOutOfBoundsException {		
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
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
	 *  Remueve el elemento que se encuentra en la posición p
	 *  @param p la posición del elemento a remover
	 *  @return el elemento removido
	 */
	public E remove(int p) throws IndexOutOfBoundsException {
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		E e = lista[p];
		// Desplaza los elementos a la izquierda para llenar el espacio
		for (int i = p; i < indice - 1; i++)
			lista[i] = lista[i + 1];
		indice--;
		return e;
	}
	
	public String toString(){
		String s = "";
		for(int i=0; i<indice; i++)
			s +=lista[i]+"\n";
		return s;
		 
	}
}
