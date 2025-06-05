package ej7.empresa;

/**
 * Interfaz que define operaciones de pago para objetos de la empresa (Empleados
 * y Facturas)
 * 
 * @author Jairo, Alexis y Jose
 * @see Empleado // --> Enlaza con la clase Empleado
 * @see Factura // --> Enlaza con la clase Factura
 */
public interface PorPagar {

	/**
	 * Calcula el monto del pago para el objeto que implementa esta interfaz
	 * 
	 * Ejemplos:
	 * Para Empleado: horasTrabajadas * valorHora, osea calculo por horas
	 * Para Factura: suma de todos los items (cantidad * precioUnitario),
	 * por suma total de los articulos
	 * 
	 * @return cantidad total a pagar como double
	 */
	public double obtenerPago();
}