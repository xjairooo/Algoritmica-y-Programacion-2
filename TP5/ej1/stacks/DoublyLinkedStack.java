package ej1.stacks;

import ej1.Stack;
import ej1.lists.DoublyLinkedList;

public class DoublyLinkedStack<E> implements Stack<E> {
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    /**
     * Constructs an initially empty stack.
     */
    public DoublyLinkedStack() {
    }

    /**
     * Returns the number of elements in the stack.
     * 
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Tests whether the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Inserts an element at the top of the stack.
     * 
     * @param e the element to be inserted
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * 
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     * Removes and returns the top element from the stack.
     * 
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * Produces a string representation of the contents of the stack.
     * (ordered from top to bottom)
     *
     * This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    @Override
    public String toString() {
        return list.toString();
    }

}