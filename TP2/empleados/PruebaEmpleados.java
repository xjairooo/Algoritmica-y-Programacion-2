package empleados;

public class PruebaEmpleados {
    public static void main(String[] args) {
        // Crear empleados
        EmpleadoAsalariado emp1 = new EmpleadoAsalariado("Ana", "1001", 2500.00);
        EmpleadoPorHora emp2 = new EmpleadoPorHora("Luis", "1002", 20.0, 42);
        EmpleadoPorComision emp3 = new EmpleadoPorComision("Sofía", "1003", 40000.0, 5.0);
        EmpleadoBaseMasComision emp4 = new EmpleadoBaseMasComision("Carlos", "1004", 6.0, 30000.0, 1200.0);

        // Mostrar información (uso de toString y String.format con %s)
        System.out.println("=== INFORMACIÓN DE EMPLEADOS ===");
        System.out.println(emp1);
        System.out.println();
        System.out.println(emp2);
        System.out.println();
        System.out.println(emp3);
        System.out.println();
        System.out.println(emp4);

    }
}
