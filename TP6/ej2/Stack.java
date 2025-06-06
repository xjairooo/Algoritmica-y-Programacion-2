package ej2;

import java.util.ArrayList;

class Stack<E> {

  private ArrayList<E> stack;

  /**
   * Returns the number of elements in the stack.
   * 
   * @return number of elements in the stack
   */
  public int size() {
    return stack.size();
  }

  /**
   * Tests whether the stack is empty.
   * 
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  /**
   * Inserts an element at the top of the stack.
   * 
   * @param e the element to be inserted
   */
  public void push(E e) {
    stack.add(e);
  }

  /**
   * Removes and returns the top element from the stack.
   * 
   * @return element removed (or null if empty)
   */
  public E pop() {
    if (isEmpty()) {
      System.out.println("Lista vacia");
    }
    return stack.remove(stack.size() - 1);
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * 
   * @return top element in the stack (or null if empty)
   */
  public E peek() {
    if (isEmpty()) {
      System.out.println("Lista vacia");
    }
    return stack.get(stack.size() - 1);
  }

  public void clear() {
    stack.clear();
  }
}
