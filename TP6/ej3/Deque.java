package ej3;

import java.util.ArrayList;

public class Deque<E> {

    private ArrayList<E> data;

    public Deque() {
        data = new ArrayList<>();
    }

    /**
     * Returns the number of elements in the deque.
     * 
     * @return number of elements in the deque
     */
    public int size() {
        return data.size();
    }

    /**
     * Tests whether the deque is empty.
     * 
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns (but does not remove) the first element of the deque.
     * 
     * @return first element of the deque (or null if empty)
     */
    public E first() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque esta vacio");
        }
        return data.get(0);
    }

    /**
     * Returns (but does not remove) the last element of the deque.
     * 
     * @return last element of the deque (or null if empty)
     */
    public E last() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque esta vacio");
        }
        return data.get(data.size() - 1);
    }

    /**
     * Inserts an element at the front of the deque.
     * 
     * @param e the new element
     */
    public void addFirst(E e) {
        data.add(0, e);
    }

    /**
     * Inserts an element at the back of the deque.
     * 
     * @param e the new element
     */
    public void addLast(E e) {
        data.add(e);
    }

    /**
     * Removes and returns the first element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque esta vacia");
        }
        return data.remove(0);
    }

    /**
     * Removes and returns the last element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque esta vacia");
        }
        return data.remove(data.size() - 1);
    }

    public void clear() {
        data.clear();
    }
}
