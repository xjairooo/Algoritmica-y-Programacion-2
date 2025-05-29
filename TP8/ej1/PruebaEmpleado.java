package ej1;

public class PruebaEmpleado {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("Juan", "12345678");
        Empleado e2 = new Empleado("Juan", "12387643");
        Empleado e3 = new Empleado("Diego", "87654321");

        Empleado emp[] = { e1, e2, e3 };

        // Map<String, Empleado> empleados = new UnsortedTableMap<>();
        // Map<String, Empleado> empleados = new ChainHashMap<>();
        Map<String, Empleado> empleados = new ProbeHashMap<>();

        for (Empleado e : emp) {
            empleados.put(e.getDni(), e);
        }

        System.out.println(empleados.get("12387643"));

        // test remove, elimanated dni
        empleados.remove("87654321");
        System.out.println(empleados.get("87654321"));

        // keySet recorre todos los dni que estan dentro del objeto empleados
        for (String s : empleados.keySet()) {
            System.out.println(s);
        }

        // Values recorre toda la informacion q pertenecen dentro del objeto empleado
        for (Empleado e : empleados.values()) {
            System.out.println(e);
        }

        for (Entry<String, Empleado> kv : empleados.entrySet()) {
            System.out.println("Clave: " + kv.getKey() + " Valor: " + kv.getValue());
        }
    }
}
