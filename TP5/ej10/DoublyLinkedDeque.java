package ej10;

public class DoublyLinkedDeque<E> implements Deque<E> {

    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    /**
     * Returns the number of elements in the deque.
     * 
     * @return number of elements in the deque
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Tests whether the deque is empty.
     * 
     * @return true if the deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns (but does not remove) the first element of the deque.
     * 
     * @return first element of the deque (or null if empty)
     */
    @Override
    public E first() {
        return list.first();
    }

    /**
     * Returns (but does not remove) the last element of the deque.
     * 
     * @return last element of the deque (or null if empty)
     */
    @Override
    public E last() {
        return list.last();
    }

    /**
     * Inserts an element at the front of the deque.
     * 
     * @param e the new element
     */
    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    /**
     * Inserts an element at the back of the deque.
     * 
     * @param e the new element
     */
    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    /**
     * Removes and returns the first element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    /**
     * Removes and returns the last element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    @Override
    public E removeLast() {
        return list.removeLast();
    }
}
