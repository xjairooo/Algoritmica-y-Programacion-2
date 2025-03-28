package racional;

// Clase Racional
public class Racional {

	// a) variables enteras para representar datos privados

	private int numerador;
	private int denominador;

	// b) Inicializa el Constructor para el objeto
	public Racional(int numerador, int denominador) {
		this.numerador = numerador;

		if (denominador == 0) // si el denominador que ingreso el usuario es 0 -> le salta un error
			// throw = lanza explícitamente una excepción (error), el programa se detiene
			// inmediato
			// new IllegalArgumentException = Crea un nuevo objeto de tipo
			// IllegalArgumentException("...mensaje...")
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Getters: acceder a los valores de los atributos
	// Setters: modificar los valores de los atributos
	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	// Si el valor q modificamos del denominador es != 0 va lanzar error
	public void setDenominador(int denominador) {
		if (denominador == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Metodos

	/**
	 * Suma de dos racionales
	 * Formula: a/b + c/d = (a*d + c*b) / (b*d)
	 * 
	 * @param otro
	 * @return la suma de los racionales
	 */
	public Racional sumar(Racional otro) {
		int nuevoNumerador = (numerador * otro.denominador) + (otro.numerador * denominador);
		int nuevoDenominador = denominador * otro.denominador;
		return new Racional(nuevoNumerador, nuevoDenominador);
	}

	/**
	 * Resta dos números racionales.
	 * Fórmula: a/b - c/d = (a*d - c*b) / (b*d)
	 * 
	 * @param otro
	 * @return
	 */
	public Racional restar(Racional otro) {
		int nuevoNumerador = (this.numerador * otro.denominador) - (otro.numerador * this.denominador);
		int nuevoDenominador = this.denominador * otro.denominador;
		return new Racional(nuevoNumerador, nuevoDenominador);
	}

	// Implementar...
	/**
	 * Multiplica dos números racionales.
	 * Fórmula: (a/b) * (c/d) = (a*c) / (b*d)
	 * 
	 * @param b
	 * @return
	 */
	public Racional multiplicar(Racional b) {
		return new Racional(1, 1);
	}

	// Implementar...
	public Racional dividir(Racional b) {
		return new Racional(1, 1);
	}

	// Implementar...
	// (a/b)^n = a^n/b^n
	// (a/b)^-n = (b/a)^n
	public static Racional potencia(Racional base, int exponente) {
		return new Racional(1, 1);
	}

	// M�todo est�tico
	public static Racional simplificar(Racional a) {
		int x = mcd(Math.abs(a.numerador), Math.abs(a.denominador));
		int n = a.numerador / x;
		int d = a.denominador / x;
		return new Racional(n, d);
	}

	// toString: mostrar un objeto
	public String toString() {
		return (numerador + "/" + denominador);
	}

	// equals: verificar cuando dos objetos son iguales
	public boolean equals(Object o) {
		Racional r1 = simplificar(this);
		Racional r2 = simplificar((Racional) o);
		return ((r1.numerador == r2.numerador) && (r1.denominador == r2.denominador));
	}

	// M�todo privado
	private static int mcd(int m, int n) {
		int t;
		while (m > 0) {
			t = m;
			m = n % m;
			n = t;
		}
		return n;
	}

}