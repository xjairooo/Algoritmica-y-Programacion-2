package ej2;

import java.util.Stack;

public class NominaEmpleados {
    public static void main(String[] args) {
        // Crear una pila para almacenar empleados
        Stack<Empleado> pilaEmpleados = new Stack<>();

        // Agregar empleados a la pila
        pilaEmpleados.push(new EmpleadoAsalariado("Jairo", "1001", 2500.00));
        pilaEmpleados.push(new EmpleadoPorHora("Luis", "1002", 20.0, 42));
        pilaEmpleados.push(new EmpleadoPorComision("Roberto", "1003", 40000.0, 5.0));
        pilaEmpleados.push(new EmpleadoBaseMasComision("Carlos", "1004", 6.0, 30000.0, 1200.0));

        while (!pilaEmpleados.isEmpty()) {
            Empleado empleado = pilaEmpleados.pop(); // Obtiene el empleado de la pila
            System.out.println("Empleado: " + empleado.getNombre());
            System.out.printf("Sueldo calculado: $%,.2f%n%n", empleado.calcularSalario());
        }
    }
}
