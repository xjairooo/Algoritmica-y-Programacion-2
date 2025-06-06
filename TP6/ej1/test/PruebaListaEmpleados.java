package test;

import empresa.Empleado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase de prueba que demuestra el uso de cada método de la interfaz List
 * con una lista de empleados.
 */
public class PruebaListaEmpleados {

    public static void main(String[] args) {
        // Suponemos una implementación concreta: ArrayListPropio que implementa
        // List<Empleado>
        List<Empleado> empleados = new ArrayList<>();

        // Crear algunos empleados
        Empleado jefe = new Empleado(100, "Luis", null, 40, 1000.0);
        Empleado e1 = new Empleado(101, "Ana", jefe, 30, 800.0);
        Empleado e2 = new Empleado(102, "Mario", jefe, 20, 900.0);

        // add(i, e): Agregamos empleados en diferentes posiciones
        empleados.add(0, jefe);
        empleados.add(1, e1);
        empleados.add(2, e2);

        // size(): Cantidad actual de empleados
        System.out.println("Total empleados: " + empleados.size());

        // isEmpty(): ¿La lista está vacía?
        System.out.println("¿Está vacía? " + empleados.isEmpty());

        // get(i): Obtener empleado en la posición 1
        System.out.println("Empleado en posición 1: " + empleados.get(1));

        // set(i, e): Reemplazar empleado en posición 1
        Empleado reemplazo = new Empleado(103, "Carlos", jefe, 35, 950.0);
        Empleado anterior = empleados.set(1, reemplazo);
        System.out.println("Reemplazado: " + anterior);
        System.out.println("Nuevo en posición 1: " + empleados.get(1));

        // remove(i): Eliminar empleado en posición 0
        Empleado eliminado = empleados.remove(0);
        System.out.println("Eliminado: " + eliminado);

        // iterator(): Recorrer con iterador
        System.out.println("Empleados restantes:");
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
