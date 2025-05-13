package empresa;

/**
 * Esta clase es para probar las clases Factura y Empleado, poniendolos en el
 * arreglo llamado 'pagos' que es de tipo PorPagar.
 * 
 * @author Jairo, Alexis y Jose
 */
public class PruebaPagos {

	public static void main(String[] args) {

		// Empiezo a instanciar los objetos de clase Facturas y Empleados
		PorPagar pagos[] = new PorPagar[10];

		// ---Empleados y Jefe---
		Empleado jefe = new Empleado(1, "Messi", null, 40, 2500.0);
		pagos[0] = new Empleado(2, "Victor", jefe, 40, 1700.0);
		pagos[1] = new Empleado(3, "Leonel", jefe, 30, 1500.0);
		pagos[2] = new Empleado(4, "Alexis", jefe, 25, 1600.0);
		pagos[3] = new Empleado(5, "Oconer", jefe, 20, 2000.0);
		pagos[4] = jefe; // Asignar el jefe al arreglo de pagos

		// ---Facturas---
		pagos[5] = new Factura("Proveedor 1", 1, "01/01/2025");
		// Agrega items a la factura
		((Factura) pagos[5]).agregarItem("Teclado", 2, 35000.0);
		((Factura) pagos[5]).agregarItem("Mouse", 1, 15000.0);

		pagos[6] = new Factura("Proveedor 2", 2, "02/01/2025");
		((Factura) pagos[6]).agregarItem("Cuadernos", 5, 3500.0);

		pagos[7] = new Factura("Proveedor 3", 3, "03/01/2025");
		((Factura) pagos[7]).agregarItem("Vasos", 10, 1000.0);

		pagos[8] = new Factura("Proveedor 4", 4, "04/01/2025");
		((Factura) pagos[8]).agregarItem("Cartas", 7, 2500.0);

		pagos[9] = new Factura("Proveedor 5", 5, "05/01/2025");
		((Factura) pagos[9]).agregarItem("Impresora", 2, 1000000.0);

		System.out.println("\n=== RESUMEN DE PAGOS ===");
		// Recorre el arreglo de pagos y muestra el tipo de pago y el monto a pagar
		// Utiliza el método obtenerPago() para obtener el monto a pagar
		for (int i = 0; i < pagos.length; i++) {
			/**
			 * Verifica si el objeto en pagos[i] es una instancia de la clase Empleado
			 * o de la clase Factura.
			 * Si es una instancia de Empleado, se asigna "EMP" a la variable tipo,
			 * si es una instancia de Factura, se asigna "FACT".
			 */
			String tipo = (pagos[i] instanceof Empleado) ? "EMP" : "FACT";
			// Imprime el tipo de pago y el monto a pagar
			System.out.printf("[%s %2d] $%8.2f%n",
					tipo,
					i + 1,
					pagos[i].obtenerPago());
		}
	}
}
