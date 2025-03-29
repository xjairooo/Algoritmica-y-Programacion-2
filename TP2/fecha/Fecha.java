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
}