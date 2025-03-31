// Fig. 10.4: Empleado.java
// Clase abstracta Empleado (superclase).
package empleados;

public abstract class Empleado {
   private String nombre;
   private String numeroDocumento;

   // constructor con tres argumentos
   public Empleado(String nombre, String numeroDocumento) {
      this.nombre = nombre;
      this.numeroDocumento = numeroDocumento;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getNumeroDocumento() {
      return this.numeroDocumento;
   }

   public void setNumeroDocumento(String numeroDocumento) {
      this.numeroDocumento = numeroDocumento;
   }

   @Override
   public String toString() {
      return String.format("Nombre: %s\nNúmero de documento: %s",
            nombre, numeroDocumento);
   }

   public abstract double calcularSalario();

}