public abstract class Bien {
    private String fechaAlta;
    private Titular titular;

    // Constructor
    public Bien(String fechaAlta, Titular titular) {
        super(); // Para los constructores de las clases Vehiculo y Inmueble deben llamar
                 // super(fechaAlta)
        this.fechaAlta = fechaAlta;
        this.titular = titular;
    }

    // Getters and Setters
    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    // toString method
    @Override
    public String toString() {
        return "Bien [fechaAlta=" + fechaAlta + ", titular=" + titular + "]";
    }

    // Clase abstracta para calcular el impuesto
    public abstract double calcularImpuesto();

}