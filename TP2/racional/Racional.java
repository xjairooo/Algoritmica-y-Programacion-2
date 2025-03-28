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
	public Racional multiplicar(Racional otro) {
		int nuevoNumerador = this.numerador * otro.numerador;
		int nuevoDenominador = this.denominador * otro.denominador;
		return new Racional(nuevoNumerador, nuevoDenominador);
	}

	// Implementar...
	/**
	 * Divide dos números racionales.
	 * Fórmula: (a/b) / (c/d) = (a*d) / (b*c)
	 * 
	 * @throws IllegalArgumentException si el divisor es cero.
	 */
	public Racional dividir(Racional otro) {
		if (otro.denominador == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero"); // Si no cumple finaliza.
		}
		int nuevoNumerador = this.numerador * otro.denominador;
		int nuevoDenominador = otro.numerador * this.denominador;
		return new Racional(nuevoNumerador, nuevoDenominador);
	}

	/**
	 * Metodo static no podemos usar this
	 * Calcula la potencia de un número racional con exponente entero (positivo o
	 * negativo)
	 * Fórmulas:
	 * - Para exponente positivo: (a/b)^n = a^n / b^n
	 * - Para exponente negativo: (a/b)^-n = (b/a)^n
	 * 
	 * @param base      El número racional a elevar, osea la fraccion
	 * @param exponente El exponente entero (puede ser positivo o negativo)
	 * @return Nuevo Racional resultado de la operación
	 */
	public static Racional potencia(Racional base, int exponente) {
		if (exponente == 0) {
			return new Racional(1, 1);
		}
		// Exponente siempre sera positivo
		// Se invierte la fraccion pero se mantiene el exponente positivo
		int exponenteAbsoluto = Math.abs(exponente); // --> Para cumplir con el exponente positivo
		int nuevoNumerador = (int) Math.pow(base.getNumerador(), exponenteAbsoluto); // (int) pq el Math.pow devuelve
																						// double
		int nuevoDenominador = (int) Math.pow(base.getDenominador(), exponenteAbsoluto); // (int) pq el Math.pow
																							// devuelve double

		return (exponente < 0)
				? new Racional(nuevoDenominador, nuevoNumerador) // Invertimos la fraccion si el exp < 0
				: new Racional(nuevoNumerador, nuevoDenominador);
	}

	/**
	 * Método estático que simplifica una fracción a su forma irreducible
	 * 
	 * @param fraccion La fracción a simplificar (objeto Racional)
	 * @return Nueva fracción simplificada
	 */
	public static Racional simplificar(Racional fraccion) {
		// Calculamos el máximo común divisor del numerador y denominador (en valor
		// absoluto)
		int maximoComunDivisor = mcd(
				Math.abs(fraccion.numerador),
				Math.abs(fraccion.denominador));

		// Simplificamos dividiendo ambos términos por el MCD
		int nuevoNumerador = fraccion.numerador / maximoComunDivisor;
		int nuevoDenominador = fraccion.denominador / maximoComunDivisor;

		// Retornamos un nuevo objeto Racional con la fracción simplificada
		return new Racional(nuevoNumerador, nuevoDenominador);
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

	/**
	 * Método privado que calcula el Máximo Común Divisor (MCD) usando el algoritmo
	 * de Euclides
	 * 
	 * @param primerNumero  Primer número para calcular MCD
	 * @param segundoNumero Segundo número para calcular MCD
	 * @return El MCD de los dos números
	 */
	private static int mcd(int primerNumero, int segundoNumero) {
		int temporal; // Variable para almacenar valores temporalmente durante el intercambio

		// Implementación del algoritmo de Euclides
		while (primerNumero > 0) {
			temporal = primerNumero;
			primerNumero = segundoNumero % primerNumero;
			segundoNumero = temporal;
		}

		// Cuando primerNumero llega a 0, segundoNumero contiene el MCD
		return segundoNumero;
	}

}