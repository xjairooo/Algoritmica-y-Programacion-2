package banco;

public abstract class Titulo {
    private String simbolo;
    private String descripcion;
    private double precio;
    private double comision = 0.005;
    
    // Constructor
    public Titulo(String simbolo, String descripcion, double precio) {
        this.simbolo = simbolo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y Setters
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    /**
     * Calcula la comisión del banco por la compra realizada (cantidad * precio *
     * comision)
     *
     * @param cantidad: cantidad de títulos comprados
     * @return comisión del banco
     */
    public double calcularComision(int cantidad){
        return (cantidad * precio) * comision;
    }
        
    /**
     * Calcula el precio total de la compra incluida la comisión del banco y los
     * impuestos (precio * cantidad + comisión + impuestos)
     *
     * @param cantidad: cantidad de títulos comprados
     * @return precio total de compra
     */
    public double calcularPrecio(int cantidad){
        return (precio * cantidad) + calcularComision(cantidad) + calcularImpuesto(cantidad);
    } 
    
    /**
    * Calcula el impuesto por la compra realizada (cantidad * precio *
    * impuesto)
    *
    * @param cantidad: cantidad de títulos comprados
    * @return impuesto
    */
    public abstract double calcularImpuesto(int cantidad);

    // HashCode y equals para comparar títulos por su simbolo
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
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
        Titulo other = (Titulo) obj;
        if (simbolo == null) {
            if (other.simbolo != null)
                return false;
        } else if (!simbolo.equals(other.simbolo))
            return false;
        return true;
    }

    // toString para mostrar informacion del título
    @Override
    public String toString() {
        return "Titulo [simbolo=" + simbolo + ", descripcion=" + descripcion + ", precio=" + precio + ", comision="
                + comision + "]";
    }
}