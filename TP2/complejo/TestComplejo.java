package complejo;

public class TestComplejo {
    public static void main(String[] args) {

        // Creo los objetos/numeros complejos para las pruebas
        Complejo c1 = new Complejo(3, 2);
        Complejo c2 = new Complejo(1, -4);
        Complejo c3 = new Complejo(-2, 5);
        Complejo c4 = new Complejo(0, 1);
        Complejo c5 = new Complejo(1, 0);

        // Imprimo los numeros complejos q se utilizaran
        System.out.println("Numeros complejos a prueba");
        imprimirComplejos(c1, c2, c3, c4, c5);

        // Se imprime las operacion entre numeros complejos
        // suma, resta, multiplicacion, division
        System.out.println("\nOperaciones basicas");
        pruebaOperacionesBasicas(c1, c2, c3);

        System.out.println();
        pruebaDivisionEscalar(c1, c2, 2.5);

    }

    /**
     * 
     * Imprime una lista de numeros complejos con formato numerado
     * ´Complejo... complejos´ -> realiza un array llamado complejos del tipo
     * complejo
     * 
     * @param complejos Arreglo variable de números complejos a imprimir
     */
    private static void imprimirComplejos(Complejo... complejos) {
        for (int i = 0; i < complejos.length; i++) {
            System.out.println("c" + (i + 1) + " = " + complejos[i]);
        }
    }

    /**
     * Prueba las operaciones aritmeticas basicas entre numeros complejos
     * 
     * @param c1 Primer numero complejo
     * @param c2 Segundo numero complejo
     * @param c3 Tercer numero complejo
     */
    private static void pruebaOperacionesBasicas(Complejo c1, Complejo c2, Complejo c3) {
        // Pruebas de suma
        System.out.println("Suma:");
        System.out.println(c1 + " + " + c2 + " = " + c1.sumar(c2));
        System.out.println(c2 + " + " + c3 + " = " + c2.sumar(c3));

        // Pruebas de resta
        System.out.println("\nResta:");
        System.out.println(c1 + " - " + c2 + " = " + c1.restar(c2));
        System.out.println(c3 + " - " + c1 + " = " + c3.restar(c1));

        // Pruebas de multiplicacion
        System.out.println("\nMultiplicacion:");
        System.out.println(c1 + " * " + c2 + " = " + c1.multiplicar(c2));
        System.out.println(c2 + " * " + c3 + " = " + c2.multiplicar(c3));

        // Pruebas de division
        System.out.println("\nDivision:");
        System.out.println(c1 + " / " + c2 + " = " + c1.dividir(c2));
        System.out.println(c3 + " / " + c1 + " = " + c3.dividir(c1));
    }

    /**
     * Prueba la division de numeros complejos por un escalar real
     * 
     * @param c1      Primer numero complejo para prueba
     * @param c2      Segundo numero complejo para prueba
     * @param escalar Valor escalar para la division
     */
    private static void pruebaDivisionEscalar(Complejo c1, Complejo c2, double escalar) {
        System.out.println("Division escalar por " + escalar + ":");
        System.out.println(c1 + " / " + escalar + " = " + c1.divisionEscalar(escalar));
        System.out.println(c2 + " / " + escalar + " = " + c2.divisionEscalar(escalar));
    }
}