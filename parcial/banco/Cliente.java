package banco;

import java.util.Arrays;

public class Cliente {
    private String nombre;
    private String email;
    private Activo[] activos;
    private int cantidadActivos = 0;
    private static final int MAX_ACTIVOS = 10; // cantidad máxima de activos distintos que puede tener un cliente
    
    // Constructor
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        activos = new Activo[MAX_ACTIVOS];
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Agrega nuevos activos al cliente. Si el título no está en sus activos, lo 
     * agrega. Si ya está en sus activos, incrementa su cantidad. 
     *  
     * @param titulo:   título comprado 
     * @param cantidad: cantidad de títulos comprados 
     * @throws ArrayIndexOutOfBoundsException: supera la cantidad máxima de títulos 
     *                                         distintos que puede tener un cliente 
     */ 
    public void comprarActivo(Titulo titulo, int cantidad) {
        if (cantidadActivos >= MAX_ACTIVOS) {
            throw new ArrayIndexOutOfBoundsException("El cliente ya alcanzao el maximo de activos");
        }
        for (int i = 0; i < cantidadActivos; i++) {
            if (activos[i].getTitulo().equals(titulo)) {
                activos[i] = new Activo(titulo, activos[i].getCantidad() + cantidad);
                return;
            }
        }
        activos[cantidadActivos++] = new Activo(titulo, cantidad);
    }

    /** 
     * Realiza la sumatoria de todos los activos del cliente. Multiplica el precio 
     * de cada título por la cantidad que tiene comprada. 
     *  
     * @return valuación de la activos del cliente 
     */ 
    public double totalActivo(){
        double total = 0;
        for (int i = 0; i < cantidadActivos; i++) {
            total += activos[i].getTitulo().calcularPrecio(activos[i].getCantidad());
        }
        return total;
    }

    // HashCode y equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Cliente other = (Cliente) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", email=" + email + ", activos=" + Arrays.toString(activos) + "]";
    }
    
    
}
