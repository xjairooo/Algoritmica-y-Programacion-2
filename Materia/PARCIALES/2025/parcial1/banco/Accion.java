package banco;

public class Accion extends Titulo{
    private double impuesto = 0.2;
    private boolean pagaDividendo;

    // Constructor
    public Accion(String simbolo, String descripcion, double precio, boolean pagaDividendo) {
        super(simbolo, descripcion, precio);
        this.pagaDividendo = pagaDividendo;
    }

    // Getter y Setter para pagaDividiendo
    public boolean isPagaDividendo() {
        return pagaDividendo;
    }

    public void setPagaDividendo(boolean pagaDividendo) {
        this.pagaDividendo = pagaDividendo;
    }

    // Implementacion del metodo abstracto calcularImpuesto de la clase padre Titulo
    @Override
    public double calcularImpuesto(int cantidad) {
        return (cantidad * getPrecio()) * impuesto;
    }
    
    @Override
    public String toString() {
        return "Accion [simbolo=" + getSimbolo() + ", descripcion=" + getDescripcion() + ", precio=" + getPrecio() + ", comision="
                + getComision() + ", pagaDividendo=" + pagaDividendo + "]";
    }
}
