// Fig. 10.5: EmpleadoAsalariado.java
// Clase EmpleadoAsalariado que extiende a Empleado.
package empleados;

public class EmpleadoAsalariado extends Empleado {
   private double salarioMensual;

   // constructor con cuatro argumentos
   public EmpleadoAsalariado(String nombre, String numeroDocumento, double salarioMensual) {
      super(nombre, numeroDocumento);
      this.salarioMensual = salarioMensual;
   }

   public double getSalarioMensual() {
      return this.salarioMensual;
   }

   public void setSalarioMensual(double salarioMensual) {
      this.salarioMensual = salarioMensual;
   }

   public double calcularSalario() {
      return this.salarioMensual;
   }

   @Override
   public String toString() {
      return String.format("%s\nTipo: Empleado Asalariado\nSalario mensual: $%,.2f\nSalario calculado: $%,.2f",
            super.toString(), salarioMensual, calcularSalario());
   }
}