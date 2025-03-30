package fecha;

/**
 * Clase para manejar fechas con validacion automatica
 * Controla años bisiestos y cambios de mes/año
 * Ejemplo: new Fecha(2023, 12, 31).diaSiguiente() → "2024-01-01"
 */
public class Fecha {
    private int año;
    private int mes;
    private int dia;

    /**
     * Crea una fecha validada
     * 
     * @param año Año (positivo)
     * @param mes Mes (1-12)
     * @param dia Dia (segun mes)
     * @throws IllegalArgumentException Si la fecha es invalida
     *                                  Ejemplo: new Fecha(2023, 2, 28) → Fecha
     *                                  valida (en el main)
     */
    public Fecha(int año, int mes, int dia) {
        if (!fechaValida(año, mes, dia)) {
            throw new IllegalArgumentException("Fecha invalida");
        }
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Avanza la fecha un dia, ajustando mes/año si es necesario
     * Ejemplo: 2023-12-31 → 2024-01-01
     */
    public void diaSiguiente() {
        if (++dia > diaEnMes()) {
            dia = 1;
            if (++mes > 12) {
                mes = 1;
                año++;
            }
        }
    }

    /**
     * Retrocede la fecha un dia, ajustando mes/año si es necesario
     * Ejemplo: 2023-01-01 → 2022-12-31
     */
    public void diaAnterior() {
        if (--dia < 1) {
            mes--;
            dia = diaEnMes();
            if (mes < 1) {
                mes = 12;
                año--;
            }
        }
    }

    /**
     * Valida si una fecha es correcta
     * 
     * @param año Año a validar
     * @param mes Mes a validar
     * @param dia Dia a validar
     * @return true si la fecha es valida
     *         Ejemplo: fechaValida(2023, 2, 29) → false
     */
    private boolean fechaValida(int año, int mes, int dia) {
        if (año < 1 || mes < 1 || mes > 12 || dia < 1)
            return false;
        return dia <= diaEnMes();
    }

    /**
     * Calcula dias en el mes actual, considerando bisiestos
     * 
     * @return Dias del mes (28-31)
     *         Ejemplo: diaEnMes() para 2023-02 → 28
     */
    private int diaEnMes() {
        if (mes == 2) { // Febrero
            return (año % 400 == 0) || (año % 100 != 0 && año % 4 == 0) ? 29 : 28;
        }
        return (mes == 4 || mes == 6 || mes == 9 || mes == 11) ? 30 : 31;
    }

    /**
     * Representacion en el formato (YYYY-MM-DD)
     * 
     * @return String con la fecha formateada
     *         Ejemplo: 2023-02-28
     */
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", año, mes, dia);
    }

    public boolean esMayorQue(Fecha otro) {
        if (this.año != otro.año)
            return this.año > otro.año;
        if (this.mes != otro.mes)
            return this.mes > otro.mes;
        return this.dia > otro.dia;
    }

    public boolean esMenorQue(Fecha otro) {
        if (this.año != otro.año)
            return this.año < otro.año;
        if (this.mes != otro.mes)
            return this.mes < otro.mes;
        return this.dia < otro.dia;
    }

    public boolean esIgualQue(Fecha otro) {
        return this.año == otro.año && this.mes == otro.mes && this.dia == otro.dia;
    }

    /**
     * Calcula la cantidad de días entre esta fecha y otra
     */
    public int diasEntre(Fecha otra) {
        return Math.abs(this.toDias() - otra.toDias());
    }

    /**
     * Suma (o resta) días a la fecha actual
     */
    public Fecha sumarDias(int dias) {
        int total = this.toDias() + dias;
        return fromDias(total);
    }

    /**
     * Devuelve el día de la semana (Lunes-Domingo)
     */
    public String diaDeLaSemana() {
        int a = año, m = mes, d = dia;
        if (m < 3) {
            m += 12;
            a--;
        }
        int k = a % 100;
        int j = a / 100;
        int diaSemana = (d + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        String[] dias = { "Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" };
        return dias[diaSemana];
    }

    // --- Métodos auxiliares privados ---

    /**
     * Convierte la fecha a días totales desde 1/1/1
     */
    private int toDias() {
        int total = dia;
        for (int m = 1; m < mes; m++) {
            total += diasEnMes(m, año);
        }
        for (int a = 1; a < año; a++) {
            total += esBisiesto(a) ? 366 : 365;
        }
        return total;
    }

    /**
     * Crea una fecha desde días totales (1/1/1)
     */
    private static Fecha fromDias(int totalDias) {
        int a = 1, m = 1, d = 1;

        while (totalDias > (esBisiesto(a) ? 366 : 365)) {
            totalDias -= esBisiesto(a) ? 366 : 365;
            a++;
        }

        while (totalDias > diasEnMes(m, a)) {
            totalDias -= diasEnMes(m, a);
            m++;
        }

        d = totalDias;
        return new Fecha(a, m, d);
    }

    private static int diasEnMes(int mes, int año) {
        if (mes == 2) {
            return esBisiesto(año) ? 29 : 28;
        }
        return (mes == 4 || mes == 6 || mes == 9 || mes == 11) ? 30 : 31;
    }

    private static boolean esBisiesto(int año) {
        return (año % 400 == 0) || (año % 100 != 0 && año % 4 == 0);
    }

}