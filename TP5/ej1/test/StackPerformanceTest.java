package ej1.test;

import ej1.Stack;
import ej1.stacks.ArrayStack;
import ej1.stacks.LinkedStack;
import ej1.stacks.DoublyLinkedStack;

public class StackPerformanceTest {
    public static void main(String[] args) {
        final int N = 1_000; // Number of elements to insert

        // Create instances of the stacks
        // ArrayStack, LinkedStack y DoublyLinkedStack
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedStack<>();
        Stack<Integer> doublyLinkedStack = new DoublyLinkedStack<>();

        // Medir el tiempo de insercion en cada pila
        long startTime, endTime;

        // ArrayStack
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++)
            arrayStack.push(i);
        for (int i = 0; i < N; i++)
            arrayStack.pop();
        endTime = System.nanoTime();
        System.out.println("ArrayStack time: " + (endTime - startTime) + " ns");

        // LinkedStack
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++)
            linkedStack.push(i);
        for (int i = 0; i < N; i++)
            linkedStack.pop();
        endTime = System.nanoTime();
        System.out.println("LinkedStack time: " + (endTime - startTime) + " ns");

        // DoublyLinkedStack
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++)
            doublyLinkedStack.push(i);
        for (int i = 0; i < N; i++)
            doublyLinkedStack.pop();
        endTime = System.nanoTime();
        System.out.println("DoublyLinkedStack time: " + (endTime - startTime) + " ns");

    }
}
