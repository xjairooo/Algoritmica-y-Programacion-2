package lista;

public class TestAlternate {

	private static SinglyLinkedList<String> lista;
	private static SinglyLinkedList<String> listaAlternada;

	public static void main(String[] args) {

		lista = new SinglyLinkedList<String>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");

		System.out.println(lista);
		listaAlternada = lista.alternate(false);
		System.out.println(listaAlternada);

	}

}
