// Fig. 10.6: EmpleadoPorHoras.java
// Clase EmpleadoPorHoras que extiende a Empleado.
package empleados;

public class EmpleadoPorHora extends Empleado {

   private double valorHora; // salario por hora
   private int horasTrabajadas;

   public EmpleadoPorHora(String nombre, String numeroDocumento, double valorHora, int horasTrabajadas) {
      super(nombre, numeroDocumento);
      this.valorHora = valorHora;
      this.horasTrabajadas = horasTrabajadas;
   }

   public double getValorHora() {
      return this.valorHora;
   }

   public void setValorHora(double valorHora) {
      this.valorHora = valorHora;
   }

   public int getHorasTrabajadas() {
      return this.horasTrabajadas;
   }

   public void setHorasTrabajadas(int horasTrabajadas) {
      this.horasTrabajadas = horasTrabajadas;
   }

   // calcular ingresos; sobrescribe método abstracto ingresos en Empleado
   public double calcularSalario() {
      if (horasTrabajadas <= 40) // sin horas extras
         return valorHora * horasTrabajadas;
      else
         return (40 * valorHora) + (horasTrabajadas - 40) * valorHora * 1.5;
   }

   // devolver representación String de EmpleadoPorHoras
   @Override
   public String toString() {
      return String.format(
            "%s\nTipo: Empleado por Hora\nValor hora: $%,.2f\nHoras trabajadas: %d\nSalario calculado: $%,.2f",
            super.toString(), valorHora, horasTrabajadas, calcularSalario());
   }
}