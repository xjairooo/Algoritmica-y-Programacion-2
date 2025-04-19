package net.datastructures;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
   // ---------------- nested Node class ----------------
   /**
    * Node of a singly linked list, which stores a reference to its element and to
    * the subsequent node in the list (or null if this is the last node).
    */
   private static class Node<E> {

      /** The element stored at this node */
      private E element; // reference to the element stored at this node

      /** A reference to the subsequent node in the list */
      private Node<E> next; // reference to the subsequent node in the list

      /**
       * Creates a node with the given element and next node.
       *
       * @param e the element to be stored
       * @param n reference to a node that should follow the new node
       */
      public Node(E e, Node<E> n) {
         element = e;
         next = n;
      }

      // Accessor methods
      /**
       * Returns the element stored at the node.
       * 
       * @return the element stored at the node
       */
      public E getElement() {
         return element;
      }

      /**
       * Returns the node that follows this one (or null if no such node).
       * 
       * @return the following node
       */
      public Node<E> getNext() {
         return next;
      }

      // Modifier methods
      /**
       * Sets the node's next reference to point to Node n.
       * 
       * @param n the node that should follow this one
       */
      public void setNext(Node<E> n) {
         next = n;
      }
   } // ----------- end of nested Node class -----------

   // instance variables of the SinglyLinkedList
   /** The head node of the list */
   private Node<E> head = null; // head node of the list (or null if empty)

   /** The last node of the list */
   private Node<E> tail = null; // last node of the list (or null if empty)

   /** Number of nodes in the list */
   private int size = 0; // number of nodes in the list

   /** Constructs an initially empty list. */
   public SinglyLinkedList() {
   } // constructs an initially empty list

   // access methods
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
    * Returns (but does not remove) the first element of the list
    * 
    * @return element at the front of the list (or null if empty)
    */
   public E first() { // returns (but does not remove) the first element
      if (isEmpty())
         return null;
      return head.getElement();
   }

   /**
    * Returns (but does not remove) the last element of the list.
    * 
    * @return element at the end of the list (or null if empty)
    */
   public E last() { // returns (but does not remove) the last element
      if (isEmpty())
         return null;
      return tail.getElement();
   }

   // update methods
   /**
    * Adds an element to the front of the list.
    * 
    * @param e the new element to add
    */
   public void addFirst(E e) { // adds element e to the front of the list
      head = new Node<>(e, head); // create and link a new node
      if (size == 0)
         tail = head; // special case: new node becomes tail also
      size++;
   }

   /**
    * Adds an element to the end of the list.
    * 
    * @param e the new element to add
    */
   public void addLast(E e) { // adds element e to the end of the list
      Node<E> newest = new Node<>(e, null); // node will eventually be the tail
      if (isEmpty())
         head = newest; // special case: previously empty list
      else
         tail.setNext(newest); // new node after existing tail
      tail = newest; // new node becomes the tail
      size++;
   }

   /**
    * Removes and returns the first element of the list.
    * 
    * @return the removed element (or null if empty)
    */
   public E removeFirst() { // removes and returns the first element
      if (isEmpty())
         return null; // nothing to remove
      E answer = head.getElement();
      head = head.getNext(); // will become null if list had only one node
      size--;
      if (size == 0)
         tail = null; // special case as list is now empty
      return answer;
   }

   @SuppressWarnings({ "unchecked" })
   public boolean equals(Object o) {
      if (o == null)
         return false;
      if (getClass() != o.getClass())
         return false;
      SinglyLinkedList other = (SinglyLinkedList) o; // use nonparameterized type
      if (size != other.size)
         return false;
      Node walkA = head; // traverse the primary list
      Node walkB = other.head; // traverse the secondary list
      while (walkA != null) {
         if (!walkA.getElement().equals(walkB.getElement()))
            return false; // mismatch
         walkA = walkA.getNext();
         walkB = walkB.getNext();
      }
      return true; // if we reach this, everything matched successfully
   }

   @SuppressWarnings({ "unchecked" })
   public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
      // always use inherited Object.clone() to create the initial copy
      SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
      if (size > 0) { // we need independent chain of nodes
         other.head = new Node<>(head.getElement(), null);
         Node<E> walk = head.getNext(); // walk through remainder of original list
         Node<E> otherTail = other.head; // remember most recently created node
         while (walk != null) { // make a new node storing same element
            Node<E> newest = new Node<>(walk.getElement(), null);
            otherTail.setNext(newest); // link previous node to this one
            otherTail = newest;
            walk = walk.getNext();
         }
         other.tail = otherTail;
      }
      return other;
   }

   public int hashCode() {
      int h = 0;
      for (Node walk = head; walk != null; walk = walk.getNext()) {
         h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's code
         h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite code
      }
      return h;
   }

   /**
    * Produces a string representation of the contents of the list. This exists for
    * debugging purposes only.
    */
   public String toString() {
      StringBuilder sb = new StringBuilder("(");
      Node<E> walk = head;
      while (walk != null) {
         sb.append(walk.getElement());
         if (walk != tail)
            sb.append(", ");
         walk = walk.getNext();
      }
      sb.append(")");
      return sb.toString();
   }

   /**
    * Crea una nueva lista y copia todos sus elementos
    *
    * @return lista nueva con una copia de la lista actual
    *
    */
   public SinglyLinkedList<E> duplicate() {
      // Crear una nueva lista vacia
      SinglyLinkedList<E> newlist = new SinglyLinkedList<>();

      // Si la lista esta vacia, devolver la nueva lista
      if (isEmpty())
         return newlist;

      Node<E> current = head;
      /*
       * Iterando mientras no lleguemos al final de la lista.
       * Agrega el elemento al final de la nueva lista, preservando el orden
       * orginal
       * Actualiza el nodo actual
       */
      while (current != null) {
         newlist.addLast(current.getElement());
         current = current.getNext();
      }
      return newlist;
   }

   /**
    * Retorna la lista con todos los elementos de la lista l insertados a partir de
    * la posición pos.
    *
    * Considere la opción de utilizar el método duplicate() o clone()
    *
    * No utilizar métodos que insertan de a un elemento como por ejemplo addPos(E,
    * p)
    *
    * Por ejemplo:
    *
    * Dada la lista: {A, B, C, D} y la lista l = {X, Y}
    *
    * addPos(l, 2) => {A, B, X, Y, C, D}
    *
    * addPos(l, 0) => {X, Y, A, B, C, D}
    *
    * addPos(l, 4) => {A, B, C, D, X, y}
    *
    * @param SinglyLinkedList<E> l : lista a insertar
    * @param SinglyLinkedList<E> pos : posición a partir de donde se inserta
    *
    *
    * @return lista original más todos los elementos de la lista l insertados a
    *         partir de la posición pos
    *
    * @exception Si los índices están fuera de rango lanza la excepción
    *               IndexOutOfBoundsException
    *
    */
   public void addList(SinglyLinkedList<E> l, int pos) throws IndexOutOfBoundsException {
      // Comprobar si esta dentro del rango
      if (pos < 0 || pos > size) {
         throw new IndexOutOfBoundsException("Posicion invalida" + pos);
      }
      // Si la lista l esta vacia, no hay nada que agregar
      if ((l.isEmpty()))
         return;

      // Crear una copia de la lista a insertar para no modificar la original
      SinglyLinkedList<E> other = l.duplicate();

      // Variables para recorrer la lista actual
      Node<E> current = head; // nodo actual
      Node<E> anterior = null; // nodo anterior
      int i = 0; // contador para la posicion

      // Avanzar hasta la posición donde se insertará la lista
      while (i < pos) {
         anterior = current; // Guardar referencia al nodo actual como previo
         current = current.getNext(); // Avanzar al siguiente nodo
         i++; // Incrementar contador de posición
      }

      if (anterior == null) { // Si la posicion es 0, se inserta al principio
         head = other.head; // La cabeza de la lista original apunta a la cabeza de la nueva lista
      } else {
         anterior.setNext(other.head); // El nodo anterior apunta a la cabeza de la nueva lista
         other.tail.setNext(current); // El nodo final de la nueva lista apunta al nodo actual
      }

      if (pos == size) { // Si la posicion es igual al tamaño, se actualiza la cola
         tail = other.tail; // La cola de la lista original apunta a la cola de la nueva lista
      }
      size += other.size; // Se actualiza el tamaño de la lista original

   }

}