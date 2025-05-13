package empresa;

/**
 * Clase de prueba para demostrar el funcionamiento de la clase Factura.
 */
public class PruebaFactura {

	public static void main(String[] args) {

		// Crear una factura con un proveedor, numero y fecha
		Factura f2 = new Factura("FortinRepublica", 22222, "2017-05-05");

		// Agregar items a la factura
		f2.agregarItem("Tornillo", 50, 0.25);
		f2.agregarItem("Clavos", 100, 0.1);

		// Mostrar resultados
		System.out.println(f2); // Imprime el toString() de la factura
		System.out.println("Total de la factura: $" + f2.obtenerPago());
	}
}
