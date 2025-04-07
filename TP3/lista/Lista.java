package TP3.lista;

/**
 * Clase que representa una lista genérica.
 * Esto permite crear listas de cualquier tipo de elemento.
 * Ejemplo: Lista<Integer>, Lista<String>, etc.
 * 
 * @param <E> Tipo de los elementos de la lista
 */
public class Lista<E> {

    private Object[] elementos; // Usamos Object[] porque no podemos crear arreglos de tipos genéricos
                                // directamente
    private int tamanio; // Cantidad actual de elementos
    private int capacidad; // Capacidad máxima del arreglo

}