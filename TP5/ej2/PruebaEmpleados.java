package ej2;

import java.util.ArrayList;
import java.util.List;

public class PruebaEmpleados {
    public static void main(String[] args) {
        // Crear lista polimórfica de empleados
        List<Empleado> listaEmpleados = new ArrayList<>();

        // Agregar empleados a la lista
        listaEmpleados.add(new EmpleadoAsalariado("Ana", "1001", 2500.00));
        listaEmpleados.add(new EmpleadoPorHora("Luis", "1002", 20.0, 42));
        listaEmpleados.add(new EmpleadoPorComision("Sofía", "1003", 40000.0, 5.0));
        listaEmpleados.add(new EmpleadoBaseMasComision("Carlos", "1004", 6.0, 30000.0, 1200.0));

        System.out.println("=== LISTADO COMPLETO CON SALARIOS ===");
        System.out.println("(Incluye 10% de incremento para Base+Comisión)\n");

        // Recorrer lista con polimorfismo con for each
        for (Empleado emp : listaEmpleados) {
            System.out.println("Tipo: " + emp.getClass().getSimpleName());
            System.out.println("Nombre: " + emp.getNombre());

            double salarioOriginal = emp.calcularSalario();
            double salarioMostrar = salarioOriginal;

            // Aplicar incremento solo a EmpleadoBaseMasComision
            // instaceof para ver si el objeto esta dentro de la clase
            if (emp instanceof EmpleadoBaseMasComision) {
                double incremento = salarioOriginal * 0.10;
                salarioMostrar += incremento;
                System.out.printf("Salario original: $%,.2f%n", salarioOriginal);
                System.out.printf("Incremento (10%%): +$%,.2f%n", incremento);
            }

            System.out.printf("Salario total: $%,.2f%n%n", salarioMostrar);
        }
    }

}