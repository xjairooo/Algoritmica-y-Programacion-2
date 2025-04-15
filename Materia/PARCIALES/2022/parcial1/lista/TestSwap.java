package lista;

public class TestSwap {

	private static DoublyLinkedList<String> lista;
	
	public static void main(String[] args) {
		
		lista = new DoublyLinkedList<String>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		
		System.out.println(lista);
		lista.swap(1, 1);
		System.out.println(lista);
		
		
	}

		
}
