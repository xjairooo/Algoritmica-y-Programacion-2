package ej9;

public class ArrayCircularDeque<E> implements Deque<E> {
    private E data[];
    private int size;
    private int front;
    private int rear;
    private int capacity;

    @SuppressWarnings("unchecked") // "Silence" the warning
    public ArrayCircularDeque(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Returns the number of elements in the deque.
     * 
     * @return number of elements in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tests whether the deque is empty.
     * 
     * @return true if the deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the deque.
     * 
     * @return first element of the deque (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    /**
     * Returns (but does not remove) the last element of the deque.
     * 
     * @return last element of the deque (or null if empty)
     */
    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return data[(rear - 1 + capacity) % capacity];
    }

    /**
     * Inserts an element at the front of the deque.
     * 
     * @param e the new element
     */
    @Override
    public void addFirst(E e) {
        if (size == capacity) {
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + capacity) % capacity; // Move front circulary
        data[front] = e;
        size++;
    }

    /**
     * Inserts an element at the back of the deque.
     * 
     * @param e the new element
     */
    @Override
    public void addLast(E e) {
        if (size == capacity) {
            throw new IllegalStateException("Deque is full");
        }
        data[rear] = e;
        rear = (rear + 1) % capacity;
        size++;
    }

    /**
     * Removes and returns the first element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E temp = data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    /**
     * Removes and returns the last element of the deque.
     * 
     * @return element removed (or null if empty)
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        rear = (rear - 1 + capacity) % capacity;
        E temp = data[rear];
        data[rear] = null;
        size--;
        return temp;
    }
}
