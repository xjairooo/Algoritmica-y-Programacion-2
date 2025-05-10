package ej8;

/*
 * Methods enqueue and dequeue
 * https://www.geeksforgeeks.org/introduction-to-circular-queue/
 */
public class ArrayCircularQueue<E> implements CircularQueue<E> {
    private E data[]; // Array to store elements
    private int size = 0; // Number of elements in the queue
    private int front = 0; // Index of the first element

    /**
     * Returns the number of elements in the queue.
     * 
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tests whether the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Inserts an element at the rear of the queue.
     * 
     * @param e the element to be inserted
     */
    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int rear = (front + size) % data.length;
        data[rear] = e;
        size++;
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * 
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    /**
     * Removes and returns the first element of the queue.
     * 
     * @return element removed (or null if empty)
     */
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return res;
    }

    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing if the queue is empty.
     */
    public void rotate() {
        if (!isEmpty()) {
            enqueue(dequeue()); // Move the element from the front to the back
        }
    }
}
