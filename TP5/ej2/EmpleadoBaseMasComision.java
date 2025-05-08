package ej2;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {
   private double salarioBase;

   public EmpleadoBaseMasComision(String nombre, String numeroDocumento,
         double porcentajeComision, double ventasBrutas,
         double salarioBase) {
      super(nombre, numeroDocumento, porcentajeComision, ventasBrutas);
      this.salarioBase = salarioBase;
   }

   public double getSalarioBase() {
      return salarioBase;
   }

   public void setSalarioBase(double salarioBase) {
      this.salarioBase = salarioBase;
   }

   @Override
   public double calcularSalario() {
      return salarioBase + super.calcularSalario();
   }

   @Override
   public String toString() {
      return String.format("%s\nSalario base: $%,.2f\nSalario total calculado: $%,.2f",
            super.toString(), salarioBase, calcularSalario());
   }
}