package racional;

class PruebaOperacionesRacional {

	public static void main(String[] args) {

		// https://www.superprof.es/apuntes/escolar/matematicas/aritmetica/racionales/numeros-racionales-2.html#tema_suma-y-resta-de-numeros-racionales

		Racional r1 = new Racional(5, 4);
		Racional r2 = new Racional(1, 6);

		// Realizar operaciones con racionales
		// 5/4 + 1/6 = 17/12
		System.out.println(r1 + " + " + r2 + " = " + r1.sumar(r2));
		// 5/4 - 1/6 = 13/12
		System.out.println(r1 + " - " + r2 + " = " + r1.restar(r2));
		// 5/4 * 1/6 = 5/24
		System.out.println(r1 + " * " + r2 + " = " + r1.multiplicar(r2));
		// 5/4 / 1/6 = 15/2
		System.out.println(r1 + " / " + r2 + " = " + r1.dividir(r2));
		// (5/4)^2 = 25/16
		System.out.println(Racional.potencia(r1, 2));

	}

}
