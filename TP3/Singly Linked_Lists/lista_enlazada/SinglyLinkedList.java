package lista_enlazada;
public class SinglyLinkedList<E>{
    private static class Node<E> {
        private E elemento;
        private Node<E> next;
        public Node(E e, Node<E> n){
            elemento = e;
            next = n;
        
        }

        public E getElemento() {return elemento;}
        public Node<E> getNext() {return next;}
        public void setNext(Node<E> n) {next = n;}
        }
        // -------- Fin nodo --------
        
        // Atributos de la clase SinglyLinkedLists
        private Node<E> head = null;    // Referencia al primer nodo de la lista
        private Node<E> tail = null;    // Referencia al ultimo nodo de la lista
        private int size = 0;           // Cantidad de elementos en la lista
        
        // Constructor
        public SinglyLinkedList(){};

        // Acceso a metodos
        /**
         * @return size Cantidad de elementos en la lista
         */
        public int size() {return size;}
        
        /**
         * @return Verifica si la lista esta vacia devuelve true, false en caso contrario
         */
        public boolean isEmpty() {return size == 0;}
        
        /**
         * @return Retorna el primer elemento de la lista (o NULL si la lista esta vacia)
         */
        public E first() {
            if (isEmpty()) return null;
            return head.getElemento();
        }

        /**
         * @return Retorna el ultimo elemento de la lista (o NULL si la lista esta vacia)
         */
        public E last() {
            if (isEmpty()) return null;
            return tail.getElemento();
        }

        //---- Actualizar metodos ----

        /**
         * Inserta un elemento al inicio de la lista
         * @param e Elemento a insertar
         */
        public void addFirst(E e) {
            head = new Node<>(e, head); // Crea un nuevo nodo y lo enlaza al inicio
            if (size == 0) {            // Si la lista estaba vacia, el nuevo nodo es el tail
                tail = head;
            }
            size++;                     // Aumenta el tamaño de la lista
        }

