package empresa;

// utiliza la interfaz PorPagar por eso implementa la interfaz
public class Empleado implements PorPagar {

	// Atributos
	//
	private int legajo;
	private String nombre;
	private int horasTrabajadas;
	private double valorHora;

	private Empleado supervisor;

	// Constructor
	public Empleado(int legajo, String nombre, Empleado supervisor, int horas_Trabajadas, double valorHora) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajadas = horas_Trabajadas;
		this.valorHora = valorHora;
	}

	// Metodo empleado por la interfaz
	// Calcula el sueldo de un empleado
	public double obtenerPago() {
		return horasTrabajadas * valorHora; // Añadido
	}

	// Mejorar el metodo toString para que imprima el nombre del supervisor
	@Override
	public String toString() {
		if (supervisor == null)
			return "Empleado [legajo=" + legajo + ", nombre=" + nombre + ", horasTrabajadas=" + horasTrabajadas
					+ ", valorHora=" + valorHora + ", supervisor=" + supervisor + "]";
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + ", horasTrabajadas=" + horasTrabajadas
				+ ", valorHora=" + valorHora + "]";
	}

}
