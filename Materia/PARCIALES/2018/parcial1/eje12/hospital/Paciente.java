package hospital;

public class Paciente {
	
	private String nombre;
	private String dni;
	 	
	public Paciente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
}