        /**
         * Inserta un elemento al final de la lista
         * @param e Elemento a insertar
         */
        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null); 
            // Verifica si la lista esta vacia
            if (isEmpty()) {
                head = newest;
            } else {
                tail.setNext(newest);
            }
            tail = newest;
            size++;
        }

        /**
         * Elemina y devuelve el primer elemento de la lista. Si la lista queda vacia,
         * tambien se actualiza el tail a null.
         * @return answer Retorna el primer elemento de la lista y lo elimina de la misma
         */
        public E removeFirst() {
            if (isEmpty()) return null;
            E answer = head.getElemento();
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
            return answer;
        }

        // ---- Agregar logica a metodos ----

        /* Insertar el elemento e en la posicion n de la lista */
        public void addPos(E e, int n) throws IndexOutOfBoundsException{
            // Verifica si la posicion es valida dentro del rango de la lista
            if (n < 0 || n > size) throw new IndexOutOfBoundsException("Posicion no valida: " + n);
            
            // Si la posicion es 0, se agrega al inicio
            if (n == 0 ){ 
                addFirst(e);
            } else if (n == size){  // Si la posicion es igual al tamaño, se agrega al final
                addLast(e);
            } else { // Si la posicion es valida, se agrega en el medio
                Node<E> current = head; // Se inicia desde el primer nodo
                for (int i = 0; i < n - 1; i++) { // Se recorre hasta la posicion anterior
                    current = current.getNext();
                }
                Node<E> newest = new Node<>(e, current.getNext()); // Se crea el nuevo nodo
                current.setNext(newest); // Inserta el nuevo nodo en la posicion
                size++; // Incrementa el tamaño de la lista
            }
        }

        /**
         *  Elemina el primer nodo que contiene el elemento especificado 'e' y lo devuelve
         *  Si el elemento no se encuentra, retorna 'null'
         * 
         * @param e Elemento a eliminar de la lista
         * @return Elemento eliminado si se encuentra, o 'null' si no esta lista
         */
        public E removeElement (E e){
            if (isEmpty()) return null; // Si la lista esta vacia, retorna null

            // Caso especial: el elemento esta en el primer nodo
            if (head.getElemento().equals(e)) {
                return removeFirst(); // Llama al metodo removeFirst, para eliminar el primer nodo
            }

            Node<E> current = head; // Nodo actual para recorrer la lista
            Node<E> previous = null; // Nodo anterior al actual
            
            // Recorre la lista buscando el nodo que contiene el elemento 'e'
            while (current != null) {
                if (current.getElemento().equals(e)) {  // Si encuentra el elemento
                    // Si el elemento se encuentra en el nodo actual, lo elimina
                    if (previous == null) {
                        head = head.getNext();
                    } else {
                        // Salta el nodo actual ajustando la referencia del nodo anterior
                        previous.setNext(current.getNext());
                    }
                    if (current == tail) {
                        // Si el nodo eleminado es el tail(cola/ultimo), actualiza el tail al nodo anterior
                        tail = previous;
                    }
                    size--; // Decrementa el tamaño de la lista
                    return current.getElemento(); // Retorna el elemento eliminado
                }
                // Si no lo encuentra, avanza al siguiente nodo
                previous = current;
                current = current.getNext();
            }
            return null;
        }

        /**
         * Elemina elemento que se encuentra en la posicion 'n' de la lista 
         * Si la posicion no es valida, lanza una excepcion
         * 
         * @param n Posicion del elemento a eliminar
         * @return Elemento eliminado de la lista si la posicion es valida, o lanza una excepcion si no lo es
         * @throws IndexOutOfBoundsException Si la posicion esta fuera de rango de la lista
         */
        public E removePos (int n) throws IndexOutOfBoundsException{
            // Verifica si la posicion es valida dentro del rango de la lista
            if (n < 0 || n >= size) throw new IndexOutOfBoundsException("Posicion no valida: " + n);
            
            if (n == 0) return removeFirst(); // Caso especial: eliminar el primer nodo
                
            Node<E> current = head; // Nodo actual para recorrer la lista
            for (int i = 0; i < n - 1; i++) { // Recorre hasta el nodo anterior al que se va a eliminar
                // Guarda el nodo actual en la variable 'current'
                current = current.getNext();
                
            }

            Node<E> nodeToRemove = current.getNext(); // Nodo a eliminar
            E removedElement = nodeToRemove.getElemento(); // Elemento a eliminar

            // Ajusta las referencias para eliminar el nodo
            current.setNext(nodeToRemove.getNext()); // Salta el nodo a eliminar

            // Si el nodo a eliminar es el tail, actualiza el tail
            if (nodeToRemove == tail) {
                tail = current; // Actualiza el tail al nodo anterior
            }
            size--; // Decrementa el tamaño de la lista
            return removedElement; // Retorna el elemento eliminado
        }

        /**
         * Inserta todos los elementos de la Lista l al final de la lista 
         * 
         * @param l Lista cuyos elementos se concatenaran al final de la lista actual
        */
        public void concatenate (SinglyLinkedList<E> l) {
            if (l.isEmpty()) return; // Si la lista es nula o vacia, no hace nada

            if(this.isEmpty()){
                // Si lista actual es vacia, simplemente copia los nodos de 'l'
                this.head = l.head;
                this.tail = l.tail;
                this.size = l.size; 
            } else {
                // Si la lista actual no es vacia, enlaza el tail de la lista actual con el head de 'l'
                this.tail.setNext(l.head);
                this.tail = l.tail; // Actualiza el tail de la lista actual
                this.size += l.size; // Aumenta el tamaño de la lista actual
            }
        }

        /** Busca el elemento 'e' dentro de la lista 
         * Retorna el elemento si se encuentra, o NULL si no esta en la lista 
         * 
         * @param e Elemento a buscar en la lista
         * @return El elemento si se encuentra, o NULL si no esta en la lista
        */
        public E search (E e){
            if (isEmpty()) return null; // Si la lista esta vacia, retorna null
            // Caso especial: el elemento esta en el primer nodo
            if (head.getElemento().equals(e)) {
                // Si el elemento es igual al primer nodo, retorna el elemento
                return head.getElemento();
            }
            Node<E> current = head; // Nodo actual para recorrer la lista
            while (current != null) { // Recorre la lista hasta el final
                if (current.getElemento().equals(e)) { // Si encuentra el elemento
                    return current.getElemento(); // Retorna el elemento encontrado
                }
                current = current.getNext(); // Avanza al siguiente nodo
            }
            return null; // Si no encuentra el elemento, retorna null
        }

        @Override
        /* Verifica si dos listas son iguales */
        public boolean equals (Object o){
            if (this == o) return true; // Si son la misma referencia, son iguales
            if (!(o instanceof SinglyLinkedList)) return false; // Si no son del mismo tipo, no son iguales

            SinglyLinkedList<?> other = (SinglyLinkedList<?>) o; // Convierte el objeto a SinglyLinkedLists
            if (this.size != other.size) return false; // Si los tamaños son diferentes, no son iguales

            Node<E> currentA = this.head; // Nodo actual de la lista A
            Node<?> currentB = other.head; // Nodo actual de la otra lista B

            while(currentA != null && currentB != null) { // Recorre ambas listas
                if (!currentA.getElemento().equals(currentB.getElemento())) { // Si los elementos son diferentes
                    return false; // No son iguales
                }
                currentA = currentA.getNext(); // Avanza al siguiente nodo de la lista A
                currentB = currentB.getNext(); // Avanza al siguiente nodo de la lista B
            }
            return true;
        }

        @Override
        /* Retorna una copia de una lista dada */
        public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
            SinglyLinkedList<E> newList = new SinglyLinkedList<>(); // Crea una nueva lista clonada
            Node<E> current = this.head; // Nodo actual para recorrer la lista original
            while (current != null) { // Recorre la lista original
                newList.addLast(current.getElemento()); // Agrega el elemento al final de la lista clonada
                current = current.getNext(); // Avanza al siguiente nodo
            }
            return newList; // Retorna la lista clonada
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena
            Node<E> current = head; // Nodo actual para recorrer la lista
            sb.append("[");
            while (current != null) { // Recorre la lista
                sb.append(current.getElemento()); // Agrega el elemento al StringBuilder
                current = current.getNext(); // Avanza al siguiente nodo
                if (current != null) { // Si no es el ultimo nodo, agrega una coma
                    sb.append(" -> ");
                }
            }
            sb.append("]"); // Cierra la cadena con corchetes
            return sb.toString(); // Retorna la cadena construida       
        }    
}
