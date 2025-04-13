package test;

import lista_enlazada.SinglyLinkedList;

public class TestSinglyLinkedList {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Crear una nueva lista
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("-- Pruebas de SinglyLinkedList --");

        // Probar addPos
        System.out.println("\n--- Prueba de addPos ---");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("Antes de addPos: " + list); // Mostrar lista antes
        list.addPos(15, 1); // Insertar 15 en la posición 1
        System.out.println("Después de addPos: " + list); // Mostrar lista después

        // Probar removeElement
        System.out.println("\n--- Prueba de removeElement ---");
        System.out.println("Antes de removeElement: " + list); // Mostrar lista antes
        System.out.println("Elemento eliminado: " + list.removeElement(20)); // Eliminar 20
        System.out.println("Después de removeElement: " + list); // Mostrar lista después

        // Probar removePos
        System.out.println("\n--- Prueba de removePos ---");
        System.out.println("Antes de removePos: " + list); // Mostrar lista antes
        System.out.println("Elemento eliminado en la posición 1: " + list.removePos(1)); // Eliminar posición 1
        System.out.println("Después de removePos: " + list); // Mostrar lista después

        // Probar concatenate
        System.out.println("\n--- Prueba de concatenate ---");
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.addLast(40);
        list2.addLast(50);
        System.out.println("Lista 1 antes de concatenar: " + list); // Mostrar lista 1 antes
        System.out.println("Lista 2 antes de concatenar: " + list2); // Mostrar lista 2 antes
        list.concatenate(list2); // Concatenar list2 a list
        System.out.println("Lista 1 después de concatenar: " + list); // Mostrar lista 1 después

        // Probar search
        System.out.println("\n--- Prueba de search ---");
        System.out.println("Buscar elemento 50: " + list.search(50)); // Buscar 50
        System.out.println("Buscar elemento 100 (no existe): " + list.search(100)); // Buscar 100

        // Probar equals
        System.out.println("\n--- Prueba de equals ---");
        SinglyLinkedList<Integer> list3 = list.clone();
        System.out.println("Lista 1: " + list); // Mostrar lista 1
        System.out.println("Lista 3 (clonada): " + list3); // Mostrar lista 3
        System.out.println("¿Listas iguales?: " + list.equals(list3)); // Verificar igualdad

        // Probar clone
        System.out.println("\n--- Prueba de clone ---");
        SinglyLinkedList<Integer> clonedList = list.clone();
        System.out.println("Lista original: " + list); // Mostrar lista original
        System.out.println("Clon de la lista: " + clonedList); // Mostrar lista clonada
    }
}