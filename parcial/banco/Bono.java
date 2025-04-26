package banco;

import java.time.LocalDate;

public  class Bono extends Titulo{
    private double impuesto = 0.01;
    private LocalDate fechaVencimiento;

    public Bono(String simbolo, String descripcion, double precio, LocalDate fechaVencimiento) {
        super(simbolo, descripcion, precio);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    // Implementacion del metodo abstracto calcularImpuesto de la clase padre Titulo
    @Override
    public double calcularImpuesto(int cantidad) {
        return (cantidad * getPrecio()) * impuesto;
    }

    @Override
    public String toString() {
        return "Bono [impuesto=" + impuesto + ", fechaVencimiento=" + fechaVencimiento + "]";
    }
}
