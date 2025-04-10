package TP3.lista.src;
public class PruebaLista {

	public static void main(String[] args) {
		Lista<Empleado> lista = new Lista<Empleado>(3);

		Empleado e1 = new Empleado(100, "Juan");
		Empleado e2 = new Empleado(110, "Ana");
		Empleado e3 = new Empleado(120, "Pedro");
		Empleado e4 = new Empleado(120, "Maria");
		/**
		 * Al insertar un 4to elemento en una lista de 3 elementos, se lanza una
		 * IndexOutOfBoundsException
		 */
		try {
			lista.add(e1);
			lista.add(e2);
			lista.add(e3);
			lista.add(e4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);	// imprime el error "Lista llena"
		}

		System.out.println(lista);
	}
}
