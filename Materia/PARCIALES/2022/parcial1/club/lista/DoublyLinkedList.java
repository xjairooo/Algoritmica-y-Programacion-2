/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lista;

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DoublyLinkedList<E> {

	// ---------------- nested Node class ----------------
	/**
	 * Node of a doubly linked list, which stores a reference to its element and to
	 * both the previous and next node in the list.
	 */
	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the preceding node in the list */
		private Node<E> prev; // reference to the previous node in the list

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param p reference to a node that should precede the new node
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		// public accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that precedes this one (or null if no such node).
		 * 
		 * @return the preceding node
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Update methods
		/**
		 * Sets the node's previous reference to point to Node n.
		 * 
		 * @param p the node that should precede this one
		 */
		public void setPrev(Node<E> p) {
			prev = p;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	/** Sentinel node at the beginning of the list */
	private Node<E> header; // header sentinel

	/** Sentinel node at the end of the list */
	private Node<E> trailer; // trailer sentinel

	/** Number of elements in the list (not including sentinels) */
	private int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() {
		header = new Node<>(null, null, null); // create header
		trailer = new Node<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer
	}

	// public accessor methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list.
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		if (isEmpty())
			return null;
		return header.getNext().getElement(); // first element is beyond header
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement(); // last element is before trailer
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); // place just after the header
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		if (isEmpty())
			return null; // nothing to remove
		return remove(header.getNext()); // first element is beyond header
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		if (isEmpty())
			return null; // nothing to remove
		return remove(trailer.getPrev()); // last element is before trailer
	}

	// private update methods
	/**
	 * Adds an element to the linked list in between the given nodes. The given
	 * predecessor and successor should be neighboring each other prior to the call.
	 *
	 * @param predecessor node just before the location where the new element is
	 *                    inserted
	 * @param successor   node just after the location where the new element is
	 *                    inserted
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	/**
	 * Removes the given node from the list and returns its element.
	 * 
	 * @param node the node to be removed (must not be a sentinel)
	 */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = header.getNext();
		while (walk != trailer) {
			sb.append(walk.getElement());
			walk = walk.getNext();
			if (walk != trailer)
				sb.append(", ");
		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * Intercambia dos elementos de la lista
	 * 
	 * @param x: ubicaci�n del primer elemento a intercambiar
	 * @param y: ubicaci�n del segundo elemento a intercambiar
	 * 
	 * Por ejemplo dada la siguiente lista: {A, B, C, D}
	 * 
	 * swap(0,3) => {D, B, C, A}
	 * swap(2,1) => {A, C, B, D}
	 * swap(2,2) => {A, B, C, D} (no realiza ning�n cambio)
	 * 
	 * Si los �ndices est�n fuera de rango lanza la excepci�n 
	 * IndexOutOfBoundsException
	 * 
	 * Nota: este m�todo intercambia los elementos de una lista dada. No crea una
	 * lista nueva
	 * 
	 */

	public void swap(int x, int y) {
		if (x < 0 || x > size)
			throw new IndexOutOfBoundsException("Indice x fuera de rango");
		if (y < 0 || y > size)
			throw new IndexOutOfBoundsException("Indice y fuera de rango");
		if (x == y)
			return;
		int z;
		if (x > y) {
			z = x;
			x = y;
			y = z;
		}
		int i = 0;
		Node<E> walk = header.getNext();
		Node<E> aux = walk;
		while (i < y) {
			if (i == x)
				aux = walk;
			i++;
			walk = walk.getNext();
		}
		
		// Versi�n 1
		// Moviendo el contenido de los nodos
		/*
		E element = aux.element;
		aux.element = walk.element;
		walk.element = element;
		*/
		
		// Versi�n 2
		// Moviendo los punteros de los nodos
		/*
		Node<E> auxPrev = aux.prev;
		Node<E> auxNext = aux.next;
		
		aux.prev = walk.prev;
		aux.next = walk.next;
		walk.prev.next = aux;
		walk.next.prev = aux;
		
		walk.prev = auxPrev;
		walk.next = auxNext;
		auxPrev.next = walk;
		auxNext.prev = walk;
		*/
				
		// Versi�n 3
		// Creando nuevos nodos y removiendo los existentes		
		addBetween(aux.getElement(), walk, walk.getNext());
		E element = remove(walk);
		addBetween(element, aux, aux.getNext());
		remove(aux);		
	}
	
} // ----------- end of DoublyLinkedList class -----------
