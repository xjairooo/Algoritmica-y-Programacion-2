package tiempo;

/**
 * La clase Tiempo representa una hora del día en formato de 24 horas,
 * con horas, minutos y segundos. Proporciona métodos para manipular
 * y consultar la hora, garantizando que siempre permanezca en rangos válidos.
 * 
 * @author Jairo Campero
 * @version 1.0
 */
public class Tiempo {

    /** Horas del día (0-23) */
    private int horas;

    /** Minutos de la hora (0-59) */
    private int minutos;

    /** Segundos del minuto (0-59) */
    private int segundos;

    /**
     * Constructor que inicializa un objeto Tiempo con los valores especificados.
     * Si algún parametro esta fuera de rango, se establece a 0.
     * 
     * @param horas    Valor inicial para las horas (0-23)
     * @param minutos  Valor inicial para los minutos (0-59)
     * @param segundos Valor inicial para los segundos (0-59)
     *                 Ejemplo: new Tiempo(25,70,80) → 01:10:20
     */
    public Tiempo(int horas, int minutos, int segundos) {
        setHoras(horas);
        setMinutos(minutos);
        setSegundos(segundos);
        normalizarTiempo();
    }

    /**
     * Obtiene las horas actuales.
     * 
     * @return Horas entre 0 y 23
     *         Ejemplo: Para 14:30:45 → 14
     */
    public int getHoras() {
        return this.horas;
    }

    /**
     * Establece el valor de las horas.
     * Si el valor esta fuera del rango 0-23, se establece a 0
     * 
     * @param horas Nuevo valor para las horas
     */
    public void setHoras(int horas) {
        this.horas = ajustarRango(horas, 24);
        normalizarTiempo();
    }

    /**
     * Obtiene los minutos actuales.
     * 
     * @return Minutos entre 0 y 59
     *         Ejemplo: Para 14:30:45 → 30
     */
    public int getMinutos() {
        return this.minutos;
    }

    /**
     * Establece el valor de los minutos
     * Si el valor está fuera del rango 0-59, se establece a 0
     * 
     * @param minutos Nuevo valor para los minutos
     */
    public void setMinutos(int minutos) {
        this.minutos = ajustarRango(minutos, 60);
        normalizarTiempo();
    }

    /**
     * Obtiene los segundos actuales.
     * 
     * @return Segundos entre 0 y 59
     *         Ejemplo: Para 14:30:45 → 45
     */
    public int getSegundos() {
        return this.segundos;
    }

    /**
     * Establece el valor de los segundos
     * Si el valor esta fuera del rango 0-59, se establece a 0
     * 
     * @param segundos Nuevo valor para los segundos
     */
    public void setSegundos(int segundos) {
        this.segundos = ajustarRango(segundos, 60);
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en un segundo.
     * Maneja automáticamente desbordamientos de segundos a minutos.
     * Ejemplo: 23:59:59 → 00:00:00
     */
    public void incrementarSegundo() {
        segundos++;
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en N segundos.
     * Maneja automáticamente desbordamientos.
     * 
     * @param segundos Cantidad de segundos a incrementar (debe ser positivo)
     * @throws IllegalArgumentException si se pasa un valor negativo
     *                                  Ejemplo: incrementarSegundos(120) → +2
     *                                  minutos
     */
    public void incrementarSegundos(int segundos) {
        if (segundos < 0)
            throw new IllegalArgumentException("No se pueden incrementar segundos negativos");
        this.segundos += segundos;
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en un minuto.
     * Maneja automáticamente desbordamientos de minutos a horas.
     * Ejemplo: 14:59:00 → 15:00:00
     */
    public void incrementarMinuto() {
        minutos++;
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en N minutos.
     * Maneja automáticamente desbordamientos.
     * 
     * @param minutos Cantidad de minutos a incrementar (debe ser positivo)
     * @throws IllegalArgumentException si se pasa un valor negativo
     *                                  Ejemplo: incrementarMinutos(90) → +1 hora y
     *                                  30 minutos
     */
    public void incrementarMinutos(int minutos) {
        if (minutos < 0)
            throw new IllegalArgumentException("No se pueden incrementar minutos negativos");
        this.minutos += minutos;
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en 1 hora.
     * Ejemplo: 23:00:00 → 00:00:00
     * Maneja automáticamente desbordamientos de horas.
     */
    public void incrementarHora() {
        horas++;
        normalizarTiempo();
    }

    /**
     * Incrementa el tiempo en N horas.
     * Maneja automáticamente desbordamientos.
     * 
     * @param horas Cantidad de horas a incrementar (debe ser positivo)
     * @throws IllegalArgumentException si se pasa un valor negativo
     *                                  Ejemplo: incrementarHoras(30) → +6 horas
     *                                  (por ciclo de 24h)
     */
    public void incrementarHoras(int horas) {
        if (horas < 0)
            throw new IllegalArgumentException("No se pueden incrementar horas negativas");
        this.horas += horas;
        normalizarTiempo();
    }

    /**
     * Ajusta un valor al rango [0, limite-1].
     * Convierte valores negativos a sus equivalentes positivos.
     * 
     * @param valor  Valor a ajustar
     * @param limite Límite superior exclusivo del rango
     * @return Valor normalizado dentro del rango
     *         Ejemplo: ajustarRango(-5, 24) → 19
     */
    private int ajustarRango(int valor, int limite) {
        while (valor < 0)
            valor += limite;
        return valor % limite;
    }

    /**
     * Normaliza segundos/minutos/horas excedentes.
     * Ejemplo: 01:70:125 → 02:11:05
     */
    private void normalizarTiempo() {
        // Ajustar segundos y llevar el exceso a minutos
        int minutosExtra = segundos / 60;
        segundos = ajustarRango(segundos, 60);
        minutos += minutosExtra;

        // Ajustar minutos y llevar el exceso a horas
        int horasExtra = minutos / 60;
        minutos = ajustarRango(minutos, 60);
        horas += horasExtra;

        // Ajustar horas
        horas = ajustarRango(horas, 24);
    }

    /**
     * Devuelve la representación en formato HH:MM:SS.
     * 
     * @return String con la hora formateada
     *         Ejemplo: 01:05:09
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
