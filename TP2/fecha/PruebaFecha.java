package fecha;

public class PruebaFecha {
    public static void main(String args[]) {
        // Prueba fecha normal
        Fecha fecha1 = new Fecha(2023, 12, 31);
        System.out.println("Fecha inicial: " + fecha1);

        // Prueba dia siguiente y anterior
        fecha1.diaSiguiente();
        System.out.println("Dia siguiente: " + fecha1);
        fecha1.diaAnterior();
        System.out.println("Dia anterior: " + fecha1); // Corregido de "siguiente" a "anterior"

        // Prueba cambio de mes
        Fecha finMes = new Fecha(2023, 11, 30);
        finMes.diaSiguiente();
        System.out.println("Fin de mes: " + finMes);

        // Prueba año bisiesto
        Fecha bisiesto = new Fecha(2020, 2, 28);
        bisiesto.diaSiguiente();
        System.out.println("Año bisiesto: " + bisiesto);

        // Prueba validacion
        try {
            new Fecha(2023, 13, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
        Fecha hoy = new Fecha(2023, 10, 15);
        Fecha navidad = new Fecha(2023, 12, 25);

        System.out.println("Días hasta navidad: " + hoy.diasEntre(navidad));
        System.out.println("Día de la semana: " + hoy.diaDeLaSemana());
        Fecha en30Dias = hoy.sumarDias(30);
        System.out.println("En 30 días será: " + en30Dias);
    }
}