package club;

import java.util.Arrays;

public abstract class Socio {

    private int nroSocio;
    private String nombre;
    private Actividad actividades[];
    private static double valorCuota;
    private static final int MAX_ACTIVIDAD = 10;
    private int nroActividades;

    public Socio(int nroSocio, String nombre) {
        super();
        this.nroSocio = nroSocio;
        this.nombre = nombre;
        actividades = new Actividad[MAX_ACTIVIDAD];
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static double getValorCuota() {
        return valorCuota;
    }

    public static void setValorCuota(double valorCuota) {
        Socio.valorCuota = valorCuota;
    }

    public int getNroActividades() {
        return nroActividades;
    }

    public void setNroActividades(int nroActividades) {
        this.nroActividades = nroActividades;
    }

    /**
     * Agrega una nueva actividad a la lista de actividades del socio.
     * 
     * @param actividad Actividad a agregar
     * @throws IndexOutOfBoundsException si se excede el límite máximo de
     *                                   actividades
     */
    public void agregarActividad(Actividad actividad) {
        if (nroActividades == MAX_ACTIVIDAD)
            throw new IndexOutOfBoundsException();
        actividades[nroActividades++] = actividad;
    }

    /**
     * Calcula el costo total de todas las actividades del socio.
     * 
     * @return Suma del costo de todas las actividades
     */
    public double calcularActividades() {
        double total = 0;
        for (int i = 0; i < nroActividades; i++)
            total += actividades[i].getCosto();
        return total;
    }

    /**
     * Calcula el valor total de la cuota que debe pagar el socio.
     * Cada tipo de socio implementa su propia lógica de cálculo.
     * 
     * @return Valor de la cuota a pagar por el socio
     */
    public abstract double calcularCuota();

    @Override
    public String toString() {
        return "Socio [nroSocio=" + nroSocio + ", nombre=" + nombre + ", actividades=" + Arrays.toString(actividades)
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nroSocio;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Socio other = (Socio) obj;
        if (nroSocio != other.nroSocio)
            return false;
        return true;
    }

}
