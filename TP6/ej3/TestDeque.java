package ej3;

public class TestDeque {

    public static void main(String[] args) {

        Deque<Empleado> listEmployee = new Deque<>();

        // Crea algunos empleado
        Empleado e1 = new Empleado();
        e1.setNombre("Jairo");
        e1.setDocumento(1234);
        listEmployee.addFirst(e1);

        Empleado e2 = new Empleado();
        e2.setDocumento(9821);
        e2.setNombre("Rosa");
        listEmployee.addLast(e2);

        // Metodos de la interface list
        System.out.println("Tamaño: " + listEmployee.size());
        System.out.println("Lista vacia?: " + listEmployee.isEmpty());
        System.out.println("Elemento superior: " + listEmployee.first());
    }
}