// Fig. 10.7: EmpleadoPorComision.java
// La clase EmpleadoPorComision extiende a Empleado.
package empleados;

public class EmpleadoPorComision extends Empleado {
   private double ventasBrutas; // ventas semanales brutas
   private double porcentajeComision;

   public EmpleadoPorComision(String nombre, String numeroDocumento,
         double ventasBrutas, double porcentajeComision) {
      super(nombre, numeroDocumento);
      this.ventasBrutas = ventasBrutas;
      this.porcentajeComision = porcentajeComision;
   }

   public double getVentasBrutas() {
      return this.ventasBrutas;
   }

   public void setVentasBrutas(double ventasBrutas) {
      this.ventasBrutas = ventasBrutas;
   }

   public double getPorcentajeComision() {
      return this.porcentajeComision;
   }

   public void setPorcentajeComision(double porcentajeComision) {
      this.porcentajeComision = porcentajeComision;
   }

   // porcentaje de comisión
   public double calcularSalario() {
      return ventasBrutas * (porcentajeComision / 100);
   }

   @Override
   public String toString() {
      return String.format(
            "%s\nTipo: Empleado por Comisión\nPorcentaje comisión: %.2f%%\nVentas brutas: $%,.2f\nSalario calculado: $%,.2f",
            super.toString(), porcentajeComision, ventasBrutas, calcularSalario());
   }
}