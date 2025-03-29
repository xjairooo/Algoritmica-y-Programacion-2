package tiempo;

public class PruebaTiempo {
    public static void main(String[] args) {
        // Prueba básica de creación e incrementos
        Tiempo tiempo = new Tiempo(23, 59, 58);
        System.out.println("Hora inicial: " + tiempo);

        tiempo.incrementarSegundo();
        System.out.println("+1 segundo: " + tiempo);

        tiempo.incrementarSegundos(2);
        System.out.println("+2 segundos: " + tiempo);

        // Prueba de desbordamiento
        tiempo.incrementarMinutos(1);
        System.out.println("+1 minuto: " + tiempo);

        // Prueba de incremento múltiple
        tiempo.incrementarHoras(5);
        System.out.println("+5 horas: " + tiempo);

        // Prueba de valores inválidos
        try {
            tiempo.incrementarMinutos(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error correcto al incrementar negativo: " + e.getMessage());
        }

        // Prueba de normalización automática
        Tiempo t2 = new Tiempo(0, 120, 120);
        System.out.println("Tiempo con valores excedentes: " + t2);
    }
}