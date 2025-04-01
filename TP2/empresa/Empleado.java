package empresa;

/**
 * Clase que representa un empleado de la empresa
 * Calcula su pago segun las horas trabajadas y el valor por hora
 * 
 * Ejemplo:
 * Empleado juan = new Empleado(123, "Juan", null, 40, 10.0);
 * double pago = juan.obtenerPago(); // 40 * 10 = 400.0
 * 
 * @see PorPagar
 */
public class Empleado implements PorPagar {

	private int legajo; // Numero de empleado
	private String nombre; // Nombre completo
	private int horasTrabajadas; // Horas trabajadas
	private double valorHora; // Valor por hora
	private Empleado supervisor; // Jefe (puede ser null)

	/**
	 * Crea el constructor de la clase Empleado e inicializa los atributos
	 * Crea un empleado
	 * 
	 * @param legajo          Numero de identificacion
	 * @param nombre          Nombre del empleado
	 * @param supervisor      Su jefe (null, en el caso de que no tenga)
	 * @param horasTrabajadas Horas trabajadas
	 * @param valorHora       Valor por hora
	 */
	public Empleado(int legajo, String nombre, Empleado supervisor,
			int horasTrabajadas, double valorHora) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
	}

	/**
	 * Calcula el pago multiplicando (horasTrabajadas * valorHora)
	 * 
	 * @return Total a pagar
	 */
	@Override
	public double obtenerPago() {
		return horasTrabajadas * valorHora;
	}

	/**
	 * Muestra los datos del empleado como texto
	 * 
	 * @return Informacion del empleado
	 */
	@Override
	public String toString() {
		String datos = "Empleado " + nombre + " (Legajo: " + legajo + ")"; // Informacion del empleado
		if (supervisor != null) { // Si tiene jefe, lo muestra
			datos += ", Supervisor: " + supervisor.nombre; // Imprime el nombre del empleado + su jefe
		}
		return datos;
	}
}