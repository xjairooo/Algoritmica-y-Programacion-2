package ej4;

import java.util.Arrays;

public class DynamicArrayList<E> {

    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public DynamicArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Añade un elemento al final de la lista
    public void add(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Retorna el tamaño actual de la lista
    public int size() {
        return size;
    }

    // Retorna el elemento en la posicion especificada
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        return (E) elements[index];
    }

    // Reemplaza el array utilizando por uno la capacidad igual a la cantidad de
    // elementos de la lista
    public void trimToSize() {
        if (size < elements.length) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    /*
     * Asegura la capaicad del array
     * Para añadir un nuevo elemento
     */
    public void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

}