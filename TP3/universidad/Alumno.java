public class Alumno{
    private String nombre;
    private String legajo;

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLegajo() {
        return this.legajo;
    }
    
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (legajo == null) {
            if (other.legajo != null)
                return false;
        } else if (!legajo.equals(other.legajo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", legajo=" + legajo + "]";
    }    
    
}    
