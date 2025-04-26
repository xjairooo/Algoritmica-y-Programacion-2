package banco;

public class Activo {
    private Titulo titulo;
    private int cantidad;
    
    public Activo(Titulo titulo, int cantidad) {
        this.titulo = titulo;
        this.cantidad = cantidad;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Activo [titulo=" + titulo + ", cantidad=" + cantidad + "]";
    }
    
    

}
