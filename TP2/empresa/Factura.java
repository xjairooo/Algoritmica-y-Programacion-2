package empresa;

import java.util.Arrays;

/**
 * Clase que representa una factura de compra a proveedores
 * Implementa la interfaz PorPagar para calcular el total a pagar
 * 
 * @author Jairo, Alexis y Jose
 * @see PorPagar // --> Enlaza con la interfaz PorPagar
 * @see Item // --> Enlaza con la clase Item
 */
public class Factura implements PorPagar {

	private static final int CANTIDAD_ITEMS = 10; // Constante para el maximo de items (10)
	private String proveedor; // Nombre del proveedor (vendedor)
	private int numero; // Numero de factura (identificador)
	private String fecha; // Fecha de compra (formato YYYY-MM-DD)
	private int cantArticulos = 0; // Cantidad de articulos agregados
	private Item[] articulos; // Arreglo de tipo Item (maximo 10 items)

	/**
	 * Crea el constructor de la clase Factura e inicializa los atributos
	 * 
	 * @param proveedor Nombre del vendedor
	 * @param numero    Numero identificador
	 * @param fecha     Fecha de compra (formato YYYY-MM-DD)
	 */
	public Factura(String proveedor, int numero, String fecha) {
		this.proveedor = proveedor;
		this.numero = numero;
		this.fecha = fecha;
		this.articulos = new Item[CANTIDAD_ITEMS];
	}

	/**
	 * Calcula el total a pagar de la factura sumando todos los items
	 * Recorre cada producto y multiplica (cantidad * precioUnitario)
	 * 
	 * Ejemplo:
	 * Si tiene:
	 * - 2 lapices a $1.50 → $3.00
	 * - 3 cuadernos a $5.00 → $15.00
	 * Retorna: $18.00
	 * 
	 * @return El valor total de la factura en formato decimal
	 */
	@Override // --> Implementa el metodo de la interfaz PorPagar, sobrescribiendo el metodo
	public double obtenerPago() {
		// Se inicializa el total a 0.0 para sumar los precios de cada item
		double total = 0.0;
		// Recorre el arreglo de articulos y suma el total
		for (int i = 0; i < cantArticulos; i++) {
			total += articulos[i].cantidad * articulos[i].precioUnitario;
		}
		return total;
	}

	/**
	 * Metodo para agregar un articulo al arreglo de tipo Item
	 * 
	 * @param descripcion    Nombre del producto
	 * @param cantidad       Cantidad comprada
	 * @param precioUnitario Precio por unidad
	 * @throws IllegalStateException Si se excede el maximo de items como maximo 10
	 */
	public void agregarItem(String descripcion, int cantidad, double precioUnitario) {
		// Verifica si se excede el maximo de items
		if (cantArticulos >= CANTIDAD_ITEMS) {
			// Si se excede, lanza una excepcion
			throw new IllegalStateException("No se pueden agregar mas de 10 items");
		}
		// Se crea un nuevo objeto de tipo Item y se agrega al arreglo
		// Agrega un nuevo item al arreglo de articulos y aumenta la cantidad de
		// articulos
		this.articulos[cantArticulos++] = new Item(descripcion, cantidad, precioUnitario);
	}

	@Override
	public String toString() {
		return "Factura proveedor: " + proveedor + " \nNumero: " + numero + "\nFecha: " + fecha
				+ "\nCantidad de Articulos: " + cantArticulos + "\nArticulos: " + Arrays.toString(articulos);
	}

	/**
	 * Clase que representa un item/producto en una factura
	 * Guarda la descripcion, cantidad y precio de cada producto
	 *
	 * Ejemplo dentro del main (PruebaFactura.java):
	 * Item item = new Item("Tornillos", 50, 0.25); // 50 Tornillos a $0.25 c/u
	 */
	private class Item {
		private String descripcion; // Nombre del producto
		private int cantidad; // Cantidad comprada
		private double precioUnitario; // Precio por unidad

		/**
		 * Crea constructor de la clase Items
		 * Crea un item con su descripcion, cantidad y precio unitario
		 * 
		 * @param descripcion    Nombre del producto
		 * @param cantidad       Cuantos se compraron
		 * @param precioUnitario Precio de c/u
		 */
		public Item(String descripcion, int cantidad, double precioUnitario) {
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
		}

		/**
		 * Muestra los datos del item con formato simple
		 * 
		 * @return Ejemplo: "Tornillos (50 x $0.25)"
		 */
		@Override
		public String toString() {
			return String.format("%s (%d x $%.2f)",
					descripcion, cantidad, precioUnitario);
		}
	}
}
