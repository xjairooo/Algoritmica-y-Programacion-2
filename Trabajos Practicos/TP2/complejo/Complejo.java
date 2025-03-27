package complejo;

public class Complejo {

    // Variables privadas que solo se puede acceder dentro de la clase Complejo
    private double real;
    private double imaginario;

    /**
     * Constructor para inicializar el numero complejo
     * 
     * @param real       Parte real del numero complejo
     * @param imaginario Parte imaginaria del numero complejo
     */
    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Obtiene la parte real del numero complejo
     * 
     * @return La parte real
     */
    public double getReal() {
        return this.real;
    }

    /**
     * Obtiene la parte imaginaria del numero complejo
     * 
     * @return La parte imaginaria
     */
    public double getImaginario() {
        return this.imaginario;
    }

    /**
     * Suma este numero complejo con otro
     * 
     * @param otro El otro numero complejo a sumar
     * @return Nuevo numero complejo resultado de la suma
     */
    public Complejo sumar(Complejo otro) {
        return new Complejo(this.real + otro.real, this.imaginario + otro.imaginario);
    }

    /**
     * Resta este numero complejo con otro
     * 
     * @param otro El otro numero complejo a restar
     * @return Nuevo numero complejo resultado de la resta
     */
    public Complejo restar(Complejo otro) {
        return new Complejo(this.real - otro.real, this.imaginario - otro.imaginario);
    }

    /**
     * Multiplica este numero complejo con otro
     * Formula: (a+bi)*(c+di) = (ac-bd) + (ad+bc)i
     * 
     * @param otro El otro numero complejo a multiplicar
     * @return Nuevo numero complejo resultado de la multiplicacion
     */
    public Complejo multiplicar(Complejo otro) {
        double nuevoReal = (this.real * otro.real) - (this.imaginario * otro.imaginario);
        double nuevoImaginario = (this.real * otro.imaginario) + (this.imaginario * otro.real);
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    /**
     * Divide este numero complejo entre otro
     * Primero calculamos el denominador (c² + d²)
     * Luego aplicamos la formula: [(ac+bd)/(c²+d²)] + [(bc-ad)/(c²+d²)]i
     * 
     * @param otro El divisor (numero complejo)
     * @return Nuevo numero complejo resultado de la division
     */
    public Complejo dividir(Complejo otro) {
        double denominador = Math.pow(otro.real, 2) + Math.pow(otro.imaginario, 2);
        double nuevoReal = ((this.real * otro.real) + (this.imaginario * otro.imaginario)) / denominador;
        double nuevoImaginario = ((this.imaginario * otro.real) - (this.real * otro.imaginario)) / denominador;
        return new Complejo(nuevoReal, nuevoImaginario);
    }

    /**
     * Divide este numero complejo por un escalar real
     * 
     * @param escalar El divisor (numero real)
     * @return Nuevo numero complejo resultado de la division
     */
    public Complejo divisionEscalar(double escalar) {
        return new Complejo(this.real / escalar, this.imaginario / escalar);
    }

    /**
     * Representacion en String del numero complejo, osea lo manipula
     * para que se imprima de forma mas legible
     * 
     * @return String con formato "a + bi" o "a - bi"
     */
    @Override
    public String toString() {
        /*
         * Si el numero imaginario es positivo, se imprime con un signo +,
         * sino con un signo -,y se imprime el valor absoluto del numero imaginario
         */
        return real + (imaginario >= 0 ? "+" : "-") + Math.abs(imaginario) + "i";
    }
}