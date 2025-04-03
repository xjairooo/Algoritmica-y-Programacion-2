package generico;

import java.util.Arrays;

public class Portfolio<T> {
	// define un array de tipo T llamada data
	private T[] data;

	public Portfolio(int capacity) {
//		data = new T[capacity]; // illegal; compiler error
		data = (T[]) new Object[capacity]; // legal, but compiler warning
	}

	// devuelve la longitud del array data
	public T get(int index) {
		return data[index];
	}

	// colocamos la posicion y el elemento del array data
	public void set(int index, T element) {
		data[index] = element;
	}

	//este metodo invierte los elementos del array  1 2 3 4 = 4 3 2 1
	// el primer elemento se coloca en la ultima posicion y el segundo en la penultima
	public void reverse() {
		int low = 0, high = data.length - 1;
		while (low < high) { // swap data[low] and data[high]
			T temp = data[low];
			data[low++] = data[high]; // post-increment of low
			data[high--] = temp; // post-decrement of high
		}
	}

	//Busca un elemento en el arreglo. Si lo encuentra, devuelve su índice; si no, devuelve -1.
	public int find(T find) {
		for (int i=0; i<data.length; i++)
			if (data[i].equals(find))
				return i;
		return -1;		
	}
	
	// Intercambia los elementos en las posiciones i y j del arreglo.
	public void swap(int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	@Override
	public String toString() {
		return "Portfolio [data=" + Arrays.toString(data) + "]";
	}
	
}
